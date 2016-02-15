package it.acsoftware.liotexamples.portlet;

import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil;

import java.util.HashMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SparkEventRaiser
 */
public class SparkEventRaiser extends MVCPortlet {
	public void raiseSparkEvent(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		String eventName = ParamUtil.getString(request, "eventName");
		String customPropsIndexes = ParamUtil
				.getString(request, "propsIndexes");
		int indexesProps[] = StringUtil.split(customPropsIndexes, 0);
		HashMap<String, String> params = new HashMap<String, String>();

		for (int i = 0; i < indexesProps.length; i++) {
			int index = indexesProps[i];
			String param = ParamUtil.getString(request, "propName" + index);
			String paramValue = ParamUtil.getString(request, "prop" + index);
			params.put(param, paramValue);
		}
		JobEventScheduleLocalServiceUtil.fireApacheSparkJobEvent(companyId,
				eventName, params);
	}

}
