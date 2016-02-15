package it.acsoftware.apachesparkmanager.util;

import it.apachesparkjobserver.model.SparkJobContexts;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class SparkRestClient {
	public static final String METHOD_GET = "get";
	public static final String METHOD_POST = "post";
	public static final String METHOD_DELETE = "delete";

	public static boolean startAsynchJob(long companyId, String jarName,
			String mainClass, String inputString) {
		try {
			com.liferay.portal.model.PortletPreferences xmlPreferences = PortletPreferencesLocalServiceUtil
					.getPortletPreferences(companyId, 1, 0,
							"apachesparkmanager_WAR_ApacheSparkManagerportlet");
			javax.portlet.PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
					.fromDefaultXML(xmlPreferences.getPreferences());
			scheduleJob(jarName, inputString, mainClass, null, false,
					portletPreferences);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String startSynchJob(long companyId, String jarName,
			String mainClass, String inputString) {
		try {
			com.liferay.portal.model.PortletPreferences xmlPreferences = PortletPreferencesLocalServiceUtil
					.getPortletPreferences(companyId, 1, 0,
							"apachesparkmanager_WAR_ApacheSparkManagerportlet");
			javax.portlet.PortletPreferences portletPreferences = PortletPreferencesFactoryUtil
					.fromDefaultXML(xmlPreferences.getPreferences());
		
			String result = scheduleJob(jarName, inputString, mainClass,
					null, true, portletPreferences);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public static String createContext(String name, String params,
			PortletPreferences portletPreferences) {
		String sparkServerProtocol = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PROTOCOL_DEFAULT));
		String sparkServerHost = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_HOST_DEFAULT));
		String sparkServerPort = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PORT_DEFAULT));
		String service = Validator.isNull(params) ? "contexts/" + name
				: "contexts/" + name + "?" + params;
		String result = SparkRestClient.doSparkRequest(
				SparkRestClient.METHOD_POST, sparkServerHost,
				Integer.parseInt(sparkServerPort), sparkServerProtocol,
				service, null, null, null);
		return result;
	}

	public static String stopContext(String context,
			PortletPreferences portletPreferences) {
		String sparkServerProtocol = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PROTOCOL_DEFAULT));
		String sparkServerHost = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_HOST_DEFAULT));
		String sparkServerPort = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PORT_DEFAULT));
		String result = SparkRestClient.doSparkRequest(
				SparkRestClient.METHOD_DELETE, sparkServerHost,
				Integer.parseInt(sparkServerPort), sparkServerProtocol,
				"contexts/" + context, null, null, null);
		return result;
	}

	public static String uploadJar(String appName, File f,
			PortletPreferences portletPreferences) {
		String sparkServerProtocol = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PROTOCOL_DEFAULT));
		String sparkServerHost = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_HOST_DEFAULT));
		String sparkServerPort = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PORT_DEFAULT));
		String result = SparkRestClient.doSparkRequest(
				SparkRestClient.METHOD_POST, sparkServerHost,
				Integer.parseInt(sparkServerPort), sparkServerProtocol, "jars/"
						+ appName, null, f, null);
		return result;
	}

	public static String scheduleJob(String name, String inputParams,
			String contextPath, String params, boolean synch,
			PortletPreferences portletPreferences) {
		if (Validator.isNull(params))
			params = "appName=" + name + "&classPath=" + contextPath
					+ "&synch=" + String.valueOf(synch) + "&context="
					+ ApacheSparkManagerConstants.JOB_CONTEXT_DEFAULT_NAME;
		else
			params += "&appName=" + name + "&classPath=" + contextPath
					+ "&synch=" + String.valueOf(synch) + "&context="
					+ ApacheSparkManagerConstants.JOB_CONTEXT_DEFAULT_NAME;

		String sparkServerProtocol = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PROTOCOL_DEFAULT));
		String sparkServerHost = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_HOST_DEFAULT));
		String sparkServerPort = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PORT_DEFAULT));
		String service = "jobs?" + params;
		
		// job must run inside one context per JVM
		checkOrCreateDefaultContext(portletPreferences);

		String result = SparkRestClient.doSparkRequest(
				SparkRestClient.METHOD_POST, sparkServerHost,
				Integer.parseInt(sparkServerPort), sparkServerProtocol,
				service, null, null, inputParams);
		return result;
	}

	private static void checkOrCreateDefaultContext(
			javax.portlet.PortletPreferences portletPreferences) {
		String contextsResponse = SparkRestClient.doSparkRequest(
				SparkRestClient.METHOD_GET, portletPreferences, "contexts",
				null, null, null);
		SparkJobContexts contexts = SparkJobContexts
				.getObject(contextsResponse);
		boolean found = false;
		if (contexts != null) {
			List<String> contextsList = contexts.getContexts();
			for (int i = 0; !found && i < contextsList.size(); i++) {
				if (contextsList.get(i).equalsIgnoreCase(
						ApacheSparkManagerConstants.JOB_CONTEXT_DEFAULT_NAME))
					found = true;
			}
		}

		
		if (!found ) {
			SparkRestClient.createContext(
					ApacheSparkManagerConstants.JOB_CONTEXT_DEFAULT_NAME, "",
					portletPreferences);
		}
		
	}

	public static String createInputSting(List<String> params) {
		String inputString = "input.string=";
		for (int i = 0; i < params.size(); i++) {
			inputString += params.get(i) + " ";
		}
		return inputString;
	}

	public static String doSparkRequest(String method,
			javax.portlet.PortletPreferences portletPreferences,
			String service, Map<String, String> params, File toSend,
			String inputString) {
		String sparkServerProtocol = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PROTOCOL_DEFAULT));
		String sparkServerHost = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_HOST_DEFAULT));
		String sparkServerPort = GetterUtil
				.getString(portletPreferences
						.getValue(
								ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT,
								ApacheSparkManagerConstants.SPARK_JOB_SERVER_PORT_DEFAULT));
		return doSparkRequest(method, sparkServerHost,
				Integer.parseInt(sparkServerPort), sparkServerProtocol,
				service, params, toSend, inputString);
	}

	public static String doSparkRequest(String method, String host, int port,
			String protocol, String service, Map<String, String> params,
			File toSend, String inputString) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		try {
			HttpHost target = new HttpHost(host, port, protocol);
			StringBuilder request = new StringBuilder();
			request.append("/" + service);
			if (params != null) {
				Iterator<String> it = params.keySet().iterator();
				for (int i = 0; i < params.size(); i++) {
					String name = it.next();
					String val = params.get(name);
					if (i == 0) {
						request.append("?");
					} else {
						request.append("&");
					}

					request.append(name + "=" + val);
				}
			}

			if (method.equalsIgnoreCase(METHOD_GET))
				return doGet(request.toString(), httpclient, target);
			else if (method.equalsIgnoreCase(METHOD_POST))
				return doPost(request.toString(), httpclient, target, toSend,
						inputString);
			else if (method.equalsIgnoreCase(METHOD_DELETE))
				return doDelete(request.toString(), httpclient, target);
			else
				throw new UnsupportedOperationException(
						"Not supported method: " + method);

		} catch (Exception e) {
			e.printStackTrace();
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("error", "true");
			obj.put("errMessage", e.getMessage());
			return obj.toString();
		} finally {
			try {
				httpclient.close();
			} catch (Exception e) {
			}
		}
	}

	private static String doGet(String request, CloseableHttpClient httpClient,
			HttpHost target) throws ParseException, IOException {
		HttpGet getRequest = new HttpGet(request.toString());
		HttpResponse httpResponse = httpClient.execute(target, getRequest);
		HttpEntity entity = httpResponse.getEntity();
		return EntityUtils.toString(entity);
	}

	private static String doPost(String request,
			CloseableHttpClient httpClient, HttpHost target, File toSend,
			String inputString) throws ParseException, IOException {
		HttpPost postRequest = new HttpPost(request.toString());
		if (toSend != null) {
			FileEntity fileEntity = new FileEntity(toSend);
			postRequest.setEntity(fileEntity);
		} else if (Validator.isNotNull(inputString)) {
			StringEntity stringEntity = new StringEntity(inputString);
			postRequest.setEntity(stringEntity);
		}
		HttpResponse httpResponse = httpClient.execute(target, postRequest);
		HttpEntity entity = httpResponse.getEntity();
		return EntityUtils.toString(entity);
	}

	private static String doDelete(String request,
			CloseableHttpClient httpClient, HttpHost target)
			throws ParseException, IOException {
		HttpDelete deleteRequest = new HttpDelete(request.toString());
		HttpResponse httpResponse = httpClient.execute(target, deleteRequest);
		HttpEntity entity = httpResponse.getEntity();
		return EntityUtils.toString(entity);
	}
}
