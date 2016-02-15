package it.acsoftware.brokerportlet.service.impl;

import it.acsoftware.brokerportlet.BrokerServiceException;
import it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService;
import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.service.base.BrokersManagerLocalServiceBaseImpl;
import it.acsoftware.brokerportlet.util.BrokersServicesManager;

import java.util.HashMap;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the brokers manager local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.acsoftware.brokerportlet.service.BrokersManagerLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.brokerportlet.service.base.BrokersManagerLocalServiceBaseImpl
 * @see it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil
 */
public class BrokersManagerLocalServiceImpl extends
		BrokersManagerLocalServiceBaseImpl {

	public void startServer(long brokerId) throws BrokerServiceException {
		BrokersServicesManager.getInstance().startServer(brokerId);
	}

	public void stopServer(long brokerId) throws BrokerServiceException {
		BrokersServicesManager.getInstance().stopServer(brokerId);
	}

	public void restartServer(long brokerId) throws BrokerServiceException {
		BrokersServicesManager.getInstance().restartServer(brokerId);
	}

	public void register(String topic, long brokerId, String bmlsClass,
			String servletContextName) {
		BrokersServicesManager.getInstance().register(topic, brokerId,
				bmlsClass, servletContextName);
	}

	public void register(String topic, long brokerId,
			BrokerMessageListenerService listener) {
		BrokersServicesManager.getInstance()
				.register(topic, brokerId, listener);
	}

	public void unregister(String topic, long brokerId, String bmlsClass,
			String servletContextName) {
		BrokersServicesManager.getInstance().unregister(topic, brokerId,
				bmlsClass, servletContextName);
	}

	public void unregister(String topic, long brokerId,
			BrokerMessageListenerService listener) {
		BrokersServicesManager.getInstance().unregister(topic, brokerId,
				listener);
	}

	public Boolean isRunning(long brokerId) {
		return BrokersServicesManager.getInstance().isRunning(brokerId);
	}

	public void sendMessage(long brokerId, byte[] message,
			HashMap<String, String> params) {
		BrokersServicesManager.getInstance().getBrokerService(brokerId)
				.send(message, params);
	}

	public void removeBrokerServiceDefinition(long brokerId)
			throws BrokerServiceException {
		BrokersServicesManager.getInstance().removeBrokerServiceDefinition(
				brokerId);
	}

	public void addBrokerServiceDefinition(Broker b, boolean reload)
			throws PortalException, SystemException {
		BrokersServicesManager.getInstance().addBrokerServiceDefinition(b,
				reload);
	}

	public String getBrokerServiceLastStatus(long brokerId) {
		return BrokersServicesManager.getInstance().getBrokerServiceLastStatus(
				brokerId);
	}
}
