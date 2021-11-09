<title>Welcome</title>
<span style="text-align:right;"><h3>Hi, <%= session.getAttribute("greetingname") %> <a href="/logout"><button>Logout</button></a></h3></span>
<h1>Home</h1>
<table>
    <tr>
        <td><a href="/articles">Browse Articles By Category</a></td>
    </tr>
    <% if ("Author".equals(session.getAttribute("userType"))) { %>
        <tr>
            <td><a href="/myarticles">My Articles</a></td>
        </tr>
        <tr>
            <td><a href="/newarticle">Create Article</a></td>
        </tr>
    <% } %>
</table>

<h4>${errorMessage}</h4>