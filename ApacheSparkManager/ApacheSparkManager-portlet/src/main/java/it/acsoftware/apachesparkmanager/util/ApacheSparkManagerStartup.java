package it.acsoftware.apachesparkmanager.util;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;

import java.util.List;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;

public class ApacheSparkManagerStartup extends SimpleAction {

	public ApacheSparkManagerStartup() {
		super();
	}

	public void run(String[] ids) throws ActionException {
		for (int i = 0; i < ids.length; i++) {
			long companyId = Long.parseLong(ids[i]);
			List<JobDateSchedule> schedules = JobDateScheduleLocalServiceUtil
					.findByCompanyId(companyId);
			for (int j = 0; j < schedules.size(); j++) {
				JobDateSchedule jds = schedules.get(j);
				//rescheduling all active scheduled jobs
				if (jds.getActive()) {
					ApacheSparkManagerScheduler.getInstance().scheduleJob(jds,
							jds.getParamsMap());
				}
			}
		}
	}

}