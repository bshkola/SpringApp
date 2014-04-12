<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>Movies of the category ${categoryName}</h2>
 
 	<c:choose> 	
		<c:when test="${not empty moviesList}">
	 		<table>
	 			<thead>
	 				<tr>
	 					<td>Name</td>
	 					<td>Release year</td>
	 					<td>Description</td>
	 				</tr>
	 			</thead>
		 		<c:forEach var="listValue" items="${moviesList}">
					<tr>
						<td>${listValue.name}</td>
						<td>${listValue.releaseYear}</td>
						<td>${listValue.description}</td>
					</tr>
				</c:forEach>		
	 		</table>
		</c:when>
		<c:otherwise>
			You have no movies in this category
		</c:otherwise>
 	</c:choose>
 	<br>
	<c:url value="mov" var="goBack"></c:url>
	<a href="${goBack}">Go back to categories</a>
</body>
</html>