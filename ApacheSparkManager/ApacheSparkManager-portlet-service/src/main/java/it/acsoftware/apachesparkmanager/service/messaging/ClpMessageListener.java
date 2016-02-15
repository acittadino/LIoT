package it.acsoftware.apachesparkmanager.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.acsoftware.apachesparkmanager.service.ApacheSparkManagerLocalServiceUtil;
import it.acsoftware.apachesparkmanager.service.ApacheSparkManagerServiceUtil;
import it.acsoftware.apachesparkmanager.service.ClpSerializer;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleServiceUtil;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleServiceUtil;


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
            ApacheSparkManagerLocalServiceUtil.clearService();

            ApacheSparkManagerServiceUtil.clearService();
            JobDateScheduleLocalServiceUtil.clearService();

            JobDateScheduleServiceUtil.clearService();
            JobEventScheduleLocalServiceUtil.clearService();

            JobEventScheduleServiceUtil.clearService();
        }
    }
}
