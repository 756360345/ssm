<%--
  Created by IntelliJ IDEA.
  User: LXY
  Date: 2019-01-10
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/ctx.jsp"%>
    <script src="${ctx}/js/opinion/opinion.js"></script>
</head>
<body>
<form class="layui-form" id="ff">
    <%--第一行条件查询--%>
    <div class="layui-row   layui-col-space15">
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <label class="layui-form-label">标题：</label>
            <div class="layui-input-block" style="width: 250px">
                <input type="text" name="oplgbt" autocomplete="off" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="margin-left: -60px">
            <label class="layui-form-label">分类：</label>
            <div class="layui-input-block" style="width: 250px">
                    <select name="opbsrsf"  id="opbsrsf" lay-filter="svr_status">
                    </select>

            </div>
        </div>
        <div class="layui-col-xs4 layui-col-sm12 layui-col-md4" style="margin-left: -60px">
            <div class="layui-form-item">
                <label class="layui-form-label">提交人</label>
                <div class="layui-input-block" style="width: 250px">
                    <input type="text" name="optjr" autocomplete="off" placeholder="请输入" class="layui-input">
                    </select>
                </div>
            </div>
        </div>
    </div>
        <%--第二行条件查询--%>
    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" >
            <label class="layui-form-label">来稿时间</label>
            <div class="layui-input-block" style="width: 400px;" >
                <div style="width: 120px;">
                    <input type="text" name="start" id="start"  placeholder="请选择" class="layui-input">
                </div>
                <div style="width: 120px;margin-left:120px;margin-top: -30px">
                    <label>--</label>
                </div>
                <div style="width: 120px;margin-left:130px; margin-top: -30px">
                    <input type="text" name="end" id="end"  placeholder="请选择" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4"  style="margin-left: -60px">
            <div class="layui-form-item" >
                <label class="layui-form-label">反映人：</label>
                <div class="layui-input-block" style="width: 250px">
                    <input type="text" name="opbsr" autocomplete="off" placeholder="请输入" class="layui-input">

                </div>
            </div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4"  style="margin-left: -60px">
            <div class="layui-form-item">
                <label class="layui-form-label">民意编号：</label>
                <div class="layui-input-block" style="width: 250px">
                    <input type="text" name="opid" autocomplete="off" placeholder="请输入" class="layui-input">

                </div>
            </div>
        </div>
    </div>
    <%--第三行条件查询--%>
    <div class="layui-row   layui-col-space15">
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <label class="layui-form-label">单位类型：</label>
            <div class="layui-input-block" style="width: 250px">
                <select name="opdwtype"  id="opdwtype">
                </select>
            </div>
        </div>

        <div class="layui-col-xs4 layui-col-sm12 layui-col-md4"  style="margin-left: -60px">
            <div class="layui-form-item">
                <label class="layui-form-label">稿件状态</label>
                <div class="layui-input-block" style="width: 250px">
                    <select name="opltype"    lay-filter="cust_region">
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" >
            <button type="button" id="btn" class="layui-btn  layui-btn-normal layui-icon  layui-icon-search"
                    lay-filter="query" lay-submit>查询</button>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="margin-left: 900px;margin-top: -69px">
            <button type="reset"  class="layui-btn  layui-btn-normal layui-icon  layui-icon-close"
                    lay-submit>重置</button>
        </div>
    </div>

</form>

<table class="layui-hide" id="test" lay-filter="test"></table>

</body>
</html>
