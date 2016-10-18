<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 11:35
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/user_header.jsp"/>
<div class="container">
    <form:form modelAttribute="user" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">用户名:</label>
            <div class="col-sm-4">
                <form:input path="username" id="name"/>
                <form:errors path="username"/>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">邮箱:</label>
            <div class="col-sm-4">
                <form:input type="email" path="email" id="email"/>
                <form:errors path="email"/>
            </div>
        </div>
        <div class="form-group">
            <label for="passwd" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-4">
                <form:input path="password" id="passwd"/>
                <form:errors path="password"/>
            </div>
        </div>
        <div class="form-group">
            <input type="submit" class="col-sm-offset-2 btn-default btn" value="提交修改">
        </div>
    </form:form>
</div>
</body>
</html>
