package it.acsoftware.liotexamples.portlet;

import it.acsoftware.liotexamples.simulators.AbstractSensorSimulator;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SensorSimulatorPortlet
 */
public class SensorSimulatorPortlet extends MVCPortlet {
	private static Log logger = LogFactoryUtil.getLog(SensorSimulatorPortlet.class);

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		String actionId = request.getResourceID();
		long brokerId = ParamUtil.getLong(request, "brokerId");
		Boolean ssl = ParamUtil.getBoolean(request, "ssl", false);
		String topic = ParamUtil.getString(request, "topic");
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		response.setContentType("application/json");
		try {
			AbstractSensorSimulator simulator = AbstractSensorSimulator
					.getInstance(brokerId, ssl, topic);
			if (actionId.equalsIgnoreCase("startStopDetection")) {

				String cmd = ParamUtil.getString(request, "cmd");
				if (cmd.equalsIgnoreCase("start")) {
					simulator.startSimulator();
					obj.put("running", true);
					obj.put("error", false);
					obj.put("errorMsg", "");
				} else {
					simulator.stopSimulator();
					obj.put("running", false);
					obj.put("error", false);
					obj.put("errorMsg", "");
				}
			}
		} catch (Exception e) {
			logger.error(e);
			obj.put("running", false);
			obj.put("error", true);
			obj.put("errorMsg", e.getMessage());
		}
		response.getWriter().println(obj.toString());
	}
}
