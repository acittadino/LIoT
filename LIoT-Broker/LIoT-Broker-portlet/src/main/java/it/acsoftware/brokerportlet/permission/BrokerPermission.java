package it.acsoftware.brokerportlet.permission;

import it.acsoftware.brokerportlet.model.Broker;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class BrokerPermission {
	public static final String RESOURCE_NAME = "it.acsoftware.brokerportlet.model.Broker";
	

	public static void check(PermissionChecker permissionChecker,
			Broker broker, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, broker, actionId)) {
			throw new PrincipalException();
		}

	}

	public static boolean contains(PermissionChecker permissionChecker,
			Broker broker, String actionId) {
		if (permissionChecker.hasOwnerPermission(broker.getCompanyId(),
				Broker.class.getName(), broker.getBrokerId(),
				broker.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(broker.getGroupId(),
				RESOURCE_NAME, broker.getBrokerId(), actionId);
	}

}
