<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>迅雷影院在线播放</title>
    <style type="text/css">body,html,div{padding: 0;margin: 0;width:100%;height:100%;}</style>
</head>
<body>
<div id="a1"></div>
<script type="text/javascript" src="/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript">
    var purl='../bt/ykyun.php?v=<?php echo $id ?>_ckxml';
    var murl='../bt/ykyun.php?v=<?php echo $id ?>_mobile';
    var flashvars={
        f:purl, //url 模式
        c:0,//调用ckplayers.js
        s:2,//XML(网址)形式调用
        p:1,//默认播放
        b:1//是否允许js和播放器交互
    };
    var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always',wmode:'transparent'};
    var isiPad = navigator.userAgent.match(/iPad|iPhone|Linux|Android|iPod/i) != null;
    if (isiPad) {
        document.getElementById('a1').innerHTML = '<video src="'+murl+'" controls="controls" autoplay="autoplay" width="100%" height="220"></video>'
    }else{
        CKobject.embedSWF('/ckplayer/ckplayer.swf','a1','ckplayer_a1','100%','100%',flashvars,params);
    }
</script>
</body>
</html>