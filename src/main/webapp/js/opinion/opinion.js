var form;
var da;
var layer;
var whe;
$(function() {
	layui.use([ 'jquery',  'element','layer', 'form' , 'laydate'],
			function() {
				var $ = layui.jquery;
				carousel=layui.carousel;
				layer = layui.layer;
				var laydate = layui.laydate;
				form = layui.form;
				var element = layui.element;
				element.init();
				initTable();
				laydate.render({
				    elem: '#start'
				  });
				laydate.render({
				    elem: '#end'
				  });
				form.on('submit(query)', function(data) {
					console.log(data);
					whe={
							'svr_cust_name':data.field.svr_cust_name,
							'svr_title':data.field.svr_title,
							'svr_type':data.field.svr_type,
							'svr_status':data.field.svr_status,
							'cust_no':data.field.cust_no,
							'start':data.field.start,
							'end':data.field.end
					}
					initTable(whe)
					return false;
				});

			});
	initFwzt();

});
function initTable(wher) {
	layui.use('table', function() {
		var table = layui.table;
		tables = table.render({
			elem : '#test',
			url : 'Ser_queryServicePager',
			where : wher,
			title: '服务反馈',
			cols : [ [ {
				title : '序号',
				type:'opid ',
					sort:true,
					width:200,
			},{
				field : 'opltype ',
				title : '稿件状态',
				width:250,
			}, {
				field : 'optjr',
				title : '提交人',
				sort : true,
				width:250,
			}, {
				field : 'oplgbt ',
				title : '标题',
				width:250,
			}, {
				field : 'svr_create_by',
				title : '创建人',
				sort : true,
				width:200,
			}, {
				field : 'svr_create_date',
				title : '创建日期',
				sort : true,
				width:300,templet : function(res) {
					return formatterDate(res.svr_create_date);
				},
			},{fixed: 'right', title:'操作',width:200,
				templet : function(res) {
					if(res.svr_status=="已分配"||res.svr_status=="新创建"||res.svr_status=="已归档"){
						return "无操作";
					}else{
						return "<a  lay-event='deal' title='处理'><i class='fa fa-hand-o-up fa-2x'></i></a>";
					}
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
		    if(obj.event === 'deal'){
		    	
		    	layer.open({
					  type: 2, 
					  area: ['1700px', '700px'],
					  title:'服务反馈',
					  anim:1,
					  content: 'ser/feedBackService.jsp', 
						  scrollbar: true,
						  move: false,
						  success: function(layero, index){
							  var body = layer.getChildFrame('body',index);//建立父子联系
					            var inputList = body.find('input');
//					            console.log(inputList);
					            $(inputList[1]).val(obj.data.svr_id);
					            $(inputList[2]).val(obj.data.svr_type);
					            $(inputList[3]).val(obj.data.svr_title);
					            $(inputList[4]).val(obj.data.svr_cust_name);
					            $(inputList[5]).val(obj.data.svr_status);
					            $(inputList[6]).val(obj.data.svr_request);
					            $(inputList[7]).val(obj.data.svr_create_by);
					            $(inputList[8]).val(formatterDate(obj.data.svr_create_date));
					            $(inputList[9]).val(obj.data.svr_due_to);
					            $(inputList[10]).val(formatterDate(obj.data.svr_due_date));
					            $(inputList[11]).val(obj.data.svr_deal_by);
					            $(inputList[12]).val(formatterDate(obj.data.svr_deal_date));
					            
					            var textAreaList = body.find('textarea');
					            $(textAreaList[0]).val(obj.data.svr_deal);
					            var SelectList = body.find('select');
					            var iframeWindow = window['layui-layer-iframe'+ index]
					            var sa=3;
					            $(inputList[14]).val(obj.data.svr_satisfy);
					            if(obj.data.svr_satisfy=='21111111111111111111111111111111'){
					            	 sa=1;
					            }else if(obj.data.svr_satisfy=='21111111111111111111111111111112'){
					            	sa=2;
					            }else if(obj.data.svr_satisfy=='21111111111111111111111111111113'){
					            	sa=3;
					            }else if(obj.data.svr_satisfy=='21111111111111111111111111111114'){
					            	sa=4;
					            }else if(obj.data.svr_satisfy=='21111111111111111111111111111115'){
					            	sa=5;
					            }
					            iframeWindow.layui.rate.render({
					            	  elem: '#svr_satisfy'
					           		   ,value:sa //初始值
					           		   ,text: true //开启文本
					           		,setText: function(value){ //自定义文本的回调
						                  var arrs = {
						                    '1': '极差'
						                    ,'2': '差'
						                    ,'3': '一般'
						                    ,'4': '良好'
						                    ,'5': '好'
						                  };
						                  this.span.text(arrs[value] || ( value + "星"));
					           		},choose: function(value) {
					                    $(inputList[14]).val('2111111111111111111111111111111'+value);
					                }
					            });
						  }
					});
		    }
		  });
			
	});
}
function initFwzt() {
	var d = "<option value='' >---请选择类型---</option>";
	$.ajax({
		url : "Dict/queryDictForType",
		data : {
			"dict_type" : "bsr"
		},
		dataType : "json",
		type : "post",
		async : false,
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				d += "<option value='" + data[i].dicvalue + "' >" + data[i].dicname
						+ "</option>";
			}
			$("select[name=opbsrsf]").append(d);
		}
	});
}

