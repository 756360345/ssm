var form;
var da;
var layer;
var whe;
var $;

$(function() {
	layui.use([ 'jquery',  'element','layer', 'form' , 'laydate'],
			function() {
				$ = layui.$;
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
                    var d=new Date(data.field.end);
                    d.setDate(d.getDate()+1);
                    var m=d.getMonth()+1;
                    var dateTime = d.getFullYear()+'-'+m+'-'+d.getDate();
                    whe={
                    	'oplgbt':data.field.oplgbt,
                        'opbsrsf':data.field.opbsrsf,
                        'optjr':data.field.optjr,
                        'start':data.field.start,
                        'end':dateTime,
                        'opbsr':data.field.opbsr,
                        'opltype':data.field.opltype
					}
					initTable(whe)
					return false;
				});
				/*$('#btn').click(function(){
					console.log($('#ff').serialize());
					initTable($('#ff').serialize());
				});*/

			});
	initFwzt();
    initType();

});
function initTable(wher) {
	layui.use('table', function() {
		var table = layui.table;
		tables = table.render({
			elem : '#test',
			url : 'opinion/queryOpinionPager',
			where : wher,
			title: '社情民意查询',

            method : "post",
            request : {
                limitName : 'rows'
            },
            text : {
                none : '对不起，暂无此类数据'
            },
            cols : [ [ {
                    field:'opid',
                    title : '序号',
					sort:true,
					width:150,
                    align:'center',
			},{
				field : 'opltype',
				title : '稿件状态',
				width:150,
                align:'center',
			}, {
				field : 'optjr',
				title : '提交人',
				sort : false,
				width:120,
                align:'center',
			}, {
				field : 'oplgbt',
				title : '标题',
				width:120,
                align:'center',
			}, {
				field : 'opbsr',
				title : '反映人',
				sort : false,
				width:120,
                align:'center',
			}, {
				field : 'optjtime',
				title : '提交日期',
				sort : true,
				width:180,align:'center', templet: "<div>{{layui.util.toDateString(d.optjtime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
			},{
                field : 'pub',
                title : '类别',
                sort : false,
                align:'center',templet : function(res) {
                    if(res.pub=='是'){
                        return "公开"
                    }
                    if(res.pub=='否'){
                        return "不公开"
                    }
                },

            },{fixed: 'right', title:'操作',width:200,align:'center',
				templet : function(res) {
                return  "<a  lay-event='baos' title='报送'><i class='fa fa-hand-o-up fa-2x'></i></a>";
				},

			}
			] ],
            done : function(res, curr, count) {

                if(res.success==false)
                    layer.msg(res.message);
			},
            page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
			      layout: [ 'count', 'prev', 'page', 'next','limit', 'skip'] //自定义分页布局
			      //,curr: 5 //设定初始在第 5 页
			      ,groups: 10 //只显示 1 个连续页码
			      ,first: false //不显示首页
			      ,last: false //不显示尾页

			    },
		});
		table.on('tool(test)', function(obj){
		    if(obj.event === 'baos'){
                        layer.confirm('确认报送？', function(index){
                            $.ajax({
                                url : "opinion/updateType",
                                data : {
                                    "opid" : obj.data.opid,
                                },
                                dataType : "json",
                                type : "post",
                                async : false,
                                success : function(data) {
                                    if(data.success){
                                        alert(data.message);
                                        tables.reload();
                                    }else{
                                        alert("系统繁忙");
                                    }
                                }
                            });

                            layer.close(index);
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
			"dictype" : "bsr"
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

function initType() {
    var d = "<option value='' >---请选择状态---</option>";
    $.ajax({
        url : "Dict/queryDictForType",
        data : {
            "dictype" : "opltype"
        },
        dataType : "json",
        type : "post",
        async : false,
        success : function(data) {
            for (var i = 0; i < data.length; i++) {
                d += "<option value='" + data[i].dicvalue + "' >" + data[i].dicname
                    + "</option>";
            }
            $("select[name=opltype]").append(d);
        }
    });
}

