package it.acsoftware.liotexamples.services.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.acsoftware.liotexamples.services.service.ClpSerializer;
import it.acsoftware.liotexamples.services.service.LIoTExamplesLocalServiceUtil;


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
            LIoTExamplesLocalServiceUtil.clearService();
        }
    }
}
