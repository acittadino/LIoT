package it.acsoftware.brokerportlet.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil;
import it.acsoftware.brokerportlet.service.ClpSerializer;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            BrokerLocalServiceUtil.clearService();

            BrokerMessageListenerLocalServiceUtil.clearService();

            BrokersManagerLocalServiceUtil.clearService();

            BrokersManagerServiceUtil.clearService();
        }
    }
}
