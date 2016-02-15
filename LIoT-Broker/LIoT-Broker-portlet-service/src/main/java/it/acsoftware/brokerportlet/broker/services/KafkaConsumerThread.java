package it.acsoftware.brokerportlet.broker.services;

import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;
import it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

public class KafkaConsumerThread implements Runnable {
	private KafkaStream<byte[], byte[]> m_stream;
	private boolean stopThread;
	private HashMap<String, HashSet<BrokerMessageListenerService>> toNotify;

	public KafkaConsumerThread(KafkaStream<byte[], byte[]> a_stream,
			int a_threadNumber,
			HashMap<String, HashSet<BrokerMessageListenerService>> toNotify) {
		this.m_stream = a_stream;
		this.stopThread = false;
		this.toNotify = toNotify;
	}

	/**
	 * When invoked, the consumer finishes to consume all available messages and
	 * then it stops.
	 */
	public void stopThread() {
		this.stopThread = true;
	}

	public boolean isStopped() {
		return this.stopThread;
	}

	public KafkaStream<byte[], byte[]> getM_stream() {
		return m_stream;
	}

	public void restartThread() {
		if (stopThread) {
			Thread t = new Thread(this);
			t.start();
		}
	}

	public void run() {
		ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
		while (!stopThread) {
			if (it.hasNext()) {
				try {
					MessageAndMetadata<byte[], byte[]> messageAndMetadata = it
							.next();
					if (messageAndMetadata != null
							&& messageAndMetadata.topic() != null
							&& messageAndMetadata.message() != null) {

						Set<BrokerMessageListenerService> receivers = toNotify
								.get(messageAndMetadata.topic());
						if (toNotify != null) {
							Iterator<BrokerMessageListenerService> itNotify = receivers
									.iterator();
							while (itNotify.hasNext()) {
								BrokerMessageListenerService receiver = itNotify
										.next();
								BrokerServiceMessage brokerServiceMessage = new BrokerServiceMessage(
										messageAndMetadata.topic(),
										messageAndMetadata.message());
								brokerServiceMessage.setParam("kafka.key",
										messageAndMetadata.key());
								ByteArrayOutputStream bos = new ByteArrayOutputStream();
								ObjectOutputStream oos = new ObjectOutputStream(
										bos);
								oos.writeObject(brokerServiceMessage);
								oos.flush();
								receiver.messageArrived(bos.toByteArray());
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
