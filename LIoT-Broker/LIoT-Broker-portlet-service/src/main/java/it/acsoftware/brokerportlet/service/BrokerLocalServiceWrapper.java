package it.acsoftware.brokerportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrokerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrokerLocalService
 * @generated
 */
public class BrokerLocalServiceWrapper implements BrokerLocalService,
    ServiceWrapper<BrokerLocalService> {
    private BrokerLocalService _brokerLocalService;

    public BrokerLocalServiceWrapper(BrokerLocalService brokerLocalService) {
        _brokerLocalService = brokerLocalService;
    }

    /**
    * Adds the broker to the database. Also notifies the appropriate model listeners.
    *
    * @param broker the broker
    * @return the broker that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.Broker addBroker(
        it.acsoftware.brokerportlet.model.Broker broker)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.addBroker(broker);
    }

    /**
    * Creates a new broker with the primary key. Does not add the broker to the database.
    *
    * @param brokerId the primary key for the new broker
    * @return the new broker
    */
    @Override
    public it.acsoftware.brokerportlet.model.Broker createBroker(long brokerId) {
        return _brokerLocalService.createBroker(brokerId);
    }

    /**
    * Deletes the broker with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param brokerId the primary key of the broker
    * @return the broker that was removed
    * @throws PortalException if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.Broker deleteBroker(long brokerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.deleteBroker(brokerId);
    }

    /**
    * Deletes the broker from the database. Also notifies the appropriate model listeners.
    *
    * @param broker the broker
    * @return the broker that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.Broker deleteBroker(
        it.acsoftware.brokerportlet.model.Broker broker)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.deleteBroker(broker);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _brokerLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public it.acsoftware.brokerportlet.model.Broker fetchBroker(long brokerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.fetchBroker(brokerId);
    }

    /**
    * Returns the broker with the primary key.
    *
    * @param brokerId the primary key of the broker
    * @return the broker
    * @throws PortalException if a broker with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.Broker getBroker(long brokerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.getBroker(brokerId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> getBrokers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.getBrokers(start, end);
    }

    /**
    * Returns the number of brokers.
    *
    * @return the number of brokers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getBrokersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.getBrokersCount();
    }

    /**
    * Updates the broker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param broker the broker
    * @return the broker that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.Broker updateBroker(
        it.acsoftware.brokerportlet.model.Broker broker)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerLocalService.updateBroker(broker);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _brokerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _brokerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _brokerLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public it.acsoftware.brokerportlet.model.Broker saveOrUpdateBroker(
        it.acsoftware.brokerportlet.model.Broker broker,
        java.util.Locale currentLocale, javax.portlet.PortletConfig config)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.BeanValidationException {
        return _brokerLocalService.saveOrUpdateBroker(broker, currentLocale,
            config);
    }

    @Override
    public void startupBrokerServices(long companyId) {
        _brokerLocalService.startupBrokerServices(companyId);
    }

    @Override
    public java.util.List<it.acsoftware.brokerportlet.model.Broker> findByCompanyId(
        long companyId) {
        return _brokerLocalService.findByCompanyId(companyId);
    }

    @Override
    public it.acsoftware.brokerportlet.model.Broker findByName(long companyId,
        java.lang.String name) {
        return _brokerLocalService.findByName(companyId, name);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BrokerLocalService getWrappedBrokerLocalService() {
        return _brokerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBrokerLocalService(
        BrokerLocalService brokerLocalService) {
        _brokerLocalService = brokerLocalService;
    }

    @Override
    public BrokerLocalService getWrappedService() {
        return _brokerLocalService;
    }

    @Override
    public void setWrappedService(BrokerLocalService brokerLocalService) {
        _brokerLocalService = brokerLocalService;
    }
}
