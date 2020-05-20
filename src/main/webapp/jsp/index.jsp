
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/jsp/common/commonJs.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>xxx</title>
</head>
<script type="text/javascript" src="${basePath}/dist/js/jquery.min.js"></script>
<body>
<form class="layui-form">
    <button class="layui-btn" onclick="show(this)"></button>
</form>
</body>
<style>
    .layui-layer-btn{
        text-align: center;

    }
</style>
<script>
    $(function () {
        $(".layui-form").closest(".layui-form-item").css({"color":"red","border":"2px solid red"});
    })

    function show(btn) {

    }

    layui.use(['form','layer','laydate','laytpl'],function () {
        var laydate = layui.laydate;
        var laytpl = layui.laytpl;
        var form = layui.form;
        var layer = layui.layer;


        layer.confirm('is not?', {icon: 3, btn:['<div id="btn" class="layui-layer-btn btn" style="width: 220px;" >确定</div>']},
            function(index){
            console.info("true")
          },function (index) {
                console.info("false")
            }

        );



    })

  



</script>
</html>
