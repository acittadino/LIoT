package it.acsoftware.brokerportlet.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrokersManagerLocalServiceClp implements BrokersManagerLocalService {
    private InvokableLocalService _invokableLocalService;
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
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;

    public BrokersManagerLocalServiceClp(
        InvokableLocalService invokableLocalService) {
        _invokableLocalService = invokableLocalService;

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

        _methodName7 = "register";

        _methodParameterTypes7 = new String[] {
                "java.lang.String", "long",
                "it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService"
            };

        _methodName8 = "unregister";

        _methodParameterTypes8 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName9 = "unregister";

        _methodParameterTypes9 = new String[] {
                "java.lang.String", "long",
                "it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService"
            };

        _methodName10 = "isRunning";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "sendMessage";

        _methodParameterTypes11 = new String[] {
                "long", "byte[][]", "java.util.HashMap"
            };

        _methodName12 = "removeBrokerServiceDefinition";

        _methodParameterTypes12 = new String[] { "long" };

        _methodName13 = "addBrokerServiceDefinition";

        _methodParameterTypes13 = new String[] {
                "it.acsoftware.brokerportlet.model.Broker", "boolean"
            };

        _methodName14 = "getBrokerServiceLastStatus";

        _methodParameterTypes14 = new String[] { "long" };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName0,
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
            _invokableLocalService.invokeMethod(_methodName1,
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
            _invokableLocalService.invokeMethod(_methodName3,
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
            _invokableLocalService.invokeMethod(_methodName4,
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
            _invokableLocalService.invokeMethod(_methodName5,
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
            _invokableLocalService.invokeMethod(_methodName6,
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
    public void register(java.lang.String topic, long brokerId,
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener) {
        try {
            _invokableLocalService.invokeMethod(_methodName7,
                _methodParameterTypes7,
                new Object[] {
                    ClpSerializer.translateInput(topic),
                    
                brokerId,
                    
                ClpSerializer.translateInput(listener)
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
            _invokableLocalService.invokeMethod(_methodName8,
                _methodParameterTypes8,
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
        it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService listener) {
        try {
            _invokableLocalService.invokeMethod(_methodName9,
                _methodParameterTypes9,
                new Object[] {
                    ClpSerializer.translateInput(topic),
                    
                brokerId,
                    
                ClpSerializer.translateInput(listener)
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
            returnObj = _invokableLocalService.invokeMethod(_methodName10,
                    _methodParameterTypes10, new Object[] { brokerId });
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
            _invokableLocalService.invokeMethod(_methodName11,
                _methodParameterTypes11,
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

    @Override
    public void removeBrokerServiceDefinition(long brokerId)
        throws it.acsoftware.brokerportlet.BrokerServiceException {
        try {
            _invokableLocalService.invokeMethod(_methodName12,
                _methodParameterTypes12, new Object[] { brokerId });
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
    public void addBrokerServiceDefinition(
        it.acsoftware.brokerportlet.model.Broker b, boolean reload)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName13,
                _methodParameterTypes13,
                new Object[] { ClpSerializer.translateInput(b), reload });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
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
    public java.lang.String getBrokerServiceLastStatus(long brokerId) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName14,
                    _methodParameterTypes14, new Object[] { brokerId });
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
}
