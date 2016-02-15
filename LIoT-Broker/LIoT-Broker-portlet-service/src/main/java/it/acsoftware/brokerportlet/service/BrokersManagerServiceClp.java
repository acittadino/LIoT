package it.acsoftware.brokerportlet.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrokersManagerServiceClp implements BrokersManagerService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;

    public BrokersManagerServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "startServer";

        _methodParameterTypes3 = new String[] { "long" };

        _methodName4 = "stopServer";

        _methodParameterTypes4 = new String[] { "long" };

        _methodName5 = "restartServer";

        _methodParameterTypes5 = new String[] { "long" };

        _methodName6 = "register";

        _methodParameterTypes6 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName7 = "unregister";

        _methodParameterTypes7 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName8 = "isRunning";

        _methodParameterTypes8 = new String[] { "long" };

        _methodName9 = "sendMessage";

        _methodParameterTypes9 = new String[] {
                "long", "byte[][]", "java.util.HashMap"
            };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        try {
            _invokableService.invokeMethod(_methodName3,
                _methodParameterTypes3, new Object[] { brokerId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof it.acsoftware.brokerportlet.BrokerServiceException) {
                throw (it.acsoftware.brokerportlet.BrokerServiceException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void stopServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        try {
            _invokableService.invokeMethod(_methodName4,
                _methodParameterTypes4, new Object[] { brokerId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof it.acsoftware.brokerportlet.BrokerServiceException) {
                throw (it.acsoftware.brokerportlet.BrokerServiceException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void restartServer(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        try {
            _invokableService.invokeMethod(_methodName5,
                _methodParameterTypes5, new Object[] { brokerId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof it.acsoftware.brokerportlet.BrokerServiceException) {
                throw (it.acsoftware.brokerportlet.BrokerServiceException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void register(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName) {
        try {
            _invokableService.invokeMethod(_methodName6,
                _methodParameterTypes6,
                new Object[] {
                    ClpSerializer.translateInput(topic),
                    
                brokerId,
                    
                ClpSerializer.translateInput(bmlsClass),
                    
                ClpSerializer.translateInput(servletContextName)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void unregister(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName) {
        try {
            _invokableService.invokeMethod(_methodName7,
                _methodParameterTypes7,
                new Object[] {
                    ClpSerializer.translateInput(topic),
                    
                brokerId,
                    
                ClpSerializer.translateInput(bmlsClass),
                    
                ClpSerializer.translateInput(servletContextName)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Boolean isRunning(long brokerId) {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8, new Object[] { brokerId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.Boolean) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void sendMessage(long brokerId, byte[] message,
        java.util.HashMap<java.lang.String, java.lang.String> params) {
        try {
            _invokableService.invokeMethod(_methodName9,
                _methodParameterTypes9,
                new Object[] {
                    brokerId,
                    
                ClpSerializer.translateInput(message),
                    
                ClpSerializer.translateInput(params)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }
}
