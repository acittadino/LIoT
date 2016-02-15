package it.acsoftware.brokerportlet.portlet;

import it.acsoftware.brokerportlet.broker.BrokerMessageListenerType;
import it.acsoftware.brokerportlet.model.Broker;
import it.acsoftware.brokerportlet.model.BrokerMessageListener;
import it.acsoftware.brokerportlet.permission.BrokerMessageListenerPermission;
import it.acsoftware.brokerportlet.permission.BrokerModelPermission;
import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;
import it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BrokerMessageListener
 */
public class BrokerMessageListenerPortlet extends MVCPortlet {
	private static Log logger = LogFactoryUtil
			.getLog(BrokerMessageListenerPortlet.class);

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String id = resourceRequest.getResourceID();
		if (id.equalsIgnoreCase("getBrokerTopics")) {
			JSONArray topics = JSONFactoryUtil.createJSONArray();
			long brokerId = ParamUtil.getLong(resourceRequest, "brokerId");
			long brokerMessageListenerId = ParamUtil.getLong(resourceRequest,
					"brokerMessageListenerId");
			try {
				Broker b = BrokerLocalServiceUtil.fetchBroker(brokerId);
				BrokerMessageListener bml = (brokerMessageListenerId > 0) ? BrokerMessageListenerLocalServiceUtil
						.fetchBrokerMessageListener(brokerMessageListenerId)
						: null;
				String[] topicsArr = b.getTopics().split(";");
				for (int i = 0; i < topicsArr.length; i++) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("topic", topicsArr[i]);
					boolean checked = false;
					if (bml != null) {
						String[] messageListenerTopcs = bml.getTopics().split(
								";");
						for (int j = 0; j < messageListenerTopcs.length
								&& !checked; j++) {
							if (messageListenerTopcs[j]
									.equalsIgnoreCase(topicsArr[i]))
								checked = true;
						}
					}
					obj.put("checked", checked);
					topics.put(obj);
				}
			} catch (Exception e) {
				logger.error(e);
			}
			resourceResponse.getWriter().println(topics.toString());
		}
	}

	public void saveOrUpdateBrokerMessageListener(ActionRequest request,
			ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		long brokerMessageListenerId = ParamUtil.getLong(request,
				"brokerMessageListenerId");
		boolean isNew = brokerMessageListenerId == 0;
		BrokerMessageListener bml = null;

		if (!isNew) {
			bml = BrokerMessageListenerLocalServiceUtil
					.fetchBrokerMessageListener(brokerMessageListenerId);

		} else {
			bml = BrokerMessageListenerLocalServiceUtil
					.createBrokerMessageListener(CounterLocalServiceUtil
							.increment(BrokerMessageListener.class.getName()));
			bml.setCreateDate(new Date());
		}

		if (isNew
				&& BrokerModelPermission.contains(
						themeDisplay.getPermissionChecker(),
						themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY)
				|| !isNew
				&& BrokerMessageListenerPermission.contains(
						themeDisplay.getPermissionChecker(), bml,
						ActionKeys.UPDATE)) {
			try {
				String brokerMessageListenerName = ParamUtil.getString(request,
						"name");
				String brokerMessageListenerDescription = ParamUtil.getString(
						request, "description");
				long brokerId = ParamUtil.getLong(request, "brokerId");
				String[] topicsArr = ParamUtil.getParameterValues(request,
						"topic");
				StringBuilder topics = new StringBuilder();
				for (int i = 0; i < topicsArr.length; i++) {
					topics.append(topicsArr[i] + ";");
				}
				String typeStr = ParamUtil.getString(request, "type");
				BrokerMessageListenerType type = BrokerMessageListenerType
						.valueOf(typeStr);

				bml.setCompanyId(themeDisplay.getCompanyId());
				bml.setGroupId(themeDisplay.getCompanyGroupId());
				bml.setUserName(themeDisplay.getUser().getScreenName());
				bml.setUserId(themeDisplay.getUserId());
				bml.setModifiedDate(new Date());
				bml.setName(brokerMessageListenerName);
				bml.setDescription(brokerMessageListenerDescription);
				bml.setBrokerId(brokerId);
				bml.setTopics(topics.toString());
				bml.setType(typeStr);
				if (type.equals(BrokerMessageListenerType.MESSAGE_BUS)) {
					String messageBusDestination = ParamUtil.getString(request,
							"messageBusDestination");
					bml.setMessageBusDestination(messageBusDestination);
				}

				BrokerMessageListenerLocalServiceUtil
						.saveOrUpdateBrokerMessageListener(bml,
								themeDisplay.getLocale(), portletConfig);
			} catch (Exception e) {
				response.setRenderParameter("mvcPath",
						"/html/brokermessagelistener/edit.jsp");
				response.setRenderParameter("errorMessage", e.getMessage());
				request.setAttribute("brokerMessageListener", bml);
				SessionErrors.add(request, "it.acsoftware.brokerportlet.error");
			}
		}
	}
	
	public void deleteMessageListener(ActionRequest request,ActionResponse response) throws Exception{
		long brokerMessageListenerId = ParamUtil.getLong(request, "brokerMessageListenerId");
		BrokerMessageListenerLocalServiceUtil.deleteBrokerMessageListener(brokerMessageListenerId);
	}

}
