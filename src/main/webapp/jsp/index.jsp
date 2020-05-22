
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
        <button class="layui-btn" onclick="select()">select</button>
</body>
<style>
</style>
<script>

    function show(btn) {
       console.info("sdsads")
    }
    let  map = {
        "id": 7888888,
        "username":"sadsad",
        "password":"777887444"
    }
    function select(){
        $.ajax({
            url:'http://localhost:8080/com/selectCommon',
            type:'post',
            contentType:'application/json',
            data:JSON.stringify(map),
            success:function (data) {
                console.info(data)
            }
        })
    }

</script>
</html>
