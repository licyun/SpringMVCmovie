<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 10:46
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
    <title>添加视频</title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/admin_header.jsp"/>
<div class="container">
    <table class="table">
        <thead>
            <td>用户头像</td>
            <td>用户id</td>
            <td>用户邮箱</td>
            <td>用户名</td>
            <td>编辑用户</td>
            <td>删除用户</td>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    <c:if test="${user.imgUrl != null }">
                        <img src="<%=path%>/img/user/${user.imgUrl}" width="40" height="40">
                    </c:if>
                    <c:if test=" ${user.imgUrl == null }">
                        <img src="<%=path%>/img/nopic.png">
                    </c:if>
                </td>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td><a href="<%=path%>/admin/edituser-${user.id}">编辑</a></td>
                <td><a href="<%=path%>/admin/deleteuser-${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
