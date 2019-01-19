<%@ page import="java.util.Date" %>
<%@ page language="java"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/common/ctx.jsp"%>
    <script src="${ctx}/js/opinion/reply.js"></script>
    <script>
        function initForm(row) {
            layui.use("form",function () {
                var form=layui.form;
                row=JSON.parse(JSON.stringify(row));
                form.val("form", row)
            });
        }
    </script>
</head>
<body>
<form action="" method="post" class="layui-form">

    <div class="layui-row">
        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">编号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="repid" id="repid"  lay-verify="title" autocomplete="off" class="layui-input" readonly="readonly">
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="svr_type" lay-verify="title" autocomplete="off" class="layui-input" readonly="readonly">
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">采用单位：</label>
                    <div class="layui-input-block">
                        <input type="text" name="repdw" lay-verify="title" autocomplete="off" class="layui-input" readonly="readonly">	</div>
                </div>
            </div>
        </div>

        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">采用时间：</label>
                    <div class="layui-input-block">
                        <input type="text" name="caidate" lay-verify="title" autocomplete="off" class="layui-input" readonly="readonly">	</div>
                </div>
            </div>
        </div>



        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">回复内容</label>
                    <div class="layui-input-block">
                        <input type="text" name="rephfnr" id="rephfnr" lay-verify="title" autocomplete="off" class="layui-input"  readonly="readonly">	</div>
                </div>
            </div>
        </div>

        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">回复单位/人</label>
                    <div class="layui-input-block">
                        <input type="text" name="repdworr" id="repdworr" lay-verify="title" autocomplete="off" class="layui-input" readonly="readonly">
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-col-xs6 ">
            <div class="grid-demo">
                <div class="layui-form-item">
                    <label class="layui-form-label">回复时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="repdate" id="repdate" value="<%=new Date().toLocaleString()%>" lay-verify="title" autocomplete="off" class="layui-input" readonly="readonly">
                    </div>
                </div>
            </div>
        </div>

    </div>
</form>
</body>
</html>
