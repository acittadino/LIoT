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
		this.bml = bml;
	}

	@Override
	public void processMessage(BrokerServiceMessage message) {
		Message m = new Message();
		m.setDestinationName(bml.getMessageBusDestination());
		m.setPayload(message.getData());
		Iterator<String> it = message.getParams().keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Object value = message.getParam(key);
			m.getValues().put(key, value);
		}
		HashMap<String,Object> values = new HashMap<String,Object>();
		values.put("topic", message.getTopic());
		m.setValues(values);
		MessageBusUtil.sendMessage(bml.getMessageBusDestination(), m);
	}

}
