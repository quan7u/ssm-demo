<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<script type="text/javascript">
	// 查找微博
	function search_weibo() {
		var keyWord = $("#searchText").val();
		var url = "${pageContext.request.contextPath }/queryWeiboByWord.action?pageNo=1&keyWord="
				+ keyWord;
		if (keyWord == "") {
			alert("什么都没有 想要找什么呢？！");
		} else {
			window.location = url;
		}
	}

	// 查找用户
	function search_people() {
		var keyWord = $("#searchText").val();
		var url = "${pageContext.request.contextPath }/queryUserByWord.action?keyWord="
				+ keyWord;
		if (keyWord == "") {
			alert("什么都没有 找个鸡儿");
		} else {
			window.location = url;
		}
	}

	var websocket = null;
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://localhost:8080/weibo/hello");
	} else {
		alert('当前浏览器 Not support websocket')
	}

	//连接发生错误的回调方法
	websocket.onerror = function() {
		//setMessageInnerHTML("WebSocket连接发生错误");
	};

	//连接成功建立的回调方法
	websocket.onopen = function() {
		//setMessageInnerHTML("WebSocket连接成功");
	}

	//接收到消息的回调方法
	websocket.onmessage = function(event) {
		setMessageInnerHTML(event.data);
		// alert("!");
	}

	//连接关闭的回调方法
	websocket.onclose = function() {
		// setMessageInnerHTML("WebSocket连接关闭");
	}

	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function() {
		closeWebSocket();
	}

	//将消息显示在网页上
	function setMessageInnerHTML(innerHTML) {
		var msg = innerHTML;
		if (msg.indexOf("*ADMIN* ") == -1) {// 没有管理员标识
			var message = '<div class="alert alert-warning">'
					+ '<a href="#" class="close" data-dismiss="alert">'
					+ '&times;</a>' + '<strong>通知！</strong>' + msg + '</div>';
			$('#message').prepend(message);
		}
	}

	//关闭WebSocket连接
	function closeWebSocket() {
		//websocket.close();
	}

	//发送消息
	function send() {
		//var message = document.getElementById('text').value;
		//websocket.send(message);
	}
</script>
<!-- 导航栏 -->
<nav class="navbar navbar-fixed-top" role="navigation"
	style="background-color: #f5f5f5eb;">
	<div class="container-fluid">
		<div>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="queryAllWeiboNow.action?pageNo=1">实时</a></li>
				<li><a href="queryAllWeiboFollow.action?pageNo=1">首页</a></li>
				<li><a href="queryAllWeiboFriends.action?pageNo=1">好友圈</a></li>
				<li><input required="required" id="searchText" type="text"
					style="margin-top: 8px;" class="form-control" placeholder="搜索"></li>
				<li><button style="margin-top: 8px; margin-left: 5px;"
						onclick="search_people();" class="form-control btn btn-info">找人</button></li>
				<li><button style="margin-top: 8px; margin-left: 10px;"
						onclick="search_weibo();" class="form-control btn btn-info">找微博</button></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a id="notice" href="#"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false"> <span
						class="glyphicon glyphicon-comment"></span> 通知 <span id="badge"
						class="badge" style="display: none; background-color: red"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="toRepostPage.action?pageNo=1">转发<span
								id="repost_badge" class="badge"
								style="display: none; background-color: red"></span></a></li>
						<li><a href="toCommentPage.action?pageNo=1">评论<span
								id="comment_badge" class="badge"
								style="display: none; background-color: red"></span></a></li>
						<li><a href="toReplyPage.action?pageNo=1">回复<span
								id="reply_badge" class="badge"
								style="display: none; background-color: red"></span></a></li>
						<li><a href="toLikePage.action?pageNo=1">赞<span
								id="like_badge" class="badge"
								style="display: none; background-color: red"></span></a></li>
						<li><a href="listFans.action?userId=${user.userId }">新的粉丝<span
								id="fans_badge" class="badge"
								style="display: none; background-color: red"></span></a></li>
					</ul></li>
				<li><a href="queryMinePage.action?pageNo=1"> <span
						class="glyphicon glyphicon-user"></span> ${user.nickname }
				</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> <span class="glyphicon glyphicon-cog"></span>设置
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="updateInfo.action">修改个人信息</a></li>
						<li><a href="toUpdatePassword.action">修改密码</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="${pageContext.request.contextPath }/exit.action">登出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- 用户信息 -->
	<input type="hidden" value="${user.face }" id="face"> <input
		type="hidden" value="${user.nickname }" id="nickname"> <input
		type="hidden" value="${user.userId}" id="userId">
	<div id="message"></div>
</nav>