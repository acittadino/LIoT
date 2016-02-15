package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApacheSparkManagerService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApacheSparkManagerService
 * @generated
 */
public class ApacheSparkManagerServiceWrapper
    implements ApacheSparkManagerService,
        ServiceWrapper<ApacheSparkManagerService> {
    private ApacheSparkManagerService _apacheSparkManagerService;

    public ApacheSparkManagerServiceWrapper(
        ApacheSparkManagerService apacheSparkManagerService) {
        _apacheSparkManagerService = apacheSparkManagerService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _apacheSparkManagerService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _apacheSparkManagerService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _apacheSparkManagerService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ApacheSparkManagerService getWrappedApacheSparkManagerService() {
        return _apacheSparkManagerService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedApacheSparkManagerService(
        ApacheSparkManagerService apacheSparkManagerService) {
        _apacheSparkManagerService = apacheSparkManagerService;
    }

    @Override
    public ApacheSparkManagerService getWrappedService() {
        return _apacheSparkManagerService;
    }

    @Override
    public void setWrappedService(
        ApacheSparkManagerService apacheSparkManagerService) {
        _apacheSparkManagerService = apacheSparkManagerService;
    }
}
