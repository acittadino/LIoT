package it.acsoftware.apachesparkmanager.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import it.acsoftware.apachesparkmanager.model.JobEventSchedule;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalService;
import it.acsoftware.apachesparkmanager.service.persistence.JobDateSchedulePersistence;
import it.acsoftware.apachesparkmanager.service.persistence.JobEventSchedulePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the job event schedule local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.acsoftware.apachesparkmanager.service.impl.JobEventScheduleLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.apachesparkmanager.service.impl.JobEventScheduleLocalServiceImpl
 * @see it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil
 * @generated
 */
public abstract class JobEventScheduleLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements JobEventScheduleLocalService,
        IdentifiableBean {
    @BeanReference(type = it.acsoftware.apachesparkmanager.service.ApacheSparkManagerLocalService.class)
    protected it.acsoftware.apachesparkmanager.service.ApacheSparkManagerLocalService apacheSparkManagerLocalService;
    @BeanReference(type = it.acsoftware.apachesparkmanager.service.ApacheSparkManagerService.class)
    protected it.acsoftware.apachesparkmanager.service.ApacheSparkManagerService apacheSparkManagerService;
    @BeanReference(type = it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalService.class)
    protected it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalService jobDateScheduleLocalService;
    @BeanReference(type = it.acsoftware.apachesparkmanager.service.JobDateScheduleService.class)
    protected it.acsoftware.apachesparkmanager.service.JobDateScheduleService jobDateScheduleService;
    @BeanReference(type = JobDateSchedulePersistence.class)
    protected JobDateSchedulePersistence jobDateSchedulePersistence;
    @BeanReference(type = it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalService.class)
    protected it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalService jobEventScheduleLocalService;
    @BeanReference(type = it.acsoftware.apachesparkmanager.service.JobEventScheduleService.class)
    protected it.acsoftware.apachesparkmanager.service.JobEventScheduleService jobEventScheduleService;
    @BeanReference(type = JobEventSchedulePersistence.class)
    protected JobEventSchedulePersistence jobEventSchedulePersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private JobEventScheduleLocalServiceClpInvoker _clpInvoker = new JobEventScheduleLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil} to access the job event schedule local service.
     */

    /**
     * Adds the job event schedule to the database. Also notifies the appropriate model listeners.
     *
     * @param jobEventSchedule the job event schedule
     * @return the job event schedule that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public JobEventSchedule addJobEventSchedule(
        JobEventSchedule jobEventSchedule) throws SystemException {
        jobEventSchedule.setNew(true);

        return jobEventSchedulePersistence.update(jobEventSchedule);
    }

    /**
     * Creates a new job event schedule with the primary key. Does not add the job event schedule to the database.
     *
     * @param jobEventScheduleId the primary key for the new job event schedule
     * @return the new job event schedule
     */
    @Override
    public JobEventSchedule createJobEventSchedule(long jobEventScheduleId) {
        return jobEventSchedulePersistence.create(jobEventScheduleId);
    }

    /**
     * Deletes the job event schedule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param jobEventScheduleId the primary key of the job event schedule
     * @return the job event schedule that was removed
     * @throws PortalException if a job event schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public JobEventSchedule deleteJobEventSchedule(long jobEventScheduleId)
        throws PortalException, SystemException {
        return jobEventSchedulePersistence.remove(jobEventScheduleId);
    }

    /**
     * Deletes the job event schedule from the database. Also notifies the appropriate model listeners.
     *
     * @param jobEventSchedule the job event schedule
     * @return the job event schedule that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public JobEventSchedule deleteJobEventSchedule(
        JobEventSchedule jobEventSchedule) throws SystemException {
        return jobEventSchedulePersistence.remove(jobEventSchedule);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(JobEventSchedule.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return jobEventSchedulePersistence.findWithDynamicQuery(dynamicQuery);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return jobEventSchedulePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return jobEventSchedulePersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return jobEventSchedulePersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return jobEventSchedulePersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public JobEventSchedule fetchJobEventSchedule(long jobEventScheduleId)
        throws SystemException {
        return jobEventSchedulePersistence.fetchByPrimaryKey(jobEventScheduleId);
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
    public JobEventSchedule getJobEventSchedule(long jobEventScheduleId)
        throws PortalException, SystemException {
        return jobEventSchedulePersistence.findByPrimaryKey(jobEventScheduleId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return jobEventSchedulePersistence.findByPrimaryKey(primaryKeyObj);
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
    public List<JobEventSchedule> getJobEventSchedules(int start, int end)
        throws SystemException {
        return jobEventSchedulePersistence.findAll(start, end);
    }

    /**
     * Returns the number of job event schedules.
     *
     * @return the number of job event schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getJobEventSchedulesCount() throws SystemException {
        return jobEventSchedulePersistence.countAll();
    }

    /**
     * Updates the job event schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param jobEventSchedule the job event schedule
     * @return the job event schedule that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public JobEventSchedule updateJobEventSchedule(
        JobEventSchedule jobEventSchedule) throws SystemException {
        return jobEventSchedulePersistence.update(jobEventSchedule);
    }

    /**
     * Returns the apache spark manager local service.
     *
     * @return the apache spark manager local service
     */
    public it.acsoftware.apachesparkmanager.service.ApacheSparkManagerLocalService getApacheSparkManagerLocalService() {
        return apacheSparkManagerLocalService;
    }

    /**
     * Sets the apache spark manager local service.
     *
     * @param apacheSparkManagerLocalService the apache spark manager local service
     */
    public void setApacheSparkManagerLocalService(
        it.acsoftware.apachesparkmanager.service.ApacheSparkManagerLocalService apacheSparkManagerLocalService) {
        this.apacheSparkManagerLocalService = apacheSparkManagerLocalService;
    }

    /**
     * Returns the apache spark manager remote service.
     *
     * @return the apache spark manager remote service
     */
    public it.acsoftware.apachesparkmanager.service.ApacheSparkManagerService getApacheSparkManagerService() {
        return apacheSparkManagerService;
    }

    /**
     * Sets the apache spark manager remote service.
     *
     * @param apacheSparkManagerService the apache spark manager remote service
     */
    public void setApacheSparkManagerService(
        it.acsoftware.apachesparkmanager.service.ApacheSparkManagerService apacheSparkManagerService) {
        this.apacheSparkManagerService = apacheSparkManagerService;
    }

    /**
     * Returns the job date schedule local service.
     *
     * @return the job date schedule local service
     */
    public it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalService getJobDateScheduleLocalService() {
        return jobDateScheduleLocalService;
    }

    /**
     * Sets the job date schedule local service.
     *
     * @param jobDateScheduleLocalService the job date schedule local service
     */
    public void setJobDateScheduleLocalService(
        it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalService jobDateScheduleLocalService) {
        this.jobDateScheduleLocalService = jobDateScheduleLocalService;
    }

    /**
     * Returns the job date schedule remote service.
     *
     * @return the job date schedule remote service
     */
    public it.acsoftware.apachesparkmanager.service.JobDateScheduleService getJobDateScheduleService() {
        return jobDateScheduleService;
    }

    /**
     * Sets the job date schedule remote service.
     *
     * @param jobDateScheduleService the job date schedule remote service
     */
    public void setJobDateScheduleService(
        it.acsoftware.apachesparkmanager.service.JobDateScheduleService jobDateScheduleService) {
        this.jobDateScheduleService = jobDateScheduleService;
    }

    /**
     * Returns the job date schedule persistence.
     *
     * @return the job date schedule persistence
     */
    public JobDateSchedulePersistence getJobDateSchedulePersistence() {
        return jobDateSchedulePersistence;
    }

    /**
     * Sets the job date schedule persistence.
     *
     * @param jobDateSchedulePersistence the job date schedule persistence
     */
    public void setJobDateSchedulePersistence(
        JobDateSchedulePersistence jobDateSchedulePersistence) {
        this.jobDateSchedulePersistence = jobDateSchedulePersistence;
    }

    /**
     * Returns the job event schedule local service.
     *
     * @return the job event schedule local service
     */
    public it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalService getJobEventScheduleLocalService() {
        return jobEventScheduleLocalService;
    }

    /**
     * Sets the job event schedule local service.
     *
     * @param jobEventScheduleLocalService the job event schedule local service
     */
    public void setJobEventScheduleLocalService(
        it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalService jobEventScheduleLocalService) {
        this.jobEventScheduleLocalService = jobEventScheduleLocalService;
    }

    /**
     * Returns the job event schedule remote service.
     *
     * @return the job event schedule remote service
     */
    public it.acsoftware.apachesparkmanager.service.JobEventScheduleService getJobEventScheduleService() {
        return jobEventScheduleService;
    }

    /**
     * Sets the job event schedule remote service.
     *
     * @param jobEventScheduleService the job event schedule remote service
     */
    public void setJobEventScheduleService(
        it.acsoftware.apachesparkmanager.service.JobEventScheduleService jobEventScheduleService) {
        this.jobEventScheduleService = jobEventScheduleService;
    }

    /**
     * Returns the job event schedule persistence.
     *
     * @return the job event schedule persistence
     */
    public JobEventSchedulePersistence getJobEventSchedulePersistence() {
        return jobEventSchedulePersistence;
    }

    /**
     * Sets the job event schedule persistence.
     *
     * @param jobEventSchedulePersistence the job event schedule persistence
     */
    public void setJobEventSchedulePersistence(
        JobEventSchedulePersistence jobEventSchedulePersistence) {
        this.jobEventSchedulePersistence = jobEventSchedulePersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("it.acsoftware.apachesparkmanager.model.JobEventSchedule",
            jobEventScheduleLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "it.acsoftware.apachesparkmanager.model.JobEventSchedule");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return JobEventSchedule.class;
    }

    protected String getModelClassName() {
        return JobEventSchedule.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = jobEventSchedulePersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
