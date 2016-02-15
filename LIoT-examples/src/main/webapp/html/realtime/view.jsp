<%@include file="/html/realtime/init.jsp"%>

<%
	List<BrokerMessageListener> listeners = BrokerMessageListenerLocalServiceUtil.findByCompany(themeDisplay.getCompanyId());
%>

<div>
	<p>Please select the Message Bus Listener from which Chart must be rendered and start a simulation with the simulator!</p>
</div>

<hr/>

<div>
	<aui:select name="messageBusListener" onChange="initWebSocket()" label="Message Bus Listener">
		<aui:option label="" value=""/>
		<% for(int i = 0; i < listeners.size();i++){ 
			BrokerMessageListener bml = listeners.get(i);
		%>
			<aui:option label="<%=bml.getName() %>" value="<%=bml.getMessageBusDestination() %>"/>
		<% } %>
	</aui:select>
</div>


<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto">

</div>


<aui:script use="aui-base,aui-node,aui-io-request">
    var started = false;
    var chartSerie = null;
    var server = null;
    
    Liferay.provide(window,'initRealtimeChart',function(){
    	var div = $('#container');
    	div.highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {
						// set up the updating of the chart each second
                        chartSerie = this.series[0];
                    }
                }
            },
            title: {
                text: 'Broker Data'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Value'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: 'BrokerData',
                data:(function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -19; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: 0
                        });
                    }
                    return data;
                }())
            }]
        });
    });
    
    Liferay.provide(window,'initWebSocket',function(){
    	var loggedUser = themeDisplay.isSignedIn();
    	var messageBusDestination = A.one('#<portlet:namespace/>messageBusListener').val();
    	
    	if (!("WebSocket" in window)) {
    		console.log("Web Socket Not Supported!");
    	} else if (loggedUser) {
    		
    		if(server != null)
    			server.close(),
    			
    		console.log('init web socket...');
    		try {
    			var webSocketUrl = 'ws://127.0.0.1:8080/LIoT-examples-portlet/webSocket/'+messageBusDestination;
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
    			var timeStamp = dataJson.timeStamp;
    			var value = dataJson.value;
    			chartSerie.addPoint([timeStamp,value],true,true);
    		};
    	} else {
    		console.log('please login first');
    	}
    });
    
    initRealtimeChart();
    
</aui:script>
	


