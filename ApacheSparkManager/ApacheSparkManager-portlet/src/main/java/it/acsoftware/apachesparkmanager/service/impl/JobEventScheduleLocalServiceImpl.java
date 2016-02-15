package it.acsoftware.apachesparkmanager.service.impl;

import it.acsoftware.apachesparkmanager.BeanValidationException;
import it.acsoftware.apachesparkmanager.model.JobEventSchedule;
import it.acsoftware.apachesparkmanager.service.base.JobEventScheduleLocalServiceBaseImpl;
import it.acsoftware.apachesparkmanager.util.SparkRestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletConfig;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;

/**
 * The implementation of the job event schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.apachesparkmanager.service.base.JobEventScheduleLocalServiceBaseImpl
 * @see it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil
 */
public class JobEventScheduleLocalServiceImpl extends
		JobEventScheduleLocalServiceBaseImpl {
	private static Log logger = LogFactoryUtil
			.getLog(JobEventScheduleLocalServiceImpl.class);

	public JobEventSchedule saveOrUpdareJobEventSchedule(JobEventSchedule jes,
			Locale currentLocale, PortletConfig config) throws SystemException,
			BeanValidationException {
		check(jes, currentLocale, config);

		boolean isNew = jes.isNew();
		jes = jobEventSchedulePersistence.update(jes);

		if (isNew && jes != null) {
			try {
				Group g = GroupLocalServiceUtil.getCompanyGroup(jes
						.getCompanyId());
				ResourceLocalServiceUtil.addResources(jes.getCompanyId(),
						g.getGroupId(), jes.getUserId(),
						JobEventSchedule.class.getName(),
						jes.getJobEventScheduleId(), false, true, false);
			} catch (Exception e) {
				logger.error(e);
			}
		}

		return jes;
	}

	private void check(JobEventSchedule jes, Locale currentLocale,
			PortletConfig config) throws BeanValidationException {
		if (Validator.isNull(jes))
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.apachesparkmanager.validationBeanNull"));

		boolean valid = true;
		boolean alreadyExists = false;

		StringBuilder invalidFields = new StringBuilder();

		if (Validator.isNull(jes.getEventName())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.label.eventName")).append(",");
		}

		if (Validator.isNull(jes.getJarName())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.label.jarName")).append(",");
		}

		if (Validator.isNull(jes.getMainClass())) {
			valid = false;
			invalidFields.append(
					LanguageUtil.get(config, currentLocale,
							"it.acsoftware.label.mainClass")).append(",");
		}

		if (valid) {
			alreadyExists = false;
		} else if (!valid) {
			String invalid = invalidFields.substring(0,
					invalidFields.length() - 1);
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale,
					"it.acsoftware.brokerportlet.validationError")
					+ " " + invalid);
		} else if (valid && alreadyExists) {
			throw new BeanValidationException(LanguageUtil.get(config,
					currentLocale, "it.acsoftware.brokerportlet.alreadyExists")
					+ " " + invalidFields.toString());
		}
	}

	public List<JobEventSchedule> findByCompanyId(long companyId) {
		try {
			return jobEventSchedulePersistence.findBycompanyId(companyId);
		} catch (Exception e) {
			return new ArrayList<JobEventSchedule>();
		}
	}

	public void fireApacheSparkJobEvent(long companyId, String name,
			HashMap<String, String> inputParamsMap) {
		try {
			List<JobEventSchedule> eventsSchedules = jobEventSchedulePersistence
					.findByeventName(companyId, name);
			for (int i = 0; i < eventsSchedules.size(); i++) {
				JobEventSchedule jes = eventsSchedules.get(i);
				if (jes.getActive()) {
					List<String> inputParams = new ArrayList<String>();
					String[] jobParams = jes.getParams().split(";");
					boolean canSchedule = true;
					for (int j = 0; j < jobParams.length; j++) {
						String[] jobParam = jobParams[j].split("\\$");
						String paramName = "";
						boolean required = false;
						if (jobParam.length > 0)
							paramName = jobParam[0];
						if (jobParam.length > 2)
							required = Boolean.parseBoolean(jobParam[2]);

						// add the param in the input param list following the
						// order
						// specified in the definition
						if (Validator.isNotNull(paramName)
								&& inputParamsMap.containsKey(paramName)) {
							inputParams.add(inputParamsMap.get(paramName));
						} else if (required)
							canSchedule = false;
					}

					// job scheduled if all parameters required from the event
					// are present in the input parameters
					if (canSchedule) {
						String inputString = SparkRestClient
								.createInputSting(inputParams);
						if (jes.getActive()) {
							SparkRestClient.startAsynchJob(companyId,
									jes.getJarName(), jes.getMainClass(),
									inputString);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
