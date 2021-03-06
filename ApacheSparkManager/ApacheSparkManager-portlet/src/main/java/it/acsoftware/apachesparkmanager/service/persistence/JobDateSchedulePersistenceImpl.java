package it.acsoftware.apachesparkmanager.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException;
import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleImpl;
import it.acsoftware.apachesparkmanager.model.impl.JobDateScheduleModelImpl;
import it.acsoftware.apachesparkmanager.service.persistence.JobDateSchedulePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the job date schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobDateSchedulePersistence
 * @see JobDateScheduleUtil
 * @generated
 */
public class JobDateSchedulePersistenceImpl extends BasePersistenceImpl<JobDateSchedule>
    implements JobDateSchedulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link JobDateScheduleUtil} to access the job date schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = JobDateScheduleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobDateScheduleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobDateScheduleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobDateScheduleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBycompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobDateScheduleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycompanyId",
            new String[] { Long.class.getName() },
            JobDateScheduleModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "jobDateSchedule.companyId = ?";
    private static final String _SQL_SELECT_JOBDATESCHEDULE = "SELECT jobDateSchedule FROM JobDateSchedule jobDateSchedule";
    private static final String _SQL_SELECT_JOBDATESCHEDULE_WHERE = "SELECT jobDateSchedule FROM JobDateSchedule jobDateSchedule WHERE ";
    private static final String _SQL_COUNT_JOBDATESCHEDULE = "SELECT COUNT(jobDateSchedule) FROM JobDateSchedule jobDateSchedule";
    private static final String _SQL_COUNT_JOBDATESCHEDULE_WHERE = "SELECT COUNT(jobDateSchedule) FROM JobDateSchedule jobDateSchedule WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "jobDateSchedule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobDateSchedule exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobDateSchedule exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(JobDateSchedulePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "active"
            });
    private static JobDateSchedule _nullJobDateSchedule = new JobDateScheduleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<JobDateSchedule> toCacheModel() {
                return _nullJobDateScheduleCacheModel;
            }
        };

    private static CacheModel<JobDateSchedule> _nullJobDateScheduleCacheModel = new CacheModel<JobDateSchedule>() {
            @Override
            public JobDateSchedule toEntityModel() {
                return _nullJobDateSchedule;
            }
        };

    public JobDateSchedulePersistenceImpl() {
        setModelClass(JobDateSchedule.class);
    }

    /**
     * Returns all the job date schedules where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching job date schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<JobDateSchedule> findBycompanyId(long companyId)
        throws SystemException {
        return findBycompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

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
    @Override
    public List<JobDateSchedule> findBycompanyId(long companyId, int start,
        int end) throws SystemException {
        return findBycompanyId(companyId, start, end, null);
    }

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
    @Override
    public List<JobDateSchedule> findBycompanyId(long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<JobDateSchedule> list = (List<JobDateSchedule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (JobDateSchedule jobDateSchedule : list) {
                if ((companyId != jobDateSchedule.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_JOBDATESCHEDULE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(JobDateScheduleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<JobDateSchedule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<JobDateSchedule>(list);
                } else {
                    list = (List<JobDateSchedule>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first job date schedule in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching job date schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a matching job date schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule findBycompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchJobDateScheduleException, SystemException {
        JobDateSchedule jobDateSchedule = fetchBycompanyId_First(companyId,
                orderByComparator);

        if (jobDateSchedule != null) {
            return jobDateSchedule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchJobDateScheduleException(msg.toString());
    }

    /**
     * Returns the first job date schedule in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching job date schedule, or <code>null</code> if a matching job date schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule fetchBycompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<JobDateSchedule> list = findBycompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last job date schedule in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching job date schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a matching job date schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule findBycompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchJobDateScheduleException, SystemException {
        JobDateSchedule jobDateSchedule = fetchBycompanyId_Last(companyId,
                orderByComparator);

        if (jobDateSchedule != null) {
            return jobDateSchedule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchJobDateScheduleException(msg.toString());
    }

    /**
     * Returns the last job date schedule in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching job date schedule, or <code>null</code> if a matching job date schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule fetchBycompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<JobDateSchedule> list = findBycompanyId(companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public JobDateSchedule[] findBycompanyId_PrevAndNext(
        long jobDateScheduleId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchJobDateScheduleException, SystemException {
        JobDateSchedule jobDateSchedule = findByPrimaryKey(jobDateScheduleId);

        Session session = null;

        try {
            session = openSession();

            JobDateSchedule[] array = new JobDateScheduleImpl[3];

            array[0] = getBycompanyId_PrevAndNext(session, jobDateSchedule,
                    companyId, orderByComparator, true);

            array[1] = jobDateSchedule;

            array[2] = getBycompanyId_PrevAndNext(session, jobDateSchedule,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected JobDateSchedule getBycompanyId_PrevAndNext(Session session,
        JobDateSchedule jobDateSchedule, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_JOBDATESCHEDULE_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(JobDateScheduleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(jobDateSchedule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<JobDateSchedule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the job date schedules where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycompanyId(long companyId) throws SystemException {
        for (JobDateSchedule jobDateSchedule : findBycompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(jobDateSchedule);
        }
    }

    /**
     * Returns the number of job date schedules where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching job date schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycompanyId(long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_JOBDATESCHEDULE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the job date schedule in the entity cache if it is enabled.
     *
     * @param jobDateSchedule the job date schedule
     */
    @Override
    public void cacheResult(JobDateSchedule jobDateSchedule) {
        EntityCacheUtil.putResult(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleImpl.class, jobDateSchedule.getPrimaryKey(),
            jobDateSchedule);

        jobDateSchedule.resetOriginalValues();
    }

    /**
     * Caches the job date schedules in the entity cache if it is enabled.
     *
     * @param jobDateSchedules the job date schedules
     */
    @Override
    public void cacheResult(List<JobDateSchedule> jobDateSchedules) {
        for (JobDateSchedule jobDateSchedule : jobDateSchedules) {
            if (EntityCacheUtil.getResult(
                        JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
                        JobDateScheduleImpl.class,
                        jobDateSchedule.getPrimaryKey()) == null) {
                cacheResult(jobDateSchedule);
            } else {
                jobDateSchedule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all job date schedules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(JobDateScheduleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(JobDateScheduleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the job date schedule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(JobDateSchedule jobDateSchedule) {
        EntityCacheUtil.removeResult(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleImpl.class, jobDateSchedule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<JobDateSchedule> jobDateSchedules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (JobDateSchedule jobDateSchedule : jobDateSchedules) {
            EntityCacheUtil.removeResult(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
                JobDateScheduleImpl.class, jobDateSchedule.getPrimaryKey());
        }
    }

    /**
     * Creates a new job date schedule with the primary key. Does not add the job date schedule to the database.
     *
     * @param jobDateScheduleId the primary key for the new job date schedule
     * @return the new job date schedule
     */
    @Override
    public JobDateSchedule create(long jobDateScheduleId) {
        JobDateSchedule jobDateSchedule = new JobDateScheduleImpl();

        jobDateSchedule.setNew(true);
        jobDateSchedule.setPrimaryKey(jobDateScheduleId);

        return jobDateSchedule;
    }

    /**
     * Removes the job date schedule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param jobDateScheduleId the primary key of the job date schedule
     * @return the job date schedule that was removed
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a job date schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule remove(long jobDateScheduleId)
        throws NoSuchJobDateScheduleException, SystemException {
        return remove((Serializable) jobDateScheduleId);
    }

    /**
     * Removes the job date schedule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the job date schedule
     * @return the job date schedule that was removed
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a job date schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule remove(Serializable primaryKey)
        throws NoSuchJobDateScheduleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            JobDateSchedule jobDateSchedule = (JobDateSchedule) session.get(JobDateScheduleImpl.class,
                    primaryKey);

            if (jobDateSchedule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchJobDateScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(jobDateSchedule);
        } catch (NoSuchJobDateScheduleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected JobDateSchedule removeImpl(JobDateSchedule jobDateSchedule)
        throws SystemException {
        jobDateSchedule = toUnwrappedModel(jobDateSchedule);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(jobDateSchedule)) {
                jobDateSchedule = (JobDateSchedule) session.get(JobDateScheduleImpl.class,
                        jobDateSchedule.getPrimaryKeyObj());
            }

            if (jobDateSchedule != null) {
                session.delete(jobDateSchedule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (jobDateSchedule != null) {
            clearCache(jobDateSchedule);
        }

        return jobDateSchedule;
    }

    @Override
    public JobDateSchedule updateImpl(
        it.acsoftware.apachesparkmanager.model.JobDateSchedule jobDateSchedule)
        throws SystemException {
        jobDateSchedule = toUnwrappedModel(jobDateSchedule);

        boolean isNew = jobDateSchedule.isNew();

        JobDateScheduleModelImpl jobDateScheduleModelImpl = (JobDateScheduleModelImpl) jobDateSchedule;

        Session session = null;

        try {
            session = openSession();

            if (jobDateSchedule.isNew()) {
                session.save(jobDateSchedule);

                jobDateSchedule.setNew(false);
            } else {
                session.merge(jobDateSchedule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !JobDateScheduleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((jobDateScheduleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        jobDateScheduleModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { jobDateScheduleModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobDateScheduleImpl.class, jobDateSchedule.getPrimaryKey(),
            jobDateSchedule);

        return jobDateSchedule;
    }

    protected JobDateSchedule toUnwrappedModel(JobDateSchedule jobDateSchedule) {
        if (jobDateSchedule instanceof JobDateScheduleImpl) {
            return jobDateSchedule;
        }

        JobDateScheduleImpl jobDateScheduleImpl = new JobDateScheduleImpl();

        jobDateScheduleImpl.setNew(jobDateSchedule.isNew());
        jobDateScheduleImpl.setPrimaryKey(jobDateSchedule.getPrimaryKey());

        jobDateScheduleImpl.setJobDateScheduleId(jobDateSchedule.getJobDateScheduleId());
        jobDateScheduleImpl.setGroupId(jobDateSchedule.getGroupId());
        jobDateScheduleImpl.setCompanyId(jobDateSchedule.getCompanyId());
        jobDateScheduleImpl.setUserId(jobDateSchedule.getUserId());
        jobDateScheduleImpl.setUserName(jobDateSchedule.getUserName());
        jobDateScheduleImpl.setCreateDate(jobDateSchedule.getCreateDate());
        jobDateScheduleImpl.setModifiedDate(jobDateSchedule.getModifiedDate());
        jobDateScheduleImpl.setScheduleName(jobDateSchedule.getScheduleName());
        jobDateScheduleImpl.setChronExpression(jobDateSchedule.getChronExpression());
        jobDateScheduleImpl.setParams(jobDateSchedule.getParams());
        jobDateScheduleImpl.setJarName(jobDateSchedule.getJarName());
        jobDateScheduleImpl.setMainClass(jobDateSchedule.getMainClass());
        jobDateScheduleImpl.setActive(jobDateSchedule.getActive());

        return jobDateScheduleImpl;
    }

    /**
     * Returns the job date schedule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the job date schedule
     * @return the job date schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a job date schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchJobDateScheduleException, SystemException {
        JobDateSchedule jobDateSchedule = fetchByPrimaryKey(primaryKey);

        if (jobDateSchedule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchJobDateScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return jobDateSchedule;
    }

    /**
     * Returns the job date schedule with the primary key or throws a {@link it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException} if it could not be found.
     *
     * @param jobDateScheduleId the primary key of the job date schedule
     * @return the job date schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobDateScheduleException if a job date schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule findByPrimaryKey(long jobDateScheduleId)
        throws NoSuchJobDateScheduleException, SystemException {
        return findByPrimaryKey((Serializable) jobDateScheduleId);
    }

    /**
     * Returns the job date schedule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the job date schedule
     * @return the job date schedule, or <code>null</code> if a job date schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        JobDateSchedule jobDateSchedule = (JobDateSchedule) EntityCacheUtil.getResult(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
                JobDateScheduleImpl.class, primaryKey);

        if (jobDateSchedule == _nullJobDateSchedule) {
            return null;
        }

        if (jobDateSchedule == null) {
            Session session = null;

            try {
                session = openSession();

                jobDateSchedule = (JobDateSchedule) session.get(JobDateScheduleImpl.class,
                        primaryKey);

                if (jobDateSchedule != null) {
                    cacheResult(jobDateSchedule);
                } else {
                    EntityCacheUtil.putResult(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
                        JobDateScheduleImpl.class, primaryKey,
                        _nullJobDateSchedule);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(JobDateScheduleModelImpl.ENTITY_CACHE_ENABLED,
                    JobDateScheduleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return jobDateSchedule;
    }

    /**
     * Returns the job date schedule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param jobDateScheduleId the primary key of the job date schedule
     * @return the job date schedule, or <code>null</code> if a job date schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobDateSchedule fetchByPrimaryKey(long jobDateScheduleId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) jobDateScheduleId);
    }

    /**
     * Returns all the job date schedules.
     *
     * @return the job date schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<JobDateSchedule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<JobDateSchedule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<JobDateSchedule> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<JobDateSchedule> list = (List<JobDateSchedule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_JOBDATESCHEDULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_JOBDATESCHEDULE;

                if (pagination) {
                    sql = sql.concat(JobDateScheduleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<JobDateSchedule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<JobDateSchedule>(list);
                } else {
                    list = (List<JobDateSchedule>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the job date schedules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (JobDateSchedule jobDateSchedule : findAll()) {
            remove(jobDateSchedule);
        }
    }

    /**
     * Returns the number of job date schedules.
     *
     * @return the number of job date schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_JOBDATESCHEDULE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the job date schedule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.acsoftware.apachesparkmanager.model.JobDateSchedule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<JobDateSchedule>> listenersList = new ArrayList<ModelListener<JobDateSchedule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<JobDateSchedule>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(JobDateScheduleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
