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

</head>





<body style="background-color: #e6ecf5">
<div class="book_con01">


    <form id="form_demo" >   <p class="book_p">
        <table class="book_table" border="1" cellpadding="10">
            <tr><td colspan="4" style="text-align: center">社情民意填报内容</td>
            </tr>
            <tr>
                <td>  <label class="td_label">来稿标题</label><i class="i_start"></i>
                </td>
                <td colspan="3"><input type="text" class="book_input03" name ="oplgbt" minlength="2"  required /></td>

            </tr>

            <tr><td><label class="td_label">大类</label></td>
                <td >
                    <select name="opdl" id="opdl" class="layui-select" style="width: 100%">
                        <option>大类一</option>
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
                <td ><input type="text" name="oplgrordw" class="book_input03"/></td>

                <td><label class="td_label">联系电话</label></td>
                <td>
                    <input type="text" name="optel" class="book_input03"/>
                </td>

            </tr>
            <tr> <td><label class="td_label">报送人身份</label></td>
                <td >
                    <select name="opbsrsf" class="layui-select" style="width: 100%">
                        <option>市政协委</option>
                        <option>区政协委员</option>
                        <option>党派成员</option>
                        <option>特约信息员</option>
                    </select>
                </td>
                <td><label class="td_label">报送时间</label></td>
                <td>
                    <input type="date" name="opbssj" class="book_input03"/>
                </td>

            </tr>
            <tr> <td><label class="td_label">报送人</label></td>
                <td colspan="3">
                    <input type="text" name="opbsr" class="book_input03"/>
                </td>
            </tr>
            <tr><td><label class="td_label">签发领导</label></td>
                <td ><input type="text" name="opqfld" class="book_input03"/></td>

                <td><label class="td_label">是否公开</label></td>
                <td style="text-align: center">
                    <input type="radio" class="input_radio" checked="checked" name="radio01"/><a>是</a><input type="radio" class="input_radio" name="radio01"/><a>否</a>
                </td>

            </tr>


            <tr>
                <td><label class="td_label">具体内容</label></td><td colspan="3">
                <textarea  class="textArae" id="editor" ></textarea>
            </td>

            </tr>

            <tr ><td>
                <label class="td_label">附件</label>
            </td>
                <td colspan="5">
        <p><label class="td_label">文件1</label><input type="filename1" value="选择文件"/></p>
        <p><label class="td_label">文件2</label><input type="filename2" value="选择文件"/> </p>
        <p><label class="td_label">文件3</label><input type="filename3" value="选择文件"/></p>
        <p><label class="label_red">附件总大小不能超过200M，超过限制,将不能发送</label></p>
        </td>

        </tr>


        </table>
        </p>
        <p class="book_foot"><input type="submit" value="提交提案"/><input type="button" value="存为草稿"/><input type="button" value="重置"/><input type="button" value="取消"/></p></form>
</div>



</body>
</html>

