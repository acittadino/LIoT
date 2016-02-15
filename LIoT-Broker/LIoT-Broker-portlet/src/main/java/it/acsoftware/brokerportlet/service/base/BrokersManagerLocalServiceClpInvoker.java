package it.acsoftware.brokerportlet.service.base;

import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrokersManagerLocalServiceClpInvoker {
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;
    private String _methodName36;
    private String[] _methodParameterTypes36;
    private String _methodName37;
    private String[] _methodParameterTypes37;
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;

    public BrokersManagerLocalServiceClpInvoker() {
        _methodName24 = "getBeanIdentifier";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "setBeanIdentifier";

        _methodParameterTypes25 = new String[] { "java.lang.String" };

        _methodName28 = "startServer";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "stopServer";

        _methodParameterTypes29 = new String[] { "long" };

        _methodName30 = "restartServer";

        _methodParameterTypes30 = new String[] { "long" };

        _methodName31 = "register";

        _methodParameterTypes31 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName32 = "register";

        _methodParameterTypes32 = new String[] {
                "java.lang.String", "long",
                "it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService"
            };

        _methodName33 = "unregister";

        _methodParameterTypes33 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName34 = "unregister";

        _methodParameterTypes34 = new String[] {
                "java.lang.String", "long",
                "it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService"
            };

        _methodName35 = "isRunning";

        _methodParameterTypes35 = new String[] { "long" };

        _methodName36 = "sendMessage";

        _methodParameterTypes36 = new String[] {
                "long", "byte[][]", "java.util.HashMap"
            };

        _methodName37 = "removeBrokerServiceDefinition";

        _methodParameterTypes37 = new String[] { "long" };

        _methodName38 = "addBrokerServiceDefinition";

        _methodParameterTypes38 = new String[] {
                "it.acsoftware.brokerportlet.model.Broker", "boolean"
            };

        _methodName39 = "getBrokerServiceLastStatus";

        _methodParameterTypes39 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return BrokersManagerLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            BrokersManagerLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            BrokersManagerLocalServiceUtil.startServer(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            BrokersManagerLocalServiceUtil.stopServer(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            BrokersManagerLocalServiceUtil.restartServer(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            BrokersManagerLocalServiceUtil.register((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);

            return null;
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            BrokersManagerLocalServiceUtil.register((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService) arguments[2]);

            return null;
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            BrokersManagerLocalServiceUtil.unregister((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);

            return null;
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            BrokersManagerLocalServiceUtil.unregister((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (it.acsoftware.brokerportlet.broker.receivers.BrokerMessageListenerService) arguments[2]);

            return null;
        }

        if (_methodName35.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
            return BrokersManagerLocalServiceUtil.isRunning(((Long) arguments[0]).longValue());
        }

        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            BrokersManagerLocalServiceUtil.sendMessage(((Long) arguments[0]).longValue(),
                (byte[]) arguments[1],
                (java.util.HashMap<java.lang.String, java.lang.String>) arguments[2]);

            return null;
        }

        if (_methodName37.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
            BrokersManagerLocalServiceUtil.removeBrokerServiceDefinition(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            BrokersManagerLocalServiceUtil.addBrokerServiceDefinition((it.acsoftware.brokerportlet.model.Broker) arguments[0],
                ((Boolean) arguments[1]).booleanValue());

            return null;
        }

        if (_methodName39.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
            return BrokersManagerLocalServiceUtil.getBrokerServiceLastStatus(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
