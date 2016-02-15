package it.acsoftware.liotexamples.simulators;

import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;
import it.acsosftware.brokerportlet.util.BrokerType;

import java.util.HashMap;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class MqttSensorSimulator extends AbstractSensorSimulator {

	private static Log logger = LogFactoryUtil.getLog(MqttSensorSimulator.class);
	private static MqttSensorSimulator instance;

	private MqttSensorSimulator(String type) {
		super(type);
	}

	public static MqttSensorSimulator getInstance() {
		if (instance == null)
			instance = new MqttSensorSimulator(BrokerType.MQTT.getType());
		return instance;
	}

	public void init(long brokerId, boolean ssl, String topic,
			HashMap<String, String> otherParams) throws SystemException {
		super.init(brokerId, ssl, topic, otherParams);
	}

	@Override
	protected void customSensorSimulatorInit() {
	}

	@Override
	protected void sendMeasure(String topic,
			HashMap<String, String> otherParams, byte[] messageBytes) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("topic", topic);
		BrokersManagerLocalServiceUtil.sendMessage(brokerId, messageBytes,
				params);
		logger.info("Sending message on topic " + topic + ":"
				+ new String(messageBytes));
	}

}
