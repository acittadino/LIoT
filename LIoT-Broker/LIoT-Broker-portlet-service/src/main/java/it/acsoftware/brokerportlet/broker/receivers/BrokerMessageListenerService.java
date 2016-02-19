package it.acsoftware.brokerportlet.broker.receivers;

import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.UUID;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public abstract class BrokerMessageListenerService {
	private static Log logger = LogFactoryUtil
			.getLog(BrokerMessageListenerService.class);

	private String id;

	// When created from entity is the id of the entity
	public BrokerMessageListenerService(
			BrokerMessageListener brokerMessageListener) {
		this.id = String.valueOf(brokerMessageListener
				.getBrokerMessageListenerId());
	}

	// When is created from code, like for websocket we pass directly the id
	public BrokerMessageListenerService(String id) {
		this.id = id;
	}

	// creates random Id, when message listener are registered from spring context
	public BrokerMessageListenerService() {
		this.id = String.valueOf(Math.random() * 1000)
				+ UUID.randomUUID().toString();
	}

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

	public String getId() {
		return id;
	}

	// this 2 method guarantees that whene a service message listener is put
	// inside a map
	// it will refer the id, so 2 istances with the same id will be considered
	// as one
	public boolean equals(Object o) {
		if (!(o instanceof BrokerMessageListenerService))
			return false;
		return this.getId().equals(((BrokerMessageListenerService) o).getId());
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

}
