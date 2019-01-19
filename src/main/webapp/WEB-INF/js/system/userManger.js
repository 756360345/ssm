$(function(){
	layui.use([ 'jquery',  'element','layer', 'form' ],
			function() {
				var $ = layui.jquery;
				var carousel=layui.carousel;
				var layer = layui.layer;
				var form = layui.form;
				var element = layui.element;
				form.on('submit(query)',function(data){
				var whe={"username":data.field.usr_name,"role_id":data.field.usr_role_id};
				initTable(whe);
				return false;
				});

	});
	$('#add').click(function () {
        userAdd();
    });
	initTable();
	initRole();
});
function initTable(whe) {
	layui.use('table', function() {
		var table = layui.table;
		tables = table.render({
			elem : '#test',
			where : whe,
			url : 'system/queryUserPager',
			cols : [ [ {
				field : 'uname',
				title : '用户名称',
                align:'center',
				width:"25%",
			}, {
				field : 'realname',
				title : '真实姓名',
				align:'center',
				width:"25%",
			}, {
				field : 'password',
                title : '用户密码',
                align:'center',
				width:"25%",templet : function(res) {
                    return  "****";
                },
			},{
				fixed: 'right', title:'操作',width:"25%",align:'center',
                templet : function(res) {
                    return  "<a  lay-event='update' title='修改'><i class=\"layui-icon\" style=\"font-size: 25px;\">&#xe642;</i> </a>" +
                        "&nbsp;&nbsp;&nbsp;<a   lay-event='delete' title='删除'><i class=\"layui-icon\" style=\"font-size: 25px; color: red;\">&#xe640;</i> </a>";
                },
			}
			] ],
			page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
			      layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
			      //,curr: 5 //设定初始在第 5 页
			      ,groups: 3 //只显示 1 个连续页码
			      ,first: false //不显示首页
			      ,last: false //不显示尾页
			      
			    },
		});
		table.on('tool(test)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'update'){
		    	layer.open({
					  type: 2, 
					  area: ['1000px', '450px'],
					  title:'查看所属页面',
					  anim:1,
					  content: 'system/toUserAdd',
						  scrollbar: true,
						  move: false,
						  success: function(layero, index){

								 var body = layer.getChildFrame('body',index);//建立父子联系
								 var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
								 var inputList = body.find('input');
								 $(inputList[1]).val(obj.data.uid);
								 $(inputList[2]).val(obj.data.uname);
								 $(inputList[3]).val(obj.data.realname);
								 $(inputList[4]).val(obj.data.password);
								 var wh={"uname":data.uname,
										 "realname":data.realname,
										 "password":data.password,
										 "uid":data.uid
									 };

								 iframeWin.initForm1(wh);//调用子页面的方法，得到子页面返回的ids
                                 iframeWin.updateUser(1);
					  }
		    	});
		    	
		    }else if(obj.event === 'delete'){
                layer.confirm('确认删除？', function(index){
                    $.ajax({
                        url : "system/userDel",
                        data : {
                            "uid" : obj.data.uid,
                        },
                        dataType : "json",
                        type : "post",
                        async : false,
                        success : function(data) {
                            if(data.success){
                                layer.alert(data.message);
                                tables.reload();
                            }else{
                                layer.alert(data.message);
                            }
                        }
                    });
                    layer.close(index);
                });
		    }else{

            }
		});
	});
}

function initRole() {
	var d = "<option value='' >---请选择用户角色---</option>";
	$.ajax({
		url : "queryRole",
		dataType : "json",
		type : "post",
		async : false,
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				d += "<option value='" + data[i].role_id + "' >" + data[i].role_name
						+ "</option>";
			}
			$("select[name=usr_role_id]").append(d);
		}
	});
}

function userAdd() {
    layer.open({
        type: 2,
        area: ['1000px', '450px'],
        title:'查看所属页面',
        anim:1,
        content: 'system/toUserAdd',
        scrollbar: true,
        move: false,
        success: function(layero, index){

        }

    });
}