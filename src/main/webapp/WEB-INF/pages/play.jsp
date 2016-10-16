<%--
  User: 李呈云
  Date: 2016/10/15
  Time: 23:17
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
    <c:import url="common/inc.jsp"/>

</head>
<body>
<c:import url="common/header.jsp"/>
    <div class="container">
        <div class="page-header">
            <h1>王牌逗王牌
                <small>动作片</small>
            </h1>
        </div>

        <div class="row">
            <div class="col-sm-2">
                <img src="<%=path%>/img/p2380681527.jpg" class="img-responsive"/>
            </div>

            <div class="col-sm-3">
                <ul class="list-group">
                    <li class="list-group-item">导演</li>
                    <li class="list-group-item">主演</li>
                    <li class="list-group-item">类型</li>
                    <li class="list-group-item">语言</li>
                    <li class="list-group-item">评分</li>
                    <li class="list-group-item">上映日期</li>
                </ul>
            </div>

            <div class="col-sm-6">
               <iframe src="/ckplay-XMTc1NzA5NDE4MA==" width="100%" height="300px"></iframe>
            </div>
        </div>


        <div class="video">

        </div>
    </div>


</body>
</html>
