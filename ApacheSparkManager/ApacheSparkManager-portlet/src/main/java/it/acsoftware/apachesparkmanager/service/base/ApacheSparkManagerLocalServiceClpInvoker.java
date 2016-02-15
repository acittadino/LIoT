package it.acsoftware.apachesparkmanager.service.base;

import it.acsoftware.apachesparkmanager.service.ApacheSparkManagerLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ApacheSparkManagerLocalServiceClpInvoker {
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;

    public ApacheSparkManagerLocalServiceClpInvoker() {
        _methodName28 = "getBeanIdentifier";

        _methodParameterTypes28 = new String[] {  };

        _methodName29 = "setBeanIdentifier";

        _methodParameterTypes29 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return ApacheSparkManagerLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            ApacheSparkManagerLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
