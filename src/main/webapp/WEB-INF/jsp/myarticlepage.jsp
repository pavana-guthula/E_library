<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>E-article library - My Articles</title>
<span style="text-align:right;"><h3>Hi, <%= session.getAttribute("greetingname") %> <a href="/logout"><button>Logout</button></a></h3></span>
<h1>My Articles</h1>
<c:forEach items="${myArticleList}" var="article">
    <p><a href="/article/${article.articleId}">${article.articleTitle}</a></p>
</c:forEach>
<c:set var = "noarticle" scope = "session" value = "${noArticle}"/>
<c:if test="${noarticle != null}">
    <p>No Article found. Click Create new to create your Article</p>
</c:if>
<a href="/newarticle"><button>Create New</button></a>
<a href="/login"><button>Back</button></a>
<h4>${errorMessage}</h4>