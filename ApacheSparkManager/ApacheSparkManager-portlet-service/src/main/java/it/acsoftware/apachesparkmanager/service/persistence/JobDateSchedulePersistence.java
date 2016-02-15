package it.acsoftware.apachesparkmanager.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;

/**
 * The persistence interface for the job date schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobDateSchedulePersistenceImpl
 * @see JobDateScheduleUtil
 * @generated
 */
public interface JobDateSchedulePersistence extends BasePersistence<JobDateSchedule> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link JobDateScheduleUtil} to access the job date schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the job date schedules where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching job date schedules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> findBycompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the job date schedules where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of job date schedules
    * @param end the upper bound of the range of job date schedules (not inclusive)
    * @return the range of matching job date schedules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> findBycompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the job date schedules where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of job date schedules
    * @param end the upper bound of the range of job date schedules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching job date schedules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> findBycompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first job date schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching job date schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a matching job date schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule findBycompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException;

    /**
    * Returns the first job date schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching job date schedule, or <code>null</code> if a matching job date schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule fetchBycompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last job date schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching job date schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a matching job date schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule findBycompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException;

    /**
    * Returns the last job date schedule in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching job date schedule, or <code>null</code> if a matching job date schedule could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule fetchBycompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the job date schedules before and after the current job date schedule in the ordered set where companyId = &#63;.
    *
    * @param jobDateScheduleId the primary key of the current job date schedule
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next job date schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a job date schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule[] findBycompanyId_PrevAndNext(
        long jobDateScheduleId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException;

    /**
    * Removes all the job date schedules where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBycompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of job date schedules where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching job date schedules
    * @throws SystemException if a system exception occurred
    */
    public int countBycompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the job date schedule in the entity cache if it is enabled.
    *
    * @param jobDateSchedule the job date schedule
    */
    public void cacheResult(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jobDateSchedule);

    /**
    * Caches the job date schedules in the entity cache if it is enabled.
    *
    * @param jobDateSchedules the job date schedules
    */
    public void cacheResult(
        java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> jobDateSchedules);

    /**
    * Creates a new job date schedule with the primary key. Does not add the job date schedule to the database.
    *
    * @param jobDateScheduleId the primary key for the new job date schedule
    * @return the new job date schedule
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule create(
        long jobDateScheduleId);

    /**
    * Removes the job date schedule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param jobDateScheduleId the primary key of the job date schedule
    * @return the job date schedule that was removed
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a job date schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule remove(
        long jobDateScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException;

    public it.acsoftware.apachesparkmanager.model.JobDateSchedule updateImpl(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jobDateSchedule)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the job date schedule with the primary key or throws a {@link it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException} if it could not be found.
    *
    * @param jobDateScheduleId the primary key of the job date schedule
    * @return the job date schedule
    * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a job date schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule findByPrimaryKey(
        long jobDateScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException;

    /**
    * Returns the job date schedule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param jobDateScheduleId the primary key of the job date schedule
    * @return the job date schedule, or <code>null</code> if a job date schedule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.apachesparkmanager.model.JobDateSchedule fetchByPrimaryKey(
        long jobDateScheduleId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the job date schedules.
    *
    * @return the job date schedules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the job date schedules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of job date schedules
    * @param end the upper bound of the range of job date schedules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of job date schedules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.apachesparkmanager.model.JobDateSchedule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the job date schedules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of job date schedules.
    *
    * @return the number of job date schedules
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
