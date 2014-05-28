<body">
<div id="wrapper">

<div id="banner">
	<div id="loginSpace">
		<sec:authorize access="isAnonymous()">
			<div>
				<form action="<spring:message code="system.baseUrl"/>/j_spring_security_check" 
						method="POST">
					<input class="loginInput" type="text" placeholder="username" name="username"/>
					<input class="loginInput" type="password" placeholder="password" name="password"/>
					<input type="submit" value="Log in"/>
				</form>
			</div>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<div id="username">
				Welcome <sec:authentication property="principal.username"/>
			</div>
			<div>
				<spring:url value="/logout" var="logoutUrl"/>
			</div>
			<a href="${logoutUrl}">Logout</a>
		</sec:authorize>
	</div>
</div>