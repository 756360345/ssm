var message;
$(function(){
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;
    layui.use(['form','laydate','upload', ],function() {
        var form = layui.form;
        var laydate = layui.laydate;
        var $ = layui.jquery
            ,upload = layui.upload;
        form.on('submit(add)', function(data) {
            var time = data.field;
            // time.opbssj=new Date(time.opbssj);
            time.opbssj = new Date(time.opbssj);
            //console.log(data.field);
            $.ajax({
                url : "opinion/Addopinion",
                data : time,
                dataType : "json",
                type : "post",
                async : false,
                success : function(data) {
                    if(data.success){
                        alert(data.message);
                        // layer.confirm("添加成功");
                        window.location.reload();
                    }else{
                        layer.alert(data.message);
                    }
                }
            });

        });
    });
        //多文件列表示例
            var demoListView = $('#demoList')
            // console.log("1"+$("#fileid").val())
            ,uploadListIns = upload.render({
            elem: '#testList'
            ,url: '/upload/'
            ,accept: 'file'
            ,multiple: true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                    // console.log(files);
                    //     console.log("1"+$("#fileid").val())
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                if(res.code == 0){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });

    });
    $("#bindAction").click(function () {
        // console.log(1);
        if (message == 1) {
            layer.alert('请确保文件上传成功', {
                icon: 5,
                title: "提示"
            });
        } else {
            submit();
        }
    })
    //提交
    function submit() {
        // 监听提交
        form.on('submit(add)', function (data) {
            // console.log(data);
            // layer.msg(JSON.stringify(data.field));
            var datas = data.field;
            console.log(datas);
            datas.prodate = new Date(datas.prodate);
            if (null == datas.file || "" == datas.file) {
                datas.file = "";
            }

            // $.ajax({
            //     url: 'submit',
            //     data:data.field,
            //     dataType: "json",
            //     Type: "post",
            //     async: false,
            //     success: function (data) {
            //         layer.alert(data.message, {
            //             icon: 5,
            //             title: "提示"
            //         });
            //     }
            // })
            return false;
        });
    }
    //取消按钮
    $("#reset").click(function () {
        //清空文件
        $("#demoList").remove();
        //提案取消 删除已上传的文件
        $.ajax({
            url: 'File/delete',
            data: {"fileid": $("#fileid").val()},
            dataType: "json",
            Type: "post",
            async: false,
            success: function (data) {
            }
        })

});
    initDL();

    initBsr();

});
//初始化单位类型
function initDL() {
    var d = "<option value='' >请选择单位类型</option>";
    $.ajax({
        url : "Dict/queryDictForType",
        data : {
            "dictype" : "opdwtype"
        },
        dataType : "json",
        Type : "post",
        async : false,
        success : function(data) {
            for (var i = 0; i < data.length; i++) {
                d += "<option value='" + data[i].dicvalue + "'>"
                    + data[i].dicname + "</option>";
            }
            $("select[name=opdwtype]").html(d);
        }
    });
}


//初始化报送人身份
function initBsr() {
    var d = "<option value='' >请选择报送人身份</option>";
    $.ajax({
        url : "Dict/queryDictForType",
        data : {
            "dictype" : "bsr"
        },
        dataType : "json",
        Type : "post",
        async : false,
        success : function(data) {
            for (var i = 0; i < data.length; i++) {
                d += "<option value='" + data[i].dicvalue + "'>"
                    + data[i].dicname + "</option>";
            }
            $("select[name=opbsrsf]").html(d);
        }
    });
}


