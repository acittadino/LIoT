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

import it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;
import it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerImpl;
import it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl;
import it.acsoftware.brokerportlet.service.persistence.BrokerMessageListenerPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the broker message listener service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerMessageListenerPersistence
 * @see BrokerMessageListenerUtil
 * @generated
 */
public class BrokerMessageListenerPersistenceImpl extends BasePersistenceImpl<BrokerMessageListener>
    implements BrokerMessageListenerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BrokerMessageListenerUtil} to access the broker message listener persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BrokerMessageListenerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
        new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
            new String[] { Long.class.getName() },
            BrokerMessageListenerModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "brokerMessageListener.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BROKERID = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrokerId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERID =
        new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrokerId",
            new String[] { Long.class.getName() },
            BrokerMessageListenerModelImpl.BROKERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BROKERID = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrokerId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_BROKERID_BROKERID_2 = "brokerMessageListener.brokerId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BROKERIDANDTYPE =
        new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrokerIdAndType",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERIDANDTYPE =
        new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrokerIdAndType",
            new String[] { Long.class.getName(), String.class.getName() },
            BrokerMessageListenerModelImpl.BROKERID_COLUMN_BITMASK |
            BrokerMessageListenerModelImpl.TYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BROKERIDANDTYPE = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByBrokerIdAndType",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_BROKERIDANDTYPE_BROKERID_2 = "brokerMessageListener.brokerId = ? AND ";
    private static final String _FINDER_COLUMN_BROKERIDANDTYPE_TYPE_1 = "brokerMessageListener.type IS NULL";
    private static final String _FINDER_COLUMN_BROKERIDANDTYPE_TYPE_2 = "brokerMessageListener.type = ?";
    private static final String _FINDER_COLUMN_BROKERIDANDTYPE_TYPE_3 = "(brokerMessageListener.type IS NULL OR brokerMessageListener.type = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED,
            BrokerMessageListenerImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByName",
            new String[] { Long.class.getName(), String.class.getName() },
            BrokerMessageListenerModelImpl.COMPANYID_COLUMN_BITMASK |
            BrokerMessageListenerModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_COMPANYID_2 = "brokerMessageListener.companyId = ? AND ";
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "brokerMessageListener.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "brokerMessageListener.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(brokerMessageListener.name IS NULL OR brokerMessageListener.name = '')";
    private static final String _SQL_SELECT_BROKERMESSAGELISTENER = "SELECT brokerMessageListener FROM BrokerMessageListener brokerMessageListener";
    private static final String _SQL_SELECT_BROKERMESSAGELISTENER_WHERE = "SELECT brokerMessageListener FROM BrokerMessageListener brokerMessageListener WHERE ";
    private static final String _SQL_COUNT_BROKERMESSAGELISTENER = "SELECT COUNT(brokerMessageListener) FROM BrokerMessageListener brokerMessageListener";
    private static final String _SQL_COUNT_BROKERMESSAGELISTENER_WHERE = "SELECT COUNT(brokerMessageListener) FROM BrokerMessageListener brokerMessageListener WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "brokerMessageListener.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BrokerMessageListener exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BrokerMessageListener exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BrokerMessageListenerPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static BrokerMessageListener _nullBrokerMessageListener = new BrokerMessageListenerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<BrokerMessageListener> toCacheModel() {
                return _nullBrokerMessageListenerCacheModel;
            }
        };

    private static CacheModel<BrokerMessageListener> _nullBrokerMessageListenerCacheModel =
        new CacheModel<BrokerMessageListener>() {
            @Override
            public BrokerMessageListener toEntityModel() {
                return _nullBrokerMessageListener;
            }
        };

    public BrokerMessageListenerPersistenceImpl() {
        setModelClass(BrokerMessageListener.class);
    }

    /**
     * Returns all the broker message listeners where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByCompany(long companyId)
        throws SystemException {
        return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the broker message listeners where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @return the range of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByCompany(long companyId, int start,
        int end) throws SystemException {
        return findByCompany(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the broker message listeners where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByCompany(long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<BrokerMessageListener> list = (List<BrokerMessageListener>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BrokerMessageListener brokerMessageListener : list) {
                if ((companyId != brokerMessageListener.getCompanyId())) {
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

            query.append(_SQL_SELECT_BROKERMESSAGELISTENER_WHERE);

            query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BrokerMessageListenerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BrokerMessageListener>(list);
                } else {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
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
     * Returns the first broker message listener in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByCompany_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByCompany_First(companyId,
                orderByComparator);

        if (brokerMessageListener != null) {
            return brokerMessageListener;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerMessageListenerException(msg.toString());
    }

    /**
     * Returns the first broker message listener in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByCompany_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<BrokerMessageListener> list = findByCompany(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last broker message listener in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByCompany_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByCompany_Last(companyId,
                orderByComparator);

        if (brokerMessageListener != null) {
            return brokerMessageListener;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerMessageListenerException(msg.toString());
    }

    /**
     * Returns the last broker message listener in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByCompany_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompany(companyId);

        if (count == 0) {
            return null;
        }

        List<BrokerMessageListener> list = findByCompany(companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the broker message listeners before and after the current broker message listener in the ordered set where companyId = &#63;.
     *
     * @param brokerMessageListenerId the primary key of the current broker message listener
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener[] findByCompany_PrevAndNext(
        long brokerMessageListenerId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = findByPrimaryKey(brokerMessageListenerId);

        Session session = null;

        try {
            session = openSession();

            BrokerMessageListener[] array = new BrokerMessageListenerImpl[3];

            array[0] = getByCompany_PrevAndNext(session, brokerMessageListener,
                    companyId, orderByComparator, true);

            array[1] = brokerMessageListener;

            array[2] = getByCompany_PrevAndNext(session, brokerMessageListener,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BrokerMessageListener getByCompany_PrevAndNext(Session session,
        BrokerMessageListener brokerMessageListener, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BROKERMESSAGELISTENER_WHERE);

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
            query.append(BrokerMessageListenerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(brokerMessageListener);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BrokerMessageListener> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the broker message listeners where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompany(long companyId) throws SystemException {
        for (BrokerMessageListener brokerMessageListener : findByCompany(
                companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(brokerMessageListener);
        }
    }

    /**
     * Returns the number of broker message listeners where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching broker message listeners
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

            query.append(_SQL_COUNT_BROKERMESSAGELISTENER_WHERE);

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
     * Returns all the broker message listeners where brokerId = &#63;.
     *
     * @param brokerId the broker ID
     * @return the matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByBrokerId(long brokerId)
        throws SystemException {
        return findByBrokerId(brokerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the broker message listeners where brokerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param brokerId the broker ID
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @return the range of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByBrokerId(long brokerId, int start,
        int end) throws SystemException {
        return findByBrokerId(brokerId, start, end, null);
    }

    /**
     * Returns an ordered range of all the broker message listeners where brokerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param brokerId the broker ID
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByBrokerId(long brokerId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERID;
            finderArgs = new Object[] { brokerId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BROKERID;
            finderArgs = new Object[] { brokerId, start, end, orderByComparator };
        }

        List<BrokerMessageListener> list = (List<BrokerMessageListener>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BrokerMessageListener brokerMessageListener : list) {
                if ((brokerId != brokerMessageListener.getBrokerId())) {
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

            query.append(_SQL_SELECT_BROKERMESSAGELISTENER_WHERE);

            query.append(_FINDER_COLUMN_BROKERID_BROKERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BrokerMessageListenerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(brokerId);

                if (!pagination) {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BrokerMessageListener>(list);
                } else {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
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
     * Returns the first broker message listener in the ordered set where brokerId = &#63;.
     *
     * @param brokerId the broker ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByBrokerId_First(long brokerId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByBrokerId_First(brokerId,
                orderByComparator);

        if (brokerMessageListener != null) {
            return brokerMessageListener;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("brokerId=");
        msg.append(brokerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerMessageListenerException(msg.toString());
    }

    /**
     * Returns the first broker message listener in the ordered set where brokerId = &#63;.
     *
     * @param brokerId the broker ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByBrokerId_First(long brokerId,
        OrderByComparator orderByComparator) throws SystemException {
        List<BrokerMessageListener> list = findByBrokerId(brokerId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last broker message listener in the ordered set where brokerId = &#63;.
     *
     * @param brokerId the broker ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByBrokerId_Last(long brokerId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByBrokerId_Last(brokerId,
                orderByComparator);

        if (brokerMessageListener != null) {
            return brokerMessageListener;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("brokerId=");
        msg.append(brokerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerMessageListenerException(msg.toString());
    }

    /**
     * Returns the last broker message listener in the ordered set where brokerId = &#63;.
     *
     * @param brokerId the broker ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByBrokerId_Last(long brokerId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByBrokerId(brokerId);

        if (count == 0) {
            return null;
        }

        List<BrokerMessageListener> list = findByBrokerId(brokerId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the broker message listeners before and after the current broker message listener in the ordered set where brokerId = &#63;.
     *
     * @param brokerMessageListenerId the primary key of the current broker message listener
     * @param brokerId the broker ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener[] findByBrokerId_PrevAndNext(
        long brokerMessageListenerId, long brokerId,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = findByPrimaryKey(brokerMessageListenerId);

        Session session = null;

        try {
            session = openSession();

            BrokerMessageListener[] array = new BrokerMessageListenerImpl[3];

            array[0] = getByBrokerId_PrevAndNext(session,
                    brokerMessageListener, brokerId, orderByComparator, true);

            array[1] = brokerMessageListener;

            array[2] = getByBrokerId_PrevAndNext(session,
                    brokerMessageListener, brokerId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BrokerMessageListener getByBrokerId_PrevAndNext(Session session,
        BrokerMessageListener brokerMessageListener, long brokerId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BROKERMESSAGELISTENER_WHERE);

        query.append(_FINDER_COLUMN_BROKERID_BROKERID_2);

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
            query.append(BrokerMessageListenerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(brokerId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(brokerMessageListener);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BrokerMessageListener> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the broker message listeners where brokerId = &#63; from the database.
     *
     * @param brokerId the broker ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByBrokerId(long brokerId) throws SystemException {
        for (BrokerMessageListener brokerMessageListener : findByBrokerId(
                brokerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(brokerMessageListener);
        }
    }

    /**
     * Returns the number of broker message listeners where brokerId = &#63;.
     *
     * @param brokerId the broker ID
     * @return the number of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByBrokerId(long brokerId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BROKERID;

        Object[] finderArgs = new Object[] { brokerId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BROKERMESSAGELISTENER_WHERE);

            query.append(_FINDER_COLUMN_BROKERID_BROKERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(brokerId);

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
     * Returns all the broker message listeners where brokerId = &#63; and type = &#63;.
     *
     * @param brokerId the broker ID
     * @param type the type
     * @return the matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByBrokerIdAndType(long brokerId,
        String type) throws SystemException {
        return findByBrokerIdAndType(brokerId, type, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the broker message listeners where brokerId = &#63; and type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param brokerId the broker ID
     * @param type the type
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @return the range of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByBrokerIdAndType(long brokerId,
        String type, int start, int end) throws SystemException {
        return findByBrokerIdAndType(brokerId, type, start, end, null);
    }

    /**
     * Returns an ordered range of all the broker message listeners where brokerId = &#63; and type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param brokerId the broker ID
     * @param type the type
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findByBrokerIdAndType(long brokerId,
        String type, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERIDANDTYPE;
            finderArgs = new Object[] { brokerId, type };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BROKERIDANDTYPE;
            finderArgs = new Object[] {
                    brokerId, type,
                    
                    start, end, orderByComparator
                };
        }

        List<BrokerMessageListener> list = (List<BrokerMessageListener>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BrokerMessageListener brokerMessageListener : list) {
                if ((brokerId != brokerMessageListener.getBrokerId()) ||
                        !Validator.equals(type, brokerMessageListener.getType())) {
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

            query.append(_SQL_SELECT_BROKERMESSAGELISTENER_WHERE);

            query.append(_FINDER_COLUMN_BROKERIDANDTYPE_BROKERID_2);

            boolean bindType = false;

            if (type == null) {
                query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_1);
            } else if (type.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_3);
            } else {
                bindType = true;

                query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BrokerMessageListenerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(brokerId);

                if (bindType) {
                    qPos.add(type);
                }

                if (!pagination) {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BrokerMessageListener>(list);
                } else {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
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
     * Returns the first broker message listener in the ordered set where brokerId = &#63; and type = &#63;.
     *
     * @param brokerId the broker ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByBrokerIdAndType_First(long brokerId,
        String type, OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByBrokerIdAndType_First(brokerId,
                type, orderByComparator);

        if (brokerMessageListener != null) {
            return brokerMessageListener;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("brokerId=");
        msg.append(brokerId);

        msg.append(", type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerMessageListenerException(msg.toString());
    }

    /**
     * Returns the first broker message listener in the ordered set where brokerId = &#63; and type = &#63;.
     *
     * @param brokerId the broker ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByBrokerIdAndType_First(long brokerId,
        String type, OrderByComparator orderByComparator)
        throws SystemException {
        List<BrokerMessageListener> list = findByBrokerIdAndType(brokerId,
                type, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last broker message listener in the ordered set where brokerId = &#63; and type = &#63;.
     *
     * @param brokerId the broker ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByBrokerIdAndType_Last(long brokerId,
        String type, OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByBrokerIdAndType_Last(brokerId,
                type, orderByComparator);

        if (brokerMessageListener != null) {
            return brokerMessageListener;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("brokerId=");
        msg.append(brokerId);

        msg.append(", type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBrokerMessageListenerException(msg.toString());
    }

    /**
     * Returns the last broker message listener in the ordered set where brokerId = &#63; and type = &#63;.
     *
     * @param brokerId the broker ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByBrokerIdAndType_Last(long brokerId,
        String type, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByBrokerIdAndType(brokerId, type);

        if (count == 0) {
            return null;
        }

        List<BrokerMessageListener> list = findByBrokerIdAndType(brokerId,
                type, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the broker message listeners before and after the current broker message listener in the ordered set where brokerId = &#63; and type = &#63;.
     *
     * @param brokerMessageListenerId the primary key of the current broker message listener
     * @param brokerId the broker ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener[] findByBrokerIdAndType_PrevAndNext(
        long brokerMessageListenerId, long brokerId, String type,
        OrderByComparator orderByComparator)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = findByPrimaryKey(brokerMessageListenerId);

        Session session = null;

        try {
            session = openSession();

            BrokerMessageListener[] array = new BrokerMessageListenerImpl[3];

            array[0] = getByBrokerIdAndType_PrevAndNext(session,
                    brokerMessageListener, brokerId, type, orderByComparator,
                    true);

            array[1] = brokerMessageListener;

            array[2] = getByBrokerIdAndType_PrevAndNext(session,
                    brokerMessageListener, brokerId, type, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BrokerMessageListener getByBrokerIdAndType_PrevAndNext(
        Session session, BrokerMessageListener brokerMessageListener,
        long brokerId, String type, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BROKERMESSAGELISTENER_WHERE);

        query.append(_FINDER_COLUMN_BROKERIDANDTYPE_BROKERID_2);

        boolean bindType = false;

        if (type == null) {
            query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_1);
        } else if (type.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_3);
        } else {
            bindType = true;

            query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_2);
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
            query.append(BrokerMessageListenerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(brokerId);

        if (bindType) {
            qPos.add(type);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(brokerMessageListener);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BrokerMessageListener> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the broker message listeners where brokerId = &#63; and type = &#63; from the database.
     *
     * @param brokerId the broker ID
     * @param type the type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByBrokerIdAndType(long brokerId, String type)
        throws SystemException {
        for (BrokerMessageListener brokerMessageListener : findByBrokerIdAndType(
                brokerId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(brokerMessageListener);
        }
    }

    /**
     * Returns the number of broker message listeners where brokerId = &#63; and type = &#63;.
     *
     * @param brokerId the broker ID
     * @param type the type
     * @return the number of matching broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByBrokerIdAndType(long brokerId, String type)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BROKERIDANDTYPE;

        Object[] finderArgs = new Object[] { brokerId, type };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BROKERMESSAGELISTENER_WHERE);

            query.append(_FINDER_COLUMN_BROKERIDANDTYPE_BROKERID_2);

            boolean bindType = false;

            if (type == null) {
                query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_1);
            } else if (type.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_3);
            } else {
                bindType = true;

                query.append(_FINDER_COLUMN_BROKERIDANDTYPE_TYPE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(brokerId);

                if (bindType) {
                    qPos.add(type);
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
     * Returns the broker message listener where companyId = &#63; and name = &#63; or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException} if it could not be found.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the matching broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByName(long companyId, String name)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByName(companyId,
                name);

        if (brokerMessageListener == null) {
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

            throw new NoSuchBrokerMessageListenerException(msg.toString());
        }

        return brokerMessageListener;
    }

    /**
     * Returns the broker message listener where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByName(long companyId, String name)
        throws SystemException {
        return fetchByName(companyId, name, true);
    }

    /**
     * Returns the broker message listener where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param companyId the company ID
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByName(long companyId, String name,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { companyId, name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs, this);
        }

        if (result instanceof BrokerMessageListener) {
            BrokerMessageListener brokerMessageListener = (BrokerMessageListener) result;

            if ((companyId != brokerMessageListener.getCompanyId()) ||
                    !Validator.equals(name, brokerMessageListener.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_BROKERMESSAGELISTENER_WHERE);

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

                List<BrokerMessageListener> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                        finderArgs, list);
                } else {
                    BrokerMessageListener brokerMessageListener = list.get(0);

                    result = brokerMessageListener;

                    cacheResult(brokerMessageListener);

                    if ((brokerMessageListener.getCompanyId() != companyId) ||
                            (brokerMessageListener.getName() == null) ||
                            !brokerMessageListener.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                            finderArgs, brokerMessageListener);
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
            return (BrokerMessageListener) result;
        }
    }

    /**
     * Removes the broker message listener where companyId = &#63; and name = &#63; from the database.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the broker message listener that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener removeByName(long companyId, String name)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = findByName(companyId, name);

        return remove(brokerMessageListener);
    }

    /**
     * Returns the number of broker message listeners where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the number of matching broker message listeners
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

            query.append(_SQL_COUNT_BROKERMESSAGELISTENER_WHERE);

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
     * Caches the broker message listener in the entity cache if it is enabled.
     *
     * @param brokerMessageListener the broker message listener
     */
    @Override
    public void cacheResult(BrokerMessageListener brokerMessageListener) {
        EntityCacheUtil.putResult(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            brokerMessageListener.getPrimaryKey(), brokerMessageListener);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
            new Object[] {
                brokerMessageListener.getCompanyId(),
                brokerMessageListener.getName()
            }, brokerMessageListener);

        brokerMessageListener.resetOriginalValues();
    }

    /**
     * Caches the broker message listeners in the entity cache if it is enabled.
     *
     * @param brokerMessageListeners the broker message listeners
     */
    @Override
    public void cacheResult(List<BrokerMessageListener> brokerMessageListeners) {
        for (BrokerMessageListener brokerMessageListener : brokerMessageListeners) {
            if (EntityCacheUtil.getResult(
                        BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
                        BrokerMessageListenerImpl.class,
                        brokerMessageListener.getPrimaryKey()) == null) {
                cacheResult(brokerMessageListener);
            } else {
                brokerMessageListener.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all broker message listeners.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BrokerMessageListenerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BrokerMessageListenerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the broker message listener.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(BrokerMessageListener brokerMessageListener) {
        EntityCacheUtil.removeResult(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            brokerMessageListener.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(brokerMessageListener);
    }

    @Override
    public void clearCache(List<BrokerMessageListener> brokerMessageListeners) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (BrokerMessageListener brokerMessageListener : brokerMessageListeners) {
            EntityCacheUtil.removeResult(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
                BrokerMessageListenerImpl.class,
                brokerMessageListener.getPrimaryKey());

            clearUniqueFindersCache(brokerMessageListener);
        }
    }

    protected void cacheUniqueFindersCache(
        BrokerMessageListener brokerMessageListener) {
        if (brokerMessageListener.isNew()) {
            Object[] args = new Object[] {
                    brokerMessageListener.getCompanyId(),
                    brokerMessageListener.getName()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                brokerMessageListener);
        } else {
            BrokerMessageListenerModelImpl brokerMessageListenerModelImpl = (BrokerMessageListenerModelImpl) brokerMessageListener;

            if ((brokerMessageListenerModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        brokerMessageListener.getCompanyId(),
                        brokerMessageListener.getName()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                    brokerMessageListener);
            }
        }
    }

    protected void clearUniqueFindersCache(
        BrokerMessageListener brokerMessageListener) {
        BrokerMessageListenerModelImpl brokerMessageListenerModelImpl = (BrokerMessageListenerModelImpl) brokerMessageListener;

        Object[] args = new Object[] {
                brokerMessageListener.getCompanyId(),
                brokerMessageListener.getName()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

        if ((brokerMessageListenerModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
            args = new Object[] {
                    brokerMessageListenerModelImpl.getOriginalCompanyId(),
                    brokerMessageListenerModelImpl.getOriginalName()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
        }
    }

    /**
     * Creates a new broker message listener with the primary key. Does not add the broker message listener to the database.
     *
     * @param brokerMessageListenerId the primary key for the new broker message listener
     * @return the new broker message listener
     */
    @Override
    public BrokerMessageListener create(long brokerMessageListenerId) {
        BrokerMessageListener brokerMessageListener = new BrokerMessageListenerImpl();

        brokerMessageListener.setNew(true);
        brokerMessageListener.setPrimaryKey(brokerMessageListenerId);

        return brokerMessageListener;
    }

    /**
     * Removes the broker message listener with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param brokerMessageListenerId the primary key of the broker message listener
     * @return the broker message listener that was removed
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener remove(long brokerMessageListenerId)
        throws NoSuchBrokerMessageListenerException, SystemException {
        return remove((Serializable) brokerMessageListenerId);
    }

    /**
     * Removes the broker message listener with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the broker message listener
     * @return the broker message listener that was removed
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener remove(Serializable primaryKey)
        throws NoSuchBrokerMessageListenerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            BrokerMessageListener brokerMessageListener = (BrokerMessageListener) session.get(BrokerMessageListenerImpl.class,
                    primaryKey);

            if (brokerMessageListener == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBrokerMessageListenerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(brokerMessageListener);
        } catch (NoSuchBrokerMessageListenerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected BrokerMessageListener removeImpl(
        BrokerMessageListener brokerMessageListener) throws SystemException {
        brokerMessageListener = toUnwrappedModel(brokerMessageListener);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(brokerMessageListener)) {
                brokerMessageListener = (BrokerMessageListener) session.get(BrokerMessageListenerImpl.class,
                        brokerMessageListener.getPrimaryKeyObj());
            }

            if (brokerMessageListener != null) {
                session.delete(brokerMessageListener);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (brokerMessageListener != null) {
            clearCache(brokerMessageListener);
        }

        return brokerMessageListener;
    }

    @Override
    public BrokerMessageListener updateImpl(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener)
        throws SystemException {
        brokerMessageListener = toUnwrappedModel(brokerMessageListener);

        boolean isNew = brokerMessageListener.isNew();

        BrokerMessageListenerModelImpl brokerMessageListenerModelImpl = (BrokerMessageListenerModelImpl) brokerMessageListener;

        Session session = null;

        try {
            session = openSession();

            if (brokerMessageListener.isNew()) {
                session.save(brokerMessageListener);

                brokerMessageListener.setNew(false);
            } else {
                session.merge(brokerMessageListener);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BrokerMessageListenerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((brokerMessageListenerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        brokerMessageListenerModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
                    args);

                args = new Object[] {
                        brokerMessageListenerModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
                    args);
            }

            if ((brokerMessageListenerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        brokerMessageListenerModelImpl.getOriginalBrokerId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERID,
                    args);

                args = new Object[] { brokerMessageListenerModelImpl.getBrokerId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERID,
                    args);
            }

            if ((brokerMessageListenerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERIDANDTYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        brokerMessageListenerModelImpl.getOriginalBrokerId(),
                        brokerMessageListenerModelImpl.getOriginalType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERIDANDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERIDANDTYPE,
                    args);

                args = new Object[] {
                        brokerMessageListenerModelImpl.getBrokerId(),
                        brokerMessageListenerModelImpl.getType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERIDANDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERIDANDTYPE,
                    args);
            }
        }

        EntityCacheUtil.putResult(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
            BrokerMessageListenerImpl.class,
            brokerMessageListener.getPrimaryKey(), brokerMessageListener);

        clearUniqueFindersCache(brokerMessageListener);
        cacheUniqueFindersCache(brokerMessageListener);

        return brokerMessageListener;
    }

    protected BrokerMessageListener toUnwrappedModel(
        BrokerMessageListener brokerMessageListener) {
        if (brokerMessageListener instanceof BrokerMessageListenerImpl) {
            return brokerMessageListener;
        }

        BrokerMessageListenerImpl brokerMessageListenerImpl = new BrokerMessageListenerImpl();

        brokerMessageListenerImpl.setNew(brokerMessageListener.isNew());
        brokerMessageListenerImpl.setPrimaryKey(brokerMessageListener.getPrimaryKey());

        brokerMessageListenerImpl.setBrokerMessageListenerId(brokerMessageListener.getBrokerMessageListenerId());
        brokerMessageListenerImpl.setGroupId(brokerMessageListener.getGroupId());
        brokerMessageListenerImpl.setCompanyId(brokerMessageListener.getCompanyId());
        brokerMessageListenerImpl.setUserId(brokerMessageListener.getUserId());
        brokerMessageListenerImpl.setUserName(brokerMessageListener.getUserName());
        brokerMessageListenerImpl.setCreateDate(brokerMessageListener.getCreateDate());
        brokerMessageListenerImpl.setModifiedDate(brokerMessageListener.getModifiedDate());
        brokerMessageListenerImpl.setName(brokerMessageListener.getName());
        brokerMessageListenerImpl.setDescription(brokerMessageListener.getDescription());
        brokerMessageListenerImpl.setBrokerId(brokerMessageListener.getBrokerId());
        brokerMessageListenerImpl.setTopics(brokerMessageListener.getTopics());
        brokerMessageListenerImpl.setType(brokerMessageListener.getType());
        brokerMessageListenerImpl.setMessageBusDestination(brokerMessageListener.getMessageBusDestination());

        return brokerMessageListenerImpl;
    }

    /**
     * Returns the broker message listener with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the broker message listener
     * @return the broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBrokerMessageListenerException, SystemException {
        BrokerMessageListener brokerMessageListener = fetchByPrimaryKey(primaryKey);

        if (brokerMessageListener == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBrokerMessageListenerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return brokerMessageListener;
    }

    /**
     * Returns the broker message listener with the primary key or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException} if it could not be found.
     *
     * @param brokerMessageListenerId the primary key of the broker message listener
     * @return the broker message listener
     * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener findByPrimaryKey(long brokerMessageListenerId)
        throws NoSuchBrokerMessageListenerException, SystemException {
        return findByPrimaryKey((Serializable) brokerMessageListenerId);
    }

    /**
     * Returns the broker message listener with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the broker message listener
     * @return the broker message listener, or <code>null</code> if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        BrokerMessageListener brokerMessageListener = (BrokerMessageListener) EntityCacheUtil.getResult(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
                BrokerMessageListenerImpl.class, primaryKey);

        if (brokerMessageListener == _nullBrokerMessageListener) {
            return null;
        }

        if (brokerMessageListener == null) {
            Session session = null;

            try {
                session = openSession();

                brokerMessageListener = (BrokerMessageListener) session.get(BrokerMessageListenerImpl.class,
                        primaryKey);

                if (brokerMessageListener != null) {
                    cacheResult(brokerMessageListener);
                } else {
                    EntityCacheUtil.putResult(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
                        BrokerMessageListenerImpl.class, primaryKey,
                        _nullBrokerMessageListener);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BrokerMessageListenerModelImpl.ENTITY_CACHE_ENABLED,
                    BrokerMessageListenerImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return brokerMessageListener;
    }

    /**
     * Returns the broker message listener with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param brokerMessageListenerId the primary key of the broker message listener
     * @return the broker message listener, or <code>null</code> if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BrokerMessageListener fetchByPrimaryKey(long brokerMessageListenerId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) brokerMessageListenerId);
    }

    /**
     * Returns all the broker message listeners.
     *
     * @return the broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the broker message listeners.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @return the range of broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the broker message listeners.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of broker message listeners
     * @param end the upper bound of the range of broker message listeners (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BrokerMessageListener> findAll(int start, int end,
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

        List<BrokerMessageListener> list = (List<BrokerMessageListener>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BROKERMESSAGELISTENER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BROKERMESSAGELISTENER;

                if (pagination) {
                    sql = sql.concat(BrokerMessageListenerModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BrokerMessageListener>(list);
                } else {
                    list = (List<BrokerMessageListener>) QueryUtil.list(q,
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
     * Removes all the broker message listeners from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (BrokerMessageListener brokerMessageListener : findAll()) {
            remove(brokerMessageListener);
        }
    }

    /**
     * Returns the number of broker message listeners.
     *
     * @return the number of broker message listeners
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

                Query q = session.createQuery(_SQL_COUNT_BROKERMESSAGELISTENER);

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
     * Initializes the broker message listener persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.acsoftware.brokerportlet.model.BrokerMessageListener")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<BrokerMessageListener>> listenersList = new ArrayList<ModelListener<BrokerMessageListener>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<BrokerMessageListener>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BrokerMessageListenerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
