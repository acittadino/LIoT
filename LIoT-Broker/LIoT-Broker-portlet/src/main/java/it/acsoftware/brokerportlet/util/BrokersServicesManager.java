package it.acsoftware.brokerportlet.util;

import it.acsoftware.brokerportlet.BrokerServiceException;
import it.acsoftware.brokerportlet.broker.BrokerServiceFactory;
import it.acsoftware.brokerportlet.broker.BrokerServiceImpl;
import it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerFactory;
import it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService;
import it.acsoftware.brokerportlet.broker.receivers.ExternalBrokerMessageListener;
import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;
import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil;

import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class BrokersServicesManager {
	private static Log log = LogFactoryUtil.getLog(BrokersServicesManager.class);

	private static BrokersServicesManager instance;
	private HashMap<Long, BrokerServiceImpl> services;
	private HashMap<String, Long> nameToIdMappings;

	private BrokersServicesManager() {
		services = new HashMap<>();
		nameToIdMappings = new HashMap<>();
	}

	public static synchronized BrokersServicesManager getInstance() {
		if (instance == null)
			instance = new BrokersServicesManager();
		return instance;
	}

	public void addBrokerServiceDefinition(Broker b, boolean reload)
			throws PortalException, SystemException {

		if (!services.containsKey(b.getBrokerId()) || reload) {
			if (reload && services.containsKey(b.getBrokerId())) {
				BrokerServiceImpl oldBs = services.get(b.getBrokerId());
				try {
					oldBs.destroyBrokerService();
				} catch (Exception e) {
					throw new SystemException(e.getMessage());
				}
			}

			BrokerServiceImpl bs = BrokerServiceFactory.createBrokerService(b);
			services.put(bs.getBrokerId(), bs);
			nameToIdMappings.put(bs.getBrokerName(), bs.getBrokerId());
			List<BrokerMessageListener> listeners = BrokerMessageListenerLocalServiceUtil
					.findByBrokerId(b.getBrokerId());
			for (int i = 0; i < listeners.size(); i++) {
				BrokerMessageListener bml = listeners.get(i);
				String[] topics = bml.getTopics().split(";");
				for (int j = 0; j < topics.length; j++) {
					String topic = topics[j];
					BrokerMessageListenerService b2ml = BrokerMessageListenerFactory
							.createBrokerToMessageListener(bml);
					bs.registerToTopic(topic, b2ml);
				}
			}
		}
	}

	public void removeBrokerServiceDefinition(long brokerId)
			throws BrokerServiceException {
		if (services.containsKey(brokerId)) {
			stopServer(brokerId);
			BrokerServiceImpl bs = services.remove(brokerId);
			nameToIdMappings.remove(bs.getBrokerName());
		}
	}

	public BrokerServiceImpl getBrokerService(long brokerId) {
		if (services.containsKey(brokerId)) {
			BrokerServiceImpl bs = services.get(brokerId);
			return bs;
		}
		return null;
	}

	public BrokerServiceImpl getBrokerServiceByName(long companyId, String name) {
		Broker b = BrokerLocalServiceUtil.findByName(companyId, name);
		if (b != null) {
			BrokerServiceImpl bs = getBrokerService(b.getBrokerId());
			return bs;
		}
		return null;
	}

	public void startServer(long brokerId) throws BrokerServiceException {
		if (services.containsKey(brokerId)
				&& !services.get(brokerId).isRunning())
			services.get(brokerId).startService();
	}

	public void stopServer(long brokerId) throws BrokerServiceException {
		if (services.containsKey(brokerId)
				&& services.get(brokerId).isRunning())
			services.get(brokerId).stopService();
	}

	public void restartServer(long brokerId) throws BrokerServiceException {
		if (services.containsKey(brokerId)) {
			stopServer(brokerId);
			startServer(brokerId);
		}
	}

	public void register(String topic, long brokerId,
			BrokerMessageListenerService bmls) {
		if (services.containsKey(brokerId)) {
			services.get(brokerId).registerToTopic(topic, bmls);
		}
	}

	// use from Remote to instantiate object from another portlet
	// requires spring bean definition
	public void register(String topic, long brokerId, String bmlsClass,
			String servletContextName) {
		if (services.containsKey(brokerId)) {
			try {
				Object obj = PortletBeanLocatorUtil.locate(servletContextName,
						bmlsClass);
				// We must use reflection because with different class loader 
				// we cannot check if the obj is a BrokerMessageListenerService instance
				ExternalBrokerMessageListener externalBml = new ExternalBrokerMessageListener(obj);
				services.get(brokerId).registerToTopic(topic, externalBml);
			} catch (Exception e) {
				log.error(e);
			}
		}
	}

	public void unregister(String topic, long brokerId,
			BrokerMessageListenerService bmls) {
		if (services.containsKey(brokerId)) {
			services.get(brokerId).unregisterToTopic(topic, bmls);
		}
	}

	// use from Remote to instantiate object from another portlet
	// requires spring bean definition
	public void unregister(String topic, long brokerId, String bmlsClass,
			String servletContextName) {
		if (services.containsKey(brokerId)) {
			Object obj = PortletBeanLocatorUtil.locate(servletContextName,
					bmlsClass);
			ExternalBrokerMessageListener externalBml = new ExternalBrokerMessageListener(obj);
			services.get(brokerId).unregisterToTopic(topic, externalBml);
		}
	}

	public boolean isRunning(long brokerId) {
		if (services.containsKey(brokerId))
			return services.get(brokerId).isRunning();
		return false;
	}

	public String getBrokerServiceLastStatus(long brokerId) {
		if (services.containsKey(brokerId)) {
			return services.get(brokerId).getLastStatus();
		}
		return null;
	}

}