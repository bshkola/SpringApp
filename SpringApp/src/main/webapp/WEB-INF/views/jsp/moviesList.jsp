<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>Movies of the category ${categoryName}</h2>
 
 	<c:choose> 	
		<c:when test="${not empty moviesList}">
	 		<table border="1">
	 			<thead>
	 				<tr>
	 					<td><b>Name</b></td>
	 					<td><b>Release year</b></td>
	 					<td><b>Description</b></td>
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
			<h1>You have no movies in this category</h1>
		</c:otherwise>
 	</c:choose>
 	<br>
	<c:url value="goBack" var="goBack"></c:url>
	<a href="http://localhost:8080/SpringApp/movies/">Go back to categories</a>
</body>
</html>