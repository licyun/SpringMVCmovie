<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 11:35
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
    <title>修改图片</title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/user_header.jsp"/>
<div class="container">
    <div class="user-left">
        <c:if test="${user.imgUrl == null}">
            <img src="<%=path%>/img/nopic.jpg" width="100" height="100">
        </c:if>
        <c:if test="${user.imgUrl != null}">
            <img src="<%=path%>/img/${user.imgUrl}" width="100" height="100">
        </c:if>
    </div>
    <div class="user-right">
        <form method="POST" action="<%=path%>/user/editimg-{uid}" enctype="multipart/form-data" role="form">
            <div class="form-group">
                <label>目前头像</label>
                <input type="file" name="file"><br />
            </div>
            <div class="form-group">
                <input type="submit" value="提交修改">
            </div>
        </form>
    </div>
</div>
</body>
</html>
