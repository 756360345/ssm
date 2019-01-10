<%--
  Created by IntelliJ IDEA.
  User: LXY
  Date: 2019-01-08
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%@ include file="/common/ctx.jsp"%>
    <script type="text/javascript" src="${ctx}/js/opinion/opinionAdd.js"></script>
    <script type="text/javascript">
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#test1' //指定元素
            });
        });
    </script>


</head>

<body style="background-color: #e6ecf5">
<div class="book_con01">


    <form id="form_demo"  class="layui-form" method="post">   <p class="book_p">
        <table class="book_table" border="1" cellpadding="10">
            <tr><td colspan="4" style="text-align: center">社情民意填报内容</td>
            </tr>
            <tr>
                <td>  <label class="td_label">来稿标题</label><i class="i_start"></i>
                </td>
                <td colspan="3">
                    <input type="text" name="oplgbt"  required lay-verify="required"
                           placeholder="请输入标题" autocomplete="off" class="layui-input">
                </td>

            </tr>

            <tr><td><label class="td_label">大类</label></td>
                <td >
                    <select name="opdl" id="opdl" class="layui-select" style="width: 100%">

                     </select>
                </td>

                <td><label class="td_label">小类</label></td>
                <td>
                    <select name="opxl" id="opxl" class="layui-select" style="width: 100%">
                        <option>大类一</option>
                    </select>
                </td>

            </tr>
            <tr><td><label class="td_label">来稿人/单位</label></td>
                <td >
                    <input type="text" name="oplgrordw"  required lay-verify="required"
                           placeholder="请输入来稿人" autocomplete="off" class="layui-input">
                </td>

                <td><label class="td_label">联系电话</label></td>
                <td>

                    <input type="text" name="optel"  required lay-verify="required"
                           placeholder="请输入联系方式" autocomplete="off" class="layui-input">
                </td>

            </tr>
            <tr> <td><label class="td_label">报送人身份</label></td>
                <td >
                    <select name="opbsrsf" class="layui-select" style="width: 100%">

                    </select>
                </td>
                <td><label class="td_label">报送时间</label></td>
                <td>
                    <div class="layui-inline" style="width: 100%"> <!-- 注意：这一层元素并不是必须的 -->
                        <input type="text" placeholder="请选择日期时间" required lay-verify="required"
                               name="opbssj" class="layui-input" id="test1">
                    </div>
                </td>

            </tr>
            <tr> <td><label class="td_label">报送人</label></td>
                <td colspan="3">
                    <input type="text" name="opbsr"  required lay-verify="required"
                           placeholder="请输入报送人" autocomplete="off" class="layui-input">
                </td>
            </tr>
            <tr><td><label class="td_label">签发领导</label></td>
                <td>
                    <input type="text" name="opqfld"  required lay-verify="required"
                           placeholder="请输入" autocomplete="off" class="layui-input">
                </td>

                <td><label class="td_label">是否公开</label></td>
                <td>
                    <div class="layui-input-block" style="margin-left: 45px">
                        <input type="radio" name="pub" value="1" title="男" checked>
                        <input type="radio" name="pub" value="2" title="女" >
                    </div>
                </td>

            </tr>


            <tr>
                <td><label class="td_label">具体内容</label></td><td colspan="3">
                <textarea  class="textArae" name="opjtnr" id="editor" ></textarea>
            </td>

            </tr>

            <tr ><td>
                <label class="td_label">附件</label>
            </td>
                <td colspan="5">
        <p><label class="td_label">文件1</label><input type="file" value="选择文件"/></p>
        <p><label class="td_label">文件2</label><input type="file" value="选择文件"/> </p>
        <p><label class="td_label">文件3</label><input type="file" value="选择文件"/></p>
        <p><label class="label_red">附件总大小不能超过200M，超过限制,将不能发送</label></p>
        </td>

        </tr>


        </table>
        </p>
        <p class="book_foot"><button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button></form>
</div>



</body>
</html>

