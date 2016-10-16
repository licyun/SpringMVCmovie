<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 10:46
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <td>用户id</td>
            <td>用户头像</td>
            <td>用户邮箱</td>
            <td>用户名</td>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.imgUrl}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
