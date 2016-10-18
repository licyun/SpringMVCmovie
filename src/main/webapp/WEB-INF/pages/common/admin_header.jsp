<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 11:03
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%=path%>/admin/index/">用户管理</a>
            <a class="navbar-brand" href="<%=path%>/admin/videos">视频管理</a>
            <a class="navbar-brand" href="<%=path%>/admin/addvideo">添加视频</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=path%>/user/loginout"><span class="glyphicon glyphicon-log-in"></span> 退出登录</a></li>
        </ul>
    </div>

</nav>