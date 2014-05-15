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

	<form:form method="POST" action="add" commandName="movieForm" enctype="multipart/form-data">
		<form:hidden path="movieId"/>
		<fieldset>
			<legend>New movie</legend>
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td><form:label path="name"><spring:message code="movie.name"/>:</form:label></td>
					<td><form:input path="name"/></td>
					<td><form:errors path="name" cssClass="error"/> </td>
				</tr>	
				<tr>
					<td><form:label path="releaseYear"><spring:message code="movie.releaseYear"/>:</form:label></td>
					<td><form:input path="releaseYear"/></td>
					<td><form:errors path="releaseYear" cssClass="error"/> </td>
				</tr>
				<tr>
					<td><form:label path="description"><spring:message code="movie.description"/>:</form:label></td>
					<td><form:textarea path="description" cols="75" rows="5"/></td>
				</tr>
				<tr>
					<td>
						<form:label path="category"><spring:message code="movie.category"/>:</form:label>
					</td>
					<td>
						<c:choose>
							<c:when test="${empty categories}">
								<spring:message code="categories.noCategory"/>
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
					<td>
						<form:label path="file">File:</form:label>
					</td>
					<td>
						<form:input type="file" path="file" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="<spring:message code="movie.add"/>"
							${empty categories ? 'disabled="disabled"' : ''}
						/>
					</td>
				</tr>			
			</table>
		</fieldset>
	</form:form>
	<br>
	<a href="<spring:message code="system.baseUrl"/>/categories">Go back to categories</a>
<%@ include file="../templates/footer.jsp" %>