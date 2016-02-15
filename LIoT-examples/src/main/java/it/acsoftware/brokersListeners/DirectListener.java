package it.acsoftware.brokersListeners;

import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;
import it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService;
import it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil;

import java.util.Iterator;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author aristidecittadino
 * 
 *         This class is a direct listener for messages arriving on the broker
 *         portlet This works thank to spring. This means that we have defined
 *         in the web.xml a new spring file custom-beans.xml. Inside this file
 *         we added a bean definition of this class that implements
 *         BrokerMessageListenerService. Than we register the spring bean as a
 *         listener through the BrokersManagerServiceUtil giving only class name
 *         and servlet context (the bean will be retrieved automatically by
 *         spring).
 * 
 *         When a message arrives the "messageArrived" method will be invoked.
 *         You can even setup more than one direct listener different for
 *         topics.
 * 
 *         This is an interesting feature but the best solution is to use
 *         message bus.
 * 
 */
public class DirectListener extends BrokerMessageListenerService {
	private static Log logger = LogFactoryUtil.getLog(DirectListener.class);

	@Override
	public void processMessage(BrokerServiceMessage data) {
		try {
			JSONObject obj = JSONFactoryUtil.createJSONObject(new String((byte[]) data.getData()));
			logger.info("--------------------DIRECT LISTENER INCOMING MESSAGE--------------------");
			logger.info("Topic:" + data.getTopic());
			logger.info("Value:" + obj.getInt("value"));
			logger.info("Label:"+obj.getString("label"));
			logger.info("TimeStamp:"+obj.getLong("timeStamp"));
			Iterator<String> it = data.getParams().keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				Object value = data.getParam(key);
				logger.info("Param " + key + " :" + value.toString());
			}
			logger.info("-------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void registerDirectListener(long brokerId, String topic) {
		BrokersManagerServiceUtil.register(topic, brokerId,
				DirectListener.class.getName(), "LIoT-examples-portlet");
	}
}
