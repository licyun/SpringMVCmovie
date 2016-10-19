

//用ajax获取分页json数据type为视频类型 i 为第几页
function getjson(type, i) {
    $.ajax( {
        type : "get",
        url : "../jsonPage-" + type + "-" + i,
        dataType:"json",
        success : function(jsondata) {
            $("#videos").empty();
            var data=eval(jsondata);    //解析json
            var length = data.length;   //json对象数
            for(var i =0; i < length; i++){
                //img不存在时调用默认图片
                if(data[i].img == null){
                    data[i].img = "../img/nopic.jpg";
                }else{
                    data[i].img = "../img/video/" + data[i].img;
                }
                //循环添加div
                var html =
                    "<div class='col-sm-6 col-md-3'>" +
                        "<div class='thumbnail'>"     +
                        "<img src='"+ data[i].img +"' width='100%' height='250' alt='"+ data[i].name +"'>" +
                            "<div class='caption'>" +
                                "<h3 class='nowrap'>"+ data[i].name +"</h3>" +
                                "<p class='nowrap'>"+ data[i].type +"</p>" +
                                "<p>" +
                                    "<a href='../description/"+ type + "-" + data[i].id +"' class='btn btn-primary' role='button'>" +
                                    "查看影片" +
                                    "</a>" +
                                "</p>" +
                            "</div>" +
                        "</div>" +
                    "</div>";
                $("#videos").append(html);
            }
        }
    });
    //记录当前页，为上一页和下一页做准备
    currentpage = i;
}