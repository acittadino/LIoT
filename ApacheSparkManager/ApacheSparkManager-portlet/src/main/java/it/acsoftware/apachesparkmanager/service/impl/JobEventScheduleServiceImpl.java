package it.acsoftware.apachesparkmanager.service.impl;

import it.acsoftware.apachesparkmanager.model.JobEventSchedule;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil;
import it.acsoftware.apachesparkmanager.service.base.JobEventScheduleServiceBaseImpl;
import it.acsoftware.apachesparkmanager.util.ApacheSparkManagerScheduler;

import java.util.HashMap;
import java.util.List;

/**
 * The implementation of the job event schedule remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.acsoftware.apachesparkmanager.service.JobEventScheduleService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.apachesparkmanager.service.base.JobEventScheduleServiceBaseImpl
 * @see it.acsoftware.apachesparkmanager.service.JobEventScheduleServiceUtil
 */
public class JobEventScheduleServiceImpl extends
		JobEventScheduleServiceBaseImpl {

	public List<JobEventSchedule> getEventList(long companyId) {
		List<JobEventSchedule> events = JobEventScheduleLocalServiceUtil
				.findByCompanyId(companyId);
		return events;
	}

	public void fireApacheSparkJobEvent(long companyId, String jobEventName,
			HashMap<String, String> params) {
		ApacheSparkManagerScheduler.getInstance().raiseJobEvent(companyId,
				jobEventName, params);
	}
}
