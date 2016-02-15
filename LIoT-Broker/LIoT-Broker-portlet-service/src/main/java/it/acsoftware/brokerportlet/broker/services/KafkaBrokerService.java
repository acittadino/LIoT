package it.acsoftware.brokerportlet.broker.services;

import it.acsoftware.brokerportlet.BrokerServiceException;
import it.acsoftware.brokerportlet.broker.BrokerServiceImpl;
import it.acsoftware.brokerportlet.model.Broker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class KafkaBrokerService extends BrokerServiceImpl {
	private Log log = LogFactoryUtil.getLog(KafkaBrokerService.class);

	private final ConsumerConnector consumer;
	private int nThread;
	private ExecutorService executor;
	private List<KafkaConsumerThread> threads;
	@SuppressWarnings("rawtypes")
	private Producer producer;

	public KafkaBrokerService(Broker b) {
		super(b);
		this.consumer = kafka.consumer.Consumer
				.createJavaConsumerConnector(createConsumerConfig(props));

		if (props == null) {
			props = new Properties();
		}

		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("metadata.broker.list", b.getUrl() + ":" + b.getPort());
		props.put("request.required.acks", "1");
		ProducerConfig config = new ProducerConfig(props);
		producer = new Producer<String, String>(config);
		this.threads = new ArrayList<KafkaConsumerThread>();
		this.nThread = b.getKafkaThreadsPerTopic();
	}

	public void shutdown() {
		boolean allStopped = false;

		for (int i = 0; i < threads.size() || !allStopped; i++) {
			if (!threads.get(i).isStopped())
				threads.get(i).stopThread();

			if (i == 0) {
				allStopped = true;
			}

			allStopped = allStopped && threads.get(i).isStopped();
			// reinit the cicle until all threads are stopped
			if (!allStopped) {
				i -= 1;
				log.debug("thread " + i + " stopped...");
			}
		}

		log.debug("Stopped all threads...");

		if (consumer != null)
			consumer.shutdown();
		if (executor != null)
			executor.shutdown();
		try {
			if (!executor.awaitTermination(2000 * nThread,
					TimeUnit.MILLISECONDS)) {
				log.debug("Timed out waiting for consumer threads to shut down, exiting uncleanly");
			}
		} catch (InterruptedException e) {
			log.debug("Interrupted during shutdown, exiting uncleanly");
		}
	}

	public void run() {
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		Iterator<String> it = toNotify.keySet().iterator();
		while (it.hasNext()) {
			String topic = it.next();
			topicCountMap.put(topic, new Integer(nThread));

			Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer
					.createMessageStreams(topicCountMap);

			List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

			executor = Executors.newFixedThreadPool(nThread);

			int threadNumber = 0;
			for (final KafkaStream<byte[], byte[]> stream : streams) {
				KafkaConsumerThread kt = new KafkaConsumerThread(stream,
						threadNumber, toNotify);
				threads.add(kt);
				executor.submit(kt);
				threadNumber++;
			}
		}
	}

	private static ConsumerConfig createConsumerConfig(Properties props) {
		return new ConsumerConfig(props);
	}

	public List<KafkaConsumerThread> getThreads() {
		return threads;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	@Override
	protected void addCustomProperties() {
		this.props.put("zookeeper.connect", b.getKafkaZookeeperHost());
		this.props.put("group.id", b.getKafkaGroupId());
	}

	@Override
	protected void doStart() throws BrokerServiceException {
		Thread t = new Thread(this);
		t.start();
		running = true;
	}

	@Override
	protected void doStop() throws BrokerServiceException {
		for (int i = 0; i < threads.size(); i++) {
			KafkaConsumerThread c = threads.get(i);
			c.stopThread();
			Thread t = new Thread(c);
			try {
				t.join();
			} catch (Exception e) {
				logger.info("Error while stopping thread: " + e.getMessage());
			}
		}

		if (consumer != null)
			consumer.shutdown();

		if (executor != null)
			executor.shutdown();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void send(byte[] message, HashMap<String, String> params) {
		String dataTopic = params.get("topic");
		String key = params.get("key");
		KeyedMessage<String, String> data = new KeyedMessage<String, String>(
				dataTopic, key, new String(message));
		List<KeyedMessage<String, String>> messages = new ArrayList<KeyedMessage<String, String>>();
		messages.add(data);
		producer.send(messages);
	}


}
