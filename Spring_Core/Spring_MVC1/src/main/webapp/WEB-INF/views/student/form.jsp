<%--
  Created by IntelliJ IDEA.
  User: Vinh
  Date: 26/08/2022
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Please Input Student Information</h2>
  <form:form method="post" action="/student/save">
    <table>
      <tr>
        <td>Name: </td>
        <td>
            <form:input type="text" path="name"/>
            <form:errors path="name"></form:errors>
        </td>
      </tr>
      <tr>
        <td>Age: </td>
        <td>
          <form:input type="number" path="age"/>
          <form:errors path="age"></form:errors>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Submit">
        </td>
      </tr>
    </table>
  </form:form>
</body>
</html>
