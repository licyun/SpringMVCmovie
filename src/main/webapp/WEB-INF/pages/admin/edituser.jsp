<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 11:00
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑用户</title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/admin_header.jsp"/>
<div class="container">
    <form:form modelAttribute="user" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">name:</label>
            <div class="col-sm-4">
                <form:input path="username" id="name"/>
                <form:errors path="username"/>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">email:</label>
            <div class="col-sm-4">
                <form:input path="email" id="email"/>
                <form:errors path="email"/>
            </div>
        </div>
        <div class="form-group">
            <label for="passwd" class="col-sm-2 control-label">passwd:</label>
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
