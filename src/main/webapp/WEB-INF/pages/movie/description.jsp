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
        <h1>湄公河行动</h1>
    </div>

    <div class="row">
        <div class="col-sm-2 col-sm-offset-1">
            <img src="<%=path%>/img/p2380677316.jpg" class="img-responsive" width="160" height="200"/>
            <div class="caption">
                <h3>
                    <a href="<%=path%>/play/1" class="btn btn-primary" role="button">立即播放</a>
                </h3>
            </div>
        </div>
        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item">导演:林超贤</li>
                <li class="list-group-item">主演:张涵予 彭于晏 孙淳 陈宝国</li>
                <li class="list-group-item">类型:动作 犯罪</li>
                <li class="list-group-item">地区:中国大陆 香港</li>
                <li class="list-group-item">评分: 8分</li>
                <li class="list-group-item">语言:中文</li>
                <li class="list-group-item">上映日期:2016</li>
            </ul>
        </div>
        <div class="col-sm-6">
            剧情描述:</br>
            2011年10月5日，两艘中国商船在湄公河金三角水域遭遇袭击，13名中国船员全部遇难，泰国警方从船上搜出90万颗冰毒。
            消息传回国内，举国震惊。为了查明真相，云南缉毒总队长高刚（张涵予 饰）接受了特殊任务，率领一支骁勇善战的战斗小组进入泰国境内，
            与潜伏在泰国的情报员方新武（彭于晏 饰）碰头，二人联手深入金三角查案。经过调查，发现案件背后果然有着重重疑点，
            真正的凶手在嫁祸残害无辜中国船员后，不但逍遥法外，更意图利用毒品制造更大的阴谋……二人决定，不惜一切代价也要拿下真凶，打击毒品犯罪，为无辜国人讨回公道！
        </div>
    </div>

</div>


</body>
</html>
