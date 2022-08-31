<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Data</title>
</head>
<body>
    <tiles:insertDefinition name="template">
        <tiles:putAttribute name="body">
            <h1>User List</h1>
            <table style="width: 40%">
                <tr>
                    <td colspan="2">
                        <form method="get" action="/user/list">
                            <input type="text" name="group">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td>Password</td>
                    <td>Email</td>
                    <td>Age</td>
                    <td>Group ID</td>
                    <td colspan="2">¬_¬</td>
                </tr>
                <c:forEach items="${users}" var="item" varStatus="loop">
                    <tr>
                        <td>${item.username}</td>
                        <td>${item.password}</td>
                        <td>${item.email}</td>
                        <td>${item.age}</td>
                        <td>${item.groupId}</td>
                        <td><a href="/user/delete/${item.username}">Delete</a></td>
                        <td><a href="/user/update?username=${item.username}">Update</a></td>
                    </tr>
                </c:forEach>
            </table>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
