<%@include file="/html/sparkeventraiser/init.jsp"%>
<%
	List<JobEventSchedule> events = JobEventScheduleLocalServiceUtil
			.findByCompanyId(themeDisplay.getCompanyId());
%>

<portlet:actionURL var="raiseSparkEventURL" name="raiseSparkEvent"></portlet:actionURL>

<aui:form action="<%=raiseSparkEventURL.toString()%>" method="post">
	<aui:select name="eventName">
		<%
			for (int i = 0; i < events.size(); i++) {
						JobEventSchedule eventSchedule = events.get(i);
		%>
		<aui:option label="<%=eventSchedule.getEventName()%>"
			value="<%=eventSchedule.getEventName()%>" />
		<%
			}
		%>
	</aui:select>

	<div id="props-fields">

		
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields">
				<aui:input fieldParam="propName0" id="propName0"
					name="propName0"
					label="Name"
					value="" inlineField="true" />

				<aui:input fieldParam="prop0" id="prop0"
					name="prop0"
					label="Value"
					value="" inlineField="true" />
			</div>
		</div>
		
		<aui:input name="propsIndexes" type="hidden" value="0" />
	</div>
	<aui:button type="submit"></aui:button>
</aui:form>

<aui:script use="aui-base,aui-node,liferay-auto-fields">

	var autoFieldProps = new Liferay.AutoFields({
		contentBox : '#props-fields',
		fieldIndexes : '<portlet:namespace />propsIndexes',
		namespace: '<portlet:namespace/>'
	}).render();

</aui:script>