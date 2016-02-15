<%@ include file="/html/apachesparkmanager/init.jsp"%>
<%
	List<JobEventSchedule> jobEventsScheduled = JobEventScheduleLocalServiceUtil.findByCompanyId(themeDisplay.getCompanyId());
%>

<portlet:renderURL var="addJobEventScheduleURL">
	<portlet:param name="mvcPath" value="/html/apachesparkmanager/tabs/scheduleEvents.jsp"/>
</portlet:renderURL>

<div align="right">
	<aui:button cssClass="btn btn-primary" type="button" href="<%=addJobEventScheduleURL.toString() %>" value="it.acsoftware.apachesparkmanager.label.addEventSchedule"/>
</div>

<liferay-ui:search-container 
		emptyResultsMessage='<%="it.acsoftware.apachesparkmanager.label.emptyEvents"%>' deltaConfigurable="false" delta="20">
			<liferay-ui:search-container-results results="<%= jobEventsScheduled %>"/>
			<liferay-ui:search-container-row className="it.acsoftware.apachesparkmanager.model.JobEventSchedule" modelVar="jes" >
				<liferay-ui:search-container-column-text value="<%=jes.getEventName()%>" name="it.acsoftware.apachesparkmanager.label.eventName" />
				<liferay-ui:search-container-column-text value="<%=jes.getJarName()%>" name="it.acsoftware.apachesparkmanager.label.jarName" />
				<liferay-ui:search-container-column-text value="<%=jes.getMainClass()%>" name="it.acsoftware.apachesparkmanager.label.mainClass" />
				
				
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu >
						<c:if test="<%=JobEventSchedulePermission.contains(permissionChecker, jes, ActionKeys.UPDATE) %>">
							<portlet:renderURL var="editJobEventScheduleURL">
								<portlet:param name="mvcPath" value="/html/apachesparkmanager/tabs/scheduleEvents.jsp"/>
								<portlet:param name="jobEventScheduleId" value="<%=String.valueOf(jes.getJobEventScheduleId())%>"/>
							</portlet:renderURL>
							<liferay-ui:icon image="edit" message="it.acsoftware.apachesparkmanager.label.edit" url="<%=editJobEventScheduleURL.toString()%>"/>
						</c:if>
						<c:if test="<%=JobEventSchedulePermission.contains(permissionChecker, jes, ActionKeys.DELETE) %>">
							<portlet:actionURL var="deleteJobEventScheduleURL" name="deleteScheduledEvent">
								<portlet:param name="jobEventScheduleId" value="<%=String.valueOf(jes.getJobEventScheduleId())%>"/>
							</portlet:actionURL>
							<liferay-ui:icon-delete message="it.acsoftware.apachesparkmanager.label.delete" url="<%=deleteJobEventScheduleURL.toString()%>"/>
						</c:if>
						
						<c:if test="<%=JobEventSchedulePermission.contains(permissionChecker, jes, ActionKeys.PERMISSIONS) %>">
							<liferay-security:permissionsURL modelResource="<%=JobEventSchedule.class.getName()%>" modelResourceDescription='<%="JobEventSchedule Permission"%>'
											resourcePrimKey="<%=Long.toString(jes.getJobEventScheduleId())%>"
											windowState="<%=LiferayWindowState.POP_UP.toString() %>" var="permissionsEntryURL" />
							<liferay-ui:icon image="permissions" url="<%=permissionsEntryURL.toString()%>" useDialog="true" method="get"  />
						</c:if>
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" type="more" paginate="true"/>
	</liferay-ui:search-container>	