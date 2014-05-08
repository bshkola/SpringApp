<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<form:form method="POST" action="add" commandName="movieForm">
		<form:hidden path="movieId"/>
		<fieldset>
			<legend>New movie</legend>
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name"/></td>
					<td><form:errors path="name" cssClass="error"/> </td>
				</tr>	
				<tr>
					<td><form:label path="releaseYear">Year:</form:label></td>
					<td><form:input path="releaseYear"/></td>
					<td><form:errors path="releaseYear" cssClass="error"/> </td>
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
								<form:select path="category" id="category" class="w300">
									<form:options items="${categories}" itemLabel="name" itemValue="categoryId"/>
								</form:select>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Add category"
							${empty categories ? 'disabled="disabled"' : ''}
						/>
					</td>
				</tr>			
			</table>
		</fieldset>
	</form:form>
	<br>
	<a href="http://localhost:8080/SpringApp/categories">Go back to categories</a>
</body>
</html>