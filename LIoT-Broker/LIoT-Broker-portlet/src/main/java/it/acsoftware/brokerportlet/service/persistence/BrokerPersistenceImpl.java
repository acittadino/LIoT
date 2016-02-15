package it.acsoftware.brokerportlet.service.persistence;

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

import it.acsoftware.brokerportlet.NoSuchBrokerException;
import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.model.impl.BrokerImpl;
import it.acsoftware.brokerportlet.model.impl.BrokerModelImpl;
import it.acsoftware.brokerportlet.service.persistence.BrokerPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the broker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerPersistence
 * @see BrokerUtil
 * @generated
 */
public class BrokerPersistenceImpl extends BasePersistenceImpl<Broker>
    implements BrokerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BrokerUtil} to access the broker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BrokerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, BrokerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, BrokerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, BrokerImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByName",
            new String[] { Long.class.getName(), String.class.getName() },
            BrokerModelImpl.COMPANYID_COLUMN_BITMASK |
            BrokerModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_COMPANYID_2 = "broker.companyId = ? AND ";
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "broker.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "broker.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(broker.name IS NULL OR broker.name = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, BrokerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
        new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, BrokerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
            new String[] { Long.class.getName() },
            BrokerModelImpl.COMPANYID_COLUMN_BITMASK |
            BrokerModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "broker.companyId = ?";
    private static final String _SQL_SELECT_BROKER = "SELECT broker FROM Broker broker";
    private static final String _SQL_SELECT_BROKER_WHERE = "SELECT broker FROM Broker broker WHERE ";
    private static final String _SQL_COUNT_BROKER = "SELECT COUNT(broker) FROM Broker broker";
    private static final String _SQL_COUNT_BROKER_WHERE = "SELECT COUNT(broker) FROM Broker broker WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "broker.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Broker exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Broker exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BrokerPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static Broker _nullBroker = new BrokerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Broker> toCacheModel() {
                return _nullBrokerCacheModel;
            }
        };

    private static CacheModel<Broker> _nullBrokerCacheModel = new CacheModel<Broker>() {
            @Override
            public Broker toEntityModel() {
                return _nullBroker;
            }
        };

    public BrokerPersistenceImpl() {
        setModelClass(Broker.class);
    }

    /**
     * Returns the broker where companyId = &#63; and name = &#63; or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerException} if it could not be found.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the matching broker
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a matching broker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker findByName(long companyId, String name)
        throws NoSuchBrokerException, SystemException {
        Broker broker = fetchByName(companyId, name);

        if (broker == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(", name=");
            msg.append(name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchBrokerException(msg.toString());
        }

        return broker;
    }

    /**
     * Returns the broker where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the matching broker, or <code>null</code> if a matching broker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker fetchByName(long companyId, String name)
        throws SystemException {
        return fetchByName(companyId, name, true);
    }

    /**
     * Returns the broker where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param companyId the company ID
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching broker, or <code>null</code> if a matching broker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker fetchByName(long companyId, String name,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { companyId, name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs, this);
        }

        if (result instanceof Broker) {
            Broker broker = (Broker) result;

            if ((companyId != broker.getCompanyId()) ||
                    !Validator.equals(name, broker.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_BROKER_WHERE);

            query.append(_FINDER_COLUMN_NAME_COMPANYID_2);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindName) {
                    qPos.add(name);
                }

                List<Broker> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                        finderArgs, list);
                } else {
                    Broker broker = list.get(0);

                    result = broker;

                    cacheResult(broker);

                    if ((broker.getCompanyId() != companyId) ||
                            (broker.getName() == null) ||
                            !broker.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                            finderArgs, broker);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Broker) result;
        }
    }

    /**
     * Removes the broker where companyId = &#63; and name = &#63; from the database.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the broker that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker removeByName(long companyId, String name)
        throws NoSuchBrokerException, SystemException {
        Broker broker = findByName(companyId, name);

        return remove(broker);
    }

    /**
     * Returns the number of brokers where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the number of matching brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByName(long companyId, String name)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { companyId, name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BROKER_WHERE);

            query.append(_FINDER_COLUMN_NAME_COMPANYID_2);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindName) {
                    qPos.add(name);
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
     * Returns all the brokers where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Broker> findByCompany(long companyId) throws SystemException {
        return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the brokers where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of brokers
     * @param end the upper bound of the range of brokers (not inclusive)
     * @return the range of matching brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Broker> findByCompany(long companyId, int start, int end)
        throws SystemException {
        return findByCompany(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the brokers where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of brokers
     * @param end the upper bound of the range of brokers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Broker> findByCompany(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<Broker> list = (List<Broker>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Broker broker : list) {
                if ((companyId != broker.getCompanyId())) {
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

            query.append(_SQL_SELECT_BROKER_WHERE);

            query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BrokerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Broker>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Broker>(list);
                } else {
                    list = (List<Broker>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first broker in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a matching broker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker findByCompany_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerException, SystemException {
        Broker broker = fetchByCompany_First(companyId, orderByComparator);

        if (broker != null) {
            return broker;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerException(msg.toString());
    }

    /**
     * Returns the first broker in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker, or <code>null</code> if a matching broker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker fetchByCompany_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Broker> list = findByCompany(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last broker in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a matching broker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker findByCompany_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerException, SystemException {
        Broker broker = fetchByCompany_Last(companyId, orderByComparator);

        if (broker != null) {
            return broker;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerException(msg.toString());
    }

    /**
     * Returns the last broker in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker, or <code>null</code> if a matching broker could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker fetchByCompany_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompany(companyId);

        if (count == 0) {
            return null;
        }

        List<Broker> list = findByCompany(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the brokers before and after the current broker in the ordered set where companyId = &#63;.
     *
     * @param brokerId the primary key of the current broker
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next broker
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker[] findByCompany_PrevAndNext(long brokerId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerException, SystemException {
        Broker broker = findByPrimaryKey(brokerId);

        Session session = null;

        try {
            session = openSession();

            Broker[] array = new BrokerImpl[3];

            array[0] = getByCompany_PrevAndNext(session, broker, companyId,
                    orderByComparator, true);

            array[1] = broker;

            array[2] = getByCompany_PrevAndNext(session, broker, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Broker getByCompany_PrevAndNext(Session session, Broker broker,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BROKER_WHERE);

        query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
            query.append(BrokerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(broker);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Broker> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the brokers where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompany(long companyId) throws SystemException {
        for (Broker broker : findByCompany(companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(broker);
        }
    }

    /**
     * Returns the number of brokers where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompany(long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BROKER_WHERE);

            query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
     * Caches the broker in the entity cache if it is enabled.
     *
     * @param broker the broker
     */
    @Override
    public void cacheResult(Broker broker) {
        EntityCacheUtil.putResult(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerImpl.class, broker.getPrimaryKey(), broker);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
            new Object[] { broker.getCompanyId(), broker.getName() }, broker);

        broker.resetOriginalValues();
    }

    /**
     * Caches the brokers in the entity cache if it is enabled.
     *
     * @param brokers the brokers
     */
    @Override
    public void cacheResult(List<Broker> brokers) {
        for (Broker broker : brokers) {
            if (EntityCacheUtil.getResult(
                        BrokerModelImpl.ENTITY_CACHE_ENABLED, BrokerImpl.class,
                        broker.getPrimaryKey()) == null) {
                cacheResult(broker);
            } else {
                broker.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all brokers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BrokerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BrokerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the broker.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Broker broker) {
        EntityCacheUtil.removeResult(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerImpl.class, broker.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(broker);
    }

    @Override
    public void clearCache(List<Broker> brokers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Broker broker : brokers) {
            EntityCacheUtil.removeResult(BrokerModelImpl.ENTITY_CACHE_ENABLED,
                BrokerImpl.class, broker.getPrimaryKey());

            clearUniqueFindersCache(broker);
        }
    }

    protected void cacheUniqueFindersCache(Broker broker) {
        if (broker.isNew()) {
            Object[] args = new Object[] { broker.getCompanyId(), broker.getName() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, broker);
        } else {
            BrokerModelImpl brokerModelImpl = (BrokerModelImpl) broker;

            if ((brokerModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        broker.getCompanyId(), broker.getName()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                    broker);
            }
        }
    }

    protected void clearUniqueFindersCache(Broker broker) {
        BrokerModelImpl brokerModelImpl = (BrokerModelImpl) broker;

        Object[] args = new Object[] { broker.getCompanyId(), broker.getName() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

        if ((brokerModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
            args = new Object[] {
                    brokerModelImpl.getOriginalCompanyId(),
                    brokerModelImpl.getOriginalName()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
        }
    }

    /**
     * Creates a new broker with the primary key. Does not add the broker to the database.
     *
     * @param brokerId the primary key for the new broker
     * @return the new broker
     */
    @Override
    public Broker create(long brokerId) {
        Broker broker = new BrokerImpl();

        broker.setNew(true);
        broker.setPrimaryKey(brokerId);

        return broker;
    }

    /**
     * Removes the broker with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param brokerId the primary key of the broker
     * @return the broker that was removed
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker remove(long brokerId)
        throws NoSuchBrokerException, SystemException {
        return remove((Serializable) brokerId);
    }

    /**
     * Removes the broker with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the broker
     * @return the broker that was removed
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker remove(Serializable primaryKey)
        throws NoSuchBrokerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Broker broker = (Broker) session.get(BrokerImpl.class, primaryKey);

            if (broker == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBrokerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(broker);
        } catch (NoSuchBrokerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Broker removeImpl(Broker broker) throws SystemException {
        broker = toUnwrappedModel(broker);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(broker)) {
                broker = (Broker) session.get(BrokerImpl.class,
                        broker.getPrimaryKeyObj());
            }

            if (broker != null) {
                session.delete(broker);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (broker != null) {
            clearCache(broker);
        }

        return broker;
    }

    @Override
    public Broker updateImpl(it.acsoftware.brokerportlet.model.Broker broker)
        throws SystemException {
        broker = toUnwrappedModel(broker);

        boolean isNew = broker.isNew();

        BrokerModelImpl brokerModelImpl = (BrokerModelImpl) broker;

        Session session = null;

        try {
            session = openSession();

            if (broker.isNew()) {
                session.save(broker);

                broker.setNew(false);
            } else {
                session.merge(broker);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BrokerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((brokerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        brokerModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
                    args);

                args = new Object[] { brokerModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
                    args);
            }
        }

        EntityCacheUtil.putResult(BrokerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerImpl.class, broker.getPrimaryKey(), broker);

        clearUniqueFindersCache(broker);
        cacheUniqueFindersCache(broker);

        return broker;
    }

    protected Broker toUnwrappedModel(Broker broker) {
        if (broker instanceof BrokerImpl) {
            return broker;
        }

        BrokerImpl brokerImpl = new BrokerImpl();

        brokerImpl.setNew(broker.isNew());
        brokerImpl.setPrimaryKey(broker.getPrimaryKey());

        brokerImpl.setBrokerId(broker.getBrokerId());
        brokerImpl.setGroupId(broker.getGroupId());
        brokerImpl.setCompanyId(broker.getCompanyId());
        brokerImpl.setUserId(broker.getUserId());
        brokerImpl.setUserName(broker.getUserName());
        brokerImpl.setCreateDate(broker.getCreateDate());
        brokerImpl.setModifiedDate(broker.getModifiedDate());
        brokerImpl.setName(broker.getName());
        brokerImpl.setProtocol(broker.getProtocol());
        brokerImpl.setUrl(broker.getUrl());
        brokerImpl.setPort(broker.getPort());
        brokerImpl.setDescription(broker.getDescription());
        brokerImpl.setType(broker.getType());
        brokerImpl.setConnectionUsername(broker.getConnectionUsername());
        brokerImpl.setConnectionPassword(broker.getConnectionPassword());
        brokerImpl.setTopics(broker.getTopics());
        brokerImpl.setCustomProps(broker.getCustomProps());
        brokerImpl.setSslEnabled(broker.getSslEnabled());
        brokerImpl.setSslSecret(broker.getSslSecret());
        brokerImpl.setSslCertificateUUid(broker.getSslCertificateUUid());
        brokerImpl.setStartAtStartup(broker.getStartAtStartup());
        brokerImpl.setMqttClientId(broker.getMqttClientId());
        brokerImpl.setMqttQos(broker.getMqttQos());
        brokerImpl.setMqttCleanSession(broker.getMqttCleanSession());
        brokerImpl.setKafkaZookeeperHost(broker.getKafkaZookeeperHost());
        brokerImpl.setKafkaThreadsPerTopic(broker.getKafkaThreadsPerTopic());
        brokerImpl.setKafkaGroupId(broker.getKafkaGroupId());

        return brokerImpl;
    }

    /**
     * Returns the broker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the broker
     * @return the broker
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBrokerException, SystemException {
        Broker broker = fetchByPrimaryKey(primaryKey);

        if (broker == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBrokerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return broker;
    }

    /**
     * Returns the broker with the primary key or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerException} if it could not be found.
     *
     * @param brokerId the primary key of the broker
     * @return the broker
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker findByPrimaryKey(long brokerId)
        throws NoSuchBrokerException, SystemException {
        return findByPrimaryKey((Serializable) brokerId);
    }

    /**
     * Returns the broker with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the broker
     * @return the broker, or <code>null</code> if a broker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Broker broker = (Broker) EntityCacheUtil.getResult(BrokerModelImpl.ENTITY_CACHE_ENABLED,
                BrokerImpl.class, primaryKey);

        if (broker == _nullBroker) {
            return null;
        }

        if (broker == null) {
            Session session = null;

            try {
                session = openSession();

                broker = (Broker) session.get(BrokerImpl.class, primaryKey);

                if (broker != null) {
                    cacheResult(broker);
                } else {
                    EntityCacheUtil.putResult(BrokerModelImpl.ENTITY_CACHE_ENABLED,
                        BrokerImpl.class, primaryKey, _nullBroker);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BrokerModelImpl.ENTITY_CACHE_ENABLED,
                    BrokerImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return broker;
    }

    /**
     * Returns the broker with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param brokerId the primary key of the broker
     * @return the broker, or <code>null</code> if a broker with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Broker fetchByPrimaryKey(long brokerId) throws SystemException {
        return fetchByPrimaryKey((Serializable) brokerId);
    }

    /**
     * Returns all the brokers.
     *
     * @return the brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Broker> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the brokers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of brokers
     * @param end the upper bound of the range of brokers (not inclusive)
     * @return the range of brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Broker> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the brokers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of brokers
     * @param end the upper bound of the range of brokers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of brokers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Broker> findAll(int start, int end,
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

        List<Broker> list = (List<Broker>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BROKER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BROKER;

                if (pagination) {
                    sql = sql.concat(BrokerModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Broker>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Broker>(list);
                } else {
                    list = (List<Broker>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the brokers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Broker broker : findAll()) {
            remove(broker);
        }
    }

    /**
     * Returns the number of brokers.
     *
     * @return the number of brokers
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

                Query q = session.createQuery(_SQL_COUNT_BROKER);

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
     * Initializes the broker persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.acsoftware.brokerportlet.model.Broker")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Broker>> listenersList = new ArrayList<ModelListener<Broker>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Broker>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BrokerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
