package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobDateScheduleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobDateScheduleLocalService
 * @generated
 */
public class JobDateScheduleLocalServiceWrapper
    implements JobDateScheduleLocalService,
        ServiceWrapper<JobDateScheduleLocalService> {
    private JobDateScheduleLocalService _jobDateScheduleLocalService;

    public JobDateScheduleLocalServiceWrapper(
        JobDateScheduleLocalService jobDateScheduleLocalService) {
        _jobDateScheduleLocalService = jobDateScheduleLocalService;
    }

    /**
    * Adds the job date schedule to the database. Also notifies the appropriate model listeners.
    *
    * @param jobDateSchedule the job date schedule
    * @return the job date schedule that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule addJobDateSchedule(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jobDateSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.addJobDateSchedule(jobDateSchedule);
    }

    /**
    * Creates a new job date schedule with the primary key. Does not add the job date schedule to the database.
    *
    * @param jobDateScheduleId the primary key for the new job date schedule
    * @return the new job date schedule
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule createJobDateSchedule(
        long jobDateScheduleId) {
        return _jobDateScheduleLocalService.createJobDateSchedule(jobDateScheduleId);
    }

    /**
    * Deletes the job date schedule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param jobDateScheduleId the primary key of the job date schedule
    * @return the job date schedule that was removed
    * @throws PortalException if a job date schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule deleteJobDateSchedule(
        long jobDateScheduleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.deleteJobDateSchedule(jobDateScheduleId);
    }

    /**
    * Deletes the job date schedule from the database. Also notifies the appropriate model listeners.
    *
    * @param jobDateSchedule the job date schedule
    * @return the job date schedule that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule deleteJobDateSchedule(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jobDateSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.deleteJobDateSchedule(jobDateSchedule);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _jobDateScheduleLocalService.dynamicQuery();
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
        return _jobDateScheduleLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _jobDateScheduleLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _jobDateScheduleLocalService.dynamicQuery(dynamicQuery, start,
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
        return _jobDateScheduleLocalService.dynamicQueryCount(dynamicQuery);
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
        return _jobDateScheduleLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule fetchJobDateSchedule(
        long jobDateScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.fetchJobDateSchedule(jobDateScheduleId);
    }

    /**
    * Returns the job date schedule with the primary key.
    *
    * @param jobDateScheduleId the primary key of the job date schedule
    * @return the job date schedule
    * @throws PortalException if a job date schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule getJobDateSchedule(
        long jobDateScheduleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.getJobDateSchedule(jobDateScheduleId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the job date schedules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of job date schedules
    * @param end the upper bound of the range of job date schedules (not inclusive)
    * @return the range of job date schedules
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> getJobDateSchedules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.getJobDateSchedules(start, end);
    }

    /**
    * Returns the number of job date schedules.
    *
    * @return the number of job date schedules
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getJobDateSchedulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.getJobDateSchedulesCount();
    }

    /**
    * Updates the job date schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param jobDateSchedule the job date schedule
    * @return the job date schedule that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule updateJobDateSchedule(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jobDateSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jobDateScheduleLocalService.updateJobDateSchedule(jobDateSchedule);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _jobDateScheduleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _jobDateScheduleLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _jobDateScheduleLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule saveOrUpdareJobDateSchedule(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jds,
        java.util.Locale currentLocale, javax.portlet.PortletConfig config)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.BeanValidationException {
        return _jobDateScheduleLocalService.saveOrUpdareJobDateSchedule(jds,
            currentLocale, config);
    }

    @Override
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> findByCompanyId(
        long companyId) {
        return _jobDateScheduleLocalService.findByCompanyId(companyId);
    }

    @Override
    public void fireApacheSparkJobDate(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jds,
        java.util.HashMap<java.lang.String, java.lang.String> inputParamsMap) {
        _jobDateScheduleLocalService.fireApacheSparkJobDate(jds, inputParamsMap);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JobDateScheduleLocalService getWrappedJobDateScheduleLocalService() {
        return _jobDateScheduleLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJobDateScheduleLocalService(
        JobDateScheduleLocalService jobDateScheduleLocalService) {
        _jobDateScheduleLocalService = jobDateScheduleLocalService;
    }

    @Override
    public JobDateScheduleLocalService getWrappedService() {
        return _jobDateScheduleLocalService;
    }

    @Override
    public void setWrappedService(
        JobDateScheduleLocalService jobDateScheduleLocalService) {
        _jobDateScheduleLocalService = jobDateScheduleLocalService;
    }
}
