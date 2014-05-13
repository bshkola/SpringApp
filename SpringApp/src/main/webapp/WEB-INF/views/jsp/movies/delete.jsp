<%@ include file="../templates/taglibs.jsp" %>
<%
	final String[] CSS_files = {
		"categories/style.css",
	};
	final String siteTitle = "categories.siteTitle";
%>

<%@ include file="../templates/doctype.jsp" %>

<%@ include file="../templates/heading.jsp" %>

<%@ include file="../templates/mainMenu.jsp" %>

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
	<a href="<spring:message code="system.baseUrl"/>/categories">Go back to categories</a>
<%@ include file="../templates/footer.jsp" %>