<%@include file="/html/sensorsimulator/init.jsp"%>
<%
	AbstractSensorSimulator simulator = AbstractSensorSimulator.getRunningSimulator();
	boolean running = (simulator != null);
	String buttonLabel = (running)?"Stop":"Start";
	List<Broker> brokerList = BrokerLocalServiceUtil.findByCompanyId(themeDisplay.getCompanyId());
%>

<portlet:resourceURL id="startStopDetection" var="startSimulatorURL">
	<portlet:param name="cmd" value="start" />
</portlet:resourceURL>

<portlet:resourceURL id="startStopDetection" var="stopSimulatorURL">
	<portlet:param name="cmd" value="stop" />
</portlet:resourceURL>

<h3>Simulator</h3>

<aui:form name="sensorSimulatorForm">
	<aui:select name="brokerId" inlineField="true">
		<% for(int i = 0; i < brokerList.size();i++){ 
				boolean selected = (running && simulator.getBrokerId() == brokerList.get(i).getBrokerId());
		%>
				<aui:option label="<%=brokerList.get(i).getName() %>" value="<%=brokerList.get(i).getBrokerId() %>" selected="<%=selected %>"/>
		<% } %>
	</aui:select>
	<aui:input type="text" name="topic" value="" inlineField="true"/>
	<aui:button name="startStopButton" value="it.acsoftware.button.label.startSimulator"
		onClick="startStopSimulator()" style="margin-top:-7px;"/>
</aui:form>

<h3>Status</h3>
<p id="status">
	<%=(running)?"Running...":"Not Running..."%>
</p>

<aui:script use="aui-base,aui-node,aui-io-request">
	var running = <%=running%>;
	Liferay.provide(window, 'startStopSimulator', function() {
		var url = (running) ? '<%=stopSimulatorURL.toString()%>': '<%=startSimulatorURL.toString()%>';
		var brokerId = A.one('#<portlet:namespace/>brokerId').val();
		var topic = A.one('#<portlet:namespace/>topic').val();
		A.io.request(url, {
			dataType : 'json',
			data:{
				<portlet:namespace/>topic:topic,
				<portlet:namespace/>brokerId:brokerId,
				<portlet:namespace/>ssl:false
			},
			on : {
				success : function() {
					var result = this.get('responseData');
					console.log(result);
					running = result.running;
					if(result.error){
						A.one('#status').html('Error:'+result.errorMsg);
					}else{
						if(running){
							A.one('#<portlet:namespace/>startStopButton').html('Stop');
							A.one('#status').html('Running...');
						}else{
							A.one('#<portlet:namespace/>startStopButton').html('Start');
							A.one('#status').html('Not running...');
						}
					}
				}
			}
		});
	});
</aui:script>
	

