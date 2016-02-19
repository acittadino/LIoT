package it.acsoftware.liotexamples.simulators;

import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;
import it.acsosftware.brokerportlet.util.BrokerType;

import java.util.HashMap;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class KafkaSensorSimulator extends AbstractSensorSimulator {
	private static Log logger = LogFactoryUtil.getLog(KafkaSensorSimulator.class);

	private static KafkaSensorSimulator instance;

	private KafkaSensorSimulator(String type) {
		super(type);
	}

	public static KafkaSensorSimulator getInstance() {
		if (instance == null)
			instance = new KafkaSensorSimulator(BrokerType.KAFKA.getType());
		return instance;
	}

	@Override
	public void init(long brokerId, boolean ssl, String topic,
			HashMap<String, String> otherParams) throws SystemException {
		super.init(brokerId, ssl, topic, otherParams);
	}

	@Override
	protected void customSensorSimulatorInit() {

	}

	@Override
	protected void sendMeasure(String topic,
			HashMap<String, String> otherParams, byte[] message) {
		String key = "Random key: " + String.valueOf((Math.random() * 100));
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("topic", topic);
		params.put("key", key);
		BrokersManagerLocalServiceUtil.sendMessage(brokerId, message, params);
		logger.info("Sending message on topic " + topic + " with key " + key
				+ ":" + new String(message));
	}

	@Override
	public void stopSimulator() {
		super.stopSimulator();
	}

}
