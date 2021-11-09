<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>E-article library - ${article.articleTitle}</title>
<span style="text-align:right;"><h3>Hi, <%= session.getAttribute("greetingname") %> <a href="/logout"><button>Logout</button></a></h3></span>
<h1>Article</h1>
<table>
    <tr>
        <td><b>Title</b></td>
        <td>${article.articleTitle}</td>
    </tr>
    <tr>
        <td><b>Category</b></td>
        <td>
            ${article.articleCategoryName}
        </td>
    </tr>
    <tr>
        <td><b>Author</b></td>
        <td>
            ${article.articleAuthorName}
        </td>
    </tr>
    <tr>
        <td><b>Description</b></td>
        <td>${article.articleDescription}</td>
    </tr>
    <tr>
        <td><b>Content</b></td>
        <td>${article.articleContent}</td>
    </tr>
    <tr>
        <td><b>Date Of Publish</b></td>
        <td>${article.dateOfPublish}</td>
    </tr>
</table>
<tr>
    <a href="/articles"><button>Back</button></a>
    <% if ("Author".equals(session.getAttribute("userType"))) { %>
        <a href="/editarticle/${article.articleId}"><button>Edit</button>
    <% } %>
</tr>