$(function(){
    $('#save').click(function () {
       var rephfnr = $('#rephfnr').val();
       var repdworr = $('#repdworr').val();
       var repdate = $('#repdate').val();
       var repid = $('#repid').val();
       repdate = new Date(repdate);
       if(null==rephfnr||''==rephfnr){
           layer.alert("回复内容不能为空");
           return false;
       }
       if(null==repdworr||''==repdworr){
           layer.alert("单位不能为空");
           return false;
       }
        $.ajax({
            url : "opinion/updateReply",
            data : {
                "rephfnr" : rephfnr,
                "repdworr":repdworr,
                "repdate":repdate,
                "repid":repid
            },
            dataType : "json",
            type : "post",
            async : false,
            success : function(data) {
               if(data.success){
                   alert(data.message);
                   var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                   parent.layer.close(index); //再执行关闭
               }else {
                   alert(data.message);
               }

            }
        });
    });
});