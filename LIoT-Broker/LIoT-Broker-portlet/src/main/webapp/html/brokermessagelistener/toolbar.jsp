
<%@ include file="/html/broker/init.jsp"%>

<%
	String keywords = ParamUtil.getString(request, "keywords","");
	boolean canAddNew = BrokerModelPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY);
%>

<portlet:renderURL var="addBrokerMessageListenerURL">
	<portlet:param name="mvcPath" value="/html/brokermessagelistener/edit.jsp"/>
</portlet:renderURL>

<aui:nav-bar>
		<c:if test="<%=canAddNew%>">
			<aui:nav id="toolbarContainer" cssClass="nav">
				<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add" iconCssClass="icon-plus">
					<aui:nav-item href="<%=addBrokerMessageListenerURL.toString() %>" iconCssClass="icon-plus" label='it.acsoftware.brokerportlet.label.addBrokerMessageListener' />
				</aui:nav-item>
			</aui:nav>
		</c:if>
</aui:nav-bar>


