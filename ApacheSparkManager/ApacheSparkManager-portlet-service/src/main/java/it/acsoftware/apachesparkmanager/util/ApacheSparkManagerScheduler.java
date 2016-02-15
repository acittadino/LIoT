package it.acsoftware.apachesparkmanager.util;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.CronTrigger;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;

public class ApacheSparkManagerScheduler {
	private static Log logger = LogFactoryUtil
			.getLog(ApacheSparkManagerScheduler.class);
	private static ApacheSparkManagerScheduler instance;

	private List<Long> dateScheduledJobs;
	private HashMap<Long, Trigger> triggers;

	public static ApacheSparkManagerScheduler getInstance() {
		if (instance == null)
			instance = new ApacheSparkManagerScheduler();
		return instance;
	}

	private ApacheSparkManagerScheduler() {
		dateScheduledJobs = new ArrayList<>();
		triggers = new HashMap<>();
	}

	public boolean isDateScheduled(long dateScheduledJobId) {
		return this.dateScheduledJobs.contains(dateScheduledJobId);
	}

	public void scheduleJob(final JobDateSchedule jds,
			HashMap<String, String> params) {
		try {
			if (!dateScheduledJobs.contains(jds.getJobDateScheduleId())
					&& jds.getActive()) {
				Message message = new Message();
				Trigger trigger = new CronTrigger(String.valueOf(jds
						.getJobDateScheduleId()), "RuleManagerGroup",
						new Date(), null, jds.getChronExpression());
				
				message.setPayload(String.valueOf(jds.getJobDateScheduleId()));
				SchedulerEngineHelperUtil
						.schedule(
								trigger,
								StorageType.MEMORY_CLUSTERED,
								trigger.getJobName(),
								ApacheSparkManagerConstants.JOB_DATE_SCHEDULER_MESSAGE_BUS_DESTINATION,
								message, 1);

				dateScheduledJobs.add(jds.getJobDateScheduleId());
				triggers.put(jds.getJobDateScheduleId(), trigger);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void removeJobDateScheduling(long jobDateScheduleId)
			throws SchedulerException {
		if (dateScheduledJobs.contains(jobDateScheduleId)) {
			String groupName = triggers.get(jobDateScheduleId).getGroupName();
			SchedulerEngineHelperUtil.delete(String.valueOf(jobDateScheduleId),
					groupName, StorageType.MEMORY_CLUSTERED);
			dateScheduledJobs.remove(jobDateScheduleId);
			triggers.remove(jobDateScheduleId);
		}
	}

	private void scheduleJob(long companyId, String eventName,
			HashMap<String, String> params) {
		JobEventScheduleLocalServiceUtil.fireApacheSparkJobEvent(companyId,
				eventName, params);
	}

	public void raiseJobEvent(long companyId, String eventName,
			HashMap<String, String> params) {
		scheduleJob(companyId, eventName, params);
	}
}
