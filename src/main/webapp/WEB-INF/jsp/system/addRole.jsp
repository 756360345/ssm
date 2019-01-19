<%@ page language="java"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/ctx.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/system/addRole.js"></script>
<title>添加用户</title>
</head>
<body>
	<form action="role_addRole.action" method="post" id="f" class="layui-form" lay-filter="f1">
		<div class="layui-form">
			<table class="layui-table">
				<tr>
					<td colspan="4" align="left"><font size="4">角色管理  >>> 添加角色</font>
						<span style="float: right;">
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="*"><i class="fa fa-check-square"></i>&nbsp;保存</button>
					</span></td>
				</tr>
				<tr>
					<td align="center" style="">角色名称:</td>
					<td>
						<input name="rolename"  type="text"  class="layui-input">
						<input name="roleid"  type="hidden"  class="layui-input">
						<div style="width: 340px;background-color: white;z-index: 99999" id="d">
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>