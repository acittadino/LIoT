package it.acsoftware.brokerportlet.service.base;

import it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrokersManagerServiceClpInvoker {
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

    public BrokersManagerServiceClpInvoker() {
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

        _methodName32 = "unregister";

        _methodParameterTypes32 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName33 = "isRunning";

        _methodParameterTypes33 = new String[] { "long" };

        _methodName34 = "sendMessage";

        _methodParameterTypes34 = new String[] {
                "long", "byte[][]", "java.util.HashMap"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return BrokersManagerServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            BrokersManagerServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            BrokersManagerServiceUtil.startServer(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            BrokersManagerServiceUtil.stopServer(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            BrokersManagerServiceUtil.restartServer(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            BrokersManagerServiceUtil.register((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);

            return null;
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            BrokersManagerServiceUtil.unregister((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);

            return null;
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            return BrokersManagerServiceUtil.isRunning(((Long) arguments[0]).longValue());
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            BrokersManagerServiceUtil.sendMessage(((Long) arguments[0]).longValue(),
                (byte[]) arguments[1],
                (java.util.HashMap<java.lang.String, java.lang.String>) arguments[2]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
