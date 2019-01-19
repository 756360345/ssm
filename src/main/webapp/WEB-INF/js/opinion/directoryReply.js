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

				form.on('submit(select)', function(data) {

                    whe={
                    	'repid':data.field.repid,
                        'repname':data.field.repname,
						'repdw':data.field.repdw,
						'rephfnr':data.field.rephfnr

					}
					initTable(whe)
					return false;
				});
				/*$('#btn').click(function(){
					console.log($('#ff').serialize());
					initTable($('#ff').serialize());
				});*/

			});
    initDwType();
    // initType();

});
function initTable(wher) {
	layui.use('table', function() {
		var table = layui.table;
		tables = table.render({
			elem : '#test',
			url : 'opinion/queryDirectoryReplyLstPager',
			where : wher,
			title: '采用稿目录',

            method : "post",
            request : {
                limitName : 'rows'
            },
            text : {
                none : '对不起，暂无此类数据'
            },
            cols : [ [ {
                    field:'repid',
                    title : '编号',
					sort:true,
					width:'16%',
                    align:'center',
			},{
				field : 'rephfnr',
				title : '回复标题',
				width:'16%',
                align:'center',
			}, {
				field : 'repname',
				title : '对应社情民意',
				sort : false,
				width:'16%',
                align:'center',
			}, {
                field : 'repdworr',
                title : '回复单位',
                sort : false,
                width:'16%',
                align:'center',
            }, {
				field : 'repdate',
				title : '回复日期',
				sort : true,
				width:'16%',align:'center', templet: "<div>{{layui.util.toDateString(d.repdate, 'yyyy-MM-dd HH:mm:ss')}}</div>"
			},{fixed: 'right', title:'操作',width:'16%',align:'center',
				templet : function(res) {
                return  "<a  lay-event='detail' id='de' title='查看详情'><i class=\"layui-icon layui-icon-list\" style=\"font-size: 30px; color: #1E9FFF;\"></i> </a>";

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

		    if(obj.event === 'detail'){
                layer.open({
                    type: 2,
                    area: ['1100px', '450px'],
                    title:'社情民意回复',
                    anim:1,
                    content: 'opinion/toReplys',
                    scrollbar: true,
                    move: false,
                    success: function(layero, index){
                        var body = layer.getChildFrame('body',index);//建立父子联系
                        var inputList = body.find('input');
                        $(inputList[1]).val(obj.data.repid);
                        $(inputList[2]).val(obj.data.repname);
                        $(inputList[3]).val(obj.data.repdw);
                        $(inputList[4]).val(obj.data.caidate);
                        $(inputList[5]).val(obj.data.rephfnr);
                        $(inputList[6]).val(obj.data.repdworr);
                        $(inputList[7]).val(obj.data.repdate);
                        var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
                        var time = obj.data.repdate;
						var wh={'repid':obj.data.repid,
								'repname':obj.data.repname,
								'repdw':obj.data.repdw,
								'caitime':obj.data.caidate,
								'rephfnr':obj.data.rephfnr	,
								'repdworr':obj.data.repdworr,
								'repdate':"<div>{{layui.util.toDateString(d.time, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                        };
						iframeWin.initForm(wh);
                    }
                });

        }
    });





    });
}
function initDwType() {
	var d = "<option value='' >---请选择类型---</option>";
	$.ajax({
		url : "Dict/queryDictForType",
		data : {
			"dictype" : "opdwtype"
		},
		dataType : "json",
		type : "post",
		async : false,
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				d += "<option value='" + data[i].dicvalue + "' >" + data[i].dicname
						+ "</option>";
			}
			$("select[name=repdw]").append(d);
		}
	});
}

/*function initType() {
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
}*/

