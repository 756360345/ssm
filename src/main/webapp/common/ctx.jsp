<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    //结尾无斜杠[/]
    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    request.setAttribute("ctx",ctx);
%>
<input type="hidden" id="absolutePath" value="${ctx }/">
<base href="${ctx }/">
<script type="text/javascript" src="js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/layui/layui.js"></script>
<script type="text/javascript" src="js/layui/layui-xtree.js"></script>
<%--<script type="text/javascript" src="../js/util/date.js"></script>--%>
<link rel="stylesheet" type="text/css" href="${ctx}/js/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="${ctx}/css/inclubd.css" media="all">
<link href="${ctx}/css/all.css" rel="stylesheet" type="text/css">
<link href="${ctx}/js/editor/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${ctx}/js/editor/css/froala_editor.min.css" rel="stylesheet" type="text/css">


