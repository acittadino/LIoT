package it.acsoftware.brokerportlet.broker.receivers;

import it.acsoftware.brokerportlet.broker.BrokerMessageListenerType;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;

public class BrokerMessageListenerFactory {
	public static BrokerMessageListenerService createBrokerToMessageListener(BrokerMessageListener bml){
		String typeStr = bml.getType();
		BrokerMessageListenerType type = BrokerMessageListenerType.valueOf(typeStr);
		if(type.equals(BrokerMessageListenerType.MESSAGE_BUS)){
			return new MessageBusService(bml);
		}
		return null;
	}

}
