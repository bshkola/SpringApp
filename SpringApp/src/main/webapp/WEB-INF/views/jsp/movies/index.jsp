<%@ include file="../templates/taglibs.jsp" %>
<%
	final String[] CSS_files = {
		"movies/style.css",
	};
	final String siteTitle = "movies.siteTitle";
%>

<%@ include file="../templates/doctype.jsp" %>

<%@ include file="../templates/heading.jsp" %>

<%@ include file="../templates/mainMenu.jsp" %>

	<h2 class="pageTitle">
		<c:choose>
			<c:when test="${categoryName == 'All categories'}">
				All movies
			</c:when>
			<c:otherwise>
				${categoryName} movies
			</c:otherwise>
		</c:choose>
	</h2>

 	<c:choose>
		<c:when test="${not empty moviesList}">
			<div id="movies_container">
				<c:forEach var="movieItem" items="${moviesList}">
					<div class="movie_list_item">
						<ul class="movie_list_item_options">
							<li>
								<a href="<spring:message code="system.baseUrl"/>/movies/edit/${movieItem.movieId}"><spring:message code="movies.edit"/></a>
							</li>
							<li>
								<a href="<spring:message code="system.baseUrl"/>/movies/delete/${movieItem.movieId}"><spring:message code="movies.delete"/></a>
							</li>
						</ul>
						<img class="image_rect" src='<spring:message code="uploadDir"/>/${movieItem.imagePath}' alt="image" height="300"/>
						<div class="movie_list_item_name">
							${movieItem.name} (${movieItem.releaseYear})
						</div>
						<div class="movie_list_item_metadata">
							${movieItem.category.name}
						</div>						
						<div class="movie_list_item_metadata">
							${movieItem.description}
						</div>
					</div>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div class="warning_statement"><spring:message code="movies.noMovie"/></div>
		</c:otherwise>
 	</c:choose>
 	<br>
	<a href="<spring:message code="system.baseUrl"/>/categories"><spring:message code="categories.goBack"/></a>
<%@ include file="../templates/footer.jsp" %>