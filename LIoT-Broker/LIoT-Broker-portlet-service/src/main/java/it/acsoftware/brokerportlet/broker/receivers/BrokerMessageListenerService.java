package it.acsoftware.brokerportlet.broker.receivers;

import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public abstract class BrokerMessageListenerService {
	private static Log logger = LogFactoryUtil
			.getLog(BrokerMessageListenerService.class);

	public void messageArrived(byte[] data) {
		ByteArrayInputStream bin = new ByteArrayInputStream(data);
		try {
			ObjectInputStream ois = new ObjectInputStream(bin);
			BrokerServiceMessage message = (BrokerServiceMessage) ois
					.readObject();
			ois.close();
			processMessage(message);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public abstract void processMessage(BrokerServiceMessage message);
}
