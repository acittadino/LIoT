package it.acsoftware.brokerportlet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.acsoftware.brokerportlet.model.Broker;

import java.util.List;

/**
 * The persistence utility for the broker service. This utility wraps {@link BrokerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerPersistence
 * @see BrokerPersistenceImpl
 * @generated
 */
public class BrokerUtil {
    private static BrokerPersistence _persistence;

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
    public static void clearCache(Broker broker) {
        getPersistence().clearCache(broker);
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
    public static List<Broker> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Broker> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Broker> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Broker update(Broker broker) throws SystemException {
        return getPersistence().update(broker);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Broker update(Broker broker, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(broker, serviceContext);
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
    public static it.acsoftware.brokerportlet.model.Broker findByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException {
        return getPersistence().findByName(companyId, name);
    }

    /**
    * Returns the broker where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching broker, or <code>null</code> if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.Broker fetchByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(companyId, name);
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
    public static it.acsoftware.brokerportlet.model.Broker fetchByName(
        long companyId, java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(companyId, name, retrieveFromCache);
    }

    /**
    * Removes the broker where companyId = &#63; and name = &#63; from the database.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the broker that was removed
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.Broker removeByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException {
        return getPersistence().removeByName(companyId, name);
    }

    /**
    * Returns the number of brokers where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the number of matching brokers
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(companyId, name);
    }

    /**
    * Returns all the brokers where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching brokers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.brokerportlet.model.Broker> findByCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompany(companyId);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.Broker> findByCompany(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompany(companyId, start, end);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.Broker> findByCompany(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompany(companyId, start, end, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.Broker findByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException {
        return getPersistence().findByCompany_First(companyId, orderByComparator);
    }

    /**
    * Returns the first broker in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker, or <code>null</code> if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.Broker fetchByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompany_First(companyId, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.Broker findByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException {
        return getPersistence().findByCompany_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last broker in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker, or <code>null</code> if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.Broker fetchByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
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
    public static it.acsoftware.brokerportlet.model.Broker[] findByCompany_PrevAndNext(
        long brokerId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException {
        return getPersistence()
                   .findByCompany_PrevAndNext(brokerId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the brokers where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompany(companyId);
    }

    /**
    * Returns the number of brokers where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching brokers
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompany(companyId);
    }

    /**
    * Caches the broker in the entity cache if it is enabled.
    *
    * @param broker the broker
    */
    public static void cacheResult(
        it.acsoftware.brokerportlet.model.Broker broker) {
        getPersistence().cacheResult(broker);
    }

    /**
    * Caches the brokers in the entity cache if it is enabled.
    *
    * @param brokers the brokers
    */
    public static void cacheResult(
        java.util.List<it.acsoftware.brokerportlet.model.Broker> brokers) {
        getPersistence().cacheResult(brokers);
    }

    /**
    * Creates a new broker with the primary key. Does not add the broker to the database.
    *
    * @param brokerId the primary key for the new broker
    * @return the new broker
    */
    public static it.acsoftware.brokerportlet.model.Broker create(long brokerId) {
        return getPersistence().create(brokerId);
    }

    /**
    * Removes the broker with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param brokerId the primary key of the broker
    * @return the broker that was removed
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.Broker remove(long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException {
        return getPersistence().remove(brokerId);
    }

    public static it.acsoftware.brokerportlet.model.Broker updateImpl(
        it.acsoftware.brokerportlet.model.Broker broker)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(broker);
    }

    /**
    * Returns the broker with the primary key or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerException} if it could not be found.
    *
    * @param brokerId the primary key of the broker
    * @return the broker
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.Broker findByPrimaryKey(
        long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException {
        return getPersistence().findByPrimaryKey(brokerId);
    }

    /**
    * Returns the broker with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param brokerId the primary key of the broker
    * @return the broker, or <code>null</code> if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.acsoftware.brokerportlet.model.Broker fetchByPrimaryKey(
        long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(brokerId);
    }

    /**
    * Returns all the brokers.
    *
    * @return the brokers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.acsoftware.brokerportlet.model.Broker> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<it.acsoftware.brokerportlet.model.Broker> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<it.acsoftware.brokerportlet.model.Broker> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the brokers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of brokers.
    *
    * @return the number of brokers
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BrokerPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BrokerPersistence) PortletBeanLocatorUtil.locate(it.acsoftware.brokerportlet.service.ClpSerializer.getServletContextName(),
                    BrokerPersistence.class.getName());

            ReferenceRegistry.registerReference(BrokerUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(BrokerPersistence persistence) {
    }
}
