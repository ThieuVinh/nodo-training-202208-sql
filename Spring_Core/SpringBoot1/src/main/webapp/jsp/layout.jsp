<%--
  Created by IntelliJ IDEA.
  User: Vinh
  Date: 30/08/2022
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Trang Chủ</title>
</head>
<body>
    <table border="1" cellpadding="2" align="center">
        <tr>
            <td height="30">Welcome to java spring</td>
        </tr>
        <tr>
            <td>
                <a href="/">Trang chủ</a>
                <sec:authorize access="!hasAnyRole('ROLE_USER')">
                    <a href="/login" style="margin-left: 30px ">Đăng nhập</a>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('ROLE_USER')">
                    <a href="/nguoi-dung" style="margin-left: 30px ">Cá nhân</a>
                    <a href="/logout" style="margin-left: 30px ">Đăng xuất</a>
                </sec:authorize>

            </td>
        </tr>
    </table>
</body>
</html>
