package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ApacheSparkManager. This utility wraps
 * {@link it.acsoftware.apachesparkmanager.service.impl.ApacheSparkManagerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ApacheSparkManagerLocalService
 * @see it.acsoftware.apachesparkmanager.service.base.ApacheSparkManagerLocalServiceBaseImpl
 * @see it.acsoftware.apachesparkmanager.service.impl.ApacheSparkManagerLocalServiceImpl
 * @generated
 */
public class ApacheSparkManagerLocalServiceUtil {
    private static ApacheSparkManagerLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link it.acsoftware.apachesparkmanager.service.impl.ApacheSparkManagerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static ApacheSparkManagerLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ApacheSparkManagerLocalService.class.getName());

            if (invokableLocalService instanceof ApacheSparkManagerLocalService) {
                _service = (ApacheSparkManagerLocalService) invokableLocalService;
            } else {
                _service = new ApacheSparkManagerLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ApacheSparkManagerLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ApacheSparkManagerLocalService service) {
    }
}
