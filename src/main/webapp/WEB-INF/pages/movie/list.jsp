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
    <c:import url="../common/inc.jsp"/>
</head>
<body>
<c:import url="../common/header.jsp"/>
<div class="container">
    <div class="page-header">
        <h1>${type}
            <small>
                <c:if test="${type == 'free'}">
                    免费影片可直接观看
                </c:if>
                <c:if test="${type == 'user'}">
                    用户影片需登录观看
                </c:if>
                <c:if test="${type == 'vip'}">
                    会员影片需开通VIP观看
                </c:if>
                <c:if test="${type == 'vipplus'}">
                    黄金VIP需要开通黄金VIP权限
                </c:if>
            </small>
        </h1>
    </div>
    <div id="videos">
        <%--<c:forEach items="${videos}" var="video">--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<div class="thumbnail">--%>
                    <%--<img src="<%=path%>/img/video/${video.img}" width="100%" height="250" alt="${video.name}">--%>
                    <%--<div class="caption">--%>
                        <%--<h3 class="nowrap">${video.name}</h3>--%>
                        <%--<p class="nowrap">${video.starring}</p>--%>
                        <%--<p>--%>
                            <%--<a href="<%=path%>/description/${type}-${video.id}" class="btn btn-primary" role="button">--%>
                                <%--查看影片--%>
                            <%--</a>--%>
                        <%--</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
    </div>
    <div class="col-sm-12">
        <ul class="pagination">
            <li><a id="page-before" href="#!">&laquo;</a></li>
            <c:forEach begin="1" end="${pageCount}" var="v" >
                <li><a class="pages" href="#!">${v}</a></li>
            </c:forEach>
            <li><a id="page-after" href="#!">&raquo;</a></li>
        </ul>
    </div>
</div>
<script src="<%=path%>/static/pagejson.js"></script>
<script>
    $(function() {
        getjson("${type}" , 1);
    });

    //闭包循环为分页标签添加监听事件
    var pages = document.getElementsByClassName('pages');
    for (var i = 0; i < pages.length; i++) {
        (function(i){
            pages[i].onclick = function(){
                getjson("${type}" ,i+1);
            }
        })(i);
    }
    var pagebefore = document.getElementById("page-before");
    var pageafter = document.getElementById("page-after");
    var currentpage = 1;
    //上一页添加监听
    pagebefore.onclick = function(){
        if(currentpage != 1)
            currentpage = currentpage - 1;
        getjson("${type}" , currentpage);
    }
    //下一页添加监听
    pageafter.onclick = function(){
        if(currentpage != ${pageCount})
            currentpage = currentpage + 1;
        getjson("${type}" , currentpage);
    }
</script>
</body>
</html>
