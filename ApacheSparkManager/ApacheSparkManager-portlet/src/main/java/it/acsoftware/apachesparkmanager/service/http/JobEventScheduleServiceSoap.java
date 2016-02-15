package it.acsoftware.apachesparkmanager.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.acsoftware.apachesparkmanager.service.JobEventScheduleServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link it.acsoftware.apachesparkmanager.service.JobEventScheduleServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link it.acsoftware.apachesparkmanager.model.JobEventScheduleSoap}.
 * If the method in the service utility returns a
 * {@link it.acsoftware.apachesparkmanager.model.JobEventSchedule}, that is translated to a
 * {@link it.acsoftware.apachesparkmanager.model.JobEventScheduleSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobEventScheduleServiceHttp
 * @see it.acsoftware.apachesparkmanager.model.JobEventScheduleSoap
 * @see it.acsoftware.apachesparkmanager.service.JobEventScheduleServiceUtil
 * @generated
 */
public class JobEventScheduleServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(JobEventScheduleServiceSoap.class);

    public static it.acsoftware.apachesparkmanager.model.JobEventScheduleSoap[] getEventList(
        long companyId) throws RemoteException {
        try {
            java.util.List<it.acsoftware.apachesparkmanager.model.JobEventSchedule> returnValue =
                JobEventScheduleServiceUtil.getEventList(companyId);

            return it.acsoftware.apachesparkmanager.model.JobEventScheduleSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void fireApacheSparkJobEvent(long companyId,
        java.lang.String jobEventName,
        java.util.HashMap<java.lang.String, java.lang.String> params)
        throws RemoteException {
        try {
            JobEventScheduleServiceUtil.fireApacheSparkJobEvent(companyId,
                jobEventName, params);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
