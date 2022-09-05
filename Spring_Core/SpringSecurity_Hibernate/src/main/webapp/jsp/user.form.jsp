<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Add User</h1>
        <form:form method="post" action="/user/save">
            Username <form:input type="text" path="username" name="username"/> <br><br>
            Password <form:input type="password" path="password" name="password"/> <br><br>
            Email <form:input type="text" path="email" name="email"/> <br><br>
            Age <form:input type="text" path="age" name="age"/> <br><br>
            Group <form:select path="groupId" id="group" name="group">
                <form:options items="${groups}" />
            </form:select>
            <p class="submit">
                <input type="submit" name="add" value="Add">
            </p>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>