<%@ include file="../templates/taglibs.jsp" %>

<html>
<body>
	<form:form method="POST" commandName="category">
		<form:hidden path="categoryId"/>
		<table>
			<tr>
				<td><form:label path="name"><spring:message code="category.name"/>:</form:label></td>
				<td><form:input path="name" disabled="true"/></td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="<spring:message code="category.delete"/>">
				</td>
			</tr>			
		</table>
	</form:form>
	<br>
	<a href="<spring:message code="system.baseUrl"/>/categories"><spring:message code="categories.goBack"/></a>
</body>
</html>