$(function () {
    updateUser();
})
function initForm1(row) {
    layui.use("form",function () {
        var form=layui.form;
        row=JSON.parse(JSON.stringify(row));
        form.val("form", row);
    });
}

function updateUser(c) {
    var url='system/userAdd'
    if(c==1){
        url='system/userUpdate';
    }
    layui.use(['form','laydate','layer' ],function() {
        var form = layui.form;
        var laydate = layui.laydate;
        var layer = layui.layer;
        form.on('submit(save)', function(data) {
            $.ajax({
                url : url,
                data : data.field,
                dataType : "json",
                type : "post",
                async : false,
                success : function(data) {
                    if(data.success){
                        alert(data.message);
                        // layer.confirm("添加成功");
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        parent.window.initTable();
                    }else{
                        layer.alert(data.message);
                    }
                }
            });

        });
    });


}