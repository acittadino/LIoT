<%@ include file="/html/brokermessagelistener/init.jsp"%>
<%
	long brokerMessageListenerId = ParamUtil.getLong(request, "brokerMessageListenerId",0);
	Object brokerMessageListenerAttribute = request.getAttribute("brokerMessageListener");
	BrokerMessageListener bml = (brokerMessageListenerId > 0)?BrokerMessageListenerLocalServiceUtil.fetchBrokerMessageListener(brokerMessageListenerId):((brokerMessageListenerAttribute == null)?BrokerMessageListenerLocalServiceUtil.createBrokerMessageListener(0L):(BrokerMessageListener)brokerMessageListenerAttribute);
	List<Broker> brokerList = BrokerLocalServiceUtil.findByCompanyId(themeDisplay.getCompanyId());
%>

<portlet:actionURL name="saveOrUpdateBrokerMessageListener" var="saveOrUpdateBrokerMessageListenerURL"/>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/brokermessagelistener/view.jsp"/>
</portlet:renderURL>
<portlet:resourceURL var="getBrokerTopicsURL" id="getBrokerTopics"/>
<liferay-ui:error key="it.acsoftware.permissionException" message="it.acsoftware.brokerportlet.permissionException"/>
<liferay-ui:error key="it.acsoftware.brokerportlet.error" >
	<liferay-ui:message key="it.acsoftware.brokerportlet.error" arguments='<%=renderRequest.getParameter("errorMessage")%>' />
</liferay-ui:error>

<div id="title">
		<c:choose>
			<c:when test="<%=bml.isNew() %>">
				
				<liferay-ui:header title="it.acsoftware.brokerportlet.newBrokerMessageListenerConfiguration" backURL="<%=backURL.toString() %>"></liferay-ui:header>
			</c:when>
			<c:otherwise>
				<liferay-ui:header title="<%=bml.getName() %>" backURL="<%=backURL.toString() %>"></liferay-ui:header>
			</c:otherwise>
		</c:choose>	
</div>
<aui:form action="<%=saveOrUpdateBrokerMessageListenerURL.toString() %>" method="post">
	<aui:input name="brokerMessageListenerId" type="hidden" value="<%=bml.getBrokerMessageListenerId() %>"/>
	<div style="float:left;width:80%">
		<aui:input name="name" value="<%=bml.getName() %>" style="width:20%;" required="true"/>
		<aui:input name="description" value="<%=bml.getDescription() %>" type="textarea" style="width:20%;height:130px"/>
		<div style="margin-bottom:10px;padding-bottom:10px">
			<aui:select name="brokerId" showEmptyOption="true" label="Broker" required="true">
				<%for(int i = 0; i < brokerList.size();i++){
					Broker b = brokerList.get(i);
					boolean checked = bml.getBrokerId() > 0 && b.getBrokerId() == bml.getBrokerId();
				%>	
					<aui:option label='<%=b.getName()+ " ("+b.getType()+")" %>' value="<%=b.getBrokerId() %>" selected="<%=checked %>"/>
				<% } %>
			</aui:select>
			<div id="brokerTopics">
			<!-- Populated via Ajax -->
			</div>
		</div>
		<liferay-ui:panel-container>
			<liferay-ui:panel title="it.acsoftware.brokerportlet.label.brokerMessageListener.destination">
				<aui:input name='type' label='<%=LanguageUtil.get(pageContext,"it.acsoftware.brokerportlet.label.brokerMessageListener.type.messageBus") %>' value="<%=BrokerMessageListenerType.MESSAGE_BUS.toString() %>" type="radio" checked="true" />
				<aui:input name="messageBusDestination" label="it.acsoftware.brokerportlet.label.brokerMessageListener.type.messageBus.destination" value="<%=bml.getMessageBusDestination() %>" required="true"/>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</div>
	<div style="float:right">
		<aui:button type="submit"/>
	</div>
</aui:form>

<aui:script use="aui-base,aui-node,aui-io-request">
	var link = '<%=getBrokerTopicsURL.toString()%>';
	Liferay.provide(window,'clearTopicsDiv',function(){
		A.one('#brokerTopics').html('');
	})
	
	Liferay.provide(window,'getBrokerTopics',function(){
		var brokerId = A.one('#<portlet:namespace/>brokerId').val();
		var brokerMessageListenerId = A.one('#<portlet:namespace/>brokerMessageListenerId').val();
		
		if(brokerId != null && brokerId != '' && brokerId > 0){
			A.io.request(link,{
				dataType:'json',
				data:{
					<portlet:namespace/>brokerId:brokerId
				},
				on:{
					success:function(){
						var topics = this.get("responseData");
						var html = '<div><h4>Topics</h4>';
						clearTopicsDiv();
						for(var i = 0; i < topics.length;i++){
							var topic = topics[i].topic;
							var checked = topics[i].checked;
							if(!checked)
								html += '<div style="width:20%"><input type="checkbox" name="<portlet:namespace/>topic" value="'+topic+'" style="margin-right:5px"/>'+topic+'</div>';
							else
								html += '<div style="width:20%"><input type="checkbox" checked name="<portlet:namespace/>topic" value="'+topic+'" style="margin-right:5px"/>'+topic+'</div>';
						}
						html += '</div>'
						A.one('#brokerTopics').html(html);
					}
				}
			});
		}
	});
	
	A.one('#<portlet:namespace/>brokerId').on('change',function(){
		getBrokerTopics();
	});
	
	getBrokerTopics();
</aui:script>
