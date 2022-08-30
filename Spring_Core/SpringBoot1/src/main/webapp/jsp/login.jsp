<%--
  Created by IntelliJ IDEA.
  User: Vinh
  Date: 30/08/2022
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login to Application</h1>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <form method="post" action="/login">
        <p><input type="text" name="j_username" placeholder="Username"/></p>
        <p><input type="password" name="j_password" placeholder="Password"/></p>
        <p><input type="submit" name="commit" value="Login"/></p>
    </form>
</body>
</html>
