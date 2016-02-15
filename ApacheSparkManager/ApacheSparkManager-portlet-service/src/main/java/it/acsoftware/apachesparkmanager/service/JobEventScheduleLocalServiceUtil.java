package it.acsoftware.apachesparkmanager.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for JobEventSchedule. This utility wraps
 * {@link it.acsoftware.apachesparkmanager.service.impl.JobEventScheduleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see JobEventScheduleLocalService
 * @see it.acsoftware.apachesparkmanager.service.base.JobEventScheduleLocalServiceBaseImpl
 * @see it.acsoftware.apachesparkmanager.service.impl.JobEventScheduleLocalServiceImpl
 * @generated
 */
public class JobEventScheduleLocalServiceUtil {
    private static JobEventScheduleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link it.acsoftware.apachesparkmanager.service.impl.JobEventScheduleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the job event schedule to the database. Also notifies the appropriate model listeners.
    *
    * @param jobEventSchedule the job event schedule
    * @return the job event schedule that was added
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule addJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addJobEventSchedule(jobEventSchedule);
    }

    /**
    * Creates a new job event schedule with the primary key. Does not add the job event schedule to the database.
    *
    * @param jobEventScheduleId the primary key for the new job event schedule
    * @return the new job event schedule
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule createJobEventSchedule(
        long jobEventScheduleId) {
        return getService().createJobEventSchedule(jobEventScheduleId);
    }

    /**
    * Deletes the job event schedule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param jobEventScheduleId the primary key of the job event schedule
    * @return the job event schedule that was removed
    * @throws PortalException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule deleteJobEventSchedule(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteJobEventSchedule(jobEventScheduleId);
    }

    /**
    * Deletes the job event schedule from the database. Also notifies the appropriate model listeners.
    *
    * @param jobEventSchedule the job event schedule
    * @return the job event schedule that was removed
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule deleteJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteJobEventSchedule(jobEventSchedule);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule fetchJobEventSchedule(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchJobEventSchedule(jobEventScheduleId);
    }

    /**
    * Returns the job event schedule with the primary key.
    *
    * @param jobEventScheduleId the primary key of the job event schedule
    * @return the job event schedule
    * @throws PortalException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule getJobEventSchedule(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getJobEventSchedule(jobEventScheduleId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> getJobEventSchedules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getJobEventSchedules(start, end);
    }

    /**
    * Returns the number of job event schedules.
    *
    * @return the number of job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static int getJobEventSchedulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getJobEventSchedulesCount();
    }

    /**
    * Updates the job event schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param jobEventSchedule the job event schedule
    * @return the job event schedule that was updated
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule updateJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateJobEventSchedule(jobEventSchedule);
    }

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

    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule saveOrUpdareJobEventSchedule(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jes,
        java.util.Locale currentLocale, javax.portlet.PortletConfig config)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.BeanValidationException {
        return getService()
                   .saveOrUpdareJobEventSchedule(jes, currentLocale, config);
    }

    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findByCompanyId(
        long companyId) {
        return getService().findByCompanyId(companyId);
    }

    public static void fireApacheSparkJobEvent(long companyId,
        java.lang.String name,
        java.util.HashMap<java.lang.String, java.lang.String> inputParamsMap) {
        getService().fireApacheSparkJobEvent(companyId, name, inputParamsMap);
    }

    public static void clearService() {
        _service = null;
    }

    public static JobEventScheduleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    JobEventScheduleLocalService.class.getName());

            if (invokableLocalService instanceof JobEventScheduleLocalService) {
                _service = (JobEventScheduleLocalService) invokableLocalService;
            } else {
                _service = new JobEventScheduleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(JobEventScheduleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(JobEventScheduleLocalService service) {
    }
}
