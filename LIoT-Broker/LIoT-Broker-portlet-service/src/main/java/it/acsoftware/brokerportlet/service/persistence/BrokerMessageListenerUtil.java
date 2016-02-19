package it.acsoftware.brokerportlet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.acsoftware.brokerportlet.model.BrokerMessageListener;

import java.util.List;

/**
 * The persistence utility for the broker message listener service. This utility wraps {@link BrokerMessageListenerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerMessageListenerPersistence
 * @see BrokerMessageListenerPersistenceImpl
 * @generated
 */
public class BrokerMessageListenerUtil {
    private static BrokerMessageListenerPersistence _persistence;

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
    public static void clearCache(BrokerMessageListener brokerMessageListener) {
        getPersistence().clearCache(brokerMessageListener);
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
    public static List<BrokerMessageListener> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<BrokerMessageListener> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<BrokerMessageListener> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static BrokerMessageListener update(
        BrokerMessageListener brokerMessageListener) throws SystemException {
        return getPersistence().update(brokerMessageListener);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static BrokerMessageListener update(
        BrokerMessageListener brokerMessageListener,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(brokerMessageListener, serviceContext);
    }

    /**
    * Returns all the broker message listeners where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompany(companyId);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByCompany(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompany(companyId, start, end);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByCompany(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompany(companyId, start, end, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().findByCompany_First(companyId, orderByComparator);
    }

    /**
    * Returns the first broker message listener in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompany_First(companyId, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().findByCompany_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last broker message listener in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener[] findByCompany_PrevAndNext(
        long brokerMessageListenerId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence()
                   .findByCompany_PrevAndNext(brokerMessageListenerId,
            companyId, orderByComparator);
    }

    /**
    * Removes all the broker message listeners where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompany(companyId);
    }

    /**
    * Returns the number of broker message listeners where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompany(companyId);
    }

    /**
    * Returns all the broker message listeners where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @return the matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerId(
        long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBrokerId(brokerId);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerId(
        long brokerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBrokerId(brokerId, start, end);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerId(
        long brokerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByBrokerId(brokerId, start, end, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerId_First(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().findByBrokerId_First(brokerId, orderByComparator);
    }

    /**
    * Returns the first broker message listener in the ordered set where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerId_First(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByBrokerId_First(brokerId, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerId_Last(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().findByBrokerId_Last(brokerId, orderByComparator);
    }

    /**
    * Returns the last broker message listener in the ordered set where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerId_Last(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByBrokerId_Last(brokerId, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener[] findByBrokerId_PrevAndNext(
        long brokerMessageListenerId, long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence()
                   .findByBrokerId_PrevAndNext(brokerMessageListenerId,
            brokerId, orderByComparator);
    }

    /**
    * Removes all the broker message listeners where brokerId = &#63; from the database.
    *
    * @param brokerId the broker ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByBrokerId(long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByBrokerId(brokerId);
    }

    /**
    * Returns the number of broker message listeners where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static int countByBrokerId(long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByBrokerId(brokerId);
    }

    /**
    * Returns all the broker message listeners where brokerId = &#63; and type = &#63;.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @return the matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerIdAndType(
        long brokerId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBrokerIdAndType(brokerId, type);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerIdAndType(
        long brokerId, java.lang.String type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBrokerIdAndType(brokerId, type, start, end);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerIdAndType(
        long brokerId, java.lang.String type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByBrokerIdAndType(brokerId, type, start, end,
            orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerIdAndType_First(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence()
                   .findByBrokerIdAndType_First(brokerId, type,
            orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerIdAndType_First(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByBrokerIdAndType_First(brokerId, type,
            orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerIdAndType_Last(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence()
                   .findByBrokerIdAndType_Last(brokerId, type, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerIdAndType_Last(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByBrokerIdAndType_Last(brokerId, type,
            orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener[] findByBrokerIdAndType_PrevAndNext(
        long brokerMessageListenerId, long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence()
                   .findByBrokerIdAndType_PrevAndNext(brokerMessageListenerId,
            brokerId, type, orderByComparator);
    }

    /**
    * Removes all the broker message listeners where brokerId = &#63; and type = &#63; from the database.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public static void removeByBrokerIdAndType(long brokerId,
        java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByBrokerIdAndType(brokerId, type);
    }

    /**
    * Returns the number of broker message listeners where brokerId = &#63; and type = &#63;.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static int countByBrokerIdAndType(long brokerId,
        java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByBrokerIdAndType(brokerId, type);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().findByName(companyId, name);
    }

    /**
    * Returns the broker message listener where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(companyId, name);
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
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByName(
        long companyId, java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(companyId, name, retrieveFromCache);
    }

    /**
    * Removes the broker message listener where companyId = &#63; and name = &#63; from the database.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the broker message listener that was removed
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener removeByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().removeByName(companyId, name);
    }

    /**
    * Returns the number of broker message listeners where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(companyId, name);
    }

    /**
    * Caches the broker message listener in the entity cache if it is enabled.
    *
    * @param brokerMessageListener the broker message listener
    */
    public static void cacheResult(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener) {
        getPersistence().cacheResult(brokerMessageListener);
    }

    /**
    * Caches the broker message listeners in the entity cache if it is enabled.
    *
    * @param brokerMessageListeners the broker message listeners
    */
    public static void cacheResult(
        java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> brokerMessageListeners) {
        getPersistence().cacheResult(brokerMessageListeners);
    }

    /**
    * Creates a new broker message listener with the primary key. Does not add the broker message listener to the database.
    *
    * @param brokerMessageListenerId the primary key for the new broker message listener
    * @return the new broker message listener
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener create(
        long brokerMessageListenerId) {
        return getPersistence().create(brokerMessageListenerId);
    }

    /**
    * Removes the broker message listener with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener that was removed
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener remove(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().remove(brokerMessageListenerId);
    }

    public static it.acsoftware.brokerportlet.model.BrokerMessageListener updateImpl(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(brokerMessageListener);
    }

    /**
    * Returns the broker message listener with the primary key or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException} if it could not be found.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener findByPrimaryKey(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException {
        return getPersistence().findByPrimaryKey(brokerMessageListenerId);
    }

    /**
    * Returns the broker message listener with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener, or <code>null</code> if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByPrimaryKey(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(brokerMessageListenerId);
    }

    /**
    * Returns all the broker message listeners.
    *
    * @return the broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the broker message listeners from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of broker message listeners.
    *
    * @return the number of broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BrokerMessageListenerPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BrokerMessageListenerPersistence) PortletBeanLocatorUtil.locate(it.acsoftware.brokerportlet.service.ClpSerializer.getServletContextName(),
                    BrokerMessageListenerPersistence.class.getName());

            ReferenceRegistry.registerReference(BrokerMessageListenerUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(BrokerMessageListenerPersistence persistence) {
    }
}
