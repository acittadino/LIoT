package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for JobDateSchedule. This utility wraps
 * {@link it.acsoftware.apachesparkmanager.service.impl.JobDateScheduleServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see JobDateScheduleService
 * @see it.acsoftware.apachesparkmanager.service.base.JobDateScheduleServiceBaseImpl
 * @see it.acsoftware.apachesparkmanager.service.impl.JobDateScheduleServiceImpl
 * @generated
 */
public class JobDateScheduleServiceUtil {
    private static JobDateScheduleService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link it.acsoftware.apachesparkmanager.service.impl.JobDateScheduleServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static JobDateScheduleService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    JobDateScheduleService.class.getName());

            if (invokableService instanceof JobDateScheduleService) {
                _service = (JobDateScheduleService) invokableService;
            } else {
                _service = new JobDateScheduleServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(JobDateScheduleServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(JobDateScheduleService service) {
    }
}
