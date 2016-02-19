package it.acsoftware.brokerportlet.broker;

import it.acsoftware.brokerportlet.model.Broker;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Properties;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

public class SslUtils {
	private Properties sslProps;
	private Broker b;

	public SslUtils(Broker b) throws PortalException, SystemException {
		this.b = b;
		FileEntry certFile = DLAppLocalServiceUtil
				.getFileEntryByUuidAndGroupId(b.getSslCertificateUUid(),
						b.getGroupId());
		sslProps = new Properties();
		sslProps.put("ssl.development.keyStorePassword", b.getSslSecret());
		sslProps.put("ssl.development.trustStoreFile", certFile.getTitle());
	}

	public String getCertPassword() {
		return b.getSslSecret();
	}

	public InputStream getCertsInputStream() {
		try {
			FileEntry certFile = DLAppLocalServiceUtil
					.getFileEntryByUuidAndGroupId(b.getSslCertificateUUid(),
							b.getGroupId());

			return certFile.getContentStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public SSLSocketFactory getSocketFactory() {
		SSLSocketFactory result = null;
		if ((null == result)) {

			try {
				KeyStore keystoreTrust = KeyStore.getInstance("BKS");
				keystoreTrust.load(this.getCertsInputStream(), this
						.getCertPassword().toCharArray());
				TrustManagerFactory trustManagerFactory = TrustManagerFactory
						.getInstance(TrustManagerFactory.getDefaultAlgorithm());
				trustManagerFactory.init(keystoreTrust);
				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, trustManagerFactory.getTrustManagers(),
						new SecureRandom());
				result = sslContext.getSocketFactory();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return result;
	}
}
