package it.acsoftware.apachesparkmanager.util;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class JobDateSchedulerMessageListener implements MessageListener {
	private static Log logger = LogFactoryUtil
			.getLog(JobDateSchedulerMessageListener.class);

	@Override
	public void receive(Message message) throws MessageListenerException {
		Long jdsId = Long.parseLong((String)message.getPayload());
		if (jdsId != null) {
			try {
				JobDateSchedule jds = JobDateScheduleLocalServiceUtil.fetchJobDateSchedule(jdsId);
				JobDateScheduleLocalServiceUtil.fireApacheSparkJobDate(jds,
						jds.getParamsMap());
			} catch (Exception e) {
				logger.error(e);
			}
		}

	}
}
