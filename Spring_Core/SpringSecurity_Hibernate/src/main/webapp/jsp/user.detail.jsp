<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>User</h1>
        <p>Tài khoản: ${users.username}</p>
        <p>Mật khẩu: ${users.password}</p>
        <p>Email: ${users.email}</p>
        <p>Tuổi: ${users.age}</p>
        <p>Nhóm: ${users.group}</p>
    </tiles:putAttribute>
</tiles:insertDefinition>
