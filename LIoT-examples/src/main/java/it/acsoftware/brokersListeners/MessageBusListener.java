package it.acsoftware.brokersListeners;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class MessageBusListener implements MessageListener {
	private static Log logger = LogFactoryUtil.getLog(MessageBusListener.class);

	@Override
	public void receive(Message message) throws MessageListenerException {
		String json = new String ((byte[])message.getPayload());
		try{
			JSONObject obj = JSONFactoryUtil.createJSONObject(json);
			logger.info("--------------------MESSAGE BUS INCOMING MESSAGE--------------------");
			logger.info("Message Bus Destination:" + message.getDestinationName());
			logger.info("Topic:" + message.getValues().get("topic").toString());
			logger.info("Value:" + obj.getInt("value"));
			logger.info("Label:"+obj.getString("label"));
			logger.info("TimeStamp:"+obj.getLong("timeStamp"));
			logger.info("-------------------------------------------------------------------------");
		}catch(Exception e){
			logger.error(e);
		}
	}

}
