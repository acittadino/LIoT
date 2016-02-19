package it.acsoftware.brokerportlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BrokersManager. This utility wraps
 * {@link it.acsoftware.brokerportlet.service.impl.BrokersManagerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BrokersManagerLocalService
 * @see it.acsoftware.brokerportlet.service.base.BrokersManagerLocalServiceBaseImpl
 * @see it.acsoftware.brokerportlet.service.impl.BrokersManagerLocalServiceImpl
 * @generated
 */
public class BrokersManagerLocalServiceUtil {
    private static BrokersManagerLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link it.acsoftware.brokerportlet.service.impl.BrokersManagerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void startServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        getService().startServer(brokerId);
    }

    public static void stopServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        getService().stopServer(brokerId);
    }

    public static void restartServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        getService().restartServer(brokerId);
    }

    public static void register(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId) {
        getService()
            .register(topic, brokerId, bmlsClass, servletContextName,
            brokerMessageListenerId);
    }

    public static void register(java.lang.String topic, long brokerId,
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener) {
        getService().register(topic, brokerId, listener);
    }

    public static void unregister(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId) {
        getService()
            .unregister(topic, brokerId, bmlsClass, servletContextName,
            brokerMessageListenerId);
    }

    public static void unregister(java.lang.String topic, long brokerId,
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener) {
        getService().unregister(topic, brokerId, listener);
    }

    public static java.lang.Boolean isRunning(long brokerId) {
        return getService().isRunning(brokerId);
    }

    public static void sendMessage(long brokerId, byte[] message,
        java.util.HashMap<java.lang.String, java.lang.String> params) {
        getService().sendMessage(brokerId, message, params);
    }

    public static void removeBrokerServiceDefinition(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        getService().removeBrokerServiceDefinition(brokerId);
    }

    public static void addBrokerServiceDefinition(
        it.acsoftware.brokerportlet.model.Broker b, boolean reload)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().addBrokerServiceDefinition(b, reload);
    }

    public static java.lang.String getBrokerServiceLastStatus(long brokerId) {
        return getService().getBrokerServiceLastStatus(brokerId);
    }

    public static void clearService() {
        _service = null;
    }

    public static BrokersManagerLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    BrokersManagerLocalService.class.getName());

            if (invokableLocalService instanceof BrokersManagerLocalService) {
                _service = (BrokersManagerLocalService) invokableLocalService;
            } else {
                _service = new BrokersManagerLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(BrokersManagerLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(BrokersManagerLocalService service) {
    }
}
