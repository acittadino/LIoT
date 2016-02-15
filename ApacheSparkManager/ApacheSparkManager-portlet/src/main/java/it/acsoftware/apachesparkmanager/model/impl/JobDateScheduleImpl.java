package it.acsoftware.apachesparkmanager.model.impl;

import java.util.HashMap;

/**
 * The extended model implementation for the JobDateSchedule service. Represents
 * a row in the &quot;ApacheSparkManager_JobDateSchedule&quot; database table,
 * with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link it.acsoftware.apachesparkmanager.model.JobDateSchedule}
 * interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class JobDateScheduleImpl extends JobDateScheduleBaseImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JobDateScheduleImpl() {

	}

	public HashMap<String, String> getParamsMap() {
		HashMap<String, String> paramsMap = new HashMap<>();
		String[] paramsArr = this.getParams().split(";");
		for (int i = 0; i < paramsArr.length; i++) {
			String[] param = paramsArr[i].split("\\$");
			String paramName = "";
			String paramValue = "";
			if (param.length > 0)
				paramName = param[0];
			if (param.length > 1)
				paramValue = param[1];
			paramsMap.put(paramName, paramValue);
		}
		return paramsMap;
	}

	

}
