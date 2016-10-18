<%--
  User: 李呈云
  Date: 2016/10/15
  Time: 21:00
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
        <h1>
            <shiro:hasRole name="vip">
                用户[<shiro:principal/>]是VIP用户,能观看vip电影<br/>
            </shiro:hasRole>
            <shiro:lacksRole name="vip">
                用户[<shiro:principal/>]不是vip用户,不能观看vip电影<br/>
            </shiro:lacksRole>
            <shiro:hasPermission name="user:vipplus">
                用户[<shiro:principal/>]拥有点播权限,能观看点播电影<br/>
            </shiro:hasPermission>
            <shiro:lacksPermission name="user:vipplus">
                用户[<shiro:principal/>]没有点播权限,不能观看点播电影<br/>
            </shiro:lacksPermission>
            <small>开通权限请联系管理员</small>
        </h1>
    </div>
    <div class="row">
        <div class="col-sm-3 col-sm-offset-1">
            <c:if test="${user.imgUrl == null}">
                <img src="<%=path%>/img/nopic.jpg" width="100" height="100"/>
            </c:if>
            <c:if test="${user.imgUrl != null}">
                <img src="<%=path%>/img/user/${user.imgUrl}" width="100" height="100"/>
            </c:if>
            <div>
                <a href="<%=path%>/user/editimg-${user.id}" class="btn btn-primary">修改头像</a>
            </div>
        </div>
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item">用户id:${user.id}</li>
                <li class="list-group-item">用户名:${user.username}</li>
                <li class="list-group-item">用户邮箱:${user.email}</li>
                <li class="list-group-item">
                    <a href="<%=path%>/user/edituser-1" class="btn btn-primary">修改个人信息</a>
                </li>
            </ul>
        </div>
    </div>



</div>
</body>
</html>
