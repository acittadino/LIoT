package it.acsoftware.brokerportlet.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.acsoftware.brokerportlet.model.Broker;

/**
 * The persistence interface for the broker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerPersistenceImpl
 * @see BrokerUtil
 * @generated
 */
public interface BrokerPersistence extends BasePersistence<Broker> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BrokerUtil} to access the broker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the broker where companyId = &#63; and name = &#63; or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerException} if it could not be found.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching broker
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker findByName(long companyId,
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException;

    /**
    * Returns the broker where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching broker, or <code>null</code> if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker fetchByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the broker where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param companyId the company ID
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching broker, or <code>null</code> if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker fetchByName(
        long companyId, java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the broker where companyId = &#63; and name = &#63; from the database.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the broker that was removed
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker removeByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException;

    /**
    * Returns the number of brokers where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the number of matching brokers
    * @throws SystemException if a system exception occurred
    */
    public int countByName(long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the brokers where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching brokers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> findByCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> findByCompany(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> findByCompany(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first broker in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker findByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException;

    /**
    * Returns the first broker in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker, or <code>null</code> if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker fetchByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last broker in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker findByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException;

    /**
    * Returns the last broker in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker, or <code>null</code> if a matching broker could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker fetchByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public it.acsoftware.brokerportlet.model.Broker[] findByCompany_PrevAndNext(
        long brokerId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException;

    /**
    * Removes all the brokers where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of brokers where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching brokers
    * @throws SystemException if a system exception occurred
    */
    public int countByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the broker in the entity cache if it is enabled.
    *
    * @param broker the broker
    */
    public void cacheResult(it.acsoftware.brokerportlet.model.Broker broker);

    /**
    * Caches the brokers in the entity cache if it is enabled.
    *
    * @param brokers the brokers
    */
    public void cacheResult(
        java.util.List<it.acsoftware.brokerportlet.model.Broker> brokers);

    /**
    * Creates a new broker with the primary key. Does not add the broker to the database.
    *
    * @param brokerId the primary key for the new broker
    * @return the new broker
    */
    public it.acsoftware.brokerportlet.model.Broker create(long brokerId);

    /**
    * Removes the broker with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param brokerId the primary key of the broker
    * @return the broker that was removed
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker remove(long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException;

    public it.acsoftware.brokerportlet.model.Broker updateImpl(
        it.acsoftware.brokerportlet.model.Broker broker)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the broker with the primary key or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerException} if it could not be found.
    *
    * @param brokerId the primary key of the broker
    * @return the broker
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerException if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker findByPrimaryKey(
        long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerException;

    /**
    * Returns the broker with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param brokerId the primary key of the broker
    * @return the broker, or <code>null</code> if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.Broker fetchByPrimaryKey(
        long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the brokers.
    *
    * @return the brokers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the brokers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of brokers.
    *
    * @return the number of brokers
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
