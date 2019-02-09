function setCookie(c_name, value) {
	var exdate = new Date()
	exdate.setDate(exdate.getDate() + 365)
	document.cookie = c_name + "=" + escape(value) + ";expires="
			+ exdate.toGMTString() + ";path=/";
}

function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=");
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if (c_end == -1)
				c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

function delCookie(name) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	document.cookie = name + "=;expires=" + exp.toGMTString();
}

function isLogin() {
	return true;
	if (getCookie("_17mb_username").length > 0) {
		return true;
	} else {
		return false;
	}
}

function addBookMarkByManual(bookid, chapterid, articlename, chaptername) {
	if (isLogin()) {
		$.ajax({
			async : false,
			type : 'POST',
			url : '/users/add-bookmark',
			contentType : "application/json",
			data : JSON.stringify({
				"articleid" : bookid,
				"chapterid" : chapterid,
				"articlename" : articlename,
				"chaptername" : chaptername
			}),
			success : function(data) {
				if (data.data.success) {
					alert('添加成功');
				} else {
					alert("请先登录您的帐号");
					window.location.href='https://m.2hxs.com/login.php'
				}
			}
		});
	} else {
		alert("登录成功后才可以使用书架功能！");
		location.href = "/login.php";
	}
}

function addHistoryBookByManual2(chapterid, bookid, chaptername) {
	var currentBook = {
		BookId : bookid,
		ChapterId : chapterid,
		ChapterName : chaptername
	};
	var bookList = getBookcase();
	if (bookList != null && bookList != undefined) {
		var bookcount = getBookcaseCount(bookList);
		bookList[bookid] = currentBook;
		saveBookcase(bookList);
		if (bookcount > 10) {
			removeBookFromTop(bookcount - 10);
		}
	}
}

function convertBookData() {
	var bookInfoStr = getCookie("bookinfo");
	if (bookInfoStr != null && bookInfoStr != undefined) {
		var cookiesBookInfo = bookInfoStr.split("§§");
		if (cookiesBookInfo.length > 0) {
			for (var i = 0; i < cookiesBookInfo.length; i++) {
				var bookInfoItem = cookiesBookInfo[i].split("||");
				if (bookInfoItem.length == 3) {
					addHistoryBookByManual2(bookInfoItem[1], bookInfoItem[0],
							bookInfoItem[2]);
				}
			}
		}
		delCookie("bookinfo");
	}
}

function getBookcase() {
	var bookList = new Array();
	var strBookList = getCookie("booklist");
	if (strBookList != null && strBookList != undefined
			&& strBookList.length > 0) {
		var arrBookList = strBookList.split(",");
		for (var i = 0; i < arrBookList.length; i++) {
			var bookItem = JSON.parse(unescape(arrBookList[i]));
			bookList[bookItem.BookId] = bookItem;
		}
	}
	return bookList;
}

function removeBookFromTop(num) {
	var bookList = new Array();
	var strBookList = getCookie("booklist");
	if (strBookList != null && strBookList != undefined
			&& strBookList.length > 0) {
		var arrBookList = strBookList.split(",");
		for (var i = num; i < arrBookList.length; i++) {
			var bookItem = JSON.parse(unescape(arrBookList[i]));
			bookList[bookItem.BookId] = bookItem;
		}
	}
	saveBookcase(bookList);
}

function getBookcaseCount(bookList) {
	var count = 0;
	if (bookList != null && bookList != undefined && bookList.length > 0) {
		for ( var bookIndex in bookList) {
			count++;
		}
	}
	return count;
}

function saveBookcase(bookList) {
	if (bookList != null && bookList != undefined && bookList.length > 0) {
		var strCookieBookId = "";
		var strCookieBookList = "";
		for ( var bookIndex in bookList) {
			strCookieBookId = strCookieBookId + "," + bookIndex;
			strCookieBookList = strCookieBookList + ","
					+ escape(JSON.stringify(bookList[bookIndex]));
		}
		if (strCookieBookId.length > 0) {
			strCookieBookId = strCookieBookId.substring(1);
		}
		if (strCookieBookList.length > 0) {
			strCookieBookList = strCookieBookList.substring(1);
		}
		setCookie("bookid", strCookieBookId);
		setCookie("booklist", strCookieBookList);
	}
}

if ($(".cont") != null && $(".cont").html() != null) {
	$(".cont").html(
			$(".cont").html().replace(/&amp;nbsp;/g, "<br />").replace(
					/\<br \/\>\s*(&nbsp;)+\<br \/\>/g, "<br />"));
}