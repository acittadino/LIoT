package it.acsoftware.brokerportlet.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.acsoftware.brokerportlet.model.BrokerMessageListener;

/**
 * The persistence interface for the broker message listener service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrokerMessageListenerPersistenceImpl
 * @see BrokerMessageListenerUtil
 * @generated
 */
public interface BrokerMessageListenerPersistence extends BasePersistence<BrokerMessageListener> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BrokerMessageListenerUtil} to access the broker message listener persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the broker message listeners where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByCompany(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByCompany(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first broker message listener in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker message listener
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the first broker message listener in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByCompany_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last broker message listener in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker message listener
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the last broker message listener in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByCompany_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public it.acsoftware.brokerportlet.model.BrokerMessageListener[] findByCompany_PrevAndNext(
        long brokerMessageListenerId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Removes all the broker message listeners where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of broker message listeners where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public int countByCompany(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the broker message listeners where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @return the matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerId(
        long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerId(
        long brokerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerId(
        long brokerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first broker message listener in the ordered set where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker message listener
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerId_First(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the first broker message listener in the ordered set where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerId_First(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last broker message listener in the ordered set where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker message listener
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerId_Last(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the last broker message listener in the ordered set where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerId_Last(
        long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public it.acsoftware.brokerportlet.model.BrokerMessageListener[] findByBrokerId_PrevAndNext(
        long brokerMessageListenerId, long brokerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Removes all the broker message listeners where brokerId = &#63; from the database.
    *
    * @param brokerId the broker ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByBrokerId(long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of broker message listeners where brokerId = &#63;.
    *
    * @param brokerId the broker ID
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public int countByBrokerId(long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the broker message listeners where brokerId = &#63; and type = &#63;.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @return the matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerIdAndType(
        long brokerId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerIdAndType(
        long brokerId, java.lang.String type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerIdAndType(
        long brokerId, java.lang.String type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerIdAndType_First(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the first broker message listener in the ordered set where brokerId = &#63; and type = &#63;.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerIdAndType_First(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByBrokerIdAndType_Last(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the last broker message listener in the ordered set where brokerId = &#63; and type = &#63;.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByBrokerIdAndType_Last(
        long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public it.acsoftware.brokerportlet.model.BrokerMessageListener[] findByBrokerIdAndType_PrevAndNext(
        long brokerMessageListenerId, long brokerId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Removes all the broker message listeners where brokerId = &#63; and type = &#63; from the database.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public void removeByBrokerIdAndType(long brokerId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of broker message listeners where brokerId = &#63; and type = &#63;.
    *
    * @param brokerId the broker ID
    * @param type the type
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public int countByBrokerIdAndType(long brokerId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the broker message listener where companyId = &#63; and name = &#63; or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException} if it could not be found.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching broker message listener
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the broker message listener where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the broker message listener where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param companyId the company ID
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching broker message listener, or <code>null</code> if a matching broker message listener could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByName(
        long companyId, java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the broker message listener where companyId = &#63; and name = &#63; from the database.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the broker message listener that was removed
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener removeByName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the number of broker message listeners where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the number of matching broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public int countByName(long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the broker message listener in the entity cache if it is enabled.
    *
    * @param brokerMessageListener the broker message listener
    */
    public void cacheResult(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener);

    /**
    * Caches the broker message listeners in the entity cache if it is enabled.
    *
    * @param brokerMessageListeners the broker message listeners
    */
    public void cacheResult(
        java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> brokerMessageListeners);

    /**
    * Creates a new broker message listener with the primary key. Does not add the broker message listener to the database.
    *
    * @param brokerMessageListenerId the primary key for the new broker message listener
    * @return the new broker message listener
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener create(
        long brokerMessageListenerId);

    /**
    * Removes the broker message listener with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener that was removed
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener remove(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    public it.acsoftware.brokerportlet.model.BrokerMessageListener updateImpl(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the broker message listener with the primary key or throws a {@link it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException} if it could not be found.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener
    * @throws it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener findByPrimaryKey(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.NoSuchBrokerMessageListenerException;

    /**
    * Returns the broker message listener with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener, or <code>null</code> if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchByPrimaryKey(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the broker message listeners.
    *
    * @return the broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the broker message listeners from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of broker message listeners.
    *
    * @return the number of broker message listeners
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
