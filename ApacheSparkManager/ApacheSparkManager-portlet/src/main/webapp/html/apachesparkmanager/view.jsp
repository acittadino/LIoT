<%@ include file="/html/apachesparkmanager/init.jsp"%>

<%
	String result = ParamUtil.getString(request, "result");
	String currentTab = ParamUtil.getString(request,"currentTab","");
	//viariables inherited from init.jsp	
	String jarsResponse = SparkRestClient.doSparkRequest(SparkRestClient.METHOD_GET,portletPreferences, "jars", null,null,null);
	SparkJobServerJars jars = SparkJobServerJars.getObject(jarsResponse);
	boolean error = jars.getJars().get("error") != null && jars.getJars().get("error").equalsIgnoreCase("true");
	HashMap<String,String> jarsHashMap = jars.getJars();
	List<String> jarsList = new ArrayList<String>();
	jarsList.addAll(jarsHashMap.keySet());
%>

<portlet:renderURL var="jarsURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/apachesparkmanager/tabs/jars.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="jobsURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/apachesparkmanager/tabs/jobs.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="contextsURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/apachesparkmanager/tabs/contexts.jsp"/>
</portlet:renderURL>

<div >
	<c:if test="<%=Validator.isNotNull(result) %>">
			<p><strong>
				Job Server Says:
				<%=result %>
			</strong></p>
		</c:if>
	</div>

<div id="sparkTab">
	<%String jarsClass = currentTab.equalsIgnoreCase("jars")?"active":"";%>
	<%String jobsClass = currentTab.equalsIgnoreCase("jobs")?"active":"";%>
	<%String contextsClass = currentTab.equalsIgnoreCase("contexts")?"active":"";%>
	<%String scheduleClass = currentTab.equalsIgnoreCase("schedule")?"active":"";%>
	<%String scheduleEventClass = currentTab.equalsIgnoreCase("scheduleEvents")?"active":"";%>
	<%String scheduleDateClass = currentTab.equalsIgnoreCase("scheduleDate")?"active":"";%>
	<ul class="nav nav-tabs">
		<li class="<%=jarsClass%>"><a href="#jars" >Jars</a></li>
		<li class=<%=jobsClass %>><a href="#jobs" >Jobs</a></li>
		<li class="<%=contextsClass%>"><a href="#contexts" >Contexts</a></li>
		<li class="<%=scheduleClass%>"><a href="#schedule" >Schedule Now</a></li>
		<li class="<%=scheduleEventClass%>"><a href="#scheduleEvents" >Schedule Job on Event</a></li>
		<li class="<%=scheduleDateClass%>"><a href="#scheduleDate" >Schedule Job on Date</a></li>

	</ul>

	<div class="tab-content" style="height:100%;min-height: 400px" >
		
		<div id="jars" class="<%=jarsClass%>">
			
			
		</div>
		
		<div id="jobs" class=<%=jobsClass %>>
			
		</div>
		
		<div id="contexts" class="<%=contextsClass%>">
			
		</div>
		
		<div id="schedule" class="<%=scheduleClass%>">
			<%@ include file="/html/apachesparkmanager/tabs/schedule.jspf" %>
		</div>
		
		<div id="scheduleEvents" class="<%=scheduleClass%>">
			<%@ include file="/html/apachesparkmanager/tabs/scheduledEvents.jsp" %>
		</div>
		
		<div id="scheduleDate" class="<%=scheduleClass%>">
			<%@ include file="/html/apachesparkmanager/tabs/scheduledDate.jspf" %>
		</div>
</div>
</div>

<aui:script use="aui-base,aui-node,aui-tabview">
	Liferay.provide(window,'reloadJars',function(){
		var link = '<%=jarsURL.toString()%>';
		doAjaxLink('jars',null,link,'','','',function(){alert('Server Unreachable,retry later!')});
	});
	
	Liferay.provide(window,'reloadJobs',function(){
		var link = '<%=jobsURL.toString()%>';
		doAjaxLink('jobs',null,link,'','','',function(){alert('Server Unreachable,retry later!')});
	});
	
	Liferay.provide(window,'reloadContexts',function(){
		var link = '<%=contextsURL.toString()%>';
		doAjaxLink('contexts',null,link,'','','',function(){alert('Server Unreachable,retry later!')});
	});
	
	Liferay.provide(window,'scrollToTop',function(){
		console.log("scrollon!");
		window.scrollTo(0, 0);
	});
	
	Liferay.provide(window,'submitUploadJarForm',function(){
		var canSubmit = true;
		
		if(A.one('#<portlet:namespace/>appName').val() == null || A.one('#<portlet:namespace/>appName').val() == ''){
			alert("Plase insert app name!");
			canSubmit = false;
		}
		
		if(A.one('#<portlet:namespace/>file').val() == null || A.one('#<portlet:namespace/>file').val() == ''){
			alert("Plase select a file!");
			canSubmit = false;
		}
		
		if(canSubmit){
			A.one('#<portlet:namespace/>uploadForm').submit();	
		}
	});
	
	Liferay.provide(window,'doAjaxLink',function(div, loadingDiv,
			link, afterRenderEvents, beforeStartFunc, onCompleteFunc,
			onErrFunc) {
		// necessary for avoiding auto scrolling
		var height = A.one('#' + div).ancestor().getStyle('height');
		A.one('#' + div).hide();
		A.one('#' + div).ancestor().setStyle('height', height);

		if (loadingDiv != null && A.one('#' + loadingDiv) != null)
			A.one('#' + loadingDiv).show();

		A.io.request(link, {
			dataType : 'text/html',
			method : 'GET',
			on : {
				success : function() {

					var result = this.get('responseData');

					A.one('#' + div).show();
					if (loadingDiv != null
							&& A.one('#' + loadingDiv) != null)
						A.one('#' + loadingDiv).hide();

					A.one('#' + div).html(result);

					if (afterRenderEvents != null
							&& afterRenderEvents != '') {
						var events = afterRenderEvents.split(",");
						for (var i = 0; i < events.length; i++) {
							Liferay.fire(events[i]);
						}
					}
				},
				failure : function() {
					onErrFunc();
				}
			}
		});
	});
	
	reloadJars();
	reloadJobs();
	reloadContexts();
	
	new A.TabView(
		      {
		        srcNode: '#sparkTab'
		      }
		 ).render();
</aui:script>