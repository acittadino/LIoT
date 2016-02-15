package it.acsoftware.apachesparkmanager.service.base;

import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JobDateScheduleLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
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
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;

    public JobDateScheduleLocalServiceClpInvoker() {
        _methodName0 = "addJobDateSchedule";

        _methodParameterTypes0 = new String[] {
                "it.acsoftware.apachesparkmanager.model.JobDateSchedule"
            };

        _methodName1 = "createJobDateSchedule";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteJobDateSchedule";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteJobDateSchedule";

        _methodParameterTypes3 = new String[] {
                "it.acsoftware.apachesparkmanager.model.JobDateSchedule"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchJobDateSchedule";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getJobDateSchedule";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getJobDateSchedules";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getJobDateSchedulesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateJobDateSchedule";

        _methodParameterTypes15 = new String[] {
                "it.acsoftware.apachesparkmanager.model.JobDateSchedule"
            };

        _methodName44 = "getBeanIdentifier";

        _methodParameterTypes44 = new String[] {  };

        _methodName45 = "setBeanIdentifier";

        _methodParameterTypes45 = new String[] { "java.lang.String" };

        _methodName50 = "saveOrUpdareJobDateSchedule";

        _methodParameterTypes50 = new String[] {
                "it.acsoftware.apachesparkmanager.model.JobDateSchedule",
                "java.util.Locale", "javax.portlet.PortletConfig"
            };

        _methodName52 = "findByCompanyId";

        _methodParameterTypes52 = new String[] { "long" };

        _methodName53 = "fireApacheSparkJobDate";

        _methodParameterTypes53 = new String[] {
                "it.acsoftware.apachesparkmanager.model.JobDateSchedule",
                "java.util.HashMap"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.addJobDateSchedule((it.acsoftware.apachesparkmanager.model.JobDateSchedule) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.createJobDateSchedule(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.deleteJobDateSchedule(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.deleteJobDateSchedule((it.acsoftware.apachesparkmanager.model.JobDateSchedule) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.fetchJobDateSchedule(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.getJobDateSchedule(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.getJobDateSchedules(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.getJobDateSchedulesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.updateJobDateSchedule((it.acsoftware.apachesparkmanager.model.JobDateSchedule) arguments[0]);
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            JobDateScheduleLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.saveOrUpdareJobDateSchedule((it.acsoftware.apachesparkmanager.model.JobDateSchedule) arguments[0],
                (java.util.Locale) arguments[1],
                (javax.portlet.PortletConfig) arguments[2]);
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return JobDateScheduleLocalServiceUtil.findByCompanyId(((Long) arguments[0]).longValue());
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            JobDateScheduleLocalServiceUtil.fireApacheSparkJobDate((it.acsoftware.apachesparkmanager.model.JobDateSchedule) arguments[0],
                (java.util.HashMap<java.lang.String, java.lang.String>) arguments[1]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
