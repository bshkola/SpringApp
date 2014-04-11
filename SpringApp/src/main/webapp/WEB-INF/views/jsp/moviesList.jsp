<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Spring MVC and List Example</h2>
 
	<c:if test="${not empty moviesList}">
 
		<ul>
			<c:forEach var="listValue" items="${moviesList}">
				<li>${listValue.name}, ${listValue.releaseYear}, ${listValue.description}</li>
			</c:forEach>
		</ul>
 
	</c:if>
</body>
</html>