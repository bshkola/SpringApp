<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Choose the category:</h2>
	
	<table>
		<c:if test="${not empty categoriesList}">
			<thead>
				<tr>
					<td><b>Category:</b></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tr>
				<td>
					<a href="http://localhost:8080/SpringApp/movies/all">All categories</a>
				</td>
			</tr>
		</c:if>

		<c:forEach var="categoryItem" items="${categoriesList}">
			<tr>
				<td>
					<a href="http://localhost:8080/SpringApp/movies/${categoryItem.name}">${categoryItem.name}</a>
				</td>
				<td>
					<a href="http://localhost:8080/SpringApp/categories/edit/${categoryItem.categoryId}">edit</a>
				</td>
				<td>
					<a href="http://localhost:8080/SpringApp/categories/delete/${categoryItem.categoryId}">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="http://localhost:8080/SpringApp/categories/add">Add new category</a>
	<br>
	<a href="http://localhost:8080/SpringApp/movies/add">Add new movie</a>
	
</body>
</html>