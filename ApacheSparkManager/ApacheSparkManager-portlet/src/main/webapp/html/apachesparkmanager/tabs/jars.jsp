<%@ include file="/html/apachesparkmanager/init.jsp" %>
<%
	//viariables inherited from init.jsp	
	String jarsResponse = SparkRestClient.doSparkRequest(SparkRestClient.METHOD_GET,portletPreferences, "jars", null,null,null);
	SparkJobServerJars jars = SparkJobServerJars.getObject(jarsResponse);
	HashMap<String,String> jarsHashMap = jars.getJars();
	List<String> jarsList = new ArrayList<String>();
	jarsList.addAll(jarsHashMap.keySet());
	boolean error = jars.getJars().get("error") != null && jars.getJars().get("error").equalsIgnoreCase("true");
%>

<portlet:actionURL name="uploadJarJob" var="uploadJarJobURL" windowState="<%=WindowState.NORMAL.toString() %>"/>

<h2>Jars</h2>
	
	<c:choose>
		<c:when test="<%=!error %>">
			<div>
				<aui:form method="POST" name="uploadForm" action="<%=uploadJarJobURL.toString() %>" enctype="multipart/form-data">
					<aui:input name="appName" id="appName" label="it.acsoftware.apachesparkmanager.label.AppName" value="" inlineField="true" required="true" />
					<aui:input type="file" label="it.acsoftware.apachesparkmanager.label.file" name="file" inlineField="true" required="true" />
					<aui:button id="submitJarButton" type="button" value="Upload" onClick="submitUploadJarForm();"/>
				</aui:form>
			</div>
			<div style="clear:both"></div>
			<div>
				<liferay-ui:search-container  emptyResultsMessage="it.acsoftware.apachesparkmanager.label.noJarsFound" >
					<liferay-ui:search-container-results
						results="<%=jarsList%>"
						total="<%=jarsList.size()%>"/>
						
					<liferay-ui:search-container-row className="java.lang.String" modelVar="jar">
						<liferay-ui:search-container-column-text name="App Name">
							<%=jar %>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Upload Date">
							<%=jarsHashMap.get(jar) %>
						</liferay-ui:search-container-column-text>
						
					</liferay-ui:search-container-row>
				
					<liferay-ui:search-iterator paginate="false"/>
				
				</liferay-ui:search-container>
				
			</div>
		</c:when>
		<c:otherwise>
			Server unreachable,please check it!
		</c:otherwise>
	</c:choose>
