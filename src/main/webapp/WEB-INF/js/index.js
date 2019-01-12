var rootPath;
var element;
$(function() {
	rootPath = $('#absolutePath').val();
	layui.use(['element','layer','jquery','tree'], function(){
		 element = layui.element;
		var layer = layui.layer;
	    var $ = layui.jquery;
	    selectLeftMenu(); 
	});
});
function selectLeftMenu() {
	$.ajax({
		url : "Module/getModule",
		type : "post",
		data:{'pid':'-1'},
		dataType : "json",
		async:false ,
		success : function(data) {

			layui.tree({
				  elem: '#sidemenubar' //传入元素选择器
				  ,nodes: data
				  ,autoRefresh:false
				  ,click: function(node){
					  var exist=$("li[lay-id='"+node.id+"']").length;
						if (exist > 0) {//判断是否已经发开选项卡
							element.tabChange('tabs', node.id);// 切换到已有的选项卡

						} else {//如果没打开就新建一个选项卡
							 if (null!=node.url) {

								  element.tabAdd('tabs', {
									  title:node.name//选m项卡的名称
					                  //把这个页面嵌套进选项卡中
					                  ,content:'<iframe scrolling="hidden" frameborder="0" src="'+rootPath+node.url+'" width="98%" height="100%"></iframe>'//支持传入html
					                  //这是选项卡的id
					                  ,id:node.id,
					              });
								    calculate();
								  element.tabChange('tabs', node.id);
								  }
						}
			        }
				});
		}
	});
}
function calculate() {
	FrameWH();
	function FrameWH() {
        var h = $(window).height() - 185;
        $("iframe").css("height", h + "px");
    }
	$(window).resize(function() {
		FrameWH();
	});
}


