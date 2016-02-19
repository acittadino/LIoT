package it.acsoftware.brokerportlet.broker.receivers;

import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;

import java.lang.reflect.Method;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author aristidecittadino This class wraps object coming from different class
 *         loader and invoke the method by reflection. Unfortunately we cannot
 *         check if the passed object is BrokerMessageListenerService instance
 *         with instanceOf But we must do it by reflection
 */
@SuppressWarnings("rawtypes")
public class ExternalBrokerMessageListener extends BrokerMessageListenerService {
	private static Log logger = LogFactoryUtil
			.getLog(ExternalBrokerMessageListener.class);

	private Object o;
	private Method m;

	public ExternalBrokerMessageListener(Object obj,String id) {
		super(id);
		boolean ok = false;
		if (obj != null) {
			Class superClass = obj.getClass().getSuperclass();
			String name = superClass.getName();
			if (name.equalsIgnoreCase("it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService")) {
				ok = true;
			}

		}
		if (!ok)
			throw new ClassCastException(
					"Object cannot be cast to BrokerMessageListenerService");

		Method[] methods = obj.getClass().getMethods();

		for (int i = 0; i < methods.length && m == null; i++) {
			Method tmp = methods[i];
			String name = tmp.getName();

			if (name.equalsIgnoreCase("messageArrived")) {
				this.m = tmp;
				this.o = obj;
			}
		}

	}

	@Override
	public void messageArrived(byte[] data) {
		try {
			if (m != null) {
				m.invoke(o, data);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	@Override
	public void processMessage(BrokerServiceMessage message) {
		throw new UnsupportedOperationException();
	}

	// We use the o Reference for HashCode,equals so the brokersServiceManager
	// HashMap will still work
	// correctly finding the correct instance
	@Override
	public int hashCode() {
		return o.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return o.equals(obj);
	}

	@Override
	public String toString() {
		return o.toString();
	}

}
