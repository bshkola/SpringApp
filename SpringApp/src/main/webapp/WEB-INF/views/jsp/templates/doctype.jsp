<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%   for (int i = 0; i < CSS_files.length; i++) {   %>
	<link rel="stylesheet" href="<spring:message code="system.baseUrl" /><spring:message code="system.cssUrl" />/<%= CSS_files[i] %>" type="text/css" />	
<% } %>

<title><spring:message code="<%= siteTitle %>"/> <spring:message code="system.siteTitle"/></title>
</head>