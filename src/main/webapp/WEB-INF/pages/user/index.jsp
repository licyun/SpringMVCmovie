<%--
  User: 李呈云
  Date: 2016/10/15
  Time: 21:00
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户首页</title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/user_header.jsp"/>
<div class="container">
    <div class="page-header">
        <h1>您还不是vip用户
            <small>开通vip请联系管理员</small>
        </h1>
    </div>
    <div class="row">
        <div class="col-sm-3 col-sm-offset-1">
            <img src="<%=path%>/img/nopic.jpg">
            <div>
                <a href="<%=path%>/user/editimg-1" class="btn btn-primary">修改头像</a>
            </div>
        </div>
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item">用户id:</li>
                <li class="list-group-item">用户名:</li>
                <li class="list-group-item">用户邮箱:</li>
                <li class="list-group-item">
                    <a href="<%=path%>/user/edituser-1" class="btn btn-primary">修改个人信息</a>
                </li>
            </ul>
        </div>
    </div>



</div>
</body>
</html>
