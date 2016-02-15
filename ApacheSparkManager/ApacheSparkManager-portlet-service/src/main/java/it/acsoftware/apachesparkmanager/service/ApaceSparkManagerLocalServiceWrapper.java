package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApaceSparkManagerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApaceSparkManagerLocalService
 * @generated
 */
public class ApaceSparkManagerLocalServiceWrapper
    implements ApaceSparkManagerLocalService,
        ServiceWrapper<ApaceSparkManagerLocalService> {
    private ApaceSparkManagerLocalService _apaceSparkManagerLocalService;

    public ApaceSparkManagerLocalServiceWrapper(
        ApaceSparkManagerLocalService apaceSparkManagerLocalService) {
        _apaceSparkManagerLocalService = apaceSparkManagerLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _apaceSparkManagerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _apaceSparkManagerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _apaceSparkManagerLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ApaceSparkManagerLocalService getWrappedApaceSparkManagerLocalService() {
        return _apaceSparkManagerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedApaceSparkManagerLocalService(
        ApaceSparkManagerLocalService apaceSparkManagerLocalService) {
        _apaceSparkManagerLocalService = apaceSparkManagerLocalService;
    }

    @Override
    public ApaceSparkManagerLocalService getWrappedService() {
        return _apaceSparkManagerLocalService;
    }

    @Override
    public void setWrappedService(
        ApaceSparkManagerLocalService apaceSparkManagerLocalService) {
        _apaceSparkManagerLocalService = apaceSparkManagerLocalService;
    }
}
