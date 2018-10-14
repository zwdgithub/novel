$.cookie = function(name, value, options) {
if (typeof value != 'undefined') {
   options = options || {};
   if (value === null) {
    value = '';
    options = $.extend({}, options);
    options.expires = -1;
   }
   var expires = '';
   if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
    var date;
    if (typeof options.expires == 'number') {
     date = new Date();
     date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
    } else {
     date = options.expires;
    }
    expires = '; expires=' + date.toUTCString();
   }
   var path = options.path ? '; path=' + (options.path) : '';
   var domain = options.domain ? '; domain=' + (options.domain) : '';
   var secure = options.secure ? '; secure' : '';
   document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
} else {
   var cookieValue = null;
   if (document.cookie && document.cookie != '') {
    var cookies = document.cookie.split(';');
    for (var i = 0; i < cookies.length; i++) {
     var cookie = jQuery.trim(cookies[i]);
     if (cookie.substring(0, name.length + 1) == (name + '=')) {
      cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
      break;
     }
    }
   }
   return cookieValue;
}
};


$(function(){
	$('.remindarea').on("touchmove", function (e) {
    	e.preventDefault();
    });
	$('.remindarea').click(function(){
		$('.remindarea').hide();
	});
	
	//导航小分类显示
	var $subNav = $('.subNav'),
		$subNav_sort = $('#subNav_sort');
	
	$subNav_sort.click(function(){
		if($subNav.css("display") == "none"){
			$subNav.show();
		}else if($subNav.css("display") == "block"){
			$subNav.hide();
		}
	});
	
	$subNav.click(function(){
		$subNav.hide();
	})
	
	//搜索
	var $searchForm_input = $('.searchForm_input'),
		$searchForm_btn = $('.searchForm_btn');
	
	$searchForm_input.focus(function(){
		if($(this).val() == '输入书名•作者'){
			$(this).val("");
		}
	});
	
	$searchForm_input.blur(function(){
		if($(this).val() == ""){
			$(this).val('输入书名•作者');
		}
	});
	
	//阅读页功能开始--------------------------
	var	$topMenu = $('.topMenu'),
		$bottomMenu = $('.bottomMenu'),
		$Readarea = $('.Readarea'),
		
		$read = $('#read'),
		$ReadAd = $('.ReadAd'),
		$Readtitle = $('.Readtitle'),
		$Readarea = $('.Readarea'),
		$Readpage = $('.Readpage'),
		$footer = $('footer'),
		$ToBg_Menu = $('.ToBg_Menu'),
		$ToBg_MenuSpan = $('.ToBg_Menu span'),
		$btn_ToNight = $('.btn_ToNight'),
		$btn_ToBg = $('.btn_ToBg'),
		$btn_ToFast = $('.btn_ToFast'),
		$ToFast_Area = $('.ToFast_Area'),
		$ToFast_open = $('.ToFast_open'),
		$ToFast_close = $('.ToFast_close'),
		$ToMsg_Area = $('.ToMsg_Area'),
		$btn_ToMsg = $('.btn_ToMsg'),
		$btn_ToFontdown = $('.btn_ToFontdown'),
		$btn_ToFontup = $('.btn_ToFontup'),
		$btn_ToFont = $('.btn_ToFont'),
		$ToFont_Area = $('.ToFont_Area');
	
	//功能显示
	$Readarea.click(function(){
		if($topMenu.css("display") == "none"){
			$topMenu.show();
			$bottomMenu.show();
		}else if($topMenu.css("display") == "block"){
			$topMenu.hide();
			$bottomMenu.hide();
			$ToBg_Menu.hide();
			$ToFast_Area.hide();
			$ToMsg_Area.hide();
			$ToFont_Area.hide();
			$bottomMenu.children().removeClass('sel');
		}
	});
	
	//背景功能选项
	$btn_ToBg.click(function(){
		if($ToBg_Menu.css("display") == "none"){
			$ToBg_Menu.show();
			$ToFast_Area.hide();
			$ToMsg_Area.hide();
			$ToFont_Area.hide();
			$(this).addClass('sel');
			$(this).siblings().removeClass('sel');
		}else if($ToBg_Menu.css("display") == "block"){
			$ToBg_Menu.hide();
			$(this).removeClass('sel');
		}
	});

	//加速功能选项
	$btn_ToFast.click(function(){
		if($ToFast_Area.css("display") == "none"){
			$ToFast_Area.show();
			$ToBg_Menu.hide();
			$ToMsg_Area.hide();
			$ToFont_Area.hide();
			$(this).addClass('sel');
			$(this).siblings().removeClass('sel');
		}else if($ToFast_Area.css("display") == "block"){
			$ToFast_Area.hide();
			$(this).removeClass('sel');
		}
	}); 
	
	$ToFast_open.click(function(){
		if($(this).hasClass('sel')){
			$(this).removeClass('sel');
			$.cookie('readfast',false);
		}else{
			$(this).addClass('sel');
			$.cookie('readfast',true);
		}
	});
	
	$btn_ToFont.click(function(){
		if($ToFont_Area.css("display") == "none"){
			$ToFont_Area.show();
			$ToBg_Menu.hide();
			$ToFast_Area.hide();
			$ToMsg_Area.hide();
			$(this).addClass('sel');
			$(this).siblings().removeClass('sel');
		}else if($ToFont_Area.css("display") == "block"){
			$ToFont_Area.hide();
			$(this).removeClass('sel');
		}
	})
	
	//阅读页功能结束--------------------------
});

function ToBgcolor(color){
	var $read = $('#read'),
		$ToBg_Menu = $('.ToBg_Menu'),
		$ToFast_Area = $('.ToFast_Area'),
		$ToMsg_Area = $('.ToMsg_Area'),
		$bottomMenu = $('.bottomMenu');
	
		if(color == 0){
			$read.removeClass();
			$read.addClass("read");
		}
		if(color == 1){
			$read.removeClass();
			$read.addClass("ToBg_yellow");
		}
		if(color == 2){
			$read.removeClass();
			$read.addClass("ToBg_green");
		}
		if(color == 3){
			$read.removeClass();
			$read.addClass("ToBg_red");
		}
		if(color == 4){
			$read.addClass("Read_Night");
		}
		$.cookie('color',color);
	if(color > 4){
		$ToBg_Menu.hide();
		$ToFast_Area.hide();
		$ToMsg_Area.hide();
		$bottomMenu.children().removeClass('sel');
	}
}

function ToFontup(size,lineheight){
	var $Readarea = $('.Readarea');
	var $nowfs = $Readarea.css("font-size"),
		$nowlh = $Readarea.css("line-height"),
		$ToBg_Menu = $('.ToBg_Menu'),
		$ToFast_Area = $('.ToFast_Area'),
		$ToMsg_Area = $('.ToMsg_Area'),
		$bottomMenu = $('.bottomMenu'); 

	$ToBg_Menu.hide();
	$ToFast_Area.hide();
	$ToMsg_Area.hide();
	
	if(size > 0) {
		$Readarea.css("font-size",size + "px");
	}else{
		if($nowfs <= "32px"){
			$Readarea.css("font-size",parseFloat($nowfs) + 2 + "px");
			$.cookie('font-size',$Readarea.css("font-size").replace('px',''));
		}
	}
	if(lineheight > 0){
		$Readarea.css("line-height",lineheight + "px");	
	}else{
		if($nowfs <= "32px"){
			$Readarea.css("line-height",parseFloat($nowlh) + 2 + "px");
			$.cookie('line-height',$Readarea.css("line-height").replace('px',''));
		}
	}
}

function ToFontdown(size,lineheight){
	var $Readarea = $('.Readarea');
	var $nowfs = $Readarea.css("font-size"),
		$nowlh = $Readarea.css("line-height"),
		$ToBg_Menu = $('.ToBg_Menu'),
		$ToFast_Area = $('.ToFast_Area'),
		$ToMsg_Area = $('.ToMsg_Area'),
		$bottomMenu = $('.bottomMenu');
	
	$ToBg_Menu.hide();
	$ToFast_Area.hide();
	$ToMsg_Area.hide();
	//$bottomMenu.children().removeClass('sel');
	
	if(size > 0) {
		$Readarea.css("font-size",size + "px");
	}else{
		if($nowfs != "14px"){
			$Readarea.css("font-size",parseFloat($nowfs) - 2 + "px");
			$.cookie('font-size',$Readarea.css("font-size").replace('px',''));
		}
	}
	if(lineheight > 0){
		$Readarea.css("line-height",lineheight + "px");	
	}else{
		if($nowfs != "14px"){
			$Readarea.css("line-height",parseFloat($nowlh) - 2 + "px");
			$.cookie('line-height',$Readarea.css("line-height").replace('px',''));
		}
	}
}

$(function(){
	var $pagenum ;
	var $pagenum2 = 0;
	
	$('.page_txt').focus(function(){
		if($pagenum2 == ""){
			$pagenum = $(this).val();
		}
		$(this).val("");
		$(this).next().text('转　到');
		$(this).next().addClass('goto');
	});
	
	$('.page_txt').blur(function(){
		if($(this).val() == ""){
			if($pagenum2 == ""){
				$(this).val($pagenum);
			}else{
				$(this).val($pagenum2);
			}
			$(this).next().text('下一页');
			$(this).next().removeClass('goto');
		}else{
			$pagenum2 = $pagenum;
		}
		
		if($("#nextPage").attr("class")=="goto"){
		    var url=$("#nextPage").attr("href");
		    //url=url.replace(/page\=\d+/,"page="+$("#txtPage").val());
		    url=url.replace(/\d+.html/,$("#txtPage").val()+".html");
                    //url=url.replace(/week\S+.html/,"week_"+$("#txtPage").val()+".html");
		    $("#nextPage").attr("href",url);
		}
	});	
})


function _17mb_top(){
//	document.write("顶部广告");
}
function _17mb_middle(){
//	document.write("中部广告");
}
function _17mb_bottom(){
//	document.write("底部广告");
}
function _17mb_xuanfu(){
//	document.write("悬浮广告");
}


