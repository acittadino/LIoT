package it.acsoftware.apachesparkmanager.service.base;

import it.acsoftware.apachesparkmanager.service.ApaceSparkManagerLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ApaceSparkManagerLocalServiceClpInvoker {
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;

    public ApaceSparkManagerLocalServiceClpInvoker() {
        _methodName26 = "getBeanIdentifier";

        _methodParameterTypes26 = new String[] {  };

        _methodName27 = "setBeanIdentifier";

        _methodParameterTypes27 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return ApaceSparkManagerLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            ApaceSparkManagerLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
