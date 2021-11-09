<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Articles</title>
<span style="text-align:right;"><h3>Hi, <%= session.getAttribute("greetingname") %> <a href="/logout"><button>Logout</button></a></h3></span>
<h1>Articles</h1>
<c:forEach items="${categoryList}" var="category">
    <h2>${category.categoryName}</h2>
    <c:forEach items="${articleList}" var="article">
        <c:set var = "categoryId" scope = "session" value = "${category.categoryId}"/>
        <c:set var = "articleCategoryId" scope = "session" value = "${article.articleCategoryId}"/>
        <c:if test="${categoryId == articleCategoryId}">
            <p><a href="/article/${article.articleId}">${article.articleTitle}</a></p>
        </c:if>
    </c:forEach>
</c:forEach>
<a href="/login"><button>Back</button></a>
<h4>${errorMessage}</h4>