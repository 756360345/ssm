$(function(){
    initXL();
    initDL();
    initBsr()
});
//初始化大类
function initDL() {
    var d = "<option value='' >请选择服务大类</option>";
    $.ajax({
        url : "Dict/queryDictForType",
        data : {
            "dictype" : "dl"
        },
        dataType : "json",
        Type : "post",
        async : false,
        success : function(data) {
            for (var i = 0; i < data.length; i++) {
                d += "<option value='" + data[i].dicvalue + "'>"
                    + data[i].dicname + "</option>";
            }
            $("select[name=opdl]").html(d);
        }
    });
}
//初始化小类
function initXL() {
    var d = "<option value='' >请选择服务小类</option>";
    $.ajax({
        url : "Dict/queryDictForType",
        data : {
            "dictype" : "xl"
        },
        dataType : "json",
        Type : "post",
        async : false,
        success : function(data) {
            for (var i = 0; i < data.length; i++) {
                d += "<option value='" + data[i].dicvalue + "'>"
                    + data[i].dicname + "</option>";
            }
            $("select[name=opxl]").html(d);
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