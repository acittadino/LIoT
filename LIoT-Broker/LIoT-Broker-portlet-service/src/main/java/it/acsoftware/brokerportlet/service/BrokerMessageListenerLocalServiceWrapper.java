package it.acsoftware.brokerportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrokerMessageListenerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrokerMessageListenerLocalService
 * @generated
 */
public class BrokerMessageListenerLocalServiceWrapper
    implements BrokerMessageListenerLocalService,
        ServiceWrapper<BrokerMessageListenerLocalService> {
    private BrokerMessageListenerLocalService _brokerMessageListenerLocalService;

    public BrokerMessageListenerLocalServiceWrapper(
        BrokerMessageListenerLocalService brokerMessageListenerLocalService) {
        _brokerMessageListenerLocalService = brokerMessageListenerLocalService;
    }

    /**
    * Adds the broker message listener to the database. Also notifies the appropriate model listeners.
    *
    * @param brokerMessageListener the broker message listener
    * @return the broker message listener that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener addBrokerMessageListener(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.addBrokerMessageListener(brokerMessageListener);
    }

    /**
    * Creates a new broker message listener with the primary key. Does not add the broker message listener to the database.
    *
    * @param brokerMessageListenerId the primary key for the new broker message listener
    * @return the new broker message listener
    */
    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener createBrokerMessageListener(
        long brokerMessageListenerId) {
        return _brokerMessageListenerLocalService.createBrokerMessageListener(brokerMessageListenerId);
    }

    /**
    * Deletes the broker message listener with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener that was removed
    * @throws PortalException if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener deleteBrokerMessageListener(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.deleteBrokerMessageListener(brokerMessageListenerId);
    }

    /**
    * Deletes the broker message listener from the database. Also notifies the appropriate model listeners.
    *
    * @param brokerMessageListener the broker message listener
    * @return the broker message listener that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener deleteBrokerMessageListener(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.deleteBrokerMessageListener(brokerMessageListener);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _brokerMessageListenerLocalService.dynamicQuery();
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
        return _brokerMessageListenerLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _brokerMessageListenerLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.acsoftware.brokerportlet.model.impl.BrokerMessageListenerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _brokerMessageListenerLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _brokerMessageListenerLocalService.dynamicQueryCount(dynamicQuery);
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
        return _brokerMessageListenerLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener fetchBrokerMessageListener(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.fetchBrokerMessageListener(brokerMessageListenerId);
    }

    /**
    * Returns the broker message listener with the primary key.
    *
    * @param brokerMessageListenerId the primary key of the broker message listener
    * @return the broker message listener
    * @throws PortalException if a broker message listener with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener getBrokerMessageListener(
        long brokerMessageListenerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.getBrokerMessageListener(brokerMessageListenerId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> getBrokerMessageListeners(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.getBrokerMessageListeners(start,
            end);
    }

    /**
    * Returns the number of broker message listeners.
    *
    * @return the number of broker message listeners
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getBrokerMessageListenersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.getBrokerMessageListenersCount();
    }

    /**
    * Updates the broker message listener in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param brokerMessageListener the broker message listener
    * @return the broker message listener that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener updateBrokerMessageListener(
        it.acsoftware.brokerportlet.model.BrokerMessageListener brokerMessageListener)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _brokerMessageListenerLocalService.updateBrokerMessageListener(brokerMessageListener);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _brokerMessageListenerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _brokerMessageListenerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _brokerMessageListenerLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public it.acsoftware.brokerportlet.model.BrokerMessageListener saveOrUpdateBrokerMessageListener(
        it.acsoftware.brokerportlet.model.BrokerMessageListener bml,
        java.util.Locale currentLocale, javax.portlet.PortletConfig config)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.acsoftware.brokerportlet.BeanValidationException {
        return _brokerMessageListenerLocalService.saveOrUpdateBrokerMessageListener(bml,
            currentLocale, config);
    }

    @Override
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByCompany(
        long companyId) {
        return _brokerMessageListenerLocalService.findByCompany(companyId);
    }

    @Override
    public java.util.List<it.acsoftware.brokerportlet.model.BrokerMessageListener> findByBrokerId(
        long brokerId) {
        return _brokerMessageListenerLocalService.findByBrokerId(brokerId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BrokerMessageListenerLocalService getWrappedBrokerMessageListenerLocalService() {
        return _brokerMessageListenerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBrokerMessageListenerLocalService(
        BrokerMessageListenerLocalService brokerMessageListenerLocalService) {
        _brokerMessageListenerLocalService = brokerMessageListenerLocalService;
    }

    @Override
    public BrokerMessageListenerLocalService getWrappedService() {
        return _brokerMessageListenerLocalService;
    }

    @Override
    public void setWrappedService(
        BrokerMessageListenerLocalService brokerMessageListenerLocalService) {
        _brokerMessageListenerLocalService = brokerMessageListenerLocalService;
    }
}
