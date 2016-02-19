package it.acsoftware.liotexamples.simulators;

import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil;
import it.acsoftware.brokersListeners.DirectListener;
import it.acsosftware.brokerportlet.util.BrokerType;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.math3.random.RandomDataGenerator;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * 
 * @author aristidecittadino This class is just for exmample purpose. It uses
 *         the brokerService to simulate a sensor which send data to the broker.
 *         This is a cross-technology implmentation. In the same package you can
 *         find all the concrete implementations for:
 * 
 *         -Mqtt -kafka
 * 
 *         In this classes you can find examples on how to interact with the
 *         BrokerServiceManager to retrieve brokers and use theme to
 *         send/receive messages. Each concrete class is completely agnostic
 *         about the broker service works because for sending message it uses
 *         the remote service BrokersManagerServiceUtil.send This approach
 *         allows high decoupling.
 */

public abstract class AbstractSensorSimulator implements Runnable {
	private boolean stop;
	private boolean inProgress;
	private RandomDataGenerator dataGenerator;
	private Thread simulator;
	protected int packetsSent;
	protected String dataTopic;
	protected HashMap<String, String> otherParams;
	protected String type;
	protected long brokerId;

	protected AbstractSensorSimulator(String type) {
		super();
		stop = false;
		inProgress = false;
		dataGenerator = new RandomDataGenerator();
		this.type = type;
	}

	public static AbstractSensorSimulator getInstance(long brokerId,
			boolean ssl, String topic) throws SystemException {
		Broker b = BrokerLocalServiceUtil.fetchBroker(brokerId);

		if (b.getType().equalsIgnoreCase(BrokerType.MQTT.getType())) {
			MqttSensorSimulator.getInstance().init(brokerId, ssl, topic,
					new HashMap<String, String>());
			return MqttSensorSimulator.getInstance();
		} else if (b.getType().equalsIgnoreCase(BrokerType.KAFKA.getType())) {
			KafkaSensorSimulator.getInstance().init(brokerId, ssl, topic,
					new HashMap<String, String>());
			return KafkaSensorSimulator.getInstance();
		}

		throw new RuntimeException("No such broker type!");

	}

	public static AbstractSensorSimulator getRunningSimulator() {
		if (MqttSensorSimulator.getInstance().isInProgress())
			return MqttSensorSimulator.getInstance();
		else if (KafkaSensorSimulator.getInstance().isInProgress())
			return KafkaSensorSimulator.getInstance();
		return null;
	}

	protected void init(long brokerId, boolean ssl, String topic,
			HashMap<String, String> otherParams) throws SystemException {
		// The only way to interact with the broker services is to use
		// Liferay services
		// Keep in mind that we are in another portlet so it's different class
		// loader
		// But services are linked to the broker portlet class loader
		if (!BrokersManagerServiceUtil.isRunning(brokerId)) {
			throw new RuntimeException(
					"Broker service is not running,please check it!");
		}
		this.brokerId = brokerId;
		this.dataTopic = topic;
		this.otherParams = otherParams;
		customSensorSimulatorInit();
	}

	protected abstract void customSensorSimulatorInit();

	public void startSimulator() {
		// Register in the same portlet a component that receive messages from
		// the broker
		// in order to print inside the console the message
		DirectListener.registerDirectListener(this.brokerId, this.dataTopic,"DirectSensorSimulator");
		
		stop = false;
		simulator = new Thread(this);
		simulator.start();
	}

	public void stopSimulator() {
		this.stop = true;
	}

	public void run() {
		// Send detection
		packetsSent = 0;
		inProgress = true;
		try {
			SensorSimulator sensorSimulator = new SensorSimulator(
					this.dataTopic, this.otherParams);
			sensorSimulator.start();
			sensorSimulator.join();
		} catch (InterruptedException exception) {

		}
		inProgress = false;
	}

	protected abstract void sendMeasure(String topic,
			HashMap<String, String> otherParams, byte[] message);

	public String getType() {
		return type;
	}

	public long getBrokerId() {
		return brokerId;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	private class SensorSimulator extends Thread {
		private String topic;
		private HashMap<String, String> otherParams;

		public SensorSimulator(String topic, HashMap<String, String> otherParams) {
			this.topic = topic;
			this.otherParams = otherParams;
		}

		@Override
		public void run() {
			while (!stop) {
				int val = dataGenerator.nextInt(0, 20000);
				Date now = new Date();
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("label", "new value incoming");
				obj.put("timeStamp", now.getTime());
				obj.put("value", val);
				sendMeasure(topic, otherParams, obj.toString().getBytes());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
