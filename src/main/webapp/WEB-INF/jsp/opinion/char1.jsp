<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="/common/ctx.jsp"%>
<script src="${ctx}/js/highcharts/highcharts.js"></script>
<script src="${ctx}/js/highcharts/exporting.js"></script>
<script src="${ctx}/js/highcharts/highcharts-zh_CN.js"></script>
<script src="${ctx}/js/opinion/char1.js">

</script>
<script>
    layui.use('form', function() {
        var form = layui.form;
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#start'
        });
        laydate.render({
            elem: '#end'
        });
    });
</script>
<body>
<div class="layui-container layui-form" style="margin-top: 10px;">

    <div class="layui-row layui-col-space0">
        <div class="layui-inline">
            <label class="layui-form-label">统计时间：</label>
            <div class="layui-input-inline">
                <input type="text" autocomplete="off" class="layui-input" name="start" id="start" placeholder="请选择" style="width: 120px;">
            </div>
            <label>----</label>
            <div class="layui-input-inline">
                <input type="text" autocomplete="off" class="layui-input" name="end" id="end" placeholder="请选择" style="width: 120px;">
            </div>
        </div>
        <button
                class="layui-btn layui-btn-sm layui-btn-radius layui-btn-radius"
                id="btn">
            <i class="layui-icon">&#xe615;</i>查询
        </button>
    </div>

</div>

<div id="container" style="min-width:400px;height:400px"></div>
</body>
</html>