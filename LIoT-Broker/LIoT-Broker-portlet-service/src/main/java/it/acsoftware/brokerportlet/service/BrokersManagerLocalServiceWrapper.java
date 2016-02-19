package it.acsoftware.brokerportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrokersManagerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrokersManagerLocalService
 * @generated
 */
public class BrokersManagerLocalServiceWrapper
    implements BrokersManagerLocalService,
        ServiceWrapper<BrokersManagerLocalService> {
    private BrokersManagerLocalService _brokersManagerLocalService;

    public BrokersManagerLocalServiceWrapper(
        BrokersManagerLocalService brokersManagerLocalService) {
        _brokersManagerLocalService = brokersManagerLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _brokersManagerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _brokersManagerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _brokersManagerLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void startServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        _brokersManagerLocalService.startServer(brokerId);
    }

    @Override
    public void stopServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        _brokersManagerLocalService.stopServer(brokerId);
    }

    @Override
    public void restartServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        _brokersManagerLocalService.restartServer(brokerId);
    }

    @Override
    public void register(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId) {
        _brokersManagerLocalService.register(topic, brokerId, bmlsClass,
            servletContextName, brokerMessageListenerId);
    }

    @Override
    public void register(java.lang.String topic, long brokerId,
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener) {
        _brokersManagerLocalService.register(topic, brokerId, listener);
    }

    @Override
    public void unregister(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId) {
        _brokersManagerLocalService.unregister(topic, brokerId, bmlsClass,
            servletContextName, brokerMessageListenerId);
    }

    @Override
    public void unregister(java.lang.String topic, long brokerId,
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener) {
        _brokersManagerLocalService.unregister(topic, brokerId, listener);
    }

    @Override
    public java.lang.Boolean isRunning(long brokerId) {
        return _brokersManagerLocalService.isRunning(brokerId);
    }

    @Override
    public void sendMessage(long brokerId, byte[] message,
        java.util.HashMap<java.lang.String, java.lang.String> params) {
        _brokersManagerLocalService.sendMessage(brokerId, message, params);
    }

    @Override
    public void removeBrokerServiceDefinition(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        _brokersManagerLocalService.removeBrokerServiceDefinition(brokerId);
    }

    @Override
    public void addBrokerServiceDefinition(
        it.acsoftware.brokerportlet.model.Broker b, boolean reload)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _brokersManagerLocalService.addBrokerServiceDefinition(b, reload);
    }

    @Override
    public java.lang.String getBrokerServiceLastStatus(long brokerId) {
        return _brokersManagerLocalService.getBrokerServiceLastStatus(brokerId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BrokersManagerLocalService getWrappedBrokersManagerLocalService() {
        return _brokersManagerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBrokersManagerLocalService(
        BrokersManagerLocalService brokersManagerLocalService) {
        _brokersManagerLocalService = brokersManagerLocalService;
    }

    @Override
    public BrokersManagerLocalService getWrappedService() {
        return _brokersManagerLocalService;
    }

    @Override
    public void setWrappedService(
        BrokersManagerLocalService brokersManagerLocalService) {
        _brokersManagerLocalService = brokersManagerLocalService;
    }
}
