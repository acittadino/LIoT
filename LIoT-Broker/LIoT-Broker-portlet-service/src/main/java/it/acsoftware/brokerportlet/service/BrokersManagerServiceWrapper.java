package it.acsoftware.brokerportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrokersManagerService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrokersManagerService
 * @generated
 */
public class BrokersManagerServiceWrapper implements BrokersManagerService,
    ServiceWrapper<BrokersManagerService> {
    private BrokersManagerService _brokersManagerService;

    public BrokersManagerServiceWrapper(
        BrokersManagerService brokersManagerService) {
        _brokersManagerService = brokersManagerService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _brokersManagerService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _brokersManagerService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _brokersManagerService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void startServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        _brokersManagerService.startServer(brokerId);
    }

    @Override
    public void stopServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        _brokersManagerService.stopServer(brokerId);
    }

    @Override
    public void restartServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        _brokersManagerService.restartServer(brokerId);
    }

    @Override
    public void register(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName) {
        _brokersManagerService.register(topic, brokerId, bmlsClass,
            servletContextName);
    }

    @Override
    public void unregister(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName) {
        _brokersManagerService.unregister(topic, brokerId, bmlsClass,
            servletContextName);
    }

    @Override
    public java.lang.Boolean isRunning(long brokerId) {
        return _brokersManagerService.isRunning(brokerId);
    }

    @Override
    public void sendMessage(long brokerId, byte[] message,
        java.util.HashMap<java.lang.String, java.lang.String> params) {
        _brokersManagerService.sendMessage(brokerId, message, params);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BrokersManagerService getWrappedBrokersManagerService() {
        return _brokersManagerService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBrokersManagerService(
        BrokersManagerService brokersManagerService) {
        _brokersManagerService = brokersManagerService;
    }

    @Override
    public BrokersManagerService getWrappedService() {
        return _brokersManagerService;
    }

    @Override
    public void setWrappedService(BrokersManagerService brokersManagerService) {
        _brokersManagerService = brokersManagerService;
    }
}
