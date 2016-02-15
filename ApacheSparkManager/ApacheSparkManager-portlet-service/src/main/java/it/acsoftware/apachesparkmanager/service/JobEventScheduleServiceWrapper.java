package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobEventScheduleService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobEventScheduleService
 * @generated
 */
public class JobEventScheduleServiceWrapper implements JobEventScheduleService,
    ServiceWrapper<JobEventScheduleService> {
    private JobEventScheduleService _jobEventScheduleService;

    public JobEventScheduleServiceWrapper(
        JobEventScheduleService jobEventScheduleService) {
        _jobEventScheduleService = jobEventScheduleService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _jobEventScheduleService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _jobEventScheduleService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _jobEventScheduleService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> getEventList(
        long companyId) {
        return _jobEventScheduleService.getEventList(companyId);
    }

    @Override
    public void fireApacheSparkJobEvent(long companyId,
        java.lang.String jobEventName,
        java.util.HashMap<java.lang.String, java.lang.String> params) {
        _jobEventScheduleService.fireApacheSparkJobEvent(companyId,
            jobEventName, params);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JobEventScheduleService getWrappedJobEventScheduleService() {
        return _jobEventScheduleService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJobEventScheduleService(
        JobEventScheduleService jobEventScheduleService) {
        _jobEventScheduleService = jobEventScheduleService;
    }

    @Override
    public JobEventScheduleService getWrappedService() {
        return _jobEventScheduleService;
    }

    @Override
    public void setWrappedService(
        JobEventScheduleService jobEventScheduleService) {
        _jobEventScheduleService = jobEventScheduleService;
    }
}
