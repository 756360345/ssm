var form;
var path;
var layer;
var whe;
$(function() {
    path=$('#absolutePath').val();
    layui.use([ 'jquery',  'element','layer', 'form' ],
        function() {
            var $ = layui.jquery;
            carousel=layui.carousel;
            layer = layui.layer;
            form = layui.form;
            var element = layui.element;
            element.init();
            initTable();
            form.on('submit(query)', function(data) {
                console.log(data);
                whe={'meename':data.field.meename,'meezt':data.field.meezt,'meecc':data.field.meecc,'meecbz':data.field.meecbz,'meezksj':data.field.meezksj,'meeaddress':data.field.meeaddress,'meelxr':data.field.meelxr,'meecjry':data.field.meecjry,'meetel':data.field.meetel}
                initTable(whe)
                return false;
            });
            $('#help').click(function(){
                layer.msg("欢迎使用社区服务管理系统");
            });

        });
    initCC();
  /*  initDj();
    initdq();*/
});
function initTable(wher) {
    layui.use('table', function () {
        var table = layui.table;
        tables = table.render({
            elem: '#test',
            url: path+'Meeting/queryMeeting',
            where: wher,
            title: '会议活动查看',
            cols: [[{
                title: '序号',
                type: 'meeid',
                sort: true,
                width: 100,
            }, {
                field: 'meezt',
                title: '会议主题',
                width: 100,
            }, {
                field: 'ccname',
                title: '会议层次',
                width: 100,
            }, {
                field: 'cbzname',
                title: '会议承办者',
                sort: true,
                width: 100,
            }, {
                field: 'meezksj',
                title: '会议召开时间',
                width: 100,
            }, {
                field: 'meeaddress',
                title: '会议召开地点',
                sort: true,
                width: 100,
            },{
                field: 'meecjry',
                title: '参加人员',
                sort: true,
                width: 100,
            },{
                field: 'meelxr',
                title: '会议联系人',
                sort: true,
                width: 100,
            },{
                field: 'meetel',
                title: '会议联系电话',
                sort: true,
                width: 100,
            },
                {fixed: 'right', title: '操作', toolbar: '#barDemo'}
            ]],
            page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                , groups: 3 //只显示 1 个连续页码
                , first: false //不显示首页
                , last: false //不显示尾页

            },
        })

        table.on('tool(test)', function (obj) {
            if (obj.event === 'querySingle') {

                    $.ajax({
                        url: "deleteCustomer",
                        data: {
                            "cust_no": obj.data.cust_no,
                        },
                        dataType: "json",
                        type: "post",
                        async: false,
                        success: function (data) {
                            if (data.success) {
                                layer.msg(data.message);
                                tables.reload();
                            } else {
                                layer.msg("系统繁忙");
                            }
                        }
                    });

                    layer.close(index);

            }
        })
    })
}

            function initCC() {
                var d = "<option value='' >---请选择会议层次---</option>";
                $.ajax({
                    url :path+ "Dict/queryDictForType",
                    data : {
                        "dictype" : "meecc"
                    },
                    dataType : "json",
                    type : "post",
                    async : false,
                    success : function(data) {
                        console.log(data)
                        for (var i = 0; i < data.length; i++) {
                            d += "<option value='" + data[i].dicvalue + "' >" + data[i].dicname
                                + "</option>";
                        }
                        $("select[name=meecc]").append(d);
                    }
                });
            }