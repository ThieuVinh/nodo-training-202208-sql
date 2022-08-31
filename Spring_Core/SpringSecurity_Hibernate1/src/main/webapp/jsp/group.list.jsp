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
            <h1>Group List</h1>
            <table style="width: 40%">
                <tr>
                    <td colspan="2">
                        <form method="get" action="/group/list">
                            <input type="text" name="q">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td colspan="2">¬_¬</td>
                </tr>
                <c:forEach items="${groups}" var="item" varStatus="loop">
                    <tr>

                        <td><a href="/user/list?group=${item.id}">${item.name}</a></td>
                        <td><a href="/group/delete/${item.id}">Delete</a></td>
                        <td><a href="/group/update?id=${item.id}">Update</a></td>
                    </tr>
                </c:forEach>
            </table>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
