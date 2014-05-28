<%@ include file="templates/taglibs.jsp" %>
<%
	final String[] CSS_files = {
		"general.css",
	};
	final String siteTitle = "movies.siteTitle";
%>

<%@ include file="templates/doctype.jsp" %>

<%@ include file="templates/heading.jsp" %>

<%@ include file="templates/mainMenu.jsp" %>

	<h2 class="pageTitle">
		${message} Please try again:
	</h2>
	<sec:authorize access="isAnonymous()">
		<div id="loginBox">
			<form action="<spring:message code="system.baseUrl"/>/j_spring_security_check" 
					method="POST">
				<input class="loginInput" type="text" placeholder="username" name="username"/>
				<input class="loginInput" type="password" placeholder="password" name="password"/>
				<input type="submit" value="Log in"/>
			</form>
		</div>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		You have already logged in.
	</sec:authorize>

<%@ include file="templates/footer.jsp" %>