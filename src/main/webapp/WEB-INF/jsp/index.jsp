
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/ctx.jsp"%>
    <title>浪琴湾小区服务管理系统</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
    <body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo" style="color: gold">浪琴湾小区服务管理系统</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item"><a href="javascript:;">其它系统</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="">邮件管理</a>
                        </dd>
                        <dd>
                            <a href="">消息管理</a>
                        </dd>
                        <dd>
                            <a href="">授权管理</a>
                        </dd>
                    </dl></li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item"><a href="javascript:;"> <img
                        src="${image}" class="layui-nav-img"> ${username }
                </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:false" id="zl">暂无功能</a>
                        </dd>
                    </dl></li>
                <li class="layui-nav-item"><a href="loginOut">退了</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll ">
                <div id="sidemenubar" lay-filter="test"></div>
            </div>
        </div>


        <div class="layui-body">
            <div class="layui-tab" lay-filter="tabs" lay-allowClose="true">
                <ul class="layui-tab-title">
                </ul>
                <div class="layui-tab-content"></div>

            </div>

            <div class="layui-footer">
                <!-- 底部固定区域 -->
                © 来自com.zking.T213 -
            </div>

        </div>

    </div>
    </body>
</html>
