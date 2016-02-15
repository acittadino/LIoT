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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException;
import it.acsoftware.apachesparkmanager.model.JobEventSchedule;
import it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleImpl;
import it.acsoftware.apachesparkmanager.model.impl.JobEventScheduleModelImpl;
import it.acsoftware.apachesparkmanager.service.persistence.JobEventSchedulePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the job event schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobEventSchedulePersistence
 * @see JobEventScheduleUtil
 * @generated
 */
public class JobEventSchedulePersistenceImpl extends BasePersistenceImpl<JobEventSchedule>
    implements JobEventSchedulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link JobEventScheduleUtil} to access the job event schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = JobEventScheduleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobEventScheduleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobEventScheduleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTNAME =
        new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobEventScheduleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByeventName",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNAME =
        new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobEventScheduleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByeventName",
            new String[] { Long.class.getName(), String.class.getName() },
            JobEventScheduleModelImpl.COMPANYID_COLUMN_BITMASK |
            JobEventScheduleModelImpl.EVENTNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EVENTNAME = new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeventName",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_EVENTNAME_COMPANYID_2 = "jobEventSchedule.companyId = ? AND ";
    private static final String _FINDER_COLUMN_EVENTNAME_EVENTNAME_1 = "jobEventSchedule.eventName IS NULL";
    private static final String _FINDER_COLUMN_EVENTNAME_EVENTNAME_2 = "lower(jobEventSchedule.eventName) = ?";
    private static final String _FINDER_COLUMN_EVENTNAME_EVENTNAME_3 = "(jobEventSchedule.eventName IS NULL OR jobEventSchedule.eventName = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobEventScheduleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBycompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED,
            JobEventScheduleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycompanyId",
            new String[] { Long.class.getName() },
            JobEventScheduleModelImpl.COMPANYID_COLUMN_BITMASK |
            JobEventScheduleModelImpl.EVENTNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "jobEventSchedule.companyId = ?";
    private static final String _SQL_SELECT_JOBEVENTSCHEDULE = "SELECT jobEventSchedule FROM JobEventSchedule jobEventSchedule";
    private static final String _SQL_SELECT_JOBEVENTSCHEDULE_WHERE = "SELECT jobEventSchedule FROM JobEventSchedule jobEventSchedule WHERE ";
    private static final String _SQL_COUNT_JOBEVENTSCHEDULE = "SELECT COUNT(jobEventSchedule) FROM JobEventSchedule jobEventSchedule";
    private static final String _SQL_COUNT_JOBEVENTSCHEDULE_WHERE = "SELECT COUNT(jobEventSchedule) FROM JobEventSchedule jobEventSchedule WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "jobEventSchedule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobEventSchedule exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobEventSchedule exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(JobEventSchedulePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "active"
            });
    private static JobEventSchedule _nullJobEventSchedule = new JobEventScheduleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<JobEventSchedule> toCacheModel() {
                return _nullJobEventScheduleCacheModel;
            }
        };

    private static CacheModel<JobEventSchedule> _nullJobEventScheduleCacheModel = new CacheModel<JobEventSchedule>() {
            @Override
            public JobEventSchedule toEntityModel() {
                return _nullJobEventSchedule;
            }
        };

    public JobEventSchedulePersistenceImpl() {
        setModelClass(JobEventSchedule.class);
    }

    /**
     * Returns all the job event schedules where companyId = &#63; and eventName = &#63;.
     *
     * @param companyId the company ID
     * @param eventName the event name
     * @return the matching job event schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<JobEventSchedule> findByeventName(long companyId,
        String eventName) throws SystemException {
        return findByeventName(companyId, eventName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<JobEventSchedule> findByeventName(long companyId,
        String eventName, int start, int end) throws SystemException {
        return findByeventName(companyId, eventName, start, end, null);
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
    @Override
    public List<JobEventSchedule> findByeventName(long companyId,
        String eventName, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNAME;
            finderArgs = new Object[] { companyId, eventName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTNAME;
            finderArgs = new Object[] {
                    companyId, eventName,
                    
                    start, end, orderByComparator
                };
        }

        List<JobEventSchedule> list = (List<JobEventSchedule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (JobEventSchedule jobEventSchedule : list) {
                if ((companyId != jobEventSchedule.getCompanyId()) ||
                        !Validator.equals(eventName,
                            jobEventSchedule.getEventName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_JOBEVENTSCHEDULE_WHERE);

            query.append(_FINDER_COLUMN_EVENTNAME_COMPANYID_2);

            boolean bindEventName = false;

            if (eventName == null) {
                query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_1);
            } else if (eventName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_3);
            } else {
                bindEventName = true;

                query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(JobEventScheduleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindEventName) {
                    qPos.add(eventName.toLowerCase());
                }

                if (!pagination) {
                    list = (List<JobEventSchedule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<JobEventSchedule>(list);
                } else {
                    list = (List<JobEventSchedule>) QueryUtil.list(q,
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
     * Returns the first job event schedule in the ordered set where companyId = &#63; and eventName = &#63;.
     *
     * @param companyId the company ID
     * @param eventName the event name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching job event schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a matching job event schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule findByeventName_First(long companyId,
        String eventName, OrderByComparator orderByComparator)
        throws NoSuchJobEventScheduleException, SystemException {
        JobEventSchedule jobEventSchedule = fetchByeventName_First(companyId,
                eventName, orderByComparator);

        if (jobEventSchedule != null) {
            return jobEventSchedule;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", eventName=");
        msg.append(eventName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchJobEventScheduleException(msg.toString());
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
    @Override
    public JobEventSchedule fetchByeventName_First(long companyId,
        String eventName, OrderByComparator orderByComparator)
        throws SystemException {
        List<JobEventSchedule> list = findByeventName(companyId, eventName, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public JobEventSchedule findByeventName_Last(long companyId,
        String eventName, OrderByComparator orderByComparator)
        throws NoSuchJobEventScheduleException, SystemException {
        JobEventSchedule jobEventSchedule = fetchByeventName_Last(companyId,
                eventName, orderByComparator);

        if (jobEventSchedule != null) {
            return jobEventSchedule;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", eventName=");
        msg.append(eventName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchJobEventScheduleException(msg.toString());
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
    @Override
    public JobEventSchedule fetchByeventName_Last(long companyId,
        String eventName, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByeventName(companyId, eventName);

        if (count == 0) {
            return null;
        }

        List<JobEventSchedule> list = findByeventName(companyId, eventName,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public JobEventSchedule[] findByeventName_PrevAndNext(
        long jobEventScheduleId, long companyId, String eventName,
        OrderByComparator orderByComparator)
        throws NoSuchJobEventScheduleException, SystemException {
        JobEventSchedule jobEventSchedule = findByPrimaryKey(jobEventScheduleId);

        Session session = null;

        try {
            session = openSession();

            JobEventSchedule[] array = new JobEventScheduleImpl[3];

            array[0] = getByeventName_PrevAndNext(session, jobEventSchedule,
                    companyId, eventName, orderByComparator, true);

            array[1] = jobEventSchedule;

            array[2] = getByeventName_PrevAndNext(session, jobEventSchedule,
                    companyId, eventName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected JobEventSchedule getByeventName_PrevAndNext(Session session,
        JobEventSchedule jobEventSchedule, long companyId, String eventName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_JOBEVENTSCHEDULE_WHERE);

        query.append(_FINDER_COLUMN_EVENTNAME_COMPANYID_2);

        boolean bindEventName = false;

        if (eventName == null) {
            query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_1);
        } else if (eventName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_3);
        } else {
            bindEventName = true;

            query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_2);
        }

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
            query.append(JobEventScheduleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (bindEventName) {
            qPos.add(eventName.toLowerCase());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(jobEventSchedule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<JobEventSchedule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the job event schedules where companyId = &#63; and eventName = &#63; from the database.
     *
     * @param companyId the company ID
     * @param eventName the event name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByeventName(long companyId, String eventName)
        throws SystemException {
        for (JobEventSchedule jobEventSchedule : findByeventName(companyId,
                eventName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(jobEventSchedule);
        }
    }

    /**
     * Returns the number of job event schedules where companyId = &#63; and eventName = &#63;.
     *
     * @param companyId the company ID
     * @param eventName the event name
     * @return the number of matching job event schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByeventName(long companyId, String eventName)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTNAME;

        Object[] finderArgs = new Object[] { companyId, eventName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_JOBEVENTSCHEDULE_WHERE);

            query.append(_FINDER_COLUMN_EVENTNAME_COMPANYID_2);

            boolean bindEventName = false;

            if (eventName == null) {
                query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_1);
            } else if (eventName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_3);
            } else {
                bindEventName = true;

                query.append(_FINDER_COLUMN_EVENTNAME_EVENTNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindEventName) {
                    qPos.add(eventName.toLowerCase());
                }

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
     * Returns all the job event schedules where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching job event schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<JobEventSchedule> findBycompanyId(long companyId)
        throws SystemException {
        return findBycompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<JobEventSchedule> findBycompanyId(long companyId, int start,
        int end) throws SystemException {
        return findBycompanyId(companyId, start, end, null);
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
    @Override
    public List<JobEventSchedule> findBycompanyId(long companyId, int start,
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

        List<JobEventSchedule> list = (List<JobEventSchedule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (JobEventSchedule jobEventSchedule : list) {
                if ((companyId != jobEventSchedule.getCompanyId())) {
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

            query.append(_SQL_SELECT_JOBEVENTSCHEDULE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(JobEventScheduleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<JobEventSchedule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<JobEventSchedule>(list);
                } else {
                    list = (List<JobEventSchedule>) QueryUtil.list(q,
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
     * Returns the first job event schedule in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching job event schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a matching job event schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule findBycompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchJobEventScheduleException, SystemException {
        JobEventSchedule jobEventSchedule = fetchBycompanyId_First(companyId,
                orderByComparator);

        if (jobEventSchedule != null) {
            return jobEventSchedule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchJobEventScheduleException(msg.toString());
    }

    /**
     * Returns the first job event schedule in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching job event schedule, or <code>null</code> if a matching job event schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule fetchBycompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<JobEventSchedule> list = findBycompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public JobEventSchedule findBycompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchJobEventScheduleException, SystemException {
        JobEventSchedule jobEventSchedule = fetchBycompanyId_Last(companyId,
                orderByComparator);

        if (jobEventSchedule != null) {
            return jobEventSchedule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchJobEventScheduleException(msg.toString());
    }

    /**
     * Returns the last job event schedule in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching job event schedule, or <code>null</code> if a matching job event schedule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule fetchBycompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<JobEventSchedule> list = findBycompanyId(companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public JobEventSchedule[] findBycompanyId_PrevAndNext(
        long jobEventScheduleId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchJobEventScheduleException, SystemException {
        JobEventSchedule jobEventSchedule = findByPrimaryKey(jobEventScheduleId);

        Session session = null;

        try {
            session = openSession();

            JobEventSchedule[] array = new JobEventScheduleImpl[3];

            array[0] = getBycompanyId_PrevAndNext(session, jobEventSchedule,
                    companyId, orderByComparator, true);

            array[1] = jobEventSchedule;

            array[2] = getBycompanyId_PrevAndNext(session, jobEventSchedule,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected JobEventSchedule getBycompanyId_PrevAndNext(Session session,
        JobEventSchedule jobEventSchedule, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_JOBEVENTSCHEDULE_WHERE);

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
            query.append(JobEventScheduleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(jobEventSchedule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<JobEventSchedule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the job event schedules where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycompanyId(long companyId) throws SystemException {
        for (JobEventSchedule jobEventSchedule : findBycompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(jobEventSchedule);
        }
    }

    /**
     * Returns the number of job event schedules where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching job event schedules
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

            query.append(_SQL_COUNT_JOBEVENTSCHEDULE_WHERE);

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
     * Caches the job event schedule in the entity cache if it is enabled.
     *
     * @param jobEventSchedule the job event schedule
     */
    @Override
    public void cacheResult(JobEventSchedule jobEventSchedule) {
        EntityCacheUtil.putResult(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleImpl.class, jobEventSchedule.getPrimaryKey(),
            jobEventSchedule);

        jobEventSchedule.resetOriginalValues();
    }

    /**
     * Caches the job event schedules in the entity cache if it is enabled.
     *
     * @param jobEventSchedules the job event schedules
     */
    @Override
    public void cacheResult(List<JobEventSchedule> jobEventSchedules) {
        for (JobEventSchedule jobEventSchedule : jobEventSchedules) {
            if (EntityCacheUtil.getResult(
                        JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
                        JobEventScheduleImpl.class,
                        jobEventSchedule.getPrimaryKey()) == null) {
                cacheResult(jobEventSchedule);
            } else {
                jobEventSchedule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all job event schedules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(JobEventScheduleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(JobEventScheduleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the job event schedule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(JobEventSchedule jobEventSchedule) {
        EntityCacheUtil.removeResult(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleImpl.class, jobEventSchedule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<JobEventSchedule> jobEventSchedules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (JobEventSchedule jobEventSchedule : jobEventSchedules) {
            EntityCacheUtil.removeResult(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
                JobEventScheduleImpl.class, jobEventSchedule.getPrimaryKey());
        }
    }

    /**
     * Creates a new job event schedule with the primary key. Does not add the job event schedule to the database.
     *
     * @param jobEventScheduleId the primary key for the new job event schedule
     * @return the new job event schedule
     */
    @Override
    public JobEventSchedule create(long jobEventScheduleId) {
        JobEventSchedule jobEventSchedule = new JobEventScheduleImpl();

        jobEventSchedule.setNew(true);
        jobEventSchedule.setPrimaryKey(jobEventScheduleId);

        return jobEventSchedule;
    }

    /**
     * Removes the job event schedule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param jobEventScheduleId the primary key of the job event schedule
     * @return the job event schedule that was removed
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule remove(long jobEventScheduleId)
        throws NoSuchJobEventScheduleException, SystemException {
        return remove((Serializable) jobEventScheduleId);
    }

    /**
     * Removes the job event schedule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the job event schedule
     * @return the job event schedule that was removed
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule remove(Serializable primaryKey)
        throws NoSuchJobEventScheduleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            JobEventSchedule jobEventSchedule = (JobEventSchedule) session.get(JobEventScheduleImpl.class,
                    primaryKey);

            if (jobEventSchedule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchJobEventScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(jobEventSchedule);
        } catch (NoSuchJobEventScheduleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected JobEventSchedule removeImpl(JobEventSchedule jobEventSchedule)
        throws SystemException {
        jobEventSchedule = toUnwrappedModel(jobEventSchedule);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(jobEventSchedule)) {
                jobEventSchedule = (JobEventSchedule) session.get(JobEventScheduleImpl.class,
                        jobEventSchedule.getPrimaryKeyObj());
            }

            if (jobEventSchedule != null) {
                session.delete(jobEventSchedule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (jobEventSchedule != null) {
            clearCache(jobEventSchedule);
        }

        return jobEventSchedule;
    }

    @Override
    public JobEventSchedule updateImpl(
        it.acsoftware.apachesparkmanager.model.JobEventSchedule jobEventSchedule)
        throws SystemException {
        jobEventSchedule = toUnwrappedModel(jobEventSchedule);

        boolean isNew = jobEventSchedule.isNew();

        JobEventScheduleModelImpl jobEventScheduleModelImpl = (JobEventScheduleModelImpl) jobEventSchedule;

        Session session = null;

        try {
            session = openSession();

            if (jobEventSchedule.isNew()) {
                session.save(jobEventSchedule);

                jobEventSchedule.setNew(false);
            } else {
                session.merge(jobEventSchedule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !JobEventScheduleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((jobEventScheduleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        jobEventScheduleModelImpl.getOriginalCompanyId(),
                        jobEventScheduleModelImpl.getOriginalEventName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNAME,
                    args);

                args = new Object[] {
                        jobEventScheduleModelImpl.getCompanyId(),
                        jobEventScheduleModelImpl.getEventName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTNAME,
                    args);
            }

            if ((jobEventScheduleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        jobEventScheduleModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { jobEventScheduleModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
            JobEventScheduleImpl.class, jobEventSchedule.getPrimaryKey(),
            jobEventSchedule);

        return jobEventSchedule;
    }

    protected JobEventSchedule toUnwrappedModel(
        JobEventSchedule jobEventSchedule) {
        if (jobEventSchedule instanceof JobEventScheduleImpl) {
            return jobEventSchedule;
        }

        JobEventScheduleImpl jobEventScheduleImpl = new JobEventScheduleImpl();

        jobEventScheduleImpl.setNew(jobEventSchedule.isNew());
        jobEventScheduleImpl.setPrimaryKey(jobEventSchedule.getPrimaryKey());

        jobEventScheduleImpl.setJobEventScheduleId(jobEventSchedule.getJobEventScheduleId());
        jobEventScheduleImpl.setGroupId(jobEventSchedule.getGroupId());
        jobEventScheduleImpl.setCompanyId(jobEventSchedule.getCompanyId());
        jobEventScheduleImpl.setUserId(jobEventSchedule.getUserId());
        jobEventScheduleImpl.setUserName(jobEventSchedule.getUserName());
        jobEventScheduleImpl.setCreateDate(jobEventSchedule.getCreateDate());
        jobEventScheduleImpl.setModifiedDate(jobEventSchedule.getModifiedDate());
        jobEventScheduleImpl.setEventName(jobEventSchedule.getEventName());
        jobEventScheduleImpl.setParams(jobEventSchedule.getParams());
        jobEventScheduleImpl.setJarName(jobEventSchedule.getJarName());
        jobEventScheduleImpl.setMainClass(jobEventSchedule.getMainClass());
        jobEventScheduleImpl.setActive(jobEventSchedule.getActive());

        return jobEventScheduleImpl;
    }

    /**
     * Returns the job event schedule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the job event schedule
     * @return the job event schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchJobEventScheduleException, SystemException {
        JobEventSchedule jobEventSchedule = fetchByPrimaryKey(primaryKey);

        if (jobEventSchedule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchJobEventScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return jobEventSchedule;
    }

    /**
     * Returns the job event schedule with the primary key or throws a {@link it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException} if it could not be found.
     *
     * @param jobEventScheduleId the primary key of the job event schedule
     * @return the job event schedule
     * @throws it.acsoftware.apachesparkmanager.NoSuchJobEventScheduleException if a job event schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule findByPrimaryKey(long jobEventScheduleId)
        throws NoSuchJobEventScheduleException, SystemException {
        return findByPrimaryKey((Serializable) jobEventScheduleId);
    }

    /**
     * Returns the job event schedule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the job event schedule
     * @return the job event schedule, or <code>null</code> if a job event schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        JobEventSchedule jobEventSchedule = (JobEventSchedule) EntityCacheUtil.getResult(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
                JobEventScheduleImpl.class, primaryKey);

        if (jobEventSchedule == _nullJobEventSchedule) {
            return null;
        }

        if (jobEventSchedule == null) {
            Session session = null;

            try {
                session = openSession();

                jobEventSchedule = (JobEventSchedule) session.get(JobEventScheduleImpl.class,
                        primaryKey);

                if (jobEventSchedule != null) {
                    cacheResult(jobEventSchedule);
                } else {
                    EntityCacheUtil.putResult(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
                        JobEventScheduleImpl.class, primaryKey,
                        _nullJobEventSchedule);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(JobEventScheduleModelImpl.ENTITY_CACHE_ENABLED,
                    JobEventScheduleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return jobEventSchedule;
    }

    /**
     * Returns the job event schedule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param jobEventScheduleId the primary key of the job event schedule
     * @return the job event schedule, or <code>null</code> if a job event schedule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JobEventSchedule fetchByPrimaryKey(long jobEventScheduleId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) jobEventScheduleId);
    }

    /**
     * Returns all the job event schedules.
     *
     * @return the job event schedules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<JobEventSchedule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<JobEventSchedule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<JobEventSchedule> findAll(int start, int end,
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

        List<JobEventSchedule> list = (List<JobEventSchedule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_JOBEVENTSCHEDULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_JOBEVENTSCHEDULE;

                if (pagination) {
                    sql = sql.concat(JobEventScheduleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<JobEventSchedule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<JobEventSchedule>(list);
                } else {
                    list = (List<JobEventSchedule>) QueryUtil.list(q,
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
     * Removes all the job event schedules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (JobEventSchedule jobEventSchedule : findAll()) {
            remove(jobEventSchedule);
        }
    }

    /**
     * Returns the number of job event schedules.
     *
     * @return the number of job event schedules
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

                Query q = session.createQuery(_SQL_COUNT_JOBEVENTSCHEDULE);

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
     * Initializes the job event schedule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.acsoftware.apachesparkmanager.model.JobEventSchedule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<JobEventSchedule>> listenersList = new ArrayList<ModelListener<JobEventSchedule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<JobEventSchedule>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(JobEventScheduleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
