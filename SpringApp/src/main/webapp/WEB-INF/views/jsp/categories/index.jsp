<%@ include file="../templates/taglibs.jsp" %>

<html>
<head>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link rel="stylesheet" href="/SpringApp/css/general.css" type="text/css"/>
</head>

<body>
	<h2><spring:message code="categories.categories"/></h2>
	
	<table>
		<c:if test="${not empty categoriesList}">
			<thead>
				<tr>
					<td><b><spring:message code="categories.category"/>:</b></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tr>
				<td>
					<a href="<spring:message code="system.baseUrl"/>/movies/all"><spring:message code="categories.allCategories"/></a>
				</td>
			</tr>
		</c:if>

		<c:forEach var="categoryItem" items="${categoriesList}">
			<tr>
				<td>
					<a href="<spring:message code="system.baseUrl"/>/movies/${categoryItem.name}">${categoryItem.name}</a>
				</td>
				<td>
					<a href="<spring:message code="system.baseUrl"/>/categories/edit/${categoryItem.categoryId}"><spring:message code="categories.edit"/></a>
				</td>
				<td>
					<a href="<spring:message code="system.baseUrl"/>/categories/delete/${categoryItem.categoryId}"><spring:message code="categories.delete"/></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="<spring:message code="system.baseUrl"/>/categories/add"><spring:message code="categories.addNew"/></a>
	<br>
	<a href="<spring:message code="system.baseUrl"/>/movies/add"><spring:message code="movies.addNew"/></a>
	
</body>
</html>