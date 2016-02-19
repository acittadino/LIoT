<%@ include file="/html/broker/init.jsp"%>
<%
	long brokerId = ParamUtil.getLong(request, "brokerId",0);
	Object brokerAttribute = request.getAttribute("broker");
	Broker b = (brokerId > 0)?BrokerLocalServiceUtil.fetchBroker(brokerId):((brokerAttribute == null)?BrokerLocalServiceUtil.createBroker(0L):(Broker)brokerAttribute);
	BrokerType[] types = BrokerType.values();
	String[] topics = (Validator.isNull(b.getTopics())?new String[]{""}:b.getTopics().split(";"));
	String[] props = (Validator.isNull(b.getCustomProps())?new String[]{""}:b.getCustomProps().split(";"));
	
	boolean typeDisabled = !b.isNew();
	FileEntry sslCert = null;
	String sslCertUrl = null;
	if(b.getSslEnabled() != null && b.getSslEnabled()){
		Folder sslCerts = ResourceLocator.getInstance().getOrCreateDocumentLibraryAttributesFolder(themeDisplay.getCompanyId(), themeDisplay.getCompanyGroupId(), 0, "SSL Certs", "SSL Certs");
		try{
		sslCert = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getCompanyGroupId(), sslCerts.getFolderId(), "Cert_"+b.getBrokerId());
		if(sslCert != null){
			sslCertUrl = ResourceLocator.getInstance().getDocumentLibraryFileUrl(sslCert, themeDisplay);
		}
		}catch(Exception e){
			log("No file found..");
		}
	}
	String panelDefaultState = (b.isNew())?"open":"close";
%>
<portlet:actionURL name="saveOrUpdateBroker" var="saveOrUpdateBrokerURL"/>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/broker/view.jsp"/>
</portlet:renderURL>
<liferay-ui:error key="it.acsoftware.permissionException" message="it.acsoftware.brokerportlet.permissionException"/>
<liferay-ui:error key="it.acsoftware.brokerportlet.error" >
	<liferay-ui:message key="it.acsoftware.brokerportlet.error" arguments='<%=renderRequest.getParameter("errorMessage")%>' />
</liferay-ui:error>

<div id="contentForm">
	<div id="title">
		<c:choose>
			<c:when test="<%=b.isNew() %>">
				
				<liferay-ui:header title="it.acsoftware.brokerportlet.newBrokerConfiguration" backURL="<%=backURL.toString() %>"></liferay-ui:header>
			</c:when>
			<c:otherwise>
				<liferay-ui:header title="<%=b.getName() %>" backURL="<%=backURL.toString() %>"></liferay-ui:header>
			</c:otherwise>
		</c:choose>	
	</div>
	<aui:form name="borkerForm" enctype="multipart/form-data" method="post" action="<%=saveOrUpdateBrokerURL.toString() %>">
		<aui:input name="brokerCmd" type="hidden" value="update" />
		<aui:input name="brokerId" type="hidden" value="<%=b.getBrokerId() %>"/>
		<div style="float: left">
			<liferay-ui:panel-container>
				<liferay-ui:panel title="Broker" state="<%=panelDefaultState %>">
					<aui:select name="brokerType"
						label="it.acsoftware.brokerportlet.label.brokerType"
						showEmptyOption="true" required="true" disabled="<%=typeDisabled %>">
						<%
							for(int i = 0; i < types.length;i++){ 
								boolean selected = b.getType() != null && b.getType().equalsIgnoreCase(types[i].getType());
						%>
						<aui:option value="<%=types[i].getType()%>"
							label="<%=types[i].getType()%>"  selected="<%=selected %>"/>
						<%
							}
						%>
					</aui:select>
					<c:if test="<%=typeDisabled %>">
						<aui:input name="brokerType" value="<%=b.getType() %>" type="hidden"></aui:input>
					</c:if>
					<aui:input name="brokerName"
						label="it.acsoftware.brokerportlet.label.broker.name"
						inlineField="true" value="<%=b.getName()%>" required="true"/>
					<aui:input name="brokerProtocol"
						label="it.acsoftware.brokerportlet.label.broker.protocol"
						inlineField="true" value="<%=b.getProtocol()%>" required="true"/>
					<aui:input name="brokerUrl"
						label="it.acsoftware.brokerportlet.label.broker.host"
						inlineField="true" value="<%=b.getUrl()%>" required="true"/>
					<aui:input name="brokerPort"
						label="it.acsoftware.brokerportlet.label.broker.port"
						inlineField="true" value="<%=b.getPort()%>" required="true">
						<aui:validator name="digits"></aui:validator>
					</aui:input>
					
					<div class="clear:both"></div>
					
					<aui:input name="brokerUsername" label="it.acsoftware.brokerportlet.label.broker.username" value="<%=b.getConnectionUsername() %>" inlineField="true" />
					<aui:input name="brokerPassword" label="it.acsoftware.brokerportlet.label.broker.password" value="<%=b.getConnectionPassword() %>" type="password" inlineField="true"/>
					
					<div class="clear:both"></div>
					<aui:input name="brokerStartAtStartup"
						label="it.acsoftware.brokerportlet.label.broker.startAtStartup"
						type="checkbox" inlineField="true"
						value="<%=b.getStartAtStartup()%>" />
					<aui:input name="sslEnabled"
						label="it.acsoftware.brokerportlet.label.broker.sslEnabled"
						type="checkbox" inlineField="true" value="<%=b.getSslEnabled()%>" />
					<div class="clear:both"></div>
					<aui:input name="brokerDescription"
						label="it.acsoftware.brokerportlet.label.broker.description"
						type="textarea" style="width:100%;height:130px"
						value="<%=b.getDescription()%>" />

					<aui:fieldset id="topic-fields">
						<%
							StringBuilder topicIndexes = new StringBuilder();
							for(int i = 0; i < topics.length;i++){ 
								topicIndexes.append(String.valueOf((i)));
								if(i < topics.length-1)
									topicIndexes.append(",");
							%>
								<div class="lfr-form-row lfr-form-row-inline">
									<div class="row-fields">
										<aui:input fieldParam='<%="topic"+(i) %>' id='<%="topic"+(i) %>'
											name='<%="topic"+(i) %>' label="it.acsoftware.brokerportlet.label.broker.topic" value="<%=topics[i] %>"/>
									</div>
								</div>
						<% } %>
						<aui:input name="topicIndexes" id="topicIndexes" type="hidden" value="<%=topicIndexes.toString()%>"/>
					</aui:fieldset>
					
				</liferay-ui:panel>
				<liferay-ui:panel title="SSL" state="<%=panelDefaultState %>"
					cssClass="hide accordionSSL">
					<aui:field-wrapper>
						<aui:field-wrapper cssClass="hide sslField">
							<aui:input name="sslSecret"
								label="it.acsoftware.brokerportlet.label.broker.sslSecret"
								required="true" disabled="true" value="<%=b.getSslSecret()%>"
								type="secret"></aui:input>
							
							<c:choose>
								<c:when test="<%=sslCert == null %>">
									<aui:input name="sslCertificate" disabled="true"
										label="it.acsoftware.brokerportlet.label.broker.sslCert"
										type="file" />
								</c:when>
								<c:otherwise>
										<label><%=LanguageUtil.get(pageContext,"it.acsoftware.brokerportlet.label.broker.sslCert") %></label>
										<a href="<%=sslCertUrl %>" style="padding-top:5px">Downlaod</a>
										<aui:button value="Reset" type="button" onClick="resetSslCertFile();"/>
								</c:otherwise>
								</c:choose>
						</aui:field-wrapper>
					</aui:field-wrapper>
				</liferay-ui:panel>
				<liferay-ui:panel
					title="MQTT Properties" state="<%=panelDefaultState %>" cssClass="hide MQTTProps brokerProps">
					<aui:field-wrapper cssClass="hide brokerField MQTTField">
						<aui:input name="MQTT-clientId"
							label="it.acsoftware.brokerportlet.label.broker.mqtt.clientId"
							required="true" value="<%=b.getMqttClientId()%>" />
					</aui:field-wrapper>

					<aui:field-wrapper cssClass="hide brokerField MQTTField">
						<aui:input name="MQTT-Qos"
							label="it.acsoftware.brokerportlet.label.broker.mqtt.qos"
							required="true" value="<%=b.getMqttQos()%>" >
								<aui:validator name="digits"></aui:validator>
              					<aui:validator name="min">-1</aui:validator>
              					<aui:validator name="max">2</aui:validator>
						</aui:input>
					</aui:field-wrapper>
					
					<aui:field-wrapper cssClass="hide brokerField MQTTField">
						<aui:input name="MQTT-cleanSession" type="checkbox"
							label="it.acsoftware.brokerportlet.label.broker.mqtt.cleanSession"
							required="true" value="<%=b.getMqttCleanSession()%>" >
						</aui:input>
					</aui:field-wrapper>
				</liferay-ui:panel>
				<liferay-ui:panel
					title="Kafka Properties" state="<%=panelDefaultState %>" cssClass="hide KAFKAProps brokerProps">
					<aui:field-wrapper cssClass="hide brokerField KAFKAField">
						<aui:input name="KAFKA-zookeeperHost"
							label="it.acsoftware.brokerportlet.label.broker.kafka.zookeeperHost"
							required="true" value="<%=b.getKafkaZookeeperHost()%>" />
					</aui:field-wrapper>
					<aui:field-wrapper cssClass="hide brokerField KAFKAField">
						<aui:input name="KAFKA-threadsPerTopic"
							label="it.acsoftware.brokerportlet.label.broker.kafka.threadsPerTopic"
							required="true" value="<%=b.getKafkaThreadsPerTopic()%>" />
					</aui:field-wrapper>
					<aui:field-wrapper cssClass="hide brokerField KAFKAField">
						<aui:input name="KAFKA-groupId"
							label="it.acsoftware.brokerportlet.label.broker.kafka.groupId"
							required="true" value="<%=b.getKafkaGroupId()%>" />
					</aui:field-wrapper>
					
				</liferay-ui:panel>
				<liferay-ui:panel title="it.acsoftware.brokerportlet.label.broker.customProps" state="<%=panelDefaultState %>">
					<div id="props-fields">
						
						<%
						StringBuilder propsIndexes = new StringBuilder();
						for(int i = 0; i < props.length;i++){
								propsIndexes.append(String.valueOf((i)));
								if(i < topics.length-1)
									propsIndexes.append(",");
								String[] prop = props[i].split("\\$");
								String propName = "";
								String propValue = "";
								if(prop.length > 0)
									propName = prop[0];
								
								if(prop.length > 1)
								 	propValue = prop[1];
							%>
							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields">
									<aui:input fieldParam='<%="propName"+i %>' id='<%="propName"+i %>'
										name='<%="propName"+i %>' label="it.acsoftware.brokerportlet.label.broker.propName" value="<%=propName %>" inlineField="true"/>
									
									<aui:input fieldParam='<%="prop"+i %>' id='<%="prop"+i %>'
										name='<%="prop"+i %>' label="it.acsoftware.brokerportlet.label.broker.propValue" value="<%=propValue %>" inlineField="true"/>
								</div>
							</div>
						<% 	} %>
						<aui:input name="propsIndexes" type="hidden" value="<%=propsIndexes%>"/>
					</div>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
		</div>
		<div style="float: right">
			<aui:button type="submit" />
			<c:choose>
				<c:when test="<%=BrokersManagerLocalServiceUtil.isRunning(b.getBrokerId())%>">
					<portlet:actionURL var="stopBrokerServiceURL" name="stopBrokerService">
									<portlet:param name="brokerId" value="<%=String.valueOf(b.getBrokerId())%>"/>
					</portlet:actionURL>
					<portlet:actionURL var="restartBrokerServiceURL" name="restartBrokerService">
									<portlet:param name="brokerId" value="<%=String.valueOf(b.getBrokerId())%>"/>
					</portlet:actionURL>
					<portlet:renderURL var="listenBrokerServiceURL" >
									<portlet:param name="brokerId" value="<%=String.valueOf(b.getBrokerId())%>"/>
									<portlet:param name="mvcPath" value="/html/broker/webSocketLog.jsp"/>
					</portlet:renderURL>
					<% String onStopClick = "brokerAction('"+stopBrokerServiceURL.toString()+"')";
				 	   String onRestartClick = "brokerAction('"+restartBrokerServiceURL.toString()+"')";
				 	   String onListenClick = "brokerAction('"+listenBrokerServiceURL.toString()+"')";
					%>
					<aui:button type="submit" value="it.acsoftware.brokerportlet.label.brokerService.stop" onClick='<%=onStopClick%>'></aui:button>
					<aui:button type="submit" value="it.acsoftware.brokerportlet.label.brokerService.restart" onClick='<%=onRestartClick%>'></aui:button>
					<aui:button type="submit" value="it.acsoftware.brokerportlet.label.brokerService.listen" onClick="<%=onListenClick %>"></aui:button>
				</c:when>
				<c:otherwise>
					<portlet:actionURL var="startBrokerServiceURL" name="startBrokerService">
									<portlet:param name="brokerId" value="<%=String.valueOf(b.getBrokerId())%>"/>
					</portlet:actionURL>
					<% String onStartClick = "brokerAction('"+startBrokerServiceURL.toString()+"')"; %>
					<aui:button type="submit" value="it.acsoftware.brokerportlet.label.brokerService.start" onClick="<%=onStartClick%>"></aui:button>
				</c:otherwise>
			</c:choose>
		</div>
	</aui:form>
</div>




<aui:script use="aui-base,aui-node,liferay-auto-fields,aui-form-validator,liferay-form">
	var sslEnabled = <%=b.getSslEnabled()%>;
	
	var DEFAULTS_FORM_VALIDATOR = A.config.FormValidator;
	var defaultRequired = DEFAULTS_FORM_VALIDATOR.RULES.required;
    
    var required = function(val, node, ruleValue) {
	    var result = defaultRequired(val, node, ruleValue);
	    if(node.get('disabled')){
            result = true;
        }
        return result;
    };      
    
    A.mix(
            DEFAULTS_FORM_VALIDATOR.RULES,
            {
                required : required 
            },
            true
        ); 
    
	A.one('#<portlet:namespace/>brokerType').on(
			'change',
			function() {
				hideAllBrokerFields();
				showBrokerFields();
			})

	A.one('#<portlet:namespace/>sslEnabledCheckbox').on('change', function() {
		var checked = this.get('checked');
		enableSSLFields(checked);
	});

	var autoFieldTopic = new Liferay.AutoFields({
		contentBox : 'fieldset#<portlet:namespace />topic-fields',
		fieldIndexes : '<portlet:namespace />topicIndexes',
		namespace: '<portlet:namespace/>'
	}).render();
	
	//workaround autofields where not saved
	autoFieldTopic.on('clone',function(event){
		autoFieldTopic.save();
	});
	
	autoFieldTopic.on('delete',function(event){
		autoFieldTopic.save();
	});
	
	autoFieldProps = new Liferay.AutoFields({
		contentBox : '#props-fields',
		fieldIndexes : '<portlet:namespace />propsIndexes',
		namespace: '<portlet:namespace/>'
	}).render();
	
	
	//workaround autofields where not saved
	autoFieldProps.on('clone',function(event){
		autoFieldProps.save();
	});
	
	autoFieldProps.on('delete',function(event){
		autoFieldProps.save();
	});

	Liferay.provide(window, 'hideAllBrokerFields', function() {
		A.all('.brokerField').each(function() {
			this.hide();
			A.one('label[for=' + this.get('id') + ']').hide();
		});
		
		A.all('.brokerProps').each(function() {
			this.hide();
		});
	});
	
	Liferay.provide(window,'showBrokerFields',function(){
		if(A.one('#<portlet:namespace/>brokerType').val() != null && A.one('#<portlet:namespace/>brokerType').val() != ''){
			var className = A.one('#<portlet:namespace/>brokerType').val()
			+ "Field";
			
			A.all('.' + className).each(function() {
				this.show();
				A.one('label[for=' + this.get('id') + ']').show();
			});
			A.one('.'+A.one('#<portlet:namespace/>brokerType').val()+'Props').show();
		}
	});

	Liferay.provide(window, 'enableSSLFields', function(enable) {
		if (enable) {
			A.all('.sslField').each(function() {
				this.get('children').each(function() {
					this.set('disabled', false);
					this.removeAttribute('disabled');
				})
				this.show()
				A.one('.accordionSSL').removeClass("hide");
			});
		} else {
			A.all('.sslField').each(function() {
				this.get('children').each(function() {
					this.set('disabled', true);
					this.setAttribute('disabled','');
				});
				this.hide();
				A.one('.accordionSSL').addClass("hide");
			});
		}
	});
	
	Liferay.provide(window,'resetSslCertFile',function(){
		A.one('#<portlet:namespace/>brokerCmd').val('resetSslCert');
		A.one('#<portlet:namespace/>borkerForm').submit();
	});
	
	Liferay.provide(window,'brokerAction',function(url){
		A.one('#<portlet:namespace/>borkerForm').set('action',url);
	});
	
	Liferay.provide(window,'brokerLink',function(url){
		window.location = url;
	});

	hideAllBrokerFields();
	enableSSLFields(sslEnabled);
	showBrokerFields();
	
</aui:script>
