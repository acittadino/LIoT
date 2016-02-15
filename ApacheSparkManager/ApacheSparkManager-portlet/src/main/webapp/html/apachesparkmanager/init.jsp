<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="it.acsoftware.apachesparkmanager.util.ApacheSparkManagerConstants"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="it.acsoftware.apachesparkmanager.util.SparkRestClient"%>
<%@ page import="it.apachesparkjobserver.model.SparkJobServerJobStatus"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="it.apachesparkjobserver.model.SparkJobServerJars"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="it.apachesparkjobserver.model.SparkJobContexts"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="it.apachesparkjobserver.model.SparkJobServerJobDetails"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="java.util.Collections"%>
<%@ page import="it.apachesparkjobserver.model.SparkJobServerJobStatusResult"%>
<%@ page import="it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil"%>
<%@ page import="it.acsoftware.apachesparkmanager.model.JobEventSchedule"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="it.acsoftware.apachesparkmanager.permission.JobEventSchedulePermission"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil"%>
<%@ page import="it.acsoftware.apachesparkmanager.model.JobDateSchedule"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />