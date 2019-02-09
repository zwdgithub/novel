var _num = 10;
function LastRead(){
	this.bookList="bookList"
	}
LastRead.prototype={	
	set:function(bid,tid,title,texttitle,author){
		if(!(bid&&tid&&title&&texttitle))return;
		var v=bid+'#'+tid+'#'+title+'#'+texttitle+'#'+author;
		this.setItem(bid,v);
		this.setBook(bid)		
		},
	
	get:function(k){
		return this.getItem(k)?this.getItem(k).split("#"):"";						
		},
	
	remove:function(k){
		this.removeItem(k);
		this.removeBook(k)			
		},
	
	setBook:function(v){
		var reg=new RegExp("(^|#)"+v); 
		var books =	this.getItem(this.bookList);
		if(books==""){
			books=v
			}
		 else{
			 if(books.search(reg)==-1){
				 books+="#"+v				 
				 }
			 else{
				  books.replace(reg,"#"+v)
				 }	 
			 }	
			this.setItem(this.bookList,books)
		
		},
	
	getBook:function(){
		var v=this.getItem(this.bookList)?this.getItem(this.bookList).split("#"):Array();
		var books=Array();
		if(v.length){
			
			for(var i=0;i<v.length;i++){
				var tem=this.getItem(v[i]).split('#');	
				if(i>v.length-(_num+1)){
					if (tem.length>3)	books.push(tem);
				}
				else{
					lastread.remove(tem[0]);
				}
			}		
		}
		return books		
	},
	
	removeBook:function(v){		
	    var reg=new RegExp("(^|#)"+v); 
		var books =	this.getItem(this.bookList);
		if(!books){
			books=""
			}
		 else{
			 if(books.search(reg)!=-1){	
			      books=books.replace(reg,"")
				 }	 
			 
			 }	
			this.setItem(this.bookList,books)		
		
		},
	
	setItem:function(k,v){
		if(!!window.localStorage){		
			localStorage.setItem(k,v);		
		}
		else{
			var expireDate=new Date();
			  var EXPIR_MONTH=3*12*30*24*3600*1000;			
			  expireDate.setTime(expireDate.getTime()+12*EXPIR_MONTH)
			  document.cookie=k+"="+encodeURIComponent(v)+";expires="+expireDate.toGMTString()+"; path=/";			  
			}			
		},
		
	getItem:function(k){
		
		var value=""
		var result=""				
		if(!!window.localStorage){
			result=window.localStorage.getItem(k);
			 value=result||"";	
		}
		else{
			var reg=new RegExp("(^| )"+k+"=([^;]*)(;|\x24)");
			var result=reg.exec(document.cookie);
			if(result){
				value=decodeURIComponent(result[2])||""}				
		}
		return value
		
		},
	
	removeItem:function(k){		
		if(!!window.localStorage){
		 window.localStorage.removeItem(k);		
		}
		else{
			var expireDate=new Date();
			expireDate.setTime(expireDate.getTime()-1000)	
			document.cookie=k+"= "+";expires="+expireDate.toGMTString()							
		}
		},	
	removeAll:function(){
		if(!!window.localStorage){
		 window.localStorage.clear();		
		}
		else{
		var v=this.getItem(this.bookList)?this.getItem(this.bookList).split("#"):Array();
		var books=Array();
		if(v.length){
			for( i in v ){
				var tem=this.removeItem(v[k])				
				}		
			}
			this.removeItem(this.bookList)				
		}
		}	
	}

function showbook(){
	var showbook=document.getElementById('newcase');
	var books=lastread.getBook();
	var bookhtml = '';
	if(books.length){
		var k = 1;
		for(var i=books.length-1;i>-1;i--){
			var articleid = parseInt(books[i][0]);
			var shortid = parseInt(articleid/1000);
			var articlename = books[i][2];
			var lastchapter = books[i][3];
			var lastchapterid = books[i][1];
			var author = books[i][4];
			var c = '';
			if((k % 2) == 0){
				c = 'hot_saleEm';
			}
			bookhtml+='<div class="hot_sale'+' '+c+'"><span class="num num'+k+'">'+k+'</span>';
            bookhtml+='<a href="/'+shortid+'_'+articleid+'/"><p class="title">'+articlename+'</p>';
            bookhtml+='<p class="author">上次阅读：<a style="color: Red;" href="/'+shortid+'_'+articleid+'/'+lastchapterid+'.html" target="_blank">'+lastchapter+'</a></p>';
            bookhtml+='<p class="author"><a href="javascript:removebook('+articleid+')"><font color="#ff0000">从书架删除</font></a></p>';
            bookhtml+='</div>';
			k++;
		}
		showbook.innerHTML = bookhtml;
	}
	else{
		showbook.innerHTML = '<div class="bookcasetip">您还没有阅读记录</div>';
	}
	

} 

function removebook(k){
	lastread.remove(k);
	showbook()
}


	
function yuedu(){
	//document.write("<a href='javascript:showbook();' target='_self'>点击查看阅读记录</a>");
	showbook();
}

window.lastread = new LastRead();

function artinfo(aid){
	$(function(){
		$.ajax({
			type:'GET',
			url:'/ajax.php',
			data:'ac=newcase&aid='+aid,
			error: function(){},
			success: function(data){
						$d = data.split("|")
						$("#"+aid+"newcase_author").html($d[3]);
						$("#"+aid+"newcase_fullflag").html($d[4]);
						$("#"+aid+"newcase_lastchapter").html('<a href="/'+$d[1]+'_'+$d[0].replace(/\s/g,'') +'/'+$d[5]+'.html">'+$d[6]+'</a>');
					}
		});
	})
	
}
