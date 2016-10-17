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
    <c:import url="../common/inc.jsp"/>

</head>
<body>
<c:import url="../common/header.jsp"/>
    <div class="container">
        <div class="page-header">
            <h1>${video.name}
                <small>${video.type}</small>
            </h1>
        </div>

        <div>
           <iframe src="/ckplay/${video.playType}-${video.vid}" width="100%" height="350"></iframe>
        </div>

    </div>
</body>
</html>
