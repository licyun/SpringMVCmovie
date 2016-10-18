<%--
  User: 李呈云
  Date: 2016/10/14
  Time: 21:16
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>movie</title>
    <c:import url="common/inc.jsp"/>
</head>
<body>
<c:import url="common/header.jsp"/>
<div class="container">
        <div>
            <c:forEach items="${videos}" var="video">
                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <img src="<%=path%>/img/video/${video.img}" width="100%" height="250" alt="${video.name}">
                        <div class="caption">
                            <h3 class="nowrap">${video.name}</h3>
                            <p class="nowrap">${video.starring}</p>
                            <p>
                                <a href="<%=path%>/description/free-${video.id}" class="btn btn-primary" role="button">
                                    查看影片
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>


</body>
</html>
