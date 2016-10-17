<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 9:41
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
    <title></title>
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/header.jsp"/>
<div class="container">
    <div class="page-header">
        <h1>${video.name}</h1>
    </div>

    <div class="row">
        <div class="col-sm-2 col-sm-offset-1">
            <c:if test="${video.img != null}">
                <img src="<%=path%>/img/video/${video.img}" class="img-responsive" width="160" height="200"/>
            </c:if>
            <c:if test="${video.img == null }">
                <img src="<%=path%>/img/load.png" class="img-responsive" width="160" height="200"/>
            </c:if>
                <div class="caption">
                <h3>
                    <a href="<%=path%>/play/${video.playType}-${video.id}" class="btn btn-primary" role="button">立即播放</a>
                </h3>
            </div>
        </div>
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item">导演:${video.director}</li>
                <li class="list-group-item">主演:${video.starring}</li>
                <li class="list-group-item">类型:${video.type}</li>
                <li class="list-group-item">地区:${video.area}</li>
                <li class="list-group-item">评分:${video.score}分</li>
                <li class="list-group-item">语言:${video.language}</li>
                <li class="list-group-item">上映日期:${video.date}</li>
            </ul>
        </div>
        <div class="col-sm-6">
            剧情描述:</br>
            ${video.description}
             </div>
    </div>

</div>


</body>
</html>
