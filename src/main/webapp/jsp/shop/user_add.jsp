<%@ page language="java" pageEncoding="utf-8" %>
<%@include file="/jsp/common/commonJs.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${basePath}/dist/layui/css/layui.css" media="all">
    <title>Title</title>
</head>
<body>
<form class="layui-form" action="" id="formTest">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:</label>
        <div class="layui-input-block">
            <input type="text" id="username" name="username" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码:</label>
        <div class="layui-input-block">
            <input type="text" id="password" name="password" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item" style="margin-right: 60px;margin-top: 40px;">
        <div class="layui-input-block" style="text-align: center;">
            <button style="width: 100px;margin-right: 20px;" class="layui-btn" lay-submit lay-filter="submitForm">确定
            </button>
        </div>
    </div>
</form>

</body>
<script>

    $(document).ready(function () {

        layui.use(['layer','form'],function () {


            var layer  = layui.layer,
                form = layui.form,
                $ = layui.jquery;


            form.on("submit(submitForm)",function (data) {
                var data = data.field;
                console.info('data---->',data)
            })


        })
    })
</script>
</html>
