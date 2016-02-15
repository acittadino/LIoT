<%@ include file="/html/apachesparkmanager/init.jsp" %>
<%
	//viariables inherited from init.jsp	
	String contextsResponse = SparkRestClient.doSparkRequest(SparkRestClient.METHOD_GET,portletPreferences, "contexts", null,null,null);
	SparkJobContexts contexts = SparkJobContexts.getObject(contextsResponse);
%>

<portlet:actionURL name="createContext" var="createContextURL" windowState="<%=WindowState.NORMAL.toString() %>"/>
<h2>Contexts</h2>
<c:choose>
<c:when test="<%=contexts != null %>">
	<aui:form method="post" action="<%=createContextURL %>">
		<aui:input name="name" inlineField="true"/>
		<aui:input name="params" inlineField="true"/>
		<aui:button value="it.acsoftware.apachesparkmanager.label.createContext" type="submit"/>
	</aui:form>
	
	<%
		List<String> contextsList = contexts.getContexts();
	%>
	<liferay-ui:search-container  emptyResultsMessage="it.acsoftware.apachesparkmanager.label.noContextsFound" >
				<liferay-ui:search-container-results 
					results="<%=contextsList%>"
					total="<%=contextsList.size()%>"/>
					
				<liferay-ui:search-container-row className="java.lang.String" modelVar="context" >
					<portlet:actionURL name="stopContext" var="stopContextURL" windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="context" value="<%=context %>"/>
					</portlet:actionURL>
					<liferay-ui:search-container-column-text name="Context">
						<%=context %>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="" >
						<liferay-ui:icon-delete url="<%=stopContextURL.toString()%>"/>
					</liferay-ui:search-container-column-text>
					
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator paginate="false"/>
			
	</liferay-ui:search-container>
</c:when>
<c:otherwise>
	Server unreachable,please check it!
</c:otherwise>
</c:choose>