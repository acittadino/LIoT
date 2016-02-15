package it.acsoftware.brokerportlet.portlet;

import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;
import it.acsoftware.brokerportlet.permission.BrokerModelPermission;
import it.acsoftware.brokerportlet.permission.BrokerPermission;
import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil;
import it.acsosftware.brokerportlet.util.BrokerType;
import it.acsosftware.brokerportlet.util.ResourceLocator;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BrokerPortlet
 */
public class BrokerPortlet extends MVCPortlet {
	public void saveOrUpdateBroker(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		UploadRequest request = PortalUtil
				.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		long brokerId = ParamUtil.getLong(request, "brokerId");
		boolean isNew = brokerId == 0;
		Broker broker = null;

		if (!isNew) {
			broker = BrokerLocalServiceUtil.fetchBroker(brokerId);

		} else {
			broker = BrokerLocalServiceUtil
					.createBroker(CounterLocalServiceUtil
							.increment(Broker.class.getName()));
			broker.setCreateDate(new Date());
		}

		if (isNew
				&& BrokerModelPermission.contains(
						themeDisplay.getPermissionChecker(),
						themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)
				|| !isNew
				&& BrokerPermission.contains(
						themeDisplay.getPermissionChecker(), broker,
						ActionKeys.UPDATE)) {

			String brokerCmd = ParamUtil.getString(request, "brokerCmd");
			if (brokerCmd.equalsIgnoreCase("update")) {
				try {

					String brokerName = ParamUtil.getString(request,
							"brokerName");
					String brokerProtocol = ParamUtil.getString(request,
							"brokerProtocol");
					String brokerHost = ParamUtil.getString(request,
							"brokerUrl");
					String brokerPort = ParamUtil.getString(request,
							"brokerPort");
					String brokerTypeStr = ParamUtil.getString(request,
							"brokerType");
					String brokerUsername = ParamUtil.getString(request,
							"brokerUsername");
					String brokerPassword = ParamUtil.getString(request,
							"brokerPassword");
					BrokerType brokerType = BrokerType.valueOf(brokerTypeStr);
					boolean startAtStartup = ParamUtil.getBoolean(request,
							"brokerStartAtStartup");
					boolean sslEnabled = ParamUtil.getBoolean(request,
							"sslEnabled");
					String description = ParamUtil.getString(request,
							"brokerDescription");
					String topicIndexes = ParamUtil.getString(request,
							"topicIndexes");
					String customPropsIndexes = ParamUtil.getString(request,
							"propsIndexes");
					int indexes[] = StringUtil.split(topicIndexes, 0);
					int indexesProps[] = StringUtil
							.split(customPropsIndexes, 0);
					StringBuilder topics = new StringBuilder();
					StringBuilder customProps = new StringBuilder();

					for (int i = 0; i < indexes.length; i++) {
						int index = indexes[i];
						String topicTmp = ParamUtil.getString(request, "topic"
								+ index);
						topics.append(topicTmp + ";");
					}

					for (int i = 0; i < indexesProps.length; i++) {
						int index = indexesProps[i];
						String param = ParamUtil.getString(request, "propName"
								+ index);
						String paramValue = ParamUtil.getString(request, "prop"
								+ index);
						customProps.append(param + "$" + paramValue + ";");
					}

					broker.setCompanyId(themeDisplay.getCompanyId());
					broker.setGroupId(themeDisplay.getCompanyGroupId());
					broker.setUserName(themeDisplay.getUser().getScreenName());
					broker.setUserId(themeDisplay.getUserId());
					broker.setModifiedDate(new Date());
					broker.setName(brokerName);
					broker.setProtocol(brokerProtocol);
					broker.setUrl(brokerHost);
					broker.setPort(brokerPort);
					broker.setType(brokerTypeStr);
					broker.setStartAtStartup(startAtStartup);
					broker.setSslEnabled(sslEnabled);
					broker.setDescription(description);
					broker.setTopics(topics.toString());
					broker.setConnectionUsername(brokerUsername);
					broker.setConnectionPassword(brokerPassword);
					broker.setCustomProps(customProps.toString());
					if (brokerType.equals(BrokerType.MQTT)) {
						String clientId = ParamUtil.getString(request,
								"MQTT-clientId");
						int qos = ParamUtil.getInteger(request, "MQTT-Qos");
						Boolean cleanSession = ParamUtil.getBoolean(request,
								"MQTT-cleanSession", false);
						broker.setMqttClientId(clientId);
						broker.setMqttQos(qos);
						broker.setMqttCleanSession(cleanSession);
					} else if (brokerType.equals(BrokerType.KAFKA)) {
						String zookeeperHost = ParamUtil.getString(request,
								"KAFKA-zookeeperHost");
						String kafkaGroupId = ParamUtil.getString(request,
								"KAFKA-groupId");
						int threadsPerTopic = ParamUtil.getInteger(request,
								"KAFKA-threadsPerTopic");
						broker.setKafkaGroupId(kafkaGroupId);
						broker.setKafkaZookeeperHost(zookeeperHost);
						broker.setKafkaThreadsPerTopic(threadsPerTopic);
					}

					File certificate = request.getFile("sslCertificate");
					if (sslEnabled) {
						String sslSecret = ParamUtil.getString(request,
								"sslSecret");
						broker.setSslSecret(sslSecret);
					}

					BrokerLocalServiceUtil.saveOrUpdateBroker(broker,
							themeDisplay.getLocale(), portletConfig);
					if (certificate != null) {
						Folder sslCerts = ResourceLocator.getInstance()
								.getOrCreateDocumentLibraryAttributesFolder(
										themeDisplay.getCompanyId(),
										themeDisplay.getCompanyGroupId(), 0,
										"SSL Certs", "SSL Certs");
						String fileUUid = ResourceLocator.getInstance()
								.addFileToDocumentLibrary(
										themeDisplay.getCompanyId(),
										themeDisplay.getCompanyGroupId(),
										themeDisplay.getUserId(), sslCerts,
										certificate,
										"Cert_" + broker.getBrokerId(),
										"application/pkcs8 ");
						broker.setSslCertificateUUid(fileUUid);
						BrokerLocalServiceUtil.saveOrUpdateBroker(broker,
								themeDisplay.getLocale(), portletConfig);
					}
				} catch (Exception e) {
					actionResponse.setRenderParameter("mvcPath",
							"/html/broker/edit.jsp");
					actionResponse.setRenderParameter("errorMessage",
							e.getMessage());
					actionRequest.setAttribute("broker", broker);
					SessionErrors.add(actionRequest,
							"it.acsoftware.brokerportlet.error");
				}
			} else if (brokerCmd.equalsIgnoreCase("resetSslCert")) {
				try {
					Folder sslCerts = ResourceLocator.getInstance()
							.getOrCreateDocumentLibraryAttributesFolder(
									themeDisplay.getCompanyId(),
									themeDisplay.getCompanyGroupId(), 0,
									"SSL Certs", "SSL Certs");
					FileEntry sslCert = DLAppLocalServiceUtil.getFileEntry(
							themeDisplay.getCompanyGroupId(),
							sslCerts.getFolderId(),
							"Cert_" + broker.getBrokerId());
					DLAppLocalServiceUtil.deleteFileEntry(sslCert
							.getFileEntryId());
				} catch (Exception e) {

					actionResponse.setRenderParameter("errorMessage",
							e.getMessage());
					actionRequest.setAttribute("broker", broker);
					SessionErrors
							.add(actionRequest,
									"it.acsoftware.brokerportlet.error",
									e.getMessage());
				}

				actionRequest.setAttribute("broker", broker);
				actionResponse.setRenderParameter("mvcPath",
						"/html/broker/edit.jsp");
			}
		} else {
			actionResponse.setRenderParameter("mvcPath",
					"/html/broker/edit.jsp");
			actionRequest.setAttribute("broker", broker);
			SessionErrors.add(actionRequest,
					"it.acsoftware.brokerportlet.permissionException");
		}
	}

	public void deleteBroker(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long brokerId = ParamUtil.getLong(actionRequest, "brokerId");
		BrokerLocalServiceUtil.deleteBroker(brokerId);
		List<BrokerMessageListener> messageListeners = BrokerMessageListenerLocalServiceUtil
				.findByBrokerId(brokerId);
		for (int i = 0; i < messageListeners.size(); i++) {
			BrokerMessageListenerLocalServiceUtil
					.deleteBrokerMessageListener(messageListeners.get(i));
		}
		BrokersManagerLocalServiceUtil.removeBrokerServiceDefinition(brokerId);
	}

	public void stopBrokerService(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long brokerId = ParamUtil.getLong(actionRequest, "brokerId");
		BrokersManagerLocalServiceUtil.stopServer(brokerId);
	}

	public void startBrokerService(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long brokerId = ParamUtil.getLong(actionRequest, "brokerId");
		BrokersManagerLocalServiceUtil.startServer(brokerId);
	}

	public void restartBrokerService(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long brokerId = ParamUtil.getLong(actionRequest, "brokerId");
		BrokersManagerLocalServiceUtil.restartServer(brokerId);
	}

}
