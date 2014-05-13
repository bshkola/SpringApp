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

	<h2 class="pageTitle"><spring:message code="categories.categories"/></h2>
	<div id="category_container">
		<c:forEach var="categoryItem" items="${categoriesList}">
			<div class="category_list_item" onClick="javascript:window.location='<spring:message code="system.baseUrl"/>/movies/${categoryItem.name}'">
				<ul class="category_list_item_options">
					<li>
						<a href="<spring:message code="system.baseUrl"/>/categories/edit/${categoryItem.categoryId}"><spring:message code="categories.edit"/></a>
					</li>
					<li>
						<a href="<spring:message code="system.baseUrl"/>/categories/delete/${categoryItem.categoryId}"><spring:message code="categories.delete"/></a>
					</li>
				</ul>
				<div class="category_list_item_name">
					${categoryItem.name}
				</div>
			</div>
		</c:forEach>
		<a href="<spring:message code="system.baseUrl"/>/categories/add">
			<div class="category_list_item">
				<spring:message code="categories.addNew"/>
			</div>
		</a>
	</div>
	
	<div id="other">
		<a href="<spring:message code="system.baseUrl"/>/movies/add"><spring:message code="movies.addNew"/></a>
	</div>
<%@ include file="../templates/footer.jsp" %>