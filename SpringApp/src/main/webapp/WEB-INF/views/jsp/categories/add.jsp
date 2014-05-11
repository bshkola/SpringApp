<%@ include file="../templates/taglibs.jsp" %>

<html>

<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<body>
	<form:form method="POST" action="add" commandName="categoryForm">
		<form:hidden path="categoryId"/>
		<form:errors path="*" class="errorblock" element="div"/>
		<table>
			<tr>
				<td><form:label path="name"><spring:message code="category.name"/>:</form:label></td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" class="error"/> </td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="<spring:message code="category.add"/>">
				</td>
			</tr>			
		</table>
	</form:form>
	<br>
	<a href="<spring:message code="system.baseUrl"/>/categories"><spring:message code="categories.goBack"/></a>
</body>
</html>