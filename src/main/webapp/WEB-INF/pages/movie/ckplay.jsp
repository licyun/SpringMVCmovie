<%--
  User: 李呈云
  Date: 2016/10/16
  Time: 0:35
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>在线播放</title>
    <style type="text/css">body,html,div{padding: 0;margin: 0;width:100%;height:100%;}</style>
</head>
<body>
<div id="a1"></div>
<script type="text/javascript" src="<%=path%>/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript">
    var id = "${vid}";
    var type = "youku";
    var flashvars={
        f:'http://xlleyun.duapp.com/tv/tvjx.php?id='+id+'%26type='+type,
        a:encodeURIComponent(id),
        s:2,
        c:0,
        p:1
    };
    var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always',wmode:'transparent'};
    var video=['https://xlleyun.duapp.com/tv/tvjx_m.php?id=' + encodeURIComponent(id) +'&type='+type+ '&ctype=phone'];    //此处需要指定资源站类型，并标记为移动输出。
    CKobject.embed('<%=path%>/ckplayer/ckplayer.swf','a1','ckplayer_a1','100%','100%',false,flashvars,video,params);
</script>
</body>
</html>