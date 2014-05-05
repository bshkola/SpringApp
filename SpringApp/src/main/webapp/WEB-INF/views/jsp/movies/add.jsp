<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
	<form:form method="POST" action="add" commandName="movie">
		<fieldset>
			<legend>New category</legend>
			<table>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name"/></td>
				</tr>	
				<tr>
					<td><form:label path="releaseYear">Year:</form:label></td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td><form:label path="description">Description:</form:label></td>
					<td><form:textarea path="description" cols="75" rows="5"/></td>
				</tr>
				<tr>
					<td>
						<form:label path="category">Category:</form:label>
					</td>
					<td>
						<c:choose>
							<c:when test="${empty categories}">
								Add category first
							</c:when>
							<c:otherwise>
								<form:select path="category">
									<form:options items="${categories}" itemValue="name"/>
								</form:select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Add category">
					</td>
				</tr>			
			</table>
		</fieldset>
	</form:form>
	<br>
	<a href="http://localhost:8080/SpringApp/categories">Go back to categories</a>
</body>
</html>