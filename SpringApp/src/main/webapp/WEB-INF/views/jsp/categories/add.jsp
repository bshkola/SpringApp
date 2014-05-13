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
<%@ include file="../templates/footer.jsp" %>