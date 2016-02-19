package it.acsoftware.brokerportlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for BrokersManager. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BrokersManagerServiceUtil
 * @see it.acsoftware.brokerportlet.service.base.BrokersManagerServiceBaseImpl
 * @see it.acsoftware.brokerportlet.service.impl.BrokersManagerServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface BrokersManagerService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BrokersManagerServiceUtil} to access the brokers manager remote service. Add custom service methods to {@link it.acsoftware.brokerportlet.service.impl.BrokersManagerServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId);

    public void unregister(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.Boolean isRunning(long brokerId);

    public void sendMessage(long brokerId, byte[] message,
        java.util.HashMap<java.lang.String, java.lang.String> params);
}
