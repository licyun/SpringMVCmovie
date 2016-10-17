<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%=path%>/">视频站</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="<%=path%>/list/free">免费影片</a></li>
                <li><a href="<%=path%>/list/user">用户影片</a></li>
                <li><a href="<%=path%>/list/vip">会员影片</a></li>
                <li><a href="<%=path%>/list/vipplus">点播影片</a></li>
            </ul>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 用户中心</a></li>
        </ul>
    </div>
</nav>