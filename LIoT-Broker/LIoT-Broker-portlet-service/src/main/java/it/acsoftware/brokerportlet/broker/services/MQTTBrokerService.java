package it.acsoftware.brokerportlet.broker.services;

import it.acsoftware.brokerportlet.BrokerServiceException;
import it.acsoftware.brokerportlet.broker.BrokerServiceImpl;
import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;
import it.acsoftware.brokerportlet.broker.SslUtils;
import it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService;
import it.acsoftware.brokerportlet.model.Broker;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.net.ssl.SSLSocketFactory;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

public class MQTTBrokerService extends BrokerServiceImpl implements
		MqttCallback {

	private static final String PROPERTY_BROKER_URL = "broker.url";
	private static final String PROPERTY_SERVER_CLIENT_ID = "server.clientId";
	private static final String PROPERTY_SERVER_QOS = "server.qos";

	private MqttClient mqttClient;
	private MqttConnectOptions connOpts = new MqttConnectOptions();

	public MQTTBrokerService(Broker b) throws PortalException, SystemException {
		super(b);

		connOpts.setCleanSession(b.getMqttCleanSession());
		if (Validator.isNotNull(b.getConnectionUsername())) {
			connOpts.setUserName(b.getConnectionUsername());
			connOpts.setPassword(b.getConnectionPassword().toCharArray());
		}

		if (b.getSslEnabled()) {
			SslUtils sslUtils = new it.acsoftware.brokerportlet.broker.SslUtils(
					b);
			SSLSocketFactory sf = sslUtils.getSocketFactory();
			connOpts.setSocketFactory(sf);
		}
		String protocol = b.getProtocol();
		if (!b.getProtocol().endsWith("://"))
			protocol += "://";
		String brokerUrl = protocol + b.getUrl() + ":" + b.getPort();

		try {
			this.mqttClient = new MqttClient(brokerUrl, b.getMqttClientId(),
					new MemoryPersistence());
		} catch (Exception e) {
			logger.error(e);
			throw new PortalException(e.getMessage());
		}

	}

	// if you need to use for custom actions you can get it!
	public MqttClient getMqttClient() {
		return this.mqttClient;
	}

	@Override
	protected void addCustomProperties() {
		String brokerUrl = b.getUrl() + ":" + b.getPort();
		props.put(PROPERTY_BROKER_URL, brokerUrl);
		props.put(PROPERTY_SERVER_CLIENT_ID, b.getMqttClientId());
		props.put(PROPERTY_SERVER_QOS, b.getMqttQos());
	}

	@Override
	protected void doStart() throws BrokerServiceException {
		logger.info("start connection to broker: "
				+ props.getProperty(PROPERTY_BROKER_URL));
		try {
			this.mqttClient.setCallback(this);
			this.mqttClient.connect(connOpts);
			String[] topics = b.getTopics().split(";");
			for (int i = 0; i < topics.length; i++) {
				this.mqttClient.subscribe(topics[i]);
			}
		} catch (MqttSecurityException e) {
			throw new BrokerServiceException(e.getMessage());
		} catch (MqttException e) {
			logger.error(e);
			throw new BrokerServiceException(e.getMessage());
		}

		logger.info("Server connected to broker...");
	}

	@Override
	protected void doStop() throws BrokerServiceException {
		try {
			logger.info("Stopping broker...");
			this.mqttClient.disconnect();
			logger.info("Broker stopped");
		} catch (MqttException e) {
			logger.info("Error while stopping broker:" + e.getMessage());
			throw new BrokerServiceException(e.getMessage());
		}

	}

	@Override
	public void connectionLost(Throwable err) {
		logger.error(err);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// nothing to do
	}

	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws Exception {
		Set<BrokerMessageListenerService> receivers = toNotify.get(topic);
		if (toNotify != null && receivers != null && receivers.size() > 0) {
			Iterator<BrokerMessageListenerService> it = receivers.iterator();
			while (it.hasNext()) {
				BrokerMessageListenerService receiver = it.next();
				BrokerServiceMessage brokerServiceMessage = new BrokerServiceMessage(
						topic, message.getPayload());
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				oos.writeObject(brokerServiceMessage);
				oos.flush();
				receiver.messageArrived(bos.toByteArray());
			}
		}
	}

	@Override
	public void send(byte[] message, HashMap<String, String> params) {
		String topic = params.get("topic");
		MqttMessage mqttMessage = new MqttMessage(message);
		mqttMessage.setQos(b.getMqttQos());
		try {
			this.mqttClient.publish(topic, mqttMessage);
			logger.info("Sending message on topic " + topic + ":"
					+ new String(message));
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isRunning() {
		return mqttClient != null && mqttClient.isConnected();
	}

}
