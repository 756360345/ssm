$(function(){

});

function initFwlx() {
    var d = "<option value='' >请选择服务大类</option>";
    $.ajax({
        url : "dict_queryDict.action",
        data : {
            "dictItem" : "FWLX"
        },
        dataType : "json",
        Type : "post",
        async : false,
        success : function(data) {
            for (var i = 0; i < data.length; i++) {
                d += "<option value='" + data[i].dictId + "'>"
                    + data[i].dictValue + "</option>";
            }
            $("select[name=svrType]").html(d);
        }
    });
}