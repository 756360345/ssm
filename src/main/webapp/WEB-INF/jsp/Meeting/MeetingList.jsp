
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/common/ctx.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/meeting/meetingList.js"></script>
<body>
<div class="layui-row   layui-col-space15">
    <div class="layui-col-sm6 layui-col-md4">
        <label class="layui-form-label">会议名称</label>
        <div class="layui-input-block">
            <input type="text" name="meename"  autocomplete="off" placeholder="请输入会议名称" class="layui-input">
        </div>
    </div>
    <div class="layui-col-sm6 layui-col-md4">
        <label class="layui-form-label">会议主题</label>
        <div class="layui-input-block">
            <input type="text" name="meezt" autocomplete="off" placeholder="请输入会议主题" class="layui-input">
        </div>
    </div>
    <div class="layui-col-md4">
        <div class="layui-form-item">
            <label class="layui-form-label">会议层次</label>
            <div class="layui-input-block" lay-verify="required">
                <select name="meecc" lay-verify="required" class="layui-select">
                </select>
            </div>
        </div>
    </div><br>
    <div class="layui-col-sm6 layui-col-md4">
    <label class="layui-form-label">会议承办者</label>
    <div class="layui-input-block">
        <input type="text" name="meecbz"  autocomplete="off" placeholder="请输入会议承办者" class="layui-input">
    </div>
</div>
    <div class="layui-col-sm6 layui-col-md4">
        <label class="layui-form-label">召开时间</label>
        <div class="layui-input-block">
            <input type="date" name="meezksj"  autocomplete="off" placeholder="请输入召开时间" class="layui-input">
        </div>
    </div>
    <div class="layui-col-sm6 layui-col-md4">
        <label class="layui-form-label">召开地点</label>
        <div class="layui-input-block">
            <input type="text" name="meeaddress"  autocomplete="off" placeholder="请输入召开地点" class="layui-input">
        </div>
    </div><br>
    <div class="layui-col-sm6 layui-col-md4">
        <label class="layui-form-label">会议联系人</label>
        <div class="layui-input-block">
            <input type="text" name="meelxr"  autocomplete="off" placeholder="会议联系人" class="layui-input">
        </div>
    </div>
    <div class="layui-col-sm6 layui-col-md4">
        <label class="layui-form-label">参加人</label>
        <div class="layui-input-block">
            <input type="text" name="meecjry"  autocomplete="off" placeholder="请输入参加人" class="layui-input">
        </div>
    </div>
    <div class="layui-col-sm6 layui-col-md4">
        <label class="layui-form-label">联系人电话</label>
        <div class="layui-input-block">
            <input type="text" name="meecjry"  autocomplete="off" placeholder="请输入联系人电话" class="layui-input">
        </div>
    </div>

</div>
<div class="layui-row layui-col-space15" style="margin-right: fill">
    <div class="layui-col-md4">
        <button class="layui-btn  layui-btn-normal layui-icon  layui-icon-search"
                lay-filter="query" lay-submit>查询</button>
        <button class="layui-btn  layui-btn-normal layui-icon  layui-icon-refresh"
                lay-filter="reset" lay-submit>重置</button>
    </div>
</div>
</form>

<script type="text/html" id="barDemo">
    <a  lay-event="querySingle" title="查看详情"><i class="fa fa-edit fa-2x"></i></a>
</script>
<table class="layui-hide" id="test" lay-filter="test"></table>
</body>
</html>
</body>
</html>
