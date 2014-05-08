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
							<a href="http://localhost:8080/SpringApp/movies/edit/${movieItem.movieId}">edit</a>
						</td>
						<td>
							<a href="http://localhost:8080/SpringApp/movies/delete/${movieItem.movieId}">delete</a>
						</td>
					</tr>
				</c:forEach>		
	 		</table>
		</c:when>
		<c:otherwise>
			<h1>You have no movies in this category</h1>
		</c:otherwise>
 	</c:choose>
 	<br>
	<a href="http://localhost:8080/SpringApp/categories">Go back to categories</a>
</body>
</html>