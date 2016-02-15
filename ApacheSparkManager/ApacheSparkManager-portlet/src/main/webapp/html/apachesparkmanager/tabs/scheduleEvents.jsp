<%@ include file="/html/apachesparkmanager/init.jsp"%>

<%
	long jobEventScheduleId = ParamUtil.getLong(request,"jobEventScheduleId", 0);
	Object jobEventScheduleAttribute = request.getAttribute("jobEventSchedule");
	JobEventSchedule jes = (jobEventScheduleId > 0) ? JobEventScheduleLocalServiceUtil.fetchJobEventSchedule(jobEventScheduleId): ((jobEventScheduleAttribute == null) ? JobEventScheduleLocalServiceUtil.createJobEventSchedule(0L): (JobEventSchedule) jobEventScheduleAttribute);
	String errorMessage = ParamUtil.getString(request,"errorMessage");	
	//viariables inherited from init.jsp	
	String jarsResponse = SparkRestClient.doSparkRequest(SparkRestClient.METHOD_GET,portletPreferences, "jars", null,null,null);
	SparkJobServerJars jars = SparkJobServerJars.getObject(jarsResponse);
	boolean error = jars.getJars().get("error") != null && jars.getJars().get("error").equalsIgnoreCase("true");
	HashMap<String,String> jarsHashMap = jars.getJars();
	List<String> jarsList = new ArrayList<String>();
	jarsList.addAll(jarsHashMap.keySet());
	String title = (jes.isNew())?LanguageUtil.get(pageContext,"it.acsoftware.apachesparkmanager.label.addEventSchedule"):jes.getEventName();
%>

<portlet:actionURL name="saveOrUpdateSchedule" var="saveOrUpdateScheduleURL" />
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/apachesparkmanager/view.jsp"/>
	<portlet:param name="currentTab" value="scheduleEvents"/>
</portlet:renderURL>
<liferay-ui:error key="it.acsoftware.apachesparkmanager.error" >
	<liferay-ui:message key="it.acsoftware.apachesparkmanager.error" arguments='<%=renderRequest.getParameter("errorMessage")%>' />
</liferay-ui:error>
<liferay-ui:error key="it.acsoftware.apachesparkmanager.permissionException" message="it.acsoftware.apachesparkmanager.permissionException"/>
<liferay-ui:header title="<%=title %>" backURL="<%=backURL.toString() %>"></liferay-ui:header>
<aui:form action="<%=saveOrUpdateScheduleURL.toString()%>"
	method="post">
	<aui:input name="jobEventScheduleId"
		value="<%=jes.getJobEventScheduleId()%>" type="hidden" inlineField="true"/>
	<aui:input name="eventName" value="<%=jes.getEventName()%>" required="true" label="it.acsoftware.apachesparkmanager.label.eventName" inlineField="true"/>
	<aui:select name="jarName" required="true" label="it.acsoftware.apachesparkmanager.label.jarName" inlineField="true">
		<%
			for (int i = 0; i < jarsList.size(); i++) {
				System.out.println(jarsList.get(i));
				boolean checked = jarsList.get(i).equalsIgnoreCase(jes.getJarName());
		%>
			<aui:option label="<%=jarsList.get(i)%>" value="<%=jarsList.get(i)%>" selected="<%=checked%>" />
		<%
			}
		%>
	</aui:select>
	<aui:input name="mainClass" value="<%=jes.getMainClass()%>" required="true" label="it.acsoftware.apachesparkmanager.label.mainClass" inlineField="true"/>
	<aui:input name="active" checked="<%=jes.getActive()!=null && jes.getActive() %>" type="checkbox" label="it.acsoftware.apachesparkmanager.label.active"/>
	<p><strong><%=LanguageUtil.get(pageContext,"it.acsoftware.apachesparkmanager.jobParametersInfo") %></strong></p>
	<br/>
	<div id="params" >
		<%
			String[] params = (Validator.isNotNull(jes.getParams()))?jes.getParams().split(";"):new String[]{"$"};
			StringBuilder paramIndexes = new StringBuilder();
			for(int i = 0; i < params.length;i++){
				String paramName = "";
				String paramType = "";
				String paramRequired = "false";
				String[] param = params[i].split("\\$");
				paramIndexes.append(i+",");
				if(param.length > 0)
					paramName = param[0];
				if(param.length > 1)
					paramType = param[1];
				if(param.length > 2)
					paramRequired = param[2];
				
		%>
				<div class=" lfr-form-row lfr-form-row-inline">
						<div class="row-fields">
							<aui:input fieldParam='<%="paramName" + i%>' id='<%="paramName" + i%>'
								name='<%="paramName" + i%>'
								label="it.acsoftware.apachesparkmanager.label.paramName"
								value="<%=paramName%>" inlineField="true" />
			
							<aui:input fieldParam='<%="paramType" + i%>' id='<%="paramType" + i%>'
								name='<%="paramType" + i%>'
								label="it.acsoftware.apachesparkmanager.label.paramType"
								value="<%=paramType%>" inlineField="true" />
							
							<aui:input fieldParam='<%="paramRequired" + i%>' id='<%="paramRequired" + i%>'
								name='<%="paramRequired" + i%>'
								label="it.acsoftware.apachesparkmanager.label.paramRequired"
								value="<%=Boolean.parseBoolean(paramRequired)%>" inlineField="true" type="checkbox"/>	
								
						</div>
				</div>
		<% } %>
		<aui:input name="paramsIndexes" value="<%=paramIndexes.toString()%>" type="hidden"/>
	</div>
	<aui:button type="submit" />
</aui:form>

<aui:script use="aui-base,aui-node,liferay-auto-fields">
	new Liferay.AutoFields({
		contentBox : '#params',
		fieldIndexes : '<portlet:namespace />paramsIndexes',
		namespace: '<portlet:namespace/>'
	}).render();
</aui:script>