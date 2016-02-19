package it.acsoftware.liotexamples.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LIoTExamplesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LIoTExamplesLocalService
 * @generated
 */
public class LIoTExamplesLocalServiceWrapper implements LIoTExamplesLocalService,
    ServiceWrapper<LIoTExamplesLocalService> {
    private LIoTExamplesLocalService _lIoTExamplesLocalService;

    public LIoTExamplesLocalServiceWrapper(
        LIoTExamplesLocalService lIoTExamplesLocalService) {
        _lIoTExamplesLocalService = lIoTExamplesLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lIoTExamplesLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lIoTExamplesLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lIoTExamplesLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LIoTExamplesLocalService getWrappedLIoTExamplesLocalService() {
        return _lIoTExamplesLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLIoTExamplesLocalService(
        LIoTExamplesLocalService lIoTExamplesLocalService) {
        _lIoTExamplesLocalService = lIoTExamplesLocalService;
    }

    @Override
    public LIoTExamplesLocalService getWrappedService() {
        return _lIoTExamplesLocalService;
    }

    @Override
    public void setWrappedService(
        LIoTExamplesLocalService lIoTExamplesLocalService) {
        _lIoTExamplesLocalService = lIoTExamplesLocalService;
    }
}
