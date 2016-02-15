package it.acsoftware.apachesparkmanager.service.base;

import it.acsoftware.apachesparkmanager.service.JobEventScheduleServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JobEventScheduleServiceClpInvoker {
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;

    public JobEventScheduleServiceClpInvoker() {
        _methodName28 = "getBeanIdentifier";

        _methodParameterTypes28 = new String[] {  };

        _methodName29 = "setBeanIdentifier";

        _methodParameterTypes29 = new String[] { "java.lang.String" };

        _methodName34 = "getEventList";

        _methodParameterTypes34 = new String[] { "long" };

        _methodName35 = "fireApacheSparkJobEvent";

        _methodParameterTypes35 = new String[] {
                "long", "java.lang.String", "java.util.HashMap"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return JobEventScheduleServiceUtil.getBeanIdentifier();
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            JobEventScheduleServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            return JobEventScheduleServiceUtil.getEventList(((Long) arguments[0]).longValue());
        }

        if (_methodName35.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
            JobEventScheduleServiceUtil.fireApacheSparkJobEvent(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.util.HashMap<java.lang.String, java.lang.String>) arguments[2]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
