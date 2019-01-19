<%--
  Created by IntelliJ IDEA.
  User: LXY
  Date: 2019-01-16
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/common/ctx.jsp"%>
    <script src="${ctx}/js/system/userAdd.js"></script>

</head>
<body>
<form action="" method="post" class="layui-form">
    <blockquote class="layui-elem-quote" style="align-content: center;">
        <button class="layui-btn layui-bg-red  layui-icon  layui-icon-chat"  id="save" lay-submit lay-filter="save"  title="保存">保存</button>
        <button type="reset" class="layui-btn layui-bg-red  layui-icon  layui-icon-chat">重置</button>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名：</label>
                    <div class="layui-input-block">
                        <input type="hidden" name="uid" id="uid"/>
                        <input type="text" name="uname" id="uname" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="realname"  lay-verify="title" autocomplete="off" class="layui-input">	</div>
                </div>
            </div>
        </div>
        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                        <input type="text" name="password" id="password" lay-verify="title" autocomplete="off" class="layui-input">	</div>
                </div>
            </div>
        </div>

    </div>
</form>

</body>
</html>
