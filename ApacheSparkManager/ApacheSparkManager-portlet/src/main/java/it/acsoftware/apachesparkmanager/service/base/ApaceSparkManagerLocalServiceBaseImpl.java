package it.acsoftware.apachesparkmanager.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalService;
import it.acsoftware.apachesparkmanager.service.persistence.JobDateSchedulePersistence;
import it.acsoftware.apachesparkmanager.service.persistence.JobEventSchedulePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the apace spark manager local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.acsoftware.apachesparkmanager.service.impl.ApaceSparkManagerLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.apachesparkmanager.service.impl.ApaceSparkManagerLocalServiceImpl
 * @see it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalServiceUtil
 * @generated
 */
public abstract class ApaceSparkManagerLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements ApaceSparkManagerLocalService,
        IdentifiableBean {
    @BeanReference(type = it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalService.class)
    protected it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalService apaceSparkManagerLocalService;
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
    private ApaceSparkManagerLocalServiceClpInvoker _clpInvoker = new ApaceSparkManagerLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalServiceUtil} to access the apace spark manager local service.
     */

    /**
     * Returns the apace spark manager local service.
     *
     * @return the apace spark manager local service
     */
    public it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalService getApaceSparkManagerLocalService() {
        return apaceSparkManagerLocalService;
    }

    /**
     * Sets the apace spark manager local service.
     *
     * @param apaceSparkManagerLocalService the apace spark manager local service
     */
    public void setApaceSparkManagerLocalService(
        it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalService apaceSparkManagerLocalService) {
        this.apaceSparkManagerLocalService = apaceSparkManagerLocalService;
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
    }

    public void destroy() {
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

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = InfrastructureUtil.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
