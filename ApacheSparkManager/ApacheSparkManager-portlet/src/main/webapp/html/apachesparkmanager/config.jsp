<%@ include file="/html/apachesparkmanager/init.jsp" %>

<%
String sparkServerProtocol = GetterUtil.getString(portletPreferences.getValue(ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL,  ApacheSparkManagerConstants.SPARK_JOB_SERVER_PROTOCOL_DEFAULT));	
String sparkServerHost = GetterUtil.getString(portletPreferences.getValue(ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST,  ApacheSparkManagerConstants.SPARK_JOB_SERVER_HOST_DEFAULT));
String sparkServerPort = GetterUtil.getString(portletPreferences.getValue(ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT,  ApacheSparkManagerConstants.SPARK_JOB_SERVER_PORT_DEFAULT));	
%>


<liferay-portlet:actionURL portletConfiguration="true" var="saveConfigParamsURL"/>

<aui:form action="<%=saveConfigParamsURL %>" method="post" >
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name='<%="preferences--"+ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL+"--" %>' value="<%=sparkServerProtocol %>" label="Spark Job Server Protocol" />
	<aui:input name='<%="preferences--"+ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST+"--" %>' value="<%=sparkServerHost %>" label="Spark Job Server Host" />
	<aui:input name='<%="preferences--"+ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT+"--" %>' value="<%=sparkServerPort %>" label="Spark Job Server Port" />
	<aui:button type="submit"/>
</aui:form>

