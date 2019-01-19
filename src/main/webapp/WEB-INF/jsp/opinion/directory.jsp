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
    <script src="${ctx}/js/opinion/directory.js"></script>
</head>
<body>
<form class="layui-form" id="ff">
    <%--第一行条件查询--%>
    <div class="layui-row   layui-col-space15">
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <label class="layui-form-label">采用稿编号：</label>
            <div class="layui-input-block" style="width: 200px">
                <input type="text" name="repid" autocomplete="off" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="margin-left: -120px;">
            <label class="layui-form-label">采用稿名称：</label>
            <div class="layui-input-block" style="width: 200px">
                <input type="text" name="repname" autocomplete="off" placeholder="请输入" class="layui-input">
            </div>
        </div>
        <div class="layui-col-xs4 layui-col-sm12 layui-col-md4" style="margin-left: -120px">
            <div class="layui-form-item" >
                <label class="layui-form-label">单位类型</label>
                <div class="layui-input-block" style="width: 200px">
                    <select name="repdw"   lay-filter="svr_status">
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="margin-left: 960px;margin-top: -72px">
            <button type="button" id="btn" class="layui-btn  layui-btn-normal layui-icon  layui-icon-search"
                    lay-filter="select" lay-submit>查询</button>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4" style="margin-left: 1060px;margin-top: -72px">
            <button type="reset"  class="layui-btn  layui-btn-normal layui-icon  layui-icon-close"
                    lay-submit>重置</button>
        </div>
    </div>
    </div>
</form>

<table class="layui-hide" id="test" lay-filter="test"></table>

</body>
</html>
