<%@ include file="/html/apachesparkmanager/init.jsp"%>

<%
	//viariables inherited from init.jsp	
	String jobsResponse = SparkRestClient.doSparkRequest(
			SparkRestClient.METHOD_GET, portletPreferences,
			"jobs", null,null,null);
	List<SparkJobServerJobStatus> statuses = SparkJobServerJobStatus
			.getObject(jobsResponse);
	if(statuses != null)
		Collections.sort(statuses);
%>

	<h2>Jobs List</h2>
	
	<div style="padding-bottom:10px;margin-bottom:10px">
		
		<aui:button type="button" value="Refresh" onClick="reloadJobs()" cssClass="btn btn-primary"/>
	</div>
	
	<liferay-ui:search-container  emptyResultsMessage="it.acsoftware.apachesparkmanager.label.noJobsFound" >
		<liferay-ui:search-container-results
			results="<%=(statuses != null)?statuses:new ArrayList<SparkJobServerJobStatus>()%>"
			total="<%= (statuses != null)?statuses.size():0%>"
		/>
		<liferay-ui:search-container-row className="it.apachesparkjobserver.model.SparkJobServerJobStatus" modelVar="jobStatus">
			<liferay-ui:search-container-column-text name="JobId">
				<portlet:renderURL var="detailURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
					<portlet:param name="mvcPath" value="/html/apachesparkmanager/tabs/jobDetails.jsp"/>
					<portlet:param name="jobId" value="<%=jobStatus.getJobId() %>"/>
				</portlet:renderURL>
				<a href="<%=detailURL.toString()%>" target="_blank"><%=jobStatus.getJobId() %></a>
			</liferay-ui:search-container-column-text>
			<%
				String status = jobStatus.getStatus();
			%>
			<liferay-ui:search-container-column-text name="Status" value="<%=status%>" />
			<liferay-ui:search-container-column-text name="StartTime" value="<%=jobStatus.getStartTime()%>" />
			<liferay-ui:search-container-column-text name="ClassPath" value="<%=jobStatus.getClassPath()%>" />
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator paginate="false"/>
	
	</liferay-ui:search-container>
