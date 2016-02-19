package it.acsoftware.brokerportlet.broker.receivers;

import java.util.HashMap;
import java.util.Iterator;

import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;

public class MessageBusService extends BrokerMessageListenerService {
	private BrokerMessageListener bml;

	public MessageBusService(BrokerMessageListener bml) {
		super(String.valueOf(bml.getBrokerMessageListenerId()));
		this.bml = bml;
	}

	@Override
	public void processMessage(BrokerServiceMessage message) {
		Message m = new Message();
		m.setDestinationName(bml.getMessageBusDestination());
		m.setPayload(message.getData());
		Iterator<String> it = message.getParams().keySet().iterator();
		HashMap<String, Object> values = new HashMap<String, Object>();
		while (it.hasNext()) {
			String key = it.next();
			Object value = message.getParam(key);
			values.put(key, value);
		}
		values.put("topic", message.getTopic());
		m.setValues(values);
		MessageBusUtil.sendMessage(bml.getMessageBusDestination(), m);
	}

}
