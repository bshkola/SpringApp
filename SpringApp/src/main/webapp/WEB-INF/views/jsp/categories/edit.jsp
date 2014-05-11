<%@ include file="../templates/taglibs.jsp" %>

<html>
<body>
	<form:form method="POST" action="" commandName="categoryForm">
		<form:hidden path="categoryId"/>
		<form:errors path="*" class="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="name"><spring:message code="category.name"/>:</form:label></td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" class="error"/> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="<spring:message code="category.edit"/>">
				</td>
			</tr>			
		</table>
	</form:form>
	<br>
	<a href="<spring:message code="system.baseUrl"/>/categories"><spring:message code="categories.goBack"/></a>
</body>
</html>