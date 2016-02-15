package it.acsoftware.liotexamples.services.service.base;

import it.acsoftware.liotexamples.services.service.LIoTExamplesLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LIoTExamplesLocalServiceClpInvoker {
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;

    public LIoTExamplesLocalServiceClpInvoker() {
        _methodName14 = "getBeanIdentifier";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "setBeanIdentifier";

        _methodParameterTypes15 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LIoTExamplesLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            LIoTExamplesLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
