$(function(){
		longview();
		$(window).scroll(function(){
			var h = $(window).height();
			var scroll = h+window.scrollY;
			if(scroll > h){
				if(scroll >= $('footer').offset().top){
					$("#slidetop").css('right','-50px');
				}else{
					$("#slidetop").css('right','20px');
				}
			}else{
				$("#slidetop").css('right','-50px');
			}
		});
	})

	function longview(){
		$('.longview').click(function(){
			var area = $(this).parents('.hot_sale');
			if(area.height() == 100){
				var heights = area.css('height','auto').height();
				area.css('height','100px');
				area.animate({
					height:heights
				},100);
				$(this).animate({
					transform:'rotate(180deg)',
					'-webkit-transform':'rotate(180deg)',
					'-moz-transform':'rotate(180deg)',
					'-o-transform':'rotate(180deg)'
				},100);
			}else{
				area.animate({
					height:'100px'
				},100);
				$(this).animate({
					transform:'rotate(0deg)',
					'-webkit-transform':'rotate(0deg)',
					'-moz-transform':'rotate(0deg)',
					'-o-transform':'rotate(0deg)'
				},100);
			}
		});
	}
	
	function slidetop(){
		var h = $(window).height();
		var scroll = h+window.scrollY;
		if(scroll > h){
			if(scroll >= $('footer').offset().top){
				$("#slidetop").css('right','-50px');
			}else{
				$("#slidetop").css('right','20px');
			}
		}else{
			$("#slidetop").css('right','-50px');
		}
	}