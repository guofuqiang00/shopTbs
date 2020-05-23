<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${basePath}/dist/layui/css/layui.css"  media="all">

    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <style>
        .layui-form-label  {
            text-align: left !important;
            width:80px;
        }
        .layui-input-block {
            margin-left: 110px;
        }
    </style>
</head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<body>

<div class="productTable">
    商品名称：
    <form class="layui-form">
        <div class="layui-inline">
            <input class="layui-input" name="productName" id="productReload" autocomplete="off">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><i>*</i>开始时间:</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" style="width: 220px" placeholder="年月日时分秒"   name="startTime" id="startTime"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><i>*</i>结束时间:</label>
            <div class="layui-input-block">
                <input   type="text" class="layui-input" style="width: 220px" placeholder="年月日时分秒"   name="endTime" id="endTime"/>
            </div>
        </div>
    </form>
    <button class="layui-btn" data-type="reload">搜索</button>
    <button class="layui-btn layui-btn-normal" data-type="addProduct">新增</button>
    <button class="layui-btn layui-btn-warm" data-type="changeProduct">修改</button>
    <button class="layui-btn layui-btn-danger" data-type="deleteProduct">删除</button>
</div>

<table class="layui-hide" id="LAY_table_product" lay-filter="product">

</table>


<script src="${basePath}/dist/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    $(document).ready(function () {
        layui.use(['table','laydate'], function(){
            var table = layui.table;

            //日期
            laydate = layui.laydate;
            //执行一个laydate实例
            var nowTime = new Date().getTime();
            laydate.render({
                elem: '#startTime', //指定元素
                format:'yyyy-MM-dd HH:mm:ss',
                min: new Date().getTime(),
                type:'datetime',
                done:function (value) {
                    var endDate = new Date($('#endTime').val()).getTime();
                    var startDate = new Date(value).getTime();
                    if (startDate >= endDate) {
                        layer.msg('开始时间不能大于等于结束时间', {
                            icon: 2,
                            time: 2000
                        });
                        $('#startTime').val($('#endTime').val());
                    }

                }
            });
            <!-- 结束时间 -->
            laydate.render({
                elem: '#endTime',
                type: 'datetime',
                min:new Date().getTime(),
                done: function (value) {
                    var startDate = new Date($('#startTime').val()).getTime();
                    var endDate = new Date(value).getTime();
                    if (endDate <= startDate) {
                        layer.msg('结束时间不能小于等于开始时间', {
                            icon: 2,
                            time: 2000
                        });
                        $('#endTime').val($('#startTime').val());
                    }
                }
            });

            //方法级渲染
            table.render({
                elem: '#LAY_table_product'
                ,url: '${pageContext.request.contextPath}/product/jsonProducts/'
                ,cols: [[
                    {checkbox: true, fixed: true}
                    ,{field:'productname', title: '商品名称', width:'50%', fixed: true}
                    ,{field:'cteatetime', title: '进货日期', width:'50%',fixed: true}
                ]]
                ,id: 'productReload'
                ,page: true

            });

            var $ = layui.$, active = {
                //拦截按钮
                reload: function(){
                    reloadTab();
                }
                ,addProduct: function(){
                    layer.open({
                        type: 1
                        ,title: '新增'
                        ,area: '500px'
                        ,content: $('#productAddTab') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                        ,btn: ['提交']
                        ,yes:function() {
                            $.ajax({
                                type: "POST",//方法类型
                                dataType: "html",//预期服务器返回的数据类型
                                url: "${pageContext.request.contextPath}/product/save" ,//url
                                data: $('#productForm').serialize(),
                                success: function (date) {
                                    console.log(date);//打印服务端返回的数据(调试用)
                                    if (date== "success") {
                                        layer.msg("操作成功",{
                                            icon:1
                                        })
                                        reloadTab();
                                    }
                                    if (date == "error") {
                                        layer.msg("操作失败",{
                                            icon:7
                                        })
                                    }
                                    layer.close(layer.index-1);

                                },
                                error : function() {
                                    layer.msg("异常！",{
                                        icon:7
                                    });
                                    layer.close(layer.index-1);
                                }
                            });

                        }
                    });
                }
                ,changeProduct: function(){ //获取选中数据
                    var checkStatus = table.checkStatus('productReload')
                        ,data = checkStatus.data;
                    if (data.length!=1) {
                        layer.msg("请选择一条数据进行编辑",{
                            icon:7
                        })
                    }else {
                        $("#productkey").val(data[0].productkey);
                        $("#createtime").val(data[0].createtime);
                        $("#productname").val(data[0].productname);
                        layer.open({
                            type: 1
                            ,title: '修改'
                            ,content: $('#productAddTab') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                            ,btn: ['提交']
                            ,yes:function() {
                                $.ajax({
                                    type: "POST",//方法类型
                                    dataType: "html",//预期服务器返回的数据类型
                                    url: "${pageContext.request.contextPath}/product/save" ,//url
                                    data: $('#productForm').serialize(),
                                    success: function (date) {
                                        if (date== "success") {
                                            layer.msg("操作成功",{
                                                icon:1
                                            })
                                            reloadTab()
                                        }
                                        if (date == "error") {
                                            layer.msg("操作失败",{
                                                icon:7
                                            })
                                        }
                                        layer.close(layer.index-1);

                                    },
                                    error : function() {
                                        layer.msg("异常！",{
                                            icon:7
                                        });
                                        layer.close(layer.index-1);
                                    }
                                });

                            }
                        });
                    }
                }
                ,deleteProduct: function(){ //获取选中数据
                    var chk_value=[];
                    var checkStatus = table.checkStatus('productReload')
                        ,data = checkStatus.data;
                    data.forEach(function(v,i,arr){
                        chk_value.push(v.productkey);
                    });
                    if (data.length<1) {
                        layer.msg("请至少选择一条数据进行删除",{
                            icon:7
                        })
                    }else {
                        layer.confirm('确定删除数据？', {
                            btn: ['删除','取消'] //按钮
                        }, function(){
                            $.ajax({
                                type: "POST",//方法类型
                                dataType: "html",//预期服务器返回的数据类型
                                url: "${pageContext.request.contextPath}/product/delete?ids="+chk_value ,//url
                                success: function (date) {
                                    console.log(date);//打印服务端返回的数据(调试用)
                                    if (date== "success") {
                                        layer.msg("删除成功",{
                                            icon:1
                                        })
                                        reloadTab()
                                    }
                                    if (date == "error") {
                                        layer.msg("删除失败",{
                                            icon:7
                                        })
                                    }
                                    layer.close(layer.index-1);

                                },
                                error : function() {
                                    layer.msg("删除异常！",{
                                        icon:7
                                    });
                                    layer.close(layer.index-1);
                                }
                            });
                        }, function(){
                            layer.closeAll();
                        });

                    }
                }
            };

            $('.productTable .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
            function reloadTab() {
                var productReload = $('#productReload');
                //执行重载
                table.reload('productReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        productname: productReload.val()
                    }
                });
            }
        });
    })

</script>
<div id="productAddTab" style="padding: 10px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;display: none;">
    <form method="post" class="layui-form" id="productForm">
        <input  id="productkey" name="productkey" type="hidden"  />
        <input  id="cteatetime" name="cteatetime" type="hidden"  />
        <div class="layui-form-item">
            <label class="layui-form-label" sytle="text-align:left">商品名称:</label>
            <div class="layui-input-block">
                <input type="text" id="productname" name="productname"  autocomplete="off"  class="layui-input" >
            </div>
        </div>

    </form>
</div>
</body>

</html>