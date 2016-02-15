package it.acsoftware.brokerportlet.broker;

import it.acsoftware.brokerportlet.BrokerServiceException;
import it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService;
import it.acsoftware.brokerportlet.model.Broker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public abstract class BrokerServiceImpl implements Runnable,BrokerService {
	protected Log logger = LogFactoryUtil.getLog(BrokerServiceImpl.class);
	protected Properties props;
	protected Broker b;
	protected HashMap<String, HashSet<BrokerMessageListenerService>> toNotify;
	protected boolean running;
	protected String lastStatus;

	public BrokerServiceImpl(Broker b) {
		this.b = b;
		this.toNotify = new HashMap<>();
		initProperties();
	}

	public long getBrokerId() {
		return b.getBrokerId();
	}

	public String getBrokerName() {
		return b.getName();
	}

	public Properties getProps() {
		return props;
	}

	public String getLastStatus() {
		return lastStatus;
	}

	public void registerToTopic(String topic,
			BrokerMessageListenerService brokerServiceReceiver) {
		if (!toNotify.containsKey(topic)) {
			toNotify.put(topic, new HashSet<BrokerMessageListenerService>());
		}
		toNotify.get(topic).add(brokerServiceReceiver);
	}

	public void unregisterToTopic(String topic,
			BrokerMessageListenerService brokerServiceReceiver) {
		if (toNotify.containsKey(topic) && toNotify.get(topic) != null
				&& toNotify.get(topic).contains(brokerServiceReceiver)) {
			toNotify.get(topic).remove(brokerServiceReceiver);
		}
	}

	public boolean isRegiteredToTopic(String topic,
			BrokerMessageListenerService brokerServiceReceiver) {
		return toNotify.get(topic) != null
				&& toNotify.get(topic).contains(brokerServiceReceiver);
	}

	public void run() {
		startService();
	}

	public void destroyBrokerService() throws BrokerServiceException {
		stopService();
		toNotify.clear();
		props.clear();
	}

	public void startService() {
		try {
			doStart();
			this.running = true;
			lastStatus = null;
		} catch (BrokerServiceException e) {
			lastStatus = "Error while starting: " + e.getMessage();
		}
	}

	public void stopService() {
		try {
			this.running = false;
			doStop();
			lastStatus = null;
		} catch (BrokerServiceException e) {
			lastStatus = "Error while stopping: " + e.getMessage();
		}
	}

	public boolean isRunning() {
		return this.running;
	}
	

	protected void initProperties(){
		props = new Properties();
		String[] properties = b.getCustomProps().split(";");
		for(int i = 0; i < properties.length;i++){
			String[] prop = properties[i].split("\\$");
			String name = "";
			String val = "";
			if(prop.length > 0)
				name = prop[0];
			if(prop.length > 1)
				val = prop[1];
			if(Validator.isNotNull(name))
				props.put(name,val);
		}
		addCustomProperties();
	}

	protected abstract void addCustomProperties();
	
	protected abstract void doStart() throws BrokerServiceException;

	protected abstract void doStop() throws BrokerServiceException;

}
