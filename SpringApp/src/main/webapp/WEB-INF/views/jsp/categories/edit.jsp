<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
	<h1>Edit category page</h1>
	<form:form method="POST" action="" commandName="category">
		<form:hidden path="categoryId"/>
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="Edit category">
				</td>
			</tr>			
		</table>
	</form:form>
	<br>
	<a href="http://localhost:8080/SpringApp/categories">Go back to categories</a>
</body>
</html>