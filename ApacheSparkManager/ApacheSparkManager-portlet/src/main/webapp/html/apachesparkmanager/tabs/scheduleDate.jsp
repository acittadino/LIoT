<%@ include file="/html/apachesparkmanager/init.jsp"%>

<%
	long jobDateScheduleId = ParamUtil.getLong(request,"jobDateScheduleId", 0);
	Object jobDateScheduleAttribute = request.getAttribute("jobDateSchedule");
	JobDateSchedule jds = (jobDateScheduleId > 0) ? JobDateScheduleLocalServiceUtil.fetchJobDateSchedule(jobDateScheduleId): ((jobDateScheduleAttribute == null) ? JobDateScheduleLocalServiceUtil.createJobDateSchedule(0L): (JobDateSchedule) jobDateScheduleAttribute);
	String errorMessage = ParamUtil.getString(request,"errorMessage");	
	//viariables inherited from init.jsp	
	String jarsResponse = SparkRestClient.doSparkRequest(SparkRestClient.METHOD_GET,portletPreferences, "jars", null,null,null);
	SparkJobServerJars jars = SparkJobServerJars.getObject(jarsResponse);
	boolean error = jars.getJars().get("error") != null && jars.getJars().get("error").equalsIgnoreCase("true");
	HashMap<String,String> jarsHashMap = jars.getJars();
	List<String> jarsList = new ArrayList<String>();
	jarsList.addAll(jarsHashMap.keySet());
	String title = (jds.isNew())?LanguageUtil.get(pageContext,"it.acsoftware.apachesparkmanager.label.addEventSchedule"):jds.getScheduleName();
%>

<portlet:actionURL name="saveOrUpdateDateSchedule" var="saveOrUpdateDateScheduleURL" />
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/apachesparkmanager/view.jsp"/>
	<portlet:param name="currentTab" value="scheduleDate"/>
</portlet:renderURL>
<liferay-ui:error key="it.acsoftware.apachesparkmanager.error" >
	<liferay-ui:message key="it.acsoftware.apachesparkmanager.error" arguments='<%=renderRequest.getParameter("errorMessage")%>' />
</liferay-ui:error>
<liferay-ui:error key="it.acsoftware.apachesparkmanager.permissionException" message="it.acsoftware.apachesparkmanager.permissionException"/>
<liferay-ui:header title="<%=title %>" backURL="<%=backURL.toString() %>"></liferay-ui:header>
<aui:form action="<%=saveOrUpdateDateScheduleURL.toString()%>"
	method="post">
	<aui:input name="isNew" value="<%=jds.isNew() %>" type="hidden"/>
	<aui:input name="jobDateScheduleId"
		value="<%=jds.getJobDateScheduleId()%>" type="hidden" inlineField="true"/>
	<aui:input name="scheduleName" value="<%=jds.getScheduleName()%>" required="true" label="it.acsoftware.apachesparkmanager.label.scheduleName" inlineField="true"/>
	<aui:input name="chronExpression" value="<%=jds.getChronExpression()%>" required="true" label="it.acsoftware.apachesparkmanager.label.cronExpression" inlineField="true"/>
	<aui:select name="jarName" required="true" label="it.acsoftware.apachesparkmanager.label.jarName" inlineField="true">
		<%
			for (int i = 0; i < jarsList.size(); i++) {
				System.out.println(jarsList.get(i));
				boolean checked = jarsList.get(i).equalsIgnoreCase(jds.getJarName());
		%>
			<aui:option label="<%=jarsList.get(i)%>" value="<%=jarsList.get(i)%>" selected="<%=checked%>" />
		<%
			}
		%>
	</aui:select>
	<aui:input name="mainClass" value="<%=jds.getMainClass()%>" required="true" label="it.acsoftware.apachesparkmanager.label.mainClass" inlineField="true"/>
	<aui:input name="active" checked="<%=(jds.getActive() != null && jds.getActive()) %>" type="checkbox" label="it.acsoftware.apachesparkmanager.label.active" value="<%=jds.getActive() %>"/>
	<p><strong><%=LanguageUtil.get(pageContext,"it.acsoftware.apachesparkmanager.jobParametersInfo") %></strong></p>
	<br/>
	<div id="params" >
		<%
			String[] params = (Validator.isNotNull(jds.getParams()))?jds.getParams().split(";"):new String[]{"$"};
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