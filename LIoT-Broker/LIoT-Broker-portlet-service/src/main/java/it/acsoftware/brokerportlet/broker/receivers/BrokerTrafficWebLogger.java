package it.acsoftware.brokerportlet.broker.receivers;

import it.acsoftware.brokerportlet.broker.BrokerServiceMessage;
import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ServerEndpoint(value = "/websocketBrokerPortlet/{brokerId}")
public class BrokerTrafficWebLogger extends BrokerMessageListenerService {
	private Log logger = LogFactoryUtil.getLog(BrokerTrafficWebLogger.class);
	private long brokerId;
	private Session session;

	public BrokerTrafficWebLogger() {
		super();
	}

	@OnOpen
	public void onOpen(Session session, @PathParam("brokerId") Long brokerId) {
		this.brokerId = brokerId;
		this.session = session;
		try {
			Broker b = BrokerLocalServiceUtil.fetchBroker(brokerId);
			String[] topics = b.getTopics().split(";");
			for (int i = 0; i < topics.length; i++) {
				BrokersManagerLocalServiceUtil.register(topics[i], brokerId,
						this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		logger.info("received:" + message + " from session: " + message);
	}

	@OnClose
	public void onClose(Session session) {
		try {
			Broker b = BrokerLocalServiceUtil.fetchBroker(brokerId);
			String[] topics = b.getTopics().split(";");
			for (int i = 0; i < topics.length; i++) {
				BrokersManagerLocalServiceUtil.unregister(topics[i], brokerId,
						this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void processMessage(BrokerServiceMessage message) {
		try {
			String topic = message.getTopic();
			String payload = message.getData().toString();
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("topic", topic);
			obj.put("payload", payload);
			session.getBasicRemote().sendText(obj.toString());
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
