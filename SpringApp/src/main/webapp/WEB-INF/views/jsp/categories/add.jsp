<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


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
	<h1>Add category page</h1>
	<form:form method="POST" action="add" commandName="category">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" cssClass="error"/> </td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="Add category">
				</td>
			</tr>			
		</table>
	</form:form>
	<br>
	<a href="http://localhost:8080/SpringApp/categories"><spring:message code="categories.goBack"/></a>
</body>
</html>