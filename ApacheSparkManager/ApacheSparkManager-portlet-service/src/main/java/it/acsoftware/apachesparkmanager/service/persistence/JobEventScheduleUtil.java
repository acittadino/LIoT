package it.acsoftware.apachesparkmanager.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.acsoftware.apachesparkmanager.model.JobEventSchedule;

import java.util.List;

/**
 * The persistence utility for the job event schedule service. This utility wraps {@link JobEventSchedulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobEventSchedulePersistence
 * @see JobEventSchedulePersistenceImpl
 * @generated
 */
public class JobEventScheduleUtil {
    private static JobEventSchedulePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(JobEventSchedule jobEventSchedule) {
        getPersistence().clearCache(jobEventSchedule);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<JobEventSchedule> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<JobEventSchedule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<JobEventSchedule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static JobEventSchedule update(JobEventSchedule jobEventSchedule)
        throws SystemException {
        return getPersistence().update(jobEventSchedule);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static JobEventSchedule update(JobEventSchedule jobEventSchedule,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(jobEventSchedule, serviceContext);
    }

    /**
    * Returns all the job event schedules where companyId = &#63; and eventName = &#63;.
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @return the matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findByeventName(
        long companyId, java.lang.String eventName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByeventName(companyId, eventName);
    }

    /**
    * Returns a range of all the job event schedules where companyId = &#63; and eventName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @param start the lower bound of the range of job event schedules
    * @param end the upper bound of the range of job event schedules (not inclusive)
    * @return the range of matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findByeventName(
        long companyId, java.lang.String eventName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByeventName(companyId, eventName, start, end);
    }

    /**
    * Returns an ordered range of all the job event schedules where companyId = &#63; and eventName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @param start the lower bound of the range of job event schedules
    * @param end the upper bound of the range of job event schedules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findByeventName(
        long companyId, java.lang.String eventName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByeventName(companyId, eventName, start, end,
            orderByComparator);
    }

    /**
    * Returns the first job event schedule in the ordered set where companyId = &#63; and eventName = &#63;.
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching job event schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule findByeventName_First(
        long companyId, java.lang.String eventName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence()
                   .findByeventName_First(companyId, eventName,
            orderByComparator);
    }

    /**
    * Returns the first job event schedule in the ordered set where companyId = &#63; and eventName = &#63;.
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching job event schedule, or <code>null</code> if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule fetchByeventName_First(
        long companyId, java.lang.String eventName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByeventName_First(companyId, eventName,
            orderByComparator);
    }

    /**
    * Returns the last job event schedule in the ordered set where companyId = &#63; and eventName = &#63;.
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching job event schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule findByeventName_Last(
        long companyId, java.lang.String eventName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence()
                   .findByeventName_Last(companyId, eventName, orderByComparator);
    }

    /**
    * Returns the last job event schedule in the ordered set where companyId = &#63; and eventName = &#63;.
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching job event schedule, or <code>null</code> if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule fetchByeventName_Last(
        long companyId, java.lang.String eventName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByeventName_Last(companyId, eventName,
            orderByComparator);
    }

    /**
    * Returns the job event schedules before and after the current job event schedule in the ordered set where companyId = &#63; and eventName = &#63;.
    *
    * @param jobEventScheduleId the primary key of the current job event schedule
    * @param companyId the company ID
    * @param eventName the event name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next job event schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule[] findByeventName_PrevAndNext(
        long jobEventScheduleId, long companyId, java.lang.String eventName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence()
                   .findByeventName_PrevAndNext(jobEventScheduleId, companyId,
            eventName, orderByComparator);
    }

    /**
    * Removes all the job event schedules where companyId = &#63; and eventName = &#63; from the database.
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByeventName(long companyId,
        java.lang.String eventName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByeventName(companyId, eventName);
    }

    /**
    * Returns the number of job event schedules where companyId = &#63; and eventName = &#63;.
    *
    * @param companyId the company ID
    * @param eventName the event name
    * @return the number of matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static int countByeventName(long companyId,
        java.lang.String eventName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByeventName(companyId, eventName);
    }

    /**
    * Returns all the job event schedules where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findBycompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycompanyId(companyId);
    }

    /**
    * Returns a range of all the job event schedules where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of job event schedules
    * @param end the upper bound of the range of job event schedules (not inclusive)
    * @return the range of matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findBycompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the job event schedules where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of job event schedules
    * @param end the upper bound of the range of job event schedules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findBycompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first job event schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching job event schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule findBycompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence()
                   .findBycompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first job event schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching job event schedule, or <code>null</code> if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule fetchBycompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last job event schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching job event schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule findBycompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence()
                   .findBycompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last job event schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching job event schedule, or <code>null</code> if a matching job event schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule fetchBycompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the job event schedules before and after the current job event schedule in the ordered set where companyId = &#63;.
    *
    * @param jobEventScheduleId the primary key of the current job event schedule
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next job event schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule[] findBycompanyId_PrevAndNext(
        long jobEventScheduleId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence()
                   .findBycompanyId_PrevAndNext(jobEventScheduleId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the job event schedules where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycompanyId(companyId);
    }

    /**
    * Returns the number of job event schedules where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static int countBycompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycompanyId(companyId);
    }

    /**
    * Caches the job event schedule in the entity cache if it is enabled.
    *
    * @param jobEventSchedule the job event schedule
    */
    public static void cacheResult(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule) {
        getPersistence().cacheResult(jobEventSchedule);
    }

    /**
    * Caches the job event schedules in the entity cache if it is enabled.
    *
    * @param jobEventSchedules the job event schedules
    */
    public static void cacheResult(
        java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> jobEventSchedules) {
        getPersistence().cacheResult(jobEventSchedules);
    }

    /**
    * Creates a new job event schedule with the primary key. Does not add the job event schedule to the database.
    *
    * @param jobEventScheduleId the primary key for the new job event schedule
    * @return the new job event schedule
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule create(
        long jobEventScheduleId) {
        return getPersistence().create(jobEventScheduleId);
    }

    /**
    * Removes the job event schedule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param jobEventScheduleId the primary key of the job event schedule
    * @return the job event schedule that was removed
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule remove(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence().remove(jobEventScheduleId);
    }

    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule updateImpl(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(jobEventSchedule);
    }

    /**
    * Returns the job event schedule with the primary key or throws a {@link it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException} if it could not be found.
    *
    * @param jobEventScheduleId the primary key of the job event schedule
    * @return the job event schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule findByPrimaryKey(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException {
        return getPersistence().findByPrimaryKey(jobEventScheduleId);
    }

    /**
    * Returns the job event schedule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param jobEventScheduleId the primary key of the job event schedule
    * @return the job event schedule, or <code>null</code> if a job event schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.apachesparkmanager.model.JobEventSchedule fetchByPrimaryKey(
        long jobEventScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(jobEventScheduleId);
    }

    /**
    * Returns all the job event schedules.
    *
    * @return the job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the job event schedules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of job event schedules
    * @param end the upper bound of the range of job event schedules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the job event schedules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of job event schedules.
    *
    * @return the number of job event schedules
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static JobEventSchedulePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (JobEventSchedulePersistence) PortletBeanLocatorUtil.locate(it.acsoftware.apachesparkmanager.service.ClpSerializer.getServletContextName(),
                    JobEventSchedulePersistence.class.getName());

            ReferenceRegistry.registerReference(JobEventScheduleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(JobEventSchedulePersistence persistence) {
    }
}
