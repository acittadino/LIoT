<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/broker/init.jsp"%>
<%
	long brokerId = ParamUtil.getLong(request, "brokerId");
	String portalBaseUrl = PortalUtil.getPortalURL(request).replace("http://", "");
%>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/broker/view.jsp"/>
</portlet:renderURL>

<liferay-ui:header title="it.acsoftware.brokerportlet.label.brokerService.listen" backURL="<%=backURL.toString() %>"></liferay-ui:header>

<div id="content">
	<p>Realtime broker log...</p>
	<div id="realtimeLog"></div>
</div>

<aui:script use="aui-base,aui-node">

var loggedUser = themeDisplay.isSignedIn();

if (!("WebSocket" in window)) {
	console.log("Web Socket Not Supported!");
} else if (loggedUser) {
	console.log('init web socket...');
	
	try {
		var webSocketUrl = 'ws://<%=portalBaseUrl%>/LIoT-Broker-portlet/websocketBrokerPortlet/<%=brokerId%>';
		console.log('opening web socket at: '+ webSocketUrl);
		server = new WebSocket(webSocketUrl);
	} catch (error) {
		console.log(error.message);
	}
	
	server.onopen = function(event) {
		console.log('waiting for device data...');
	};

	window.onbeforeunload = function() {
		server.close();
	};
	
	server.onclose = function(event) {
		console.log('Closing connection ... ');
	};

	server.onerror = function(event) {
		console.log('<p>' + event.data + '</p>');
	};

	server.onmessage = function(event) {
		var message = event.data;
		var dataJson = JSON.parse(message);
		A.one('#realtimeLog').append('<p>----------------------------<br/><strong>topic:</strong>'+dataJson.topic+"<br/> <strong>payload:</strong> "+dataJson.payload);
	};
	
} else {
	console.log('please login first');
}


</aui:script>