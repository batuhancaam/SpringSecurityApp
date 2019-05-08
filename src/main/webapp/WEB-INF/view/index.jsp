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
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>
