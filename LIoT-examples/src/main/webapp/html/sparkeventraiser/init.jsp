<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="it.acsoftware.brokerportlet.service.BrokerMessageListenerLocalServiceUtil"%>
<%@page import="it.acsoftware.brokerportlet.model.BrokerMessageListener"%>
<%@page import="java.util.List"%>
<%@page import="it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil"%>
<%@page import="it.acsoftware.apachesparkmanager.model.JobEventSchedule"%>
<%@page import="it.acsoftware.liotexamples.portlet.SparkEventRaiser"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />