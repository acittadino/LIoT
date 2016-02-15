package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApacheSparkManagerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApacheSparkManagerLocalService
 * @generated
 */
public class ApacheSparkManagerLocalServiceWrapper
    implements ApacheSparkManagerLocalService,
        ServiceWrapper<ApacheSparkManagerLocalService> {
    private ApacheSparkManagerLocalService _apacheSparkManagerLocalService;

    public ApacheSparkManagerLocalServiceWrapper(
        ApacheSparkManagerLocalService apacheSparkManagerLocalService) {
        _apacheSparkManagerLocalService = apacheSparkManagerLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _apacheSparkManagerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _apacheSparkManagerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _apacheSparkManagerLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ApacheSparkManagerLocalService getWrappedApacheSparkManagerLocalService() {
        return _apacheSparkManagerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedApacheSparkManagerLocalService(
        ApacheSparkManagerLocalService apacheSparkManagerLocalService) {
        _apacheSparkManagerLocalService = apacheSparkManagerLocalService;
    }

    @Override
    public ApacheSparkManagerLocalService getWrappedService() {
        return _apacheSparkManagerLocalService;
    }

    @Override
    public void setWrappedService(
        ApacheSparkManagerLocalService apacheSparkManagerLocalService) {
        _apacheSparkManagerLocalService = apacheSparkManagerLocalService;
    }
}
