package it.acsoftware.brokersListeners;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * 
 * @author aristidecittadino This class implements the web socket logic. The
 *         principle is very simple, this class is creates when a user arrives
 *         on the web socket page. Once created, this class is registered to the
 *         message bus, to the topic on which messages arrive. So the same class
 *         is at the same time messageBus receiver and websocket. We this
 *         approach is very simple to push data on the web page!
 * 
 *         You can choose to register directly as a broker listener(see DirectListener) or to add as
 *         messageBus listener We chose the second way.
 */

@ServerEndpoint(value = "/webSocket/{messageBusDestination}")
public class WebSocketListener implements MessageListener {
	private static Log logger = LogFactoryUtil.getLog(WebSocketListener.class);
	private String messageBusDestination;
	private Session session;

	@OnOpen
	public void onOpen(Session session,
			@PathParam("messageBusDestination") String messageBusDestination) {
		this.messageBusDestination = messageBusDestination;
		this.session = session;

		// registering on the message bus service
		// with this invocation you don't have to register the bean in the spring xml
		// you can do it directly at runtime!
		MessageBusUtil
				.registerMessageListener(this.messageBusDestination, this);
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		logger.info("received:" + message + " from session: " + message);
	}

	@OnClose
	public void onClose(Session session) {
		try {
			// on closing web socket, we unregister the component from the
			// message bus
			MessageBusUtil.unregisterMessageListener(
					this.messageBusDestination, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void receive(Message message) throws MessageListenerException {
		// we send a json object to the websocket
		// we assume that is the simulator that is sending messages
		byte[] byteMessage = (byte[]) message.getPayload();
		try {
			String json = new String(byteMessage);
			session.getBasicRemote().sendText(json);
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
