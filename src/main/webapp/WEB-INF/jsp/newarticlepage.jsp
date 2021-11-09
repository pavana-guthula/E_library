<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>E-article library - Create Article</title>
<span style="text-align:right;"><h3>Hi, <%= session.getAttribute("greetingname") %> <a href="/logout"><button>Logout</button></a></h3></span>
<h1>New Article</h1>
<form:form method="post" action="save">
    <form:input type="hidden" path="articleAuthorName" value= "<%= session.getAttribute(\"name\") %>" />
	<table>
		<tr>
			<td>Title</td>
			<td><form:input path="articleTitle" required="required"/></td>
		</tr>
		<tr>
			<td>Category</td>
			<td>
			    <form:select path="articleCategoryId">
			        <c:forEach items="${categoryList}" var="category">
			            <form:option value="${category.categoryId}">${category.categoryName}</form:option>
                    </c:forEach>
			    </form:select>
			</td>
		</tr>
		<tr>
            <td>Description</td>
            <td><form:input path="articleDescription" required="required"/></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><textarea id="articleContent" rows="10" cols="100" name="articleContent" required="required"></textarea></td>
        </tr>
	</table>
	<input type="submit" value="Publish" />
</form:form>
<a href="/login"><button>Cancel</button></td></a>