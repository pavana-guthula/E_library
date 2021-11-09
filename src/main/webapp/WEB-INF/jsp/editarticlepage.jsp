<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>E-library Edit Article</title>
<span style="text-align:right;"><h3>Hi, <%= session.getAttribute("greetingname") %> <a href="/logout"><button>Logout</button></a></h3></span>
<h1>Edit Article</h1>
<form:form method="post" action="update/${article.articleId}">
    <table>
        <tr>
            <td>Title</td>
            <td><form:input path="articleTitle" required="required" value="${article.articleTitle}"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><form:input path="articleDescription" required="required" value="${article.articleDescription}"/></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><textarea id="articleContent" rows="10" cols="100" name="articleContent" required="required">${article.articleContent}</textarea></td>
        </tr>
    </table>
    <input type="submit" value="Update" />
</form:form>
<a href="/article/${article.articleId}"><button>Cancel</button></a>
<c:if test="${(sessionScope.name).equals(author)}">
    <a href="/deletearticle/${article.articleId}"><button>Delete</button></a>
</c:if>
