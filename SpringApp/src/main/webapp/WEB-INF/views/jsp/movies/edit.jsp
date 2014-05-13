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
		<form:hidden path="movieId"/>
		<fieldset>
			<legend>New movie</legend>
			<table>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name"/></td>
				</tr>	
				<tr>
					<td><form:label path="releaseYear">Year:</form:label></td>
					<td><form:input path="releaseYear"/></td>
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
						<input type="submit" value="Edit category"/>
					</td>
				</tr>			
			</table>
		</fieldset>
	</form:form>
	<br>
	<a href="<spring:message code="system.baseUrl"/>/categories">Go back to categories</a>
<%@ include file="../templates/footer.jsp" %>