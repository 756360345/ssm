var form;
var table;
var tables;
var wheres = {};
var xtree3;
var roleName;

$(function() {
	layui.use([ 'form', 'laydate', "layer", 'table' ], function() {
		form = layui.form;
		var layer = layui.layer;
		table = layui.table;
		// createRight();
		//sp();
		initTable(wheres);
        show();
		// 查询按钮
		/*$("#query").click(function() {
			wheres = {
				"name" : $("#name").val(),
			};
			initTable(wheres);
		});*/

		table.on('toolbar(tb)', function(obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			var data = checkStatus.data;
			// console.log(data);
			switch (obj.event) {
			case 'add':
				layer.open({
					type : 2,
					id : 1,
					content : 'system/toRoleAdd', // 这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
					area : [ '500px', '333px' ],
					shade : 0,
					maxmin : true,

				});
				break;
			case 'del':
				if (data.length == 0) {
					layer.msg('请选择要删除的列', {
						icon : 6
					});
					return false;
				} else {
					layer.confirm('您确定要删除所选中的数据？', {
						btn : [ '确定', '取消' ]
					// 按钮
					}, function() {
						$.get("system/delRole?roleid=" + data[0].roleId,
								function(res) {
									layer.msg('删除成功', {
										icon : 1
									});
									tables.reload();
								});
					}, function() {
						layer.msg('取消成功', {
							icon : 1
						});
					});
				}
				break;
			case 'edit':
				if (data.length == 0) {
					layer.msg('请选择要修改的角色', {
						icon : 6
					});
					return false;
				} else {
					layer.open({
						type : 2,
						id : 1,
						content : 'system/toRoleAdd', // 这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content:
						area : [ '500px', '333px' ],
						shade : 0,
						maxmin : true,
                        success: function(layero, index){
                            var body = layer.getChildFrame('body',index);//建立父子联系
                            var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
                            var inputList = body.find('input');
                            // alert(data[0].roleId);
                           /*console.log(obj.data.roleName);*/
                            $(inputList[1]).val(data[0].roleName);
                            $(inputList[2]).val(data[0].roleId);

                            var wh={"rolename":data[0].roleName,
                                "roleid":data[0].roleId,

                            };
                            iframeWin.initForm1(wh);//调用子页面的方法，得到子页面返回的ids
                            iframeWin.UARole(1);
                        }
                    });

				}
				break;

			}
			;
		});
		/*table.on('tool(tb)', function(obj) {
			/!*var data = obj.data;
			$("input[name=roleId]").val(data.roleId)
			roleName=data.roleName;*!/
			if (obj.event === 'fp') {
				alert("来了老弟");
				$.ajax({
					url : "Module/initModule",
					data : {
						"roleid" :"-1"//data.roleId
					},
					dataType : "json",
					Type : "post",
					async : false,
					success : function(data) {
						console.log(data);
						initRight(data);
						//sp();
					}
				});
			} 
		});*/
		
		/*$("#save").click(function(){
			var roleid=$("input[name=roleId]").val();
			if(0==roleid){
				layer.msg("请先选择角色",{icon:6});
				return false;
			}else{
				layer.confirm('您确定要为'+roleName+"修改所使用权限?", {icon: 3, title:'提示'}, function(index){
					layer.close(index);
					$("input[name=roleId]").val(0);
					saveRight(roleid);
				});
			}
		})*/
	});
});
function show(){
    $.ajax({
        url : "Module/initModule",
        data : {
            "roleid" :"-1"//data.roleId
        },
        dataType : "json",
        Type : "post",
        async : false,
        success : function(data) {
            console.log(data);
            initRight(data);
            //sp();
        }
    });
}

/*
function saveRight(roleid){
	//var roleid=$("input[name=roleId]").val();
	var _allck = xtree3.GetAllCheckBox();
    var arr = new Array();
    var arrIndex = 0;
    for (var i = 0; i < _allck.length; i++) {
        if (_allck[i].checked) {
            arr[arrIndex] = _allck[i]; 
            arrIndex++;
        }
    }
    var result = [];
    $.each(arr,function(i,x){
    	result[i]=x.value;
    });
    $.ajax({
		url : "right_saveRight.action",
		data : {
			"result" :result,
			"roleId" : roleid,
		},
		dataType : "json",
		Type : "post",
		async : true,
		traditional: true,//属性在这里设置   ajax传数组数据需要加
		success : function(data) {
			layer.msg(data.message);
			xtree3.render();
		}
	});
    
}
*/

/*function sp(){
    var va = document.getElementsByTagName("span");
    if(va.length > 1){
        for(i=0; i<va.length; i++){
            va[0].innerHTML = "全选";
        }
    }else{
        va[0].innerHTML = "全选";
    }
}*/
function initTable(wheres) {
	tables = table.render({
		toolbar : '#toolbarDemo',
		elem : '#tb',
		height : 500,
		url : 'system/queryRolePager',
		where : wheres,
		id : "idTest",
		page : false // 开启分页
		,
		cols : [ [ // 表头
				{
					type:"radio"
				},
				{
					field : 'roleId',
					title : '编号',
					sort : true,
					type : 'numbers',
					width : '50%'
				},
				{
					field : 'roleName',
					title : '角色名称',
                    width : '50%',
					align:'center',
					templet : function(res) {
						return "<a  style=\"color: blue;margin-top: 0px\" lay-event=\"fp\" id=\"fp\" >"+res.roleName+"</s>";
					}
				} ] ]
	});
}

/*function createRight(){
	$.ajax({
		url : "right_initRight.action",
		data : {
			"right_parent_code" : "-1"
		},
		dataType : "json",
		Type : "post",
		async : false,
		success : function(data) {
			initRight(data);
		}
	});
}*/

function initRight(data) {
	layui.use('form', function() {
		var form = layui.form;
	// 3、最完整的参数用法
		xtree3 = new layuiXtree({
			elem : 'xtree3' // 必填
			,
			form : form // 必填
			,
			data : data // 必填
			,
			isopen : false // 加载完毕后的展开状态，默认值：true
			,
			ckall : false // 启用全选功能，默认值：fals。。e
			,
			ckallback : function() {
			} // 全选框状态改变后执行的回调函数
			,
			icon : { // 三种图标样式，更改几个都可以，用的是layui的图标
				open : "&#xe68e;" // 节点打开的图标
				,
				close : "&#xe622;" // 节点关闭的图标
				,
				end : "&#xe621;" // 末尾节点的图标
			},
			color : { // 三种图标颜色，独立配色，更改几个都可以
				open : "#EE9A00" // 节点图标打开的颜色
				,
				close : "#EEC591" // 节点图标关闭的颜色
				,
				end : "#828282" // 末级节点图标的颜色
			}

			,
			click : function(data) { // 节点选中状态改变事件监听，全选框有自己的监听事件
				console.log(data.elem); // 得到checkbox原始DOM对象
				console.log(data.elem.checked); // 开关是否开启，true或者false
				console.log(data.value); // 开关value值，也可以通过data.elem.value得到
			}
		});
	});
}

