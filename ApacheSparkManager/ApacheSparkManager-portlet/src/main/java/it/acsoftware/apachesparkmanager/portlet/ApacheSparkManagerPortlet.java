package it.acsoftware.apachesparkmanager.portlet;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.model.JobEventSchedule;
import it.acsoftware.apachesparkmanager.permission.ApacheSparkManagerModelPermission;
import it.acsoftware.apachesparkmanager.permission.JobDateSchedulePermission;
import it.acsoftware.apachesparkmanager.permission.JobEventSchedulePermission;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil;
import it.acsoftware.apachesparkmanager.util.ApacheSparkManagerScheduler;
import it.acsoftware.apachesparkmanager.util.SparkRestClient;

import java.io.File;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ApacheSparkManager
 */
public class ApacheSparkManagerPortlet extends MVCPortlet {
	public void uploadJarJob(ActionRequest request, ActionResponse response)
			throws Exception {
		UploadRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);
		String appName = ParamUtil.getString(uploadRequest, "appName");
		File f = uploadRequest.getFile("file");
		PortletPreferences portletPreferences = request.getPreferences();
		String result = SparkRestClient.uploadJar(appName, f,
				portletPreferences);
		response.setRenderParameter("result", result);
		response.setRenderParameter("currentTab", "jars");
	}

	public void stopContext(ActionRequest request, ActionResponse response)
			throws Exception {
		String context = ParamUtil.getString(request, "context");
		PortletPreferences portletPreferences = request.getPreferences();
		String result = SparkRestClient
				.stopContext(context, portletPreferences);
		response.setRenderParameter("result", result);
		response.setRenderParameter("currentTab", "contexts");
	}

	public void createContext(ActionRequest request, ActionResponse response)
			throws Exception {
		String name = ParamUtil.getString(request, "name");
		String params = ParamUtil.getString(request, "params");
		PortletPreferences portletPreferences = request.getPreferences();
		String result = SparkRestClient.createContext(name, params,
				portletPreferences);
		response.setRenderParameter("result", result);
		response.setRenderParameter("currentTab", "contexts");
	}

	public void scheduleJob(ActionRequest request, ActionResponse response)
			throws Exception {
		String name = ParamUtil.getString(request, "name");
		String inputParams = ParamUtil.getString(request, "inputParams", "");
		String contextPath = ParamUtil.getString(request, "contextPath", "");
		String params = ParamUtil.getString(request, "params");

		boolean synch = ParamUtil.getBoolean(request, "synch", false);
		String result = SparkRestClient.scheduleJob(name, inputParams,
				contextPath, params, synch, request.getPreferences());
		response.setRenderParameter("result", result);
		response.setRenderParameter("currentTab", "jobs");
	}

	public void saveOrUpdateSchedule(ActionRequest request,
			ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		long jobEventScheduleId = ParamUtil.getLong(request,
				"jobEventScheduleId");
		boolean isNew = jobEventScheduleId == 0;
		JobEventSchedule jes = null;

		if (!isNew) {
			jes = JobEventScheduleLocalServiceUtil
					.fetchJobEventSchedule(jobEventScheduleId);
		} else {
			jes = JobEventScheduleLocalServiceUtil
					.createJobEventSchedule(CounterLocalServiceUtil
							.increment(JobEventSchedule.class.getName()));
			jes.setCreateDate(new Date());
		}

		if (isNew
				&& ApacheSparkManagerModelPermission.contains(
						themeDisplay.getPermissionChecker(),
						themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)
				|| !isNew
				&& JobEventSchedulePermission.contains(
						themeDisplay.getPermissionChecker(), jes,
						ActionKeys.UPDATE)) {
			String eventName = ParamUtil.getString(request, "eventName");
			String jarName = ParamUtil.getString(request, "jarName");
			String mainClass = ParamUtil.getString(request, "mainClass");
			boolean active = ParamUtil.getBoolean(request, "active");
			String[] paramsIndexes = ParamUtil.getString(request,
					"paramsIndexes").split(",");
			StringBuilder params = new StringBuilder();
			for (int i = 0; i < paramsIndexes.length; i++) {
				String paramName = ParamUtil.getString(request, "paramName"
						+ paramsIndexes[i]);
				String paramValue = ParamUtil.getString(request, "paramType"
						+ paramsIndexes[i]);
				String paramRequired = ParamUtil.getString(request,
						"paramRequired" + paramsIndexes[i]);
				params.append(paramName + "$" + paramValue + "$"
						+ paramRequired + ";");
			}
			jes.setCompanyId(themeDisplay.getCompanyId());
			jes.setGroupId(themeDisplay.getCompanyGroupId());
			jes.setUserName(themeDisplay.getUser().getScreenName());
			jes.setUserId(themeDisplay.getUserId());
			jes.setModifiedDate(new Date());
			jes.setEventName(eventName);
			jes.setJarName(jarName);
			jes.setActive(active);
			jes.setMainClass(mainClass);
			jes.setParams(params.toString());
			try {
				JobEventScheduleLocalServiceUtil.saveOrUpdareJobEventSchedule(
						jes, themeDisplay.getLocale(), portletConfig);
				response.setRenderParameter("currentTab", "scheduleEvents");
				response.setRenderParameter("mvcPath",
						"/html/apachesparkmanager/view.jsp");
			} catch (Exception e) {
				SessionErrors.add(request,
						"it.acsoftware.apachesparkmanager.error");
				request.setAttribute("jobEventSchedule", jes);
				response.setRenderParameter("errorMessage", e.getMessage());
				response.setRenderParameter("mvcPath",
						"/html/apachesparkmanager/tabs/scheduleEvents.jsp");
			}
		} else {
			SessionErrors.add(request,
					"it.acsoftware.apachesparkmanager.permissionException");
			response.setRenderParameter("mvcPath",
					"/html/apachesparkmanager/tabs/scheduleEvents.jsp");
		}

	}

	public void saveOrUpdateDateSchedule(ActionRequest request,
			ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		long jobDateScheduleId = ParamUtil
				.getLong(request, "jobDateScheduleId");
		
		boolean isNew = ParamUtil
				.getBoolean(request, "isNew");
		
		JobDateSchedule jds = null;

		if (!isNew) {
			jds = JobDateScheduleLocalServiceUtil
					.fetchJobDateSchedule(jobDateScheduleId);
		} else {
			jds = JobDateScheduleLocalServiceUtil
					.createJobDateSchedule(CounterLocalServiceUtil
							.increment(JobDateSchedule.class.getName()));
			jds.setCreateDate(new Date());
		}

		if (isNew
				&& ApacheSparkManagerModelPermission.contains(
						themeDisplay.getPermissionChecker(),
						themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)
				|| !isNew
				&& JobDateSchedulePermission.contains(
						themeDisplay.getPermissionChecker(), jds,
						ActionKeys.UPDATE)) {
			String scheduleName = ParamUtil.getString(request, "scheduleName");
			String chronExpression = ParamUtil.getString(request,
					"chronExpression");
			String jarName = ParamUtil.getString(request, "jarName");
			String mainClass = ParamUtil.getString(request, "mainClass");
			boolean active = ParamUtil.getBoolean(request, "active");
			String[] paramsIndexes = ParamUtil.getString(request,
					"paramsIndexes").split(",");
			StringBuilder params = new StringBuilder();
			for (int i = 0; i < paramsIndexes.length; i++) {
				String paramName = ParamUtil.getString(request, "paramName"
						+ paramsIndexes[i]);
				String paramValue = ParamUtil.getString(request, "paramType"
						+ paramsIndexes[i]);
				String paramRequired = ParamUtil.getString(request,
						"paramRequired" + paramsIndexes[i]);
				params.append(paramName + "$" + paramValue + "$"
						+ paramRequired + ";");
			}
			jds.setCompanyId(themeDisplay.getCompanyId());
			jds.setGroupId(themeDisplay.getCompanyGroupId());
			jds.setUserName(themeDisplay.getUser().getScreenName());
			jds.setUserId(themeDisplay.getUserId());
			jds.setModifiedDate(new Date());
			jds.setScheduleName(scheduleName);
			jds.setJarName(jarName);
			jds.setMainClass(mainClass);
			jds.setChronExpression(chronExpression);
			jds.setParams(params.toString());
			jds.setActive(active);
			try {
				JobDateScheduleLocalServiceUtil.saveOrUpdareJobDateSchedule(
						jds, themeDisplay.getLocale(), portletConfig);
				response.setRenderParameter("currentTab", "scheduleDate");
				response.setRenderParameter("mvcPath",
						"/html/apachesparkmanager/view.jsp");
			} catch (Exception e) {
				SessionErrors.add(request,
						"it.acsoftware.apachesparkmanager.error");
				request.setAttribute("jobDateSchedule", jds);
				response.setRenderParameter("errorMessage", e.getMessage());
				response.setRenderParameter("mvcPath",
						"/html/apachesparkmanager/tabs/scheduleDate.jsp");
			}
		} else {
			SessionErrors.add(request,
					"it.acsoftware.apachesparkmanager.permissionException");
			response.setRenderParameter("mvcPath",
					"/html/apachesparkmanager/tabs/scheduleDate.jsp");
		}

	}

	public void deleteScheduledEvent(ActionRequest request,
			ActionResponse response) throws Exception {
		long jobEventScheduleId = ParamUtil.getLong(request,
				"jobEventScheduleId");
		JobEventScheduleLocalServiceUtil
				.deleteJobEventSchedule(jobEventScheduleId);
		response.setRenderParameter("currentTab", "scheduleEvents");
		response.setRenderParameter("mvcPath",
				"/html/apachesparkmanager/view.jsp");
	}
	
	public void deleteScheduledDate(ActionRequest request,
			ActionResponse response) throws Exception {
		long jobDateScheduleId = ParamUtil.getLong(request,
				"jobDateScheduleId");
		ApacheSparkManagerScheduler.getInstance().removeJobDateScheduling(jobDateScheduleId);
		JobDateScheduleLocalServiceUtil
				.deleteJobDateSchedule(jobDateScheduleId);
		response.setRenderParameter("currentTab", "scheduleDate");
		response.setRenderParameter("mvcPath",
				"/html/apachesparkmanager/view.jsp");
	}

}
