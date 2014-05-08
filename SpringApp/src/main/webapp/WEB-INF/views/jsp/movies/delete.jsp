<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
	<form:form method="POST" action="" commandName="movieForm">
		<fieldset>
			<legend>Movie to delete</legend>
			<table>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name" disabled="true"/></td>
				</tr>	
				<tr>
					<td><form:label path="releaseYear">Year:</form:label></td>
					<td><form:input path="releaseYear" disabled="true"/></td>
				</tr>
				<tr>
					<td><form:label path="description">Description:</form:label></td>
					<td><form:textarea path="description" cols="75" rows="5" disabled="true"/></td>
				</tr>
				<tr>
					<td>
						<form:label path="category">Category:</form:label>
					</td>
					<td>
						<form:select path="category" id="category" disabled="true">
							<form:options items="${categories}" itemLabel="name" itemValue="categoryId"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Delete movie"/>
					</td>
				</tr>			
			</table>
		</fieldset>
	</form:form>
	<br>
	<a href="http://localhost:8080/SpringApp/categories">Go back to categories</a>
</body>
</html>