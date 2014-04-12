<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Choose the category:</h2>
 
	<c:if test="${not empty categoriesList}">
		<ul>
			<c:forEach var="categoryItem" items="${categoriesList}">
				<li>
					<c:url value="${categoryItem.name}" var="category" />
					<a href="movies/${category}">${categoryItem.name}</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>