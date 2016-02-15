package it.acsoftware.brokerportlet.permission;

import it.acsoftware.brokerportlet.model.BrokerMessageListener;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class BrokerMessageListenerPermission {
	public static final String RESOURCE_NAME = "it.acsoftware.brokerportlet.model.BrokerMessageListener";
	

	public static void check(PermissionChecker permissionChecker,
			BrokerMessageListener brokerMessageListener, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, brokerMessageListener, actionId)) {
			throw new PrincipalException();
		}

	}

	public static boolean contains(PermissionChecker permissionChecker,
			BrokerMessageListener brokerMessageListener, String actionId) {
		if (permissionChecker.hasOwnerPermission(brokerMessageListener.getCompanyId(),
				BrokerMessageListener.class.getName(), brokerMessageListener.getBrokerMessageListenerId(),
				brokerMessageListener.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(brokerMessageListener.getGroupId(),
				RESOURCE_NAME, brokerMessageListener.getBrokerMessageListenerId(), actionId);
	}

}
