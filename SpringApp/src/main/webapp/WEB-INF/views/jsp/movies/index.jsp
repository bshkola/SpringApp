<%@ include file="../templates/taglibs.jsp" %>

<html>
<body>
	<h2><spring:message code="movies.header"/> ${categoryName}</h2>
 
 	<c:choose>
		<c:when test="${not empty moviesList}">
	 		<table border="1">
	 			<thead>
	 				<tr>
	 					<td><b><spring:message code="movie.name"/></b></td>
	 					<td><b><spring:message code="movie.releaseYear"/></b></td>
	 					<td><b><spring:message code="movie.description"/></b></td>
	 					<td></td>
	 					<td></td>
	 				</tr>
	 			</thead>
		 		<c:forEach var="movieItem" items="${moviesList}">
					<tr>
						<td>${movieItem.name}</td>
						<td>${movieItem.releaseYear}</td>
						<td>${movieItem.description}</td>
						<td>
							<a href="<spring:message code="system.baseUrl"/>/movies/edit/${movieItem.movieId}"><spring:message code="movies.edit"/></a>
						</td>
						<td>
							<a href="<spring:message code="system.baseUrl"/>/movies/delete/${movieItem.movieId}"><spring:message code="movies.delete"/></a>
						</td>
					</tr>
				</c:forEach>		
	 		</table>
		</c:when>
		<c:otherwise>
			<h1><spring:message code="movies.noMovie"/></h1>
		</c:otherwise>
 	</c:choose>
 	<br>
	<a href="<spring:message code="system.baseUrl"/>/categories"><spring:message code="categories.goBack"/></a>
</body>
</html>