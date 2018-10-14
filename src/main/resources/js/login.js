var $login_name = $('.login_nm');
var $login_psw = $('.login_psw');
var $login_bto = $('.login_bto');
var $reg_bto = $('.reg_bto');
var $register_nm = $('.register_nm');
var $register_psw = $('.register_psw');
var $register_repsw = $('.register_repsw');

	$login_name.focus(function(){
		if($login_name.val() == "用户名"){
			$login_name.val("");
		}
	});
	
	$login_name.blur(function(){
		checkloginname();
	});
	
	$login_psw.focus(function(){
		if($login_psw.val() == "你的账号密码"){
			$login_psw.val("");
			
		}
	});
	
	$login_psw.blur(function(){
		checkloginpwd();
	});
	
	$login_bto.click(function(){
		if(checkloginname() && checkloginpwd()){
			document.form_login.submit();
		}else{
			return false;
		}
	});

	$reg_bto.click(function(){
		if(checkregname()&&checkregpwd()&&checkregrepwd()){
			console.log();
			document.form_reg.submit();
		}else{
			return false;
		}
	});
	
	$register_psw.focus(function(){
		if($register_psw.val() == "账号密码"){
			$register_psw.val("");
		}
	});
	
	$register_psw.blur(function(){
		checkregpwd();
	}); 
	
	$register_repsw.focus(function(){
		if($register_repsw.val() == "再次输入密码"){
			$register_repsw.val("");
		}
	});
	
	$register_repsw.blur(function(){
		checkregrepwd();
	}); 
	
	$register_nm.focus(function(){
		if($register_nm.val() == "账号名，5~16位字符"){
			$register_nm.val("");
			$(this).parent().next().show();
			
		}else{
			//$(this).parent().next().hide();
			}
	});
	
	$register_nm.blur(function(){
		checkregname();
	});
	
	
	function checkloginname(){
		if($login_name.val() == "" || $login_name.val() == "用户名"){
			$login_name.val("用户名");
			$login_name.parent().next().show();
			return false;
		}else{$login_name.parent().next().hide();return true;}
	}

	function checkloginpwd(){
		if($login_psw.val() == "" || $login_psw.val() == "你的账号密码"){
			$login_psw.val("你的账号密码");
			$login_psw.parent().next().show();
			return false;
		}else{$login_psw.parent().next().hide();return true;}
	}
	
	function checkregname(){
		//验证提示	
	       var iszw = /^\w*[u4e00-u9fa5]+\w*$/;
			if($register_nm.val() == "" || $register_nm.val() =="账号名，5~16位字符"){
				 $register_nm.parent().next().html("账号名为5-16位字符，由英文、数字组成，不能全数字");
				 $register_nm.parent().next().show();
				 return false;
			}else if(!iszw.test($register_nm.val())){
					 $register_nm.parent().next().html("不能有中文字符哦");
					 $register_nm.parent().next().show();
					 return false;
	        }else if(!isNaN($register_nm.val())){
	        	$register_nm.parent().next().html("不能全数字哦");
	        	$register_nm.parent().next().show();
	        	return false;
	        }else if($register_nm.val().length<5 || $register_nm.val().length >16 )
	        {
	        	$register_nm.parent().next().html("账号名为5-16位字符，由英文、数字组成，不能全数字");
	        	$register_nm.parent().next().show();
	        	return false;
	       
	        }else{
	        	$register_nm.parent().next().html("输入正确");
	        	$register_nm.parent().next().show();
	        	return true;
	       }
	}
	
	function checkmobile(){
		if(!$register_moble_nm.val().match(/^1[3|4|5|8][0-9]\d{4,8}$/)){
			$register_moble_nm.parent().parent().next().html("手机号码格式不正确！请重新输入！");
			$register_moble_nm.parent().parent().next().show();
			return false;
		}else{$register_moble_nm.parent().parent().next().hide();return true;}
	}
	
	function checkregpwd(){
		if($register_psw.val() == "" || $register_psw.val() == "账号密码"){
			$register_psw.val("账号密码");
			$register_psw.parent().next().show();
			return false;
		}else{$register_psw.parent().next().hide();return true;}
	}
	
	function checkregrepwd(){
	    if($register_repsw.val() == "" || $register_repsw.val() == "再次输入密码"){
			$register_repsw.val("再次输入密码");
			$register_repsw.parent().next().html("请再次输入密码");
			$register_repsw.parent().next().show();
			return false;
		}
		else if($register_repsw.val() != $register_psw.val()){
			$register_repsw.parent().next().html("两次输入的密码不一致！");
			$register_repsw.parent().next().show();
			return false;
		}else{$register_repsw.parent().next().hide();return true;}
	}


