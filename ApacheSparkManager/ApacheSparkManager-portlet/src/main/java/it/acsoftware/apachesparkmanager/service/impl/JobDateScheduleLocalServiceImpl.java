package it.acsoftware.apachesparkmanager.service.impl;

import it.acsoftware.apachesparkmanager.BeanValidationException;
import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.service.base.JobDateScheduleLocalServiceBaseImpl;
import it.acsoftware.apachesparkmanager.util.ApacheSparkManagerScheduler;
import it.acsoftware.apachesparkmanager.util.SparkRestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletConfig;

import org.quartz.CronExpression;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;

/**
 * The implementation of the job date schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.apachesparkmanager.service.base.JobDateScheduleLocalServiceBaseImpl
 * @see it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil
 */
public class JobDateScheduleLocalServiceImpl extends
		JobDateScheduleLocalServiceBaseImpl {

	private static Log logger = LogFactoryUtil
			.getLog(JobDateScheduleLocalServiceImpl.class);

	public JobDateSchedule saveOrUpdareJobDateSchedule(JobDateSchedule jds,
			Locale currentLocale, PortletConfig config) throws SystemException,
			BeanValidationException {
		check(jds, currentLocale, config);

		boolean isNew = jds.isNew();
		jds = jobDateSchedulePersistence.update(jds);

		if (isNew && jds != null) {
			try {
				Group g = GroupLocalServiceUtil.getCompanyGroup(jds
						.getCompanyId());
				ResourceLocalServiceUtil.addResources(jds.getCompanyId(),
						g.getGroupId(), jds.getUserId(),
						JobDateSchedule.class.getName(),
						jds.getJobDateScheduleId(), false, true, false);
			} catch (Exception e) {
				logger.error(e);
			}
		}

		if (jds.getActive())
			ApacheSparkManagerScheduler.getInstance().scheduleJob(jds,
					jds.getParamsMap());
		else
			try {
				ApacheSparkManagerScheduler.getInstance()
						.removeJobDateScheduling(jds.getJobDateScheduleId());
			} catch (Exception e) {
				logger.error(e);
			}

		return jds;
	}

	private void check(JobDateSchedule jes, Locale currentLocale,
			PortletConfig config) throws BeanValidationException {
		if (Validator.isNull(jes))
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.apachesparkmanager.validationBeanNull"));

		boolean valid = true;
		boolean alreadyExists = false;

		StringBuilder invalidFields = new StringBuilder();

		if (Validator.isNull(jes.getScheduleName())) {
			valid = false;
			invalidFields
					.append(LanguageUtil
							.get(config, currentLocale,
									"it.acsoftware.apachesparkmanager.label.scheduleName"))
					.append(",");
		}

		if (Validator.isNull(jes.getJarName())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.apachesparkmanager.label.jarName"))
					.append(",");
		}

		if (Validator.isNull(jes.getMainClass())) {
			valid = false;
			invalidFields
					.append(LanguageUtil.get(config, currentLocale,
							"it.acsoftwareapachesparkmanager..label.mainClass"))
					.append(",");
		}

		if (!CronExpression.isValidExpression(jes.getChronExpression())) {
			valid = false;
			invalidFields
					.append(LanguageUtil
							.get(config, currentLocale,
									"it.acsoftware.apachesparkmanager.label.cronExpression"))
					.append(",");
		}

		if (valid) {
			alreadyExists = false;
		} else if (!valid) {
			String invalid = invalidFields.substring(0,
					invalidFields.length() - 1);
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.apachesparkmanager.validationError")
					+ " " + invalid);
		} else if (valid && alreadyExists) {
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.apachesparkmanager.alreadyExists")
					+ " " + invalidFields.toString());
		}
	}

	public List<JobDateSchedule> findByCompanyId(long companyId) {
		try {
			return jobDateSchedulePersistence.findBycompanyId(companyId);
		} catch (Exception e) {
			return new ArrayList<JobDateSchedule>();
		}
	}

	public void fireApacheSparkJobDate(JobDateSchedule jds,
			HashMap<String, String> inputParamsMap) {
		try {
			List<String> inputParams = new ArrayList<String>();
			String[] jobParams = jds.getParams().split(";");
			boolean canSchedule = true;
			for (int j = 0; j < jobParams.length; j++) {
				String[] jobParam = jobParams[j].split("\\$");
				String paramName = "";
				boolean required = false;
				if (jobParam.length > 0)
					paramName = jobParam[0];
				if (jobParam.length > 2)
					required = Boolean.parseBoolean(jobParam[2]);

				// add the param in the input param list following the order
				// specified in the definition
				if (Validator.isNotNull(paramName)
						&& inputParamsMap.containsKey(paramName)) {
					inputParams.add(inputParamsMap.get(paramName));
				} else if (required)
					canSchedule = false;
			}
			// job scheduled if all parameters required from the event are
			// present in the input parameters
			if (canSchedule) {
				String inputString = SparkRestClient
						.createInputSting(inputParams);
				SparkRestClient.startAsynchJob(jds.getCompanyId(),
						jds.getJarName(), jds.getMainClass(), inputString);
			}

		} catch (Exception e) {
			logger.error(e);
		}
	}
}
