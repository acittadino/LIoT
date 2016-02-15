<%@ include file="/html/apachesparkmanager/init.jsp"%>
<%

	String jobId = ParamUtil.getString(request, "jobId");
	//must retrieve variables,ajax call
	String sparkServerProtocol = GetterUtil.getString(portletPreferences.getValue(ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PROTOCOL,  ApacheSparkManagerConstants.SPARK_JOB_SERVER_PROTOCOL_DEFAULT));	
	String sparkServerHost = GetterUtil.getString(portletPreferences.getValue(ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_HOST,  ApacheSparkManagerConstants.SPARK_JOB_SERVER_HOST_DEFAULT));
	String sparkServerPort = GetterUtil.getString(portletPreferences.getValue(ApacheSparkManagerConstants.INIT_PARAM_NAME_SPARK_JOB_SERVER_PORT,  ApacheSparkManagerConstants.SPARK_JOB_SERVER_PORT_DEFAULT));
	String jsonResponse = SparkRestClient.doSparkRequest(SparkRestClient.METHOD_GET, sparkServerHost, Integer.parseInt(sparkServerPort), sparkServerProtocol, "jobs/"+jobId, null,null,null);
	SparkJobServerJobDetails sparkJobServerStatusDetails = SparkJobServerJobDetails.getObject(jsonResponse);
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/apachesparkmanager/view.jsp"/>
	<portlet:param name="currentTab" value="jobs"/>
</portlet:renderURL>

<liferay-ui:header title='<%="Job ID:"+jobId %>' backURL="<%=backURL.toString() %>"></liferay-ui:header>

<div>
	<c:choose>
	<c:when test="<%=sparkJobServerStatusDetails != null %>">
		<p>Status: <%=sparkJobServerStatusDetails.getStatus()%></p>
		<c:if test="<%=sparkJobServerStatusDetails.getResult() != null %>">
			<p>Result:</p>
			<ul>
				<% Iterator<String> it = sparkJobServerStatusDetails.getResult().keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
				%>
					
					<li><%=key+":"+sparkJobServerStatusDetails.getResult().get(key) %></li>
				
				<% } %>
			</ul>
		</c:if>
		
		<c:if test="<%=sparkJobServerStatusDetails.getError() != null %>">
			<%SparkJobServerJobStatusResult res = sparkJobServerStatusDetails.getError(); %>
			<p>Error Message: <%=res.getMessage() %></p>
			<p>Error Class: <%=res.getErrorClass() %></p>
			STACK TRACE:
			<ul>
			<%for(int i = 0; i < res.getStack().size();i++){ %>
				<li><%=res.getStack().get(i) %></li>
			<% } %>	
			</ul>
		</c:if>
	</c:when>
	<c:otherwise>
		<p>Details not available</p>
	</c:otherwise>
	</c:choose>
</div>


