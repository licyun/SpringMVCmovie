<%--
  User: 李呈云
  Date: 2016/10/17
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
        <td>视频图片</td>
        <td>视频id</td>
        <td>视频名称</td>
        <td>剧情类型</td>
        <td>编辑视频</td>
        <td>删除视频</td>
        </thead>
        <c:forEach items="${videos}" var="video">
            <tr>
                <td>
                    <c:if test="${video.img != null }">
                        <img src="<%=path%>/img/video/${video.img}" width="40" height="40">
                    </c:if>
                    <c:if test=" ${video.img == null }">
                        <img src="<%=path%>/img/load.jpg">
                    </c:if>
                </td>
                <td>${video.id}</td>
                <td>${video.name}</td>
                <td>${video.type}</td>
                <td><a href="<%=path%>/admin/editvideo-${video.id}">编辑</a></td>
                <td><a href="<%=path%>/admin/deletevideo-${video.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
