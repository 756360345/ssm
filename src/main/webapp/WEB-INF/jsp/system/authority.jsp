<%@ page language="java"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/ctx.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="${ctx}/js/system/authority.js"></script>
	<title>权限管理</title>
	<style type="text/css">
		.layui-table-view .layui-form-radio>i {
			margin-top:15px;
			font-size: 20px;
		}
	</style>
	<script type="text/javascript" src="js/layui/layui-xtree.js"></script>
</head>
<body>
<script type="text/html" id="toolbarDemo">
	<div class="layui-btn-container">
		<button id="add" lay-event="add" class="layui-btn layui-btn-sm ">
			<i class="layui-icon">&#xe654;</i>    添加
		</button>
		<button id="edit" lay-event="edit" class="layui-btn layui-btn-warm layui-btn-sm">
			<i class="layui-icon">&#xe642;</i> 编辑
		</button>
		<button id="del" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">
			<i class="layui-icon">&#xe640;</i> 删除
		</button>
	</div>
</script>
<div>
	<div style="width: 50%;">
		<table id="tb" lay-filter="tb" style=""></table>
	</div>
	<div style="width: 38%;margin-left: 780px;margin-top: -21px;margin-top: -514px;">
		<button style="margin-left: 50px;" id="save"  class="layui-btn layui-btn-sm ">
			<i class="layui-icon">&#xe654;</i> 保存
		</button>
		<form class="layui-form">
			<div id="xtree3" style="margin-left: -115px" class="xtree_contianer"></div>
			<input type="hidden" name="roleId" value="0">
			<ul id="demo"></ul>
		</form>
	</div>
</div>

</body>
</html>