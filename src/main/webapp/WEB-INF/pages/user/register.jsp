<%--
  User: 李呈云
  Date: 2016/10/15
  Time: 21:00
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/header.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h1 class="col-sm-offset-4">用户注册</h1>
        <form:form modelAttribute="user" method="post" class="form-horizontal" role="form">
            <div class="form-group">
                <label class="col-sm-offset-2 col-sm-2 control-label">用户名</label>
                <div class="col-sm-4">
                    <form:input path="username" class="form-control"/>
                    <form:errors path="username"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-offset-2 col-sm-2 control-label">邮箱</label>
                <div class="col-sm-4">
                    <form:input type="email" path="email" class="form-control"/>
                    <form:errors path="email"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-offset-2 col-sm-2 control-label">密码</label>
                <div class="col-sm-4">
                    <form:password path="password" class="form-control"/>
                    <form:errors path="password"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-4">
                    <input type="submit" class="btn btn-primary btn-lg" role="button" value="注册"/>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
