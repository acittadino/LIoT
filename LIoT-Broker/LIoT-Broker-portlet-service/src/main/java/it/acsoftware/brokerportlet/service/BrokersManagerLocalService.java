package it.acsoftware.brokerportlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for BrokersManager. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BrokersManagerLocalServiceUtil
 * @see it.acsoftware.brokerportlet.service.base.BrokersManagerLocalServiceBaseImpl
 * @see it.acsoftware.brokerportlet.service.impl.BrokersManagerLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface BrokersManagerLocalService extends BaseLocalService,
    InvokableLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BrokersManagerLocalServiceUtil} to access the brokers manager local service. Add custom service methods to {@link it.acsoftware.brokerportlet.service.impl.BrokersManagerLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public void startServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException;

    public void stopServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException;

    public void restartServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException;

    public void register(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName);

    public void register(java.lang.String topic, long brokerId,
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener);

    public void unregister(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName);

    public void unregister(java.lang.String topic, long brokerId,
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.Boolean isRunning(long brokerId);

    public void sendMessage(long brokerId, byte[] message,
        java.util.HashMap<java.lang.String, java.lang.String> params);

    public void removeBrokerServiceDefinition(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException;

    public void addBrokerServiceDefinition(
        it.acsoftware.brokerportlet.model.Broker b, boolean reload)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getBrokerServiceLastStatus(long brokerId);
}
