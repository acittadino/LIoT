<%@ include file="/html/brokermessagelistener/init.jsp"%>

<%
	List<BrokerMessageListener> brokersMessageListeners = BrokerMessageListenerLocalServiceUtil.findByCompany(themeDisplay.getCompanyId());
%>
<div>
	<aui:row cssClass="lfr-app-column-view">
		<aui:col cssClass="context-pane"  width="<%= 100 %>">
			<liferay-ui:app-view-toolbar includeDisplayStyle="<%= true %>" includeSelectAll="<%= false %>">
				<c:import url="/html/brokermessagelistener/toolbar.jsp" />
			</liferay-ui:app-view-toolbar>
		</aui:col>
	</aui:row>
</div>

<div>
	<liferay-ui:search-container 
		emptyResultsMessage='<%="it.acsoftware.brokerportlet.label.emptyBrokerMessageListener"%>' deltaConfigurable="false" delta="20">
			<liferay-ui:search-container-results results="<%= brokersMessageListeners %>"/>
			<liferay-ui:search-container-row className="it.acsoftware.brokerportlet.model.BrokerMessageListener" modelVar="bml" >
				<liferay-ui:search-container-column-text value="<%=bml.getName()%>" name="it.acsoftware.brokerportlet.label.brokerMessageListener.name" />
				<liferay-ui:search-container-column-text value="<%=bml.getType()%>" name="it.acsoftware.brokerportlet.label.brokerMessageListener.type" />
			
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu >
						<c:if test="<%=BrokerMessageListenerPermission.contains(permissionChecker, bml, ActionKeys.UPDATE) %>">
							<portlet:renderURL var="editBrokerURL">
								<portlet:param name="mvcPath" value="/html/brokermessagelistener/edit.jsp"/>
								<portlet:param name="brokerMessageListenerId" value="<%=String.valueOf(bml.getBrokerMessageListenerId())%>"/>
							</portlet:renderURL>
							<liferay-ui:icon image="edit" message="it.acsoftware.brokerportlet.label.edit" url="<%=editBrokerURL.toString()%>"/>
						</c:if>
						<c:if test="<%=BrokerMessageListenerPermission.contains(permissionChecker, bml, ActionKeys.DELETE) %>">
							<portlet:actionURL var="deleteBrokerURL" name="deleteMessageListener">
								<portlet:param name="brokerMessageListenerId" value="<%=String.valueOf(bml.getBrokerMessageListenerId())%>"/>
							</portlet:actionURL>
							<liferay-ui:icon-delete message="it.acsoftware.brokerportlet.label.delete" url="<%=deleteBrokerURL.toString()%>"/>
						</c:if>
						<c:if test="<%=BrokerMessageListenerPermission.contains(permissionChecker, bml, ActionKeys.PERMISSIONS) %>">
							<liferay-security:permissionsURL
											modelResource="<%=BrokerMessageListener.class.getName()%>"
											modelResourceDescription='<%="Broker Message Listener Permission"%>'
											resourcePrimKey="<%=Long.toString(bml.getBrokerMessageListenerId())%>"
											windowState="<%=LiferayWindowState.POP_UP.toString() %>"
											var="permissionsEntryURL" />
										<liferay-ui:icon image="permissions" url="<%=permissionsEntryURL%>" useDialog="true" method="get"  />
						</c:if>
						
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" type="more" paginate="true"/>
	</liferay-ui:search-container>	
</div>

