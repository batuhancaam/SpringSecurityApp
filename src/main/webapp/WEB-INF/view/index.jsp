<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Welcome Home Page</title>
</head>
<body>
<h2>Home Page</h2>
<hr/>

<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Roles: <security:authentication property="principal.authorities"/>


</p>

<hr>

<p>
    <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
    (Only for Manager peeps)


</p>
<p>
    <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
    (Only for Admin peeps)


</p>
<hr>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>
