package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobEventScheduleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobEventScheduleLocalService
 * @generated
 */
public class JobEventScheduleLocalServiceWrapper
    implements JobEventScheduleLocalService,
        ServiceWrapper<JobEventScheduleLocalService> {
    private JobEventScheduleLocalService _jobEventScheduleLocalService;

    public JobEventScheduleLocalServiceWrapper(
        JobEventScheduleLocalService jobEventScheduleLocalService) {
        _jobEventScheduleLocalService = jobEventScheduleLocalService;
    }

    /**
    * Adds the job event schedule to the database. Also notifies the appropriate model listeners.
    *
    * @param jobEventSchedule the job event schedule
    * @return the job event schedule that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule addJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.addJobEventSchedule(jobEventSchedule);
    }

    /**
    * Creates a new job event schedule with the primary key. Does not add the job event schedule to the database.
    *
    * @param jobEventScheduleId the primary key for the new job event schedule
    * @return the new job event schedule
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule createJobEventSchedule(
        long jobEventScheduleId) {
        return _jobEventScheduleLocalService.createJobEventSchedule(jobEventScheduleId);
    }

    /**
    * Deletes the job event schedule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param jobEventScheduleId the primary key of the job event schedule
    * @return the job event schedule that was removed
    * @throws PortalException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule deleteJobEventSchedule(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.deleteJobEventSchedule(jobEventScheduleId);
    }

    /**
    * Deletes the job event schedule from the database. Also notifies the appropriate model listeners.
    *
    * @param jobEventSchedule the job event schedule
    * @return the job event schedule that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule deleteJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.deleteJobEventSchedule(jobEventSchedule);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _jobEventScheduleLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule fetchJobEventSchedule(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.fetchJobEventSchedule(jobEventScheduleId);
    }

    /**
    * Returns the job event schedule with the primary key.
    *
    * @param jobEventScheduleId the primary key of the job event schedule
    * @return the job event schedule
    * @throws PortalException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule getJobEventSchedule(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.getJobEventSchedule(jobEventScheduleId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the job event schedules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of job event schedules
    * @param end the upper bound of the range of job event schedules (not inclusive)
    * @return the range of job event schedules
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> getJobEventSchedules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.getJobEventSchedules(start, end);
    }

    /**
    * Returns the number of job event schedules.
    *
    * @return the number of job event schedules
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getJobEventSchedulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.getJobEventSchedulesCount();
    }

    /**
    * Updates the job event schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param jobEventSchedule the job event schedule
    * @return the job event schedule that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule updateJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobEventScheduleLocalService.updateJobEventSchedule(jobEventSchedule);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _jobEventScheduleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _jobEventScheduleLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _jobEventScheduleLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobEventSchedule saveOrUpdareJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jes,
        java.util.Locale currentLocale, javax.portlet.PortletConfig config)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.BeanValidationException {
        return _jobEventScheduleLocalService.saveOrUpdareJobEventSchedule(jes,
            currentLocale, config);
    }

    @Override
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findByCompanyId(
        long companyId) {
        return _jobEventScheduleLocalService.findByCompanyId(companyId);
    }

    @Override
    public void fireApacheSparkJobEvent(long companyId, java.lang.String name,
        java.util.HashMap<java.lang.String, java.lang.String> inputParamsMap) {
        _jobEventScheduleLocalService.fireApacheSparkJobEvent(companyId, name,
            inputParamsMap);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JobEventScheduleLocalService getWrappedJobEventScheduleLocalService() {
        return _jobEventScheduleLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJobEventScheduleLocalService(
        JobEventScheduleLocalService jobEventScheduleLocalService) {
        _jobEventScheduleLocalService = jobEventScheduleLocalService;
    }

    @Override
    public JobEventScheduleLocalService getWrappedService() {
        return _jobEventScheduleLocalService;
    }

    @Override
    public void setWrappedService(
        JobEventScheduleLocalService jobEventScheduleLocalService) {
        _jobEventScheduleLocalService = jobEventScheduleLocalService;
    }
}
