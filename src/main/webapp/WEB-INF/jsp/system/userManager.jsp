<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%@include file="/common/ctx.jsp" %>
<title>Insert title here</title>
<script type="text/javascript" src="${ctx}/js/system/userManger.js"></script>
</head>
<body>
<form class="layui-form" action="">
   <div class="layui-row">
    <div class="layui-col-xs3">
      <div class="grid-demo grid-demo-bg1">
       <div class="layui-form-item">
						<label class="layui-form-label">用户名称</label>
						<div class="layui-input-block">
							<input type="text" name="uname"
								placeholder="请输入用户名称" autocomplete="off" class="layui-input">
						</div>
					</div>
      </div>
    </div>
    <div class="layui-col-xs3">
      <div class="grid-demo">
        <div class="layui-form-item">
						<label class="layui-form-label">用户角色</label>
						<div class="layui-input-block">
							<select name="usr_role_id" id="usr_role_id"></select>
						</div>
					</div>
      </div>
    </div>
    <div class="layui-col-xs3">
      <div class="grid-demo">
        &nbsp;&nbsp;&nbsp;    <button class="layui-btn layui-bg-red  layui-icon  layui-icon-chat" lay-submit lay-filter="query" title="查询">查询</button>
 &nbsp;&nbsp;&nbsp;
      <a class="layui-btn" id="add" lay-event='add' ><i class="layui-icon layui-icon-add-1"></i>添加用户</a>
      </div>
    </div>
  </div>
</form>

<table class="layui-hide" id="test" lay-filter="test"></table>




</body>
</html>