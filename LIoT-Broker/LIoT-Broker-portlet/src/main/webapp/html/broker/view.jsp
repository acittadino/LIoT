<%@ include file="/html/broker/init.jsp"%>
<%
	List<Broker> brokers = BrokerLocalServiceUtil.findByCompanyId(themeDisplay.getCompanyId());
%>
<div>
	<aui:row cssClass="lfr-app-column-view">
		<aui:col cssClass="context-pane"  width="<%= 100 %>">
			<liferay-ui:app-view-toolbar includeDisplayStyle="<%= true %>" includeSelectAll="<%= false %>">
				<c:import url="/html/broker/toolbar.jsp" />
			</liferay-ui:app-view-toolbar>
		</aui:col>
	</aui:row>
</div>

<div>
	<liferay-ui:search-container 
		emptyResultsMessage='<%="it.acsoftware.brokerportlet.label.emptyBroker"%>' deltaConfigurable="false" delta="20">
			<liferay-ui:search-container-results results="<%= brokers %>"/>
			<liferay-ui:search-container-row className="it.acsoftware.brokerportlet.model.Broker" modelVar="broker" >
				<liferay-ui:search-container-column-text value="<%=broker.getName()%>" name="it.acsoftware.brokerportlet.label.broker.name" />
				<liferay-ui:search-container-column-text value="<%=broker.getUrl()%>" name="it.acsoftware.brokerportlet.label.broker.host" />
				<liferay-ui:search-container-column-text value="<%=broker.getPort()%>" name="it.acsoftware.brokerportlet.label.broker.port" />
				<liferay-ui:search-container-column-text value="<%=String.valueOf(broker.getSslEnabled())%>" name="it.acsoftware.brokerportlet.label.broker.sslEnabled" />
				<liferay-ui:search-container-column-text  name="" >
					<div align="center">
						<c:choose>
							<c:when test="<%=BrokersManagerLocalServiceUtil.isRunning(broker.getBrokerId())%>">
								<liferay-ui:icon image="maximize"  url="" message='<%=LanguageUtil.get(pageContext,"it.acsoftware.brokerportlet.label.broker.running") %>' />
							</c:when>
							<c:otherwise>
								<liferay-ui:icon image="minimize" url="" message='<%=LanguageUtil.get(pageContext,"it.acsoftware.brokerportlet.label.broker.stopped") %>'/>
							</c:otherwise>
						</c:choose>
					</div>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text  name="" >
					<% String brokerServiceStatus = BrokersManagerLocalServiceUtil.getBrokerServiceLastStatus(broker.getBrokerId()); %>
					<c:choose>
						<c:when test="<%=Validator.isNotNull(brokerServiceStatus) %>">
							<p><%=brokerServiceStatus %></p>
						</c:when>
						<c:otherwise>
							<div align="center">
								<p>-</p>
							</div>
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu >
						<c:if test="<%=BrokerPermission.contains(permissionChecker, broker, ActionKeys.UPDATE) %>">
							<portlet:renderURL var="editBrokerURL">
								<portlet:param name="mvcPath" value="/html/broker/edit.jsp"/>
								<portlet:param name="brokerId" value="<%=String.valueOf(broker.getBrokerId())%>"/>
							</portlet:renderURL>
							<liferay-ui:icon image="edit" message="it.acsoftware.brokerportlet.label.edit" url="<%=editBrokerURL.toString()%>"/>
						</c:if>
						<c:if test="<%=BrokerPermission.contains(permissionChecker, broker, ActionKeys.DELETE) %>">
							<portlet:actionURL var="deleteBrokerURL" name="deleteBroker">
								<portlet:param name="brokerId" value="<%=String.valueOf(broker.getBrokerId())%>"/>
							</portlet:actionURL>
							<liferay-ui:icon-delete message="it.acsoftware.brokerportlet.label.delete" url="<%=deleteBrokerURL.toString()%>"/>
						</c:if>
						<c:if test="<%=BrokerPermission.contains(permissionChecker, broker, ActionKeys.PERMISSIONS) %>">
							<liferay-security:permissionsURL
											modelResource="<%=Broker.class.getName()%>"
											modelResourceDescription='<%="Broker Permission"%>'
											resourcePrimKey="<%=Long.toString(broker.getBrokerId())%>"
											windowState="<%=LiferayWindowState.POP_UP.toString() %>"
											var="permissionsEntryURL" />
										<liferay-ui:icon image="permissions" url="<%=permissionsEntryURL%>" useDialog="true" method="get"  />
						</c:if>
						
						<c:choose>
							<c:when test="<%=BrokersManagerLocalServiceUtil.isRunning(broker.getBrokerId())%>">
								<portlet:actionURL var="stopBrokerServiceURL" name="stopBrokerService">
									<portlet:param name="brokerId" value="<%=String.valueOf(broker.getBrokerId())%>"/>
								</portlet:actionURL>
								<portlet:actionURL var="restartBrokerServiceURL" name="restartBrokerService">
									<portlet:param name="brokerId" value="<%=String.valueOf(broker.getBrokerId())%>"/>
								</portlet:actionURL>
								<portlet:renderURL var="listenBrokerServiceURL" >
									<portlet:param name="brokerId" value="<%=String.valueOf(broker.getBrokerId())%>"/>
									<portlet:param name="mvcPath" value="/html/broker/webSocketLog.jsp"/>
								</portlet:renderURL>
								
								<liferay-ui:icon image="minimize"  message="it.acsoftware.brokerportlet.label.brokerService.stop" url="<%=stopBrokerServiceURL.toString() %>"/>
								<liferay-ui:icon image="undo" message="it.acsoftware.brokerportlet.label.brokerService.restart" url="<%=restartBrokerServiceURL.toString() %>"/>
								<liferay-ui:icon image="feed" message="it.acsoftware.brokerportlet.label.brokerService.listen" url="<%=listenBrokerServiceURL.toString() %>"/>
							</c:when>
							<c:otherwise>
								<portlet:actionURL var="startBrokerServiceURL" name="startBrokerService">
									<portlet:param name="brokerId" value="<%=String.valueOf(broker.getBrokerId())%>"/>
								</portlet:actionURL>
								
								<liferay-ui:icon image="maximize" message="it.acsoftware.brokerportlet.label.brokerService.start" url="<%=startBrokerServiceURL.toString() %>"/>
							</c:otherwise>
						</c:choose>
						
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" type="more" paginate="true"/>
	</liferay-ui:search-container>	
	
</div>