package it.acsoftware.brokerportlet.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import it.acsoftware.brokerportlet.model.BrokerMessageListener;
import it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalService;
import it.acsoftware.brokerportlet.service.persistence.BrokerMessageListenerPersistence;
import it.acsoftware.brokerportlet.service.persistence.BrokerPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the broker message listener local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.acsoftware.brokerportlet.service.impl.BrokerMessageListenerLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.acsoftware.brokerportlet.service.impl.BrokerMessageListenerLocalServiceImpl
 * @see it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil
 * @generated
 */
public abstract class BrokerMessageListenerLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements BrokerMessageListenerLocalService,
        IdentifiableBean {
    @BeanReference(type = it.acsoftware.brokerportlet.service.BrokerLocalService.class)
    protected it.acsoftware.brokerportlet.service.BrokerLocalService brokerLocalService;
    @BeanReference(type = BrokerPersistence.class)
    protected BrokerPersistence brokerPersistence;
    @BeanReference(type = it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalService.class)
    protected it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalService brokerMessageListenerLocalService;
    @BeanReference(type = BrokerMessageListenerPersistence.class)
    protected BrokerMessageListenerPersistence brokerMessageListenerPersistence;
    @BeanReference(type = it.acsoftware.brokerportlet.service.BrokersManagerLocalService.class)
    protected it.acsoftware.brokerportlet.service.BrokersManagerLocalService brokersManagerLocalService;
    @BeanReference(type = it.acsoftware.brokerportlet.service.BrokersManagerService.class)
    protected it.acsoftware.brokerportlet.service.BrokersManagerService brokersManagerService;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private BrokerMessageListenerLocalServiceClpInvoker _clpInvoker = new BrokerMessageListenerLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil} to access the broker message listener local service.
     */

    /**
     * Adds the broker message listener to the database. Also notifies the appropriate model listeners.
     *
     * @param brokerMessageListener the broker message listener
     * @return the broker message listener that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public BrokerMessageListener addBrokerMessageListener(
        BrokerMessageListener brokerMessageListener) throws SystemException {
        brokerMessageListener.setNew(true);

        return brokerMessageListenerPersistence.update(brokerMessageListener);
    }

    /**
     * Creates a new broker message listener with the primary key. Does not add the broker message listener to the database.
     *
     * @param brokerMessageListenerId the primary key for the new broker message listener
     * @return the new broker message listener
     */
    @Override
    public BrokerMessageListener createBrokerMessageListener(
        long brokerMessageListenerId) {
        return brokerMessageListenerPersistence.create(brokerMessageListenerId);
    }

    /**
     * Deletes the broker message listener with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param brokerMessageListenerId the primary key of the broker message listener
     * @return the broker message listener that was removed
     * @throws PortalException if a broker message listener with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public BrokerMessageListener deleteBrokerMessageListener(
        long brokerMessageListenerId) throws PortalException, SystemException {
        return brokerMessageListenerPersistence.remove(brokerMessageListenerId);
    }

    /**
     * Deletes the broker message listener from the database. Also notifies the appropriate model listeners.
     *
     * @param brokerMessageListener the broker message listener
     * @return the broker message listener that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public BrokerMessageListener deleteBrokerMessageListener(
        BrokerMessageListener brokerMessageListener) throws SystemException {
        return brokerMessageListenerPersistence.remove(brokerMessageListener);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(BrokerMessageListener.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return brokerMessageListenerPersistence.findWithDynamicQuery(dynamicQuery);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return brokerMessageListenerPersistence.findWithDynamicQuery(dynamicQuery,
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return brokerMessageListenerPersistence.findWithDynamicQuery(dynamicQuery,
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return brokerMessageListenerPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return brokerMessageListenerPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public BrokerMessageListener fetchBrokerMessageListener(
        long brokerMessageListenerId) throws SystemException {
        return brokerMessageListenerPersistence.fetchByPrimaryKey(brokerMessageListenerId);
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
    public BrokerMessageListener getBrokerMessageListener(
        long brokerMessageListenerId) throws PortalException, SystemException {
        return brokerMessageListenerPersistence.findByPrimaryKey(brokerMessageListenerId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return brokerMessageListenerPersistence.findByPrimaryKey(primaryKeyObj);
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
    public List<BrokerMessageListener> getBrokerMessageListeners(int start,
        int end) throws SystemException {
        return brokerMessageListenerPersistence.findAll(start, end);
    }

    /**
     * Returns the number of broker message listeners.
     *
     * @return the number of broker message listeners
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getBrokerMessageListenersCount() throws SystemException {
        return brokerMessageListenerPersistence.countAll();
    }

    /**
     * Updates the broker message listener in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param brokerMessageListener the broker message listener
     * @return the broker message listener that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public BrokerMessageListener updateBrokerMessageListener(
        BrokerMessageListener brokerMessageListener) throws SystemException {
        return brokerMessageListenerPersistence.update(brokerMessageListener);
    }

    /**
     * Returns the broker local service.
     *
     * @return the broker local service
     */
    public it.acsoftware.brokerportlet.service.BrokerLocalService getBrokerLocalService() {
        return brokerLocalService;
    }

    /**
     * Sets the broker local service.
     *
     * @param brokerLocalService the broker local service
     */
    public void setBrokerLocalService(
        it.acsoftware.brokerportlet.service.BrokerLocalService brokerLocalService) {
        this.brokerLocalService = brokerLocalService;
    }

    /**
     * Returns the broker persistence.
     *
     * @return the broker persistence
     */
    public BrokerPersistence getBrokerPersistence() {
        return brokerPersistence;
    }

    /**
     * Sets the broker persistence.
     *
     * @param brokerPersistence the broker persistence
     */
    public void setBrokerPersistence(BrokerPersistence brokerPersistence) {
        this.brokerPersistence = brokerPersistence;
    }

    /**
     * Returns the broker message listener local service.
     *
     * @return the broker message listener local service
     */
    public it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalService getBrokerMessageListenerLocalService() {
        return brokerMessageListenerLocalService;
    }

    /**
     * Sets the broker message listener local service.
     *
     * @param brokerMessageListenerLocalService the broker message listener local service
     */
    public void setBrokerMessageListenerLocalService(
        it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalService brokerMessageListenerLocalService) {
        this.brokerMessageListenerLocalService = brokerMessageListenerLocalService;
    }

    /**
     * Returns the broker message listener persistence.
     *
     * @return the broker message listener persistence
     */
    public BrokerMessageListenerPersistence getBrokerMessageListenerPersistence() {
        return brokerMessageListenerPersistence;
    }

    /**
     * Sets the broker message listener persistence.
     *
     * @param brokerMessageListenerPersistence the broker message listener persistence
     */
    public void setBrokerMessageListenerPersistence(
        BrokerMessageListenerPersistence brokerMessageListenerPersistence) {
        this.brokerMessageListenerPersistence = brokerMessageListenerPersistence;
    }

    /**
     * Returns the brokers manager local service.
     *
     * @return the brokers manager local service
     */
    public it.acsoftware.brokerportlet.service.BrokersManagerLocalService getBrokersManagerLocalService() {
        return brokersManagerLocalService;
    }

    /**
     * Sets the brokers manager local service.
     *
     * @param brokersManagerLocalService the brokers manager local service
     */
    public void setBrokersManagerLocalService(
        it.acsoftware.brokerportlet.service.BrokersManagerLocalService brokersManagerLocalService) {
        this.brokersManagerLocalService = brokersManagerLocalService;
    }

    /**
     * Returns the brokers manager remote service.
     *
     * @return the brokers manager remote service
     */
    public it.acsoftware.brokerportlet.service.BrokersManagerService getBrokersManagerService() {
        return brokersManagerService;
    }

    /**
     * Sets the brokers manager remote service.
     *
     * @param brokersManagerService the brokers manager remote service
     */
    public void setBrokersManagerService(
        it.acsoftware.brokerportlet.service.BrokersManagerService brokersManagerService) {
        this.brokersManagerService = brokersManagerService;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("it.acsoftware.brokerportlet.model.BrokerMessageListener",
            brokerMessageListenerLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "it.acsoftware.brokerportlet.model.BrokerMessageListener");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return BrokerMessageListener.class;
    }

    protected String getModelClassName() {
        return BrokerMessageListener.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = brokerMessageListenerPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
