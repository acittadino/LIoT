package it.acsoftware.apachesparkmanager.permission;

import it.acsoftware.apachesparkmanager.model.JobEventSchedule;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class JobEventSchedulePermission {
	public static final String RESOURCE_NAME = "it.acsoftware.apachesparkmanager.model.JobEventSchedule";

	public static void check(PermissionChecker permissionChecker,
			JobEventSchedule jes, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, jes, actionId)) {
			throw new PrincipalException();
		}

	}

	public static boolean contains(PermissionChecker permissionChecker,
			JobEventSchedule jes, String actionId) {
		if (permissionChecker.hasOwnerPermission(jes.getCompanyId(),
				JobEventSchedule.class.getName(), jes.getJobEventScheduleId(),
				jes.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(jes.getGroupId(), RESOURCE_NAME,
				jes.getJobEventScheduleId(), actionId);
	}

}
