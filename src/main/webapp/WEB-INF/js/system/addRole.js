var form;
var table;
var tables;
var wheres={};
$(function() {
    UARole();
});
function initForm1(row) {
	// console.log(row);
    layui.use("form",function () {
        var form=layui.form;
        row=JSON.parse(JSON.stringify(row));
        form.val("form", row);
    });
}

function UARole(c){
	// alert(c);
	var url='system/addRole';
	if(c==1){
		url='system/updateRole';
	}
    layui.use([ 'form', 'laydate', "layer", 'table' ], function() {
        //获取需要编辑行数据
        form = layui.form;
        var layer = layui.layer;
        // 保存按钮
        form.on('submit(*)', function(data) {
            $.ajax({
                url : url,
                data : data.field,
                datatype : 'json',
                type : 'post',
                async : true,
                success : function(data) {
                    if (data.success) {
                        alert(result.message);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }else{
                        alert(data.message);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.location.reload();
                        parent.layer.close(index);
                    }

                }
            });
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.location.reload(); // 父页面刷新
            parent.layer.close(index); //再执行关闭
        });

    });
}


