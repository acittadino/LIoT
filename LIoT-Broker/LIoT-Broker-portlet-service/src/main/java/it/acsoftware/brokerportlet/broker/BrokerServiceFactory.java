package it.acsoftware.brokerportlet.broker;

import it.acsoftware.brokerportlet.broker.services.KafkaBrokerService;
import it.acsoftware.brokerportlet.broker.services.MQTTBrokerService;
import it.acsoftware.brokerportlet.model.Broker;
import it.acsosftware.brokerportlet.util.BrokerType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class BrokerServiceFactory {
	public static BrokerServiceImpl createBrokerService(Broker b)
			throws PortalException, SystemException {
		BrokerType type = BrokerType.valueOf(b.getType());
		if (type.equals(BrokerType.MQTT)) {
			return new MQTTBrokerService(b);
		} else if (type.equals(BrokerType.KAFKA)) {
			return new KafkaBrokerService(b);
		}

		return null;
	}
}
