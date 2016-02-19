package it.acsoftware.brokerportlet.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
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
 * @see BrokersManagerServiceHttp
 * @see it.acsoftware.brokerportlet.service.BrokersManagerServiceUtil
 * @generated
 */
public class BrokersManagerServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(BrokersManagerServiceSoap.class);

    public static void startServer(long brokerId) throws RemoteException {
        try {
            BrokersManagerServiceUtil.startServer(brokerId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void stopServer(long brokerId) throws RemoteException {
        try {
            BrokersManagerServiceUtil.stopServer(brokerId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void restartServer(long brokerId) throws RemoteException {
        try {
            BrokersManagerServiceUtil.restartServer(brokerId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void register(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId) throws RemoteException {
        try {
            BrokersManagerServiceUtil.register(topic, brokerId, bmlsClass,
                servletContextName, brokerMessageListenerId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void unregister(java.lang.String topic, long brokerId,
        java.lang.String bmlsClass, java.lang.String servletContextName,
        java.lang.String brokerMessageListenerId) throws RemoteException {
        try {
            BrokersManagerServiceUtil.unregister(topic, brokerId, bmlsClass,
                servletContextName, brokerMessageListenerId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.Boolean isRunning(long brokerId)
        throws RemoteException {
        try {
            java.lang.Boolean returnValue = BrokersManagerServiceUtil.isRunning(brokerId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void sendMessage(long brokerId, byte[] message,
        java.util.HashMap<java.lang.String, java.lang.String> params)
        throws RemoteException {
        try {
            BrokersManagerServiceUtil.sendMessage(brokerId, message, params);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
