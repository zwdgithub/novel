var checkbg = "#A7A7A7";
var CryptoJS=CryptoJS||function(h,o){var f={},j=f.lib={},k=j.Base=function(){function a(){}return{extend:function(b){a.prototype=this;var c=new a;b&&c.mixIn(b);c.$super=this;return c},create:function(){var a=this.extend();a.init.apply(a,arguments);return a},init:function(){},mixIn:function(a){for(var c in a){a.hasOwnProperty(c)&&(this[c]=a[c])}a.hasOwnProperty("toString")&&(this.toString=a.toString)},clone:function(){return this.$super.extend(this)}}}(),i=j.WordArray=k.extend({init:function(a,b){a=this.words=a||[];this.sigBytes=b!=o?b:4*a.length},toString:function(a){return(a||p).stringify(this)},concat:function(a){var b=this.words,c=a.words,d=this.sigBytes,a=a.sigBytes;this.clamp();if(d%4){for(var e=0;e<a;e++){b[d+e>>>2]|=(c[e>>>2]>>>24-8*(e%4)&255)<<24-8*((d+e)%4)}}else{if(65535<c.length){for(e=0;e<a;e+=4){b[d+e>>>2]=c[e>>>2]}}else{b.push.apply(b,c)}}this.sigBytes+=a;return this},clamp:function(){var a=this.words,b=this.sigBytes;a[b>>>2]&=4294967295<<32-8*(b%4);a.length=h.ceil(b/4)},clone:function(){var a=k.clone.call(this);a.words=this.words.slice(0);return a},random:function(a){for(var b=[],c=0;c<a;c+=4){b.push(4294967296*h.random()|0)}return i.create(b,a)}}),l=f.enc={},p=l.Hex={stringify:function(a){for(var b=a.words,a=a.sigBytes,c=[],d=0;d<a;d++){var e=b[d>>>2]>>>24-8*(d%4)&255;c.push((e>>>4).toString(16));c.push((e&15).toString(16))}return c.join("")},parse:function(a){for(var b=a.length,c=[],d=0;d<b;d+=2){c[d>>>3]|=parseInt(a.substr(d,2),16)<<24-4*(d%8)}return i.create(c,b/2)}},n=l.Latin1={stringify:function(a){for(var b=a.words,a=a.sigBytes,c=[],d=0;d<a;d++){c.push(String.fromCharCode(b[d>>>2]>>>24-8*(d%4)&255))}return c.join("")},parse:function(a){for(var b=a.length,c=[],d=0;d<b;d++){c[d>>>2]|=(a.charCodeAt(d)&255)<<24-8*(d%4)}return i.create(c,b)}},q=l.Utf8={stringify:function(a){try{return decodeURIComponent(escape(n.stringify(a)))}catch(b){throw Error("Malformed UTF-8 data")}},parse:function(a){return n.parse(unescape(encodeURIComponent(a)))}},m=j.BufferedBlockAlgorithm=k.extend({reset:function(){this._data=i.create();this._nDataBytes=0},_append:function(a){"string"==typeof a&&(a=q.parse(a));this._data.concat(a);this._nDataBytes+=a.sigBytes},_process:function(a){var b=this._data,c=b.words,d=b.sigBytes,e=this.blockSize,f=d/(4*e),f=a?h.ceil(f):h.max((f|0)-this._minBufferSize,0),a=f*e,d=h.min(4*a,d);if(a){for(var g=0;g<a;g+=e){this._doProcessBlock(c,g)}g=c.splice(0,a);b.sigBytes-=d}return i.create(g,d)},clone:function(){var a=k.clone.call(this);a._data=this._data.clone();return a},_minBufferSize:0});j.Hasher=m.extend({init:function(){this.reset()},reset:function(){m.reset.call(this);this._doReset()},update:function(a){this._append(a);this._process();return this},finalize:function(a){a&&this._append(a);this._doFinalize();return this._hash},clone:function(){var a=m.clone.call(this);a._hash=this._hash.clone();return a},blockSize:16,_createHelper:function(a){return function(b,c){return a.create(c).finalize(b)}},_createHmacHelper:function(a){return function(b,c){return r.HMAC.create(a,c).finalize(b)}}});var r=f.algo={};return f}(Math);(function(){var h=CryptoJS,i=h.lib.WordArray;h.enc.Base64={stringify:function(b){var e=b.words,f=b.sigBytes,c=this._map;b.clamp();for(var b=[],a=0;a<f;a+=3){for(var d=(e[a>>>2]>>>24-8*(a%4)&255)<<16|(e[a+1>>>2]>>>24-8*((a+1)%4)&255)<<8|e[a+2>>>2]>>>24-8*((a+2)%4)&255,g=0;4>g&&a+0.75*g<f;g++){b.push(c.charAt(d>>>6*(3-g)&63))}}if(e=c.charAt(64)){for(;b.length%4;){b.push(e)}}return b.join("")},parse:function(b){var b=b.replace(/\s/g,""),e=b.length,f=this._map,c=f.charAt(64);c&&(c=b.indexOf(c),-1!=c&&(e=c));for(var c=[],a=0,d=0;d<e;d++){if(d%4){var g=f.indexOf(b.charAt(d-1))<<2*(d%4),h=f.indexOf(b.charAt(d))>>>6-2*(d%4);c[a>>>2]|=(g|h)<<24-8*(a%4);a++}}return i.create(c,a)},_map:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="}})();
//内容页用户设置
function nr_setbg(intype){
	var huyandiv = document.getElementById("huyandiv");
	var light = document.getElementById("lightdiv");
	if(intype == "huyan"){
		if(huyandiv.className == "button huyanon"){
			document.cookie="light=huyan;path=/"; 
			set("light","huyan");
		}
		else{
			document.cookie="light=no;path=/"; 
			set("light","no");
		}
	}
	if(intype == "light"){
		if(light.innerHTML == "关灯"){
			document.cookie="light=yes;path=/";
			set("light","yes");
		}
		else{
			document.cookie="light=no;path=/"; 
			set("light","no");
		}
	}
	if(intype == "big"){
		document.cookie="font=big;path=/";
		set("font","big");
	}
	if(intype == "middle"){
		document.cookie="font=middle;path=/"; 
		set("font","middle");
	}
	if(intype == "small"){
		document.cookie="font=small;path=/"; 
		set("font","small");
	}		
}

//内容页读取设置
function getset(){ 
	var strCookie=document.cookie; 
	var arrCookie=strCookie.split("; ");  
	var light;
	var font;

	for(var i=0;i<arrCookie.length;i++){ 
		var arr=arrCookie[i].split("="); 
		if("light"==arr[0]){ 
			light=arr[1]; 
			break; 
		} 
	} 

	//light
	if(light == "yes"){
		set("light","yes");
	}
	else if(light == "no"){
		set("light","no");
	}
	else if(light == "huyan"){
		set("light","huyan");
	}
}


//内容页读取设置
function getset1(){ 
	var strCookie=document.cookie; 
	var arrCookie=strCookie.split("; ");  
	var light;
	var font;

	for(var j=0;j<arrCookie.length;j++){ 
		var arr=arrCookie[j].split("="); 
		if("font"==arr[0]){ 
			font=arr[1]; 
			break; 
		} 
	} 

	//font
	if(font == "big"){
		set("font","big");
	}
	else if(font == "middle"){
		set("font","middle");
	}
	else if(font == "small"){
		set("font","small");
	}
	else{
		set("font","middle");	
	}
}

//内容页应用设置
function set(intype,p){
	var nr_body = document.getElementById("read");//页面body
	var huyandiv = document.getElementById("huyandiv");//护眼div
	var lightdiv = document.getElementById("lightdiv");//灯光div
	var fontfont = document.getElementById("fontfont");//字体div
	var fontbig = document.getElementById("fontbig");//大字体div
	var fontmiddle = document.getElementById("fontmiddle");//中字体div
	var fontsmall = document.getElementById("fontsmall");//小字体div
	var nr1 =  document.getElementById("chaptercontent");//内容div
	var nr_title =  document.getElementById("top");//文章标题
	//var nr_title =  document.getElementById("nr_title");//文章标题
	//var shuqian_2 = document.getElementById("shuqian_2");//书签链接
	
	//var pt_prev =  document.getElementById("pt_prev1");
	//var pt_mulu =  document.getElementById("pt_mulu1");
	//var pt_next =  document.getElementById("pt_next1");
	//var pb_prev =  document.getElementById("pb_prev1");
	//var pb_mulu =  document.getElementById("pb_mulu1");
	//var pb_next =  document.getElementById("pb_next1");

	
	//灯光
	if(intype == "light"){
		if(p == "yes"){	
			//关灯
			lightdiv.innerHTML = "开灯";
                        lightdiv.className="button lighton";
			nr_body.style.backgroundColor = "#222222";
                        //nr_body.style.backgroundColor = "rgb(50, 55, 59)";
			huyandiv.className = "button huyanon";
			//nr_title.style.color = "#ccc";
			nr1.style.color = "#888888";
                        nr_title.style.color = "#888888";
                        //nr1.style.color = "rgb(153, 153, 153)";
			//pt_prev.style.cssText = "background-color:#222;color:#0065B5;";
			//pt_mulu.style.cssText = "background-color:#222;color:#0065B5;";
			//pt_next.style.cssText = "background-color:#222;color:#0065B5;";
			//pb_prev.style.cssText = "background-color:#222;color:#0065B5;";
			//pb_mulu.style.cssText = "background-color:#222;color:#0065B5;";
			//pb_next.style.cssText = "background-color:#222;color:#0065B5;";
			//shuqian_2.style.color = "#999";
		}
		else if(p == "no"){
			//开灯
			lightdiv.innerHTML = "关灯";
			lightdiv.className="button lightoff";
			nr_body.style.backgroundColor = "rgb(251, 246, 236)";
			nr1.style.color = "#000";
                        nr_title.style.color = "#000";
			//nr_title.style.color = "#000";
			huyandiv.className = "button huyanon";
			//pt_prev.style.cssText = "";
			//pt_mulu.style.cssText = "";
			//pt_next.style.cssText = "";
			//pb_prev.style.cssText = "";
			//pb_mulu.style.cssText = "";
			//pb_next.style.cssText = "";
			//shuqian_2.style.color = "#000";
		}
		else if(p == "huyan"){
			//护眼
			lightdiv.innerHTML = "关灯";
                        lightdiv.className="button lightoff";
			huyandiv.className="button huyanoff";
			nr_body.style.backgroundColor = "rgb(220, 236, 210)";
			nr1.style.color = "#000";
			//pt_prev.style.cssText = "background-color:#0E7A18;color:#000;";
			//pt_mulu.style.cssText = "background-color:#0E7A18;color:#000;";
			//pt_next.style.cssText = "background-color:#0E7A18;color:#000;";
			//pb_prev.style.cssText = "background-color:#0E7A18;color:#000;";
			//pb_mulu.style.cssText = "background-color:#0E7A18;color:#000;";
			//pb_next.style.cssText = "background-color:#0E7A18;color:#000;";
			//shuqian_2.style.color = "#000";
		}
	}
	//字体
	if(intype == "font"){
		fontbig.className="sizebg";
		fontmiddle.className="sizebg";
		fontsmall.className="sizebg";
		if(p == "big"){
			fontbig.className="button sizebgon";
			nr1.style.fontSize="25px";
		}
		if(p == "middle"){
			fontmiddle.className="button sizebgon";
			nr1.style.fontSize = "20px";
		}
		if(p == "small"){
			fontsmall.className="button sizebgon";
			nr1.style.fontSize = "14px";
		}
	}
}


function style_top(){
document.writeln("");
}

function fanye2(){
document.writeln("");
}

function tm(){

}
