package it.acsoftware.apachesparkmanager.permission;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class JobDateSchedulePermission {
	public static final String RESOURCE_NAME = "it.acsoftware.apachesparkmanager.model.JobDateSchedule";

	public static void check(PermissionChecker permissionChecker,
			JobDateSchedule jds, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, jds, actionId)) {
			throw new PrincipalException();
		}

	}

	public static boolean contains(PermissionChecker permissionChecker,
			JobDateSchedule jds, String actionId) {
		if (permissionChecker.hasOwnerPermission(jds.getCompanyId(),
				JobDateSchedule.class.getName(), jds.getJobDateScheduleId(),
				jds.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(jds.getGroupId(), RESOURCE_NAME,
				jds.getJobDateScheduleId(), actionId);
	}

}
