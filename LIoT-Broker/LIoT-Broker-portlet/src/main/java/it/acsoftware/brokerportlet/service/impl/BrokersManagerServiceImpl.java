package it.acsoftware.brokerportlet.service.impl;

import it.acsoftware.brokerportlet.BrokerServiceException;
import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.base.BrokersManagerServiceBaseImpl;

import java.util.HashMap;

/**
 * The implementation of the brokers manager remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.acsoftware.brokerportlet.service.BrokersManagerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.brokerportlet.service.base.BrokersManagerServiceBaseImpl
 * @see it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil
 */
public class BrokersManagerServiceImpl extends BrokersManagerServiceBaseImpl {

	public void startServer(long brokerId) throws BrokerServiceException {
		BrokersManagerLocalServiceUtil.startServer(brokerId);
	}

	public void stopServer(long brokerId) throws BrokerServiceException {
		BrokersManagerLocalServiceUtil.stopServer(brokerId);
	}

	public void restartServer(long brokerId) throws BrokerServiceException {
		BrokersManagerLocalServiceUtil.restartServer(brokerId);
	}

	public void register(String topic, long brokerId, String bmlsClass,
			String servletContextName) {
		BrokersManagerLocalServiceUtil.register(topic, brokerId, bmlsClass,
				servletContextName);
	}

	public void unregister(String topic, long brokerId, String bmlsClass,
			String servletContextName) {
		BrokersManagerLocalServiceUtil.unregister(topic, brokerId, bmlsClass,
				servletContextName);
	}

	public Boolean isRunning(long brokerId) {
		return BrokersManagerLocalServiceUtil.isRunning(brokerId);
	}
	
	public void sendMessage(long brokerId,byte[] message,HashMap<String,String> params){
		BrokersManagerLocalServiceUtil.sendMessage(brokerId, message, params);
	}

	
}
