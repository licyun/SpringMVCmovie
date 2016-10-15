<%--
  User: 李呈云
  Date: 2016/10/15
  Time: 11:30
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>mybatis test</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form:form modelAttribute="user" method="post" role="form">
    <div class="form-group">
        <label>name</label>
        <form:input path="username"/>
    </div>
    <div class="form-group">
        <label>password</label>
        <form:input path="password"/>
    </div>
    <div class="form-group">
        <input type="submit" value="提交">
    </div>
</form:form>
</body>
</html>
