<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/templatemo_main.css">
</head>

<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/weibo/hello");
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
        setMessageInnerHTML("欢迎管理员");
        websocket.send("yrucrewissuperadmin");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
    	var msg=innerHTML.split(" - ")
		
		var table=document.getElementById("tb");

		 var row;
		 row=table.insertRow(1);
		for(var i=0;i<msg.length;i++){
			 var cell = row.insertCell(i);
		 	 cell.appendChild(document.createTextNode(msg[i]));
		}
		if(table.rows.length>50){
			table.deleteRow(table.rows.length-1);
		}
      //  document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
        document.getElementById('text').value="";
    }
</script>
<body>
	<div class="navbar" role="navigation">
		<div class="navbar-header">
			<div class="logo">
				<h1>微博后台管理</h1>
			</div>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
	</div>
	<div class="template-page-wrapper">
		<div class="navbar-collapse collapse templatemo-sidebar">
			<ul class="templatemo-sidebar-menu">
				<li class="active"><a href="#"><i class="fa fa-home"></i>概览</a></li>
				<li><a href="#"><i class="fa fa-database"></i>微博管理</a></li>
				<li><a href="tables.html"><i class="fa fa-users"></i>用户管理</a></li>
				<li><a href="preferences.html"><i class="fa fa-cog"></i>密码修改</a></li>
				<li><a href="javascript:;" data-toggle="modal"
					data-target="#confirmModal"><i class="fa fa-sign-out"></i>退出登录</a></li>
			</ul>
		</div>
		<!--/.navbar-collapse -->

		<div class="templatemo-content-wrapper">
			<div class="templatemo-content">

				发送公告<br />
				<input id="text" type="text" />
				<button onclick="send()">发送消息</button>
				<hr />
				<button onclick="closeWebSocket()">关闭WebSocket连接</button>
				<hr />
				<div id="message"></div>
				<table id="tb" class="altrowstable">
					<th align="center" colspan="9">实时信息监控</th>
				</table>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">你确定要退出登录吗?</h4>
					</div>
					<div class="modal-footer">
						<a href="sign-in.html" class="btn btn-primary">Yes</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/templatemo_script.js"></script>

</body>
</html>