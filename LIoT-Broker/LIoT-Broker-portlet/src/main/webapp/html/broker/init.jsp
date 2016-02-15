<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>

<%@page import="it.acsosftware.brokerportlet.util.BrokerType"%>
<%@ page import="it.acsoftware.brokerportlet.model.Broker"%>
<%@ page import="it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil"%>
<%@ page import="it.acsosftware.brokerportlet.util.LIoTBrokerPortletConstants"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="it.acsosftware.brokerportlet.util.ResourceLocator"%>
<%@ page import="java.io.File"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="it.acsoftware.brokerportlet.permission.BrokerModelPermission"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="it.acsoftware.brokerportlet.permission.BrokerPermission"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="it.acsoftware.brokerportlet.service.BrokersManagerLocalServiceUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />