<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 11:00
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
    <title>编辑用户</title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/admin_header.jsp"/>
<div class="container">
    <form:form modelAttribute="userPR" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">用户名:</label>
            <div class="col-sm-4">
                <form:input path="name" id="name"/>
                <form:errors path="name"/>
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
            <label for="password" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-4">
                <form:input path="password" id="passwd"/>
                <form:errors path="password"/>
            </div>
        </div>
        <div class="form-group">
            <label for="userRole" class="col-sm-2 control-label">角色:</label>
            <div class="col-sm-4">
                <input type="radio" name="userRole" value="user"
                       <c:if test="${userPR.userRole == 'user'}">checked</c:if> >user
                <input type="radio" name="userRole" value="vip"
                       <c:if test="${userPR.userRole == 'vip'}">checked</c:if> >vip
                <form:errors path="userRole"/>
            </div>
        </div>
        <div class="form-group">
            <label for="userPermission" class="col-sm-2 control-label">权限:</label>
            <div class="col-sm-4">
                <input type="radio" name="userPermission" value="user:user"
                       <c:if test="${userPR.userPermission == 'user:user'}">checked</c:if> >user
                <input type="radio" name="userPermission" value="user:vipplus"
                       <c:if test="${userPR.userPermission == 'user:vipplus'}">checked</c:if> >vipplus
                <form:errors path="userPermission"/>
            </div>
        </div>
        <div class="form-group">
            <input type="submit" class="col-sm-offset-2 btn-default btn" value="提交修改">
        </div>
    </form:form>
</div>
</body>
</html>
