package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobDateScheduleService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobDateScheduleService
 * @generated
 */
public class JobDateScheduleServiceWrapper implements JobDateScheduleService,
    ServiceWrapper<JobDateScheduleService> {
    private JobDateScheduleService _jobDateScheduleService;

    public JobDateScheduleServiceWrapper(
        JobDateScheduleService jobDateScheduleService) {
        _jobDateScheduleService = jobDateScheduleService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _jobDateScheduleService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _jobDateScheduleService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _jobDateScheduleService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JobDateScheduleService getWrappedJobDateScheduleService() {
        return _jobDateScheduleService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJobDateScheduleService(
        JobDateScheduleService jobDateScheduleService) {
        _jobDateScheduleService = jobDateScheduleService;
    }

    @Override
    public JobDateScheduleService getWrappedService() {
        return _jobDateScheduleService;
    }

    @Override
    public void setWrappedService(JobDateScheduleService jobDateScheduleService) {
        _jobDateScheduleService = jobDateScheduleService;
    }
}
