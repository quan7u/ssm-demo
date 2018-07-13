<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/login.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/upload.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/zoomify.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.12.0.min.js "></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/upload.js "></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/longPolling.js "></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#bt0").click(function() {
			$("#com0").toggle();
		});
		$("#bt1").click(function() {
			$("#com1").toggle();
		});
		$("#bt2").click(function() {
			$("#com2").toggle();
		});
		$("#bt3").click(function() {
			$("#com3").toggle();
		});
		$("#bt4").click(function() {
			$("#com4").toggle();
		});
		$("#bt5").click(function() {
			$("#com5").toggle();
		});
		$("#bt6").click(function() {
			$("#com6").toggle();
		});
		$("#bt7").click(function() {
			$("#com7").toggle();
		});
		$("#bt8").click(function() {
			$("#com8").toggle();
		});
		$("#bt9").click(function() {
			$("#com9").toggle();
		});
	})
</script>

<!-- 导航栏 -->
<jsp:include page="../nav.jsp"></jsp:include>
</head>
<body style="padding: 80px">


	<!-- 正文 -->
	<div class="container">
		<!-- 右侧个人简单信息 -->
		<div style="width: 20%; float: right; background-color: #fff;height: 220px;">
			<!-- 头像 -->
			<img src="/imgUpload/${user.face}" style="margin-top: 10px;"
				height="90px " width="90px" class="img-circle " align="center">
			<!-- 昵称 -->
			<br> <span style="font-size: 20px;">${user.nickname}&nbsp;&nbsp;</span>
			<br> <br>
			<table align="center" style="table-layout: fixed;">
				<tr>
					<td><a href="queryUserPage.action?userId=${user.userId}">${user.weiboCount }微博&nbsp;</a></td>
					<td><a href="listFollow.action?userId=${user.userId }">${user.followCount }关注&nbsp;</a></td>
					<td><a href="listFans.action?userId=${user.userId }">${user.fansCount }粉丝</td>
				</tr>
			</table>
			<br>
			<c:if test="${user.sex==0 }">
				<span style="font-size: 15px">♀ </span>
			</c:if>
			<c:if test="${user.sex==1 }">
				<span style="font-size: 15px">♂ </span>
			</c:if>
			<span style="font-size: 15px"> ${user.age } 岁 ${user.p }
				${user.c }</span>
		</div>

		<!-- 左侧导航栏 -->
		<div style="width: 8%; float: left; margin-right: 10px; background-color: #fff;">
			<ul class="nav navbar-nav navbar-left">
				<li style="width: 100%"><a href="queryAllWeiboFollow.action?pageNo=1">首页</a></li>
				<li style="width: 100%"><a href="queryAllWeiboFriends.action?pageNo=1">好友圈</a></li>
				<li style="width: 100%"><a href="toMyLikes.action?pageNo=1">我的赞</a></li>
				<li style="width: 100%"><a href="toMyCollection.action?pageNo=1">我的收藏</a></li>
			</ul>
		</div>

		<!-- 微博内容 -->
		<div style="width: 70%; float: left;">
			<!-- 发送新微博 -->
			<div class="container" style="width: auto; background-color: #fff;">
				<p style="font-size: 40px; color: black">分享新鲜事</p>
				<form method="post" action="post.action">
					<textarea class="form-control" rows="4"
						style="border: 1px; resize: none; width: 100%; background-color: #eee"
						name="weiboCustom.content"></textarea>
					<div id="uploader-demo">
						<div class="webuploader-container">
							<!--用来存放item-->
							<div id="fileList" class="uploader-list"></div>
							<div id="sendButtom">
								<div id="one" style="float: left; margin-left: 40%;">
									<div id="filePicker" class="webuploader-pick form-control">选择图片</div>
									<input type="file" name="file"
										class="webuploader-element-invisible" multiple="multiple"
										accept="image/*"> <label
										style="cursor: pointer; background: rgb(255, 255, 255);"></label>
								</div>
								<div id="two" style="float: left;">
									<button id="postWeibo" type="submit"
										class="form-control btn btn-success">发微博</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

			<c:forEach items="${weiboList }" var="weibo" varStatus="status">
				<div id="weiboItem">
					<!-- 头部 -->
					<div class="container"
						style="width: auto; background-color: white;">
						<!-- 头像 -->
						<div
							style="cursor: pointer; height: 50px; width: 50px; margin: 10px; float: left;">
							<c:if test="${weibo.user.userId==user.userId}">
								<img onclick="javascript:clickme();"
									src="/imgUpload/${weibo.user.face}" width="50px" height="50px"
									class="img-circle">
							</c:if>
							<c:if test="${weibo.user.userId!=user.userId}">
								<img onclick="javascript:clickother(${weibo.user.userId});"
									src="/imgUpload/${weibo.user.face}" width="50px" height="50px"
									class="img-circle">
							</c:if>
						</div>
						<!-- 昵称+日期 -->
						<div
							style="text-align: left; margin: 10px; margin-left: 20px; float: left;">
							<a style="color: #333; font-size: 20px" href="javascrip:;">${weibo.user.nickname }</a><br>
							<span style="color: #333; font-size: 15px">${weibo.date }</span>
						</div>
					</div>
					<!-- 内容 -->
					<div class="container"
						style="width: auto; background-color: #fff;">
						<!-- 文字 -->
						<!-- onclick="javascript:clickWeibo(${weibo.weiboId});" -->
						<div style="text-align: left; margin-left: 85px">
							<p style="color: #333; font-size: 17px">${weibo.content }</p>
						</div>
						<!-- 原创微博 -->
						<c:if test="${weibo.original == 1 }">
							<!-- 图片 -->
							<div class="example"
								style="margin-left: 85px; margin-bottom: 20px;">
								<table>
									<tr>
										<c:if test="${weibo.pic1!=null }">
											<td><img src="/imgUpload/${weibo.pic1 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
										<c:if test="${weibo.pic2!=null }">
											<td><img src="/imgUpload/${weibo.pic2 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
										<c:if test="${weibo.pic3!=null }">
											<td><img src="/imgUpload/${weibo.pic3 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
									</tr>
									<tr>
										<c:if test="${weibo.pic4!=null }">
											<td><img src="/imgUpload/${weibo.pic4 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
										<c:if test="${weibo.pic5!=null }">
											<td><img src="/imgUpload/${weibo.pic5 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
										<c:if test="${weibo.pic6!=null }">
											<td><img src="/imgUpload/${weibo.pic6 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
									</tr>
									<tr>
										<c:if test="${weibo.pic7!=null }">
											<td><img src="/imgUpload/${weibo.pic7 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
										<c:if test="${weibo.pic8!=null }">
											<td><img src="/imgUpload/${weibo.pic8 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
										<c:if test="${weibo.pic9!=null }">
											<td><img src="/imgUpload/${weibo.pic9 }"
												style="width: 130px; height: 130px"></td>
										</c:if>
									</tr>
								</table>
							</div>
						</c:if>
					</div>

					<!-- 非原创 转发微博 -->
					<c:if test="${weibo.original == 0 }">
						<!-- 头部 -->
						<div class="container"
							style="width: auto; background-color: #eaeaec;">
							<!-- 头像 -->
							<div
								style="cursor: pointer; height: 30px; width: 30px; margin: 10px; float: left; margin-left: 100px;">

								<c:if test="${weibo.repost.user.userId==user.userId }">
									<img onclick="javascript:clickme();"
										src="/imgUpload/${weibo.repost.user.face}" width="40px"
										height="40px" class="img-circle">
								</c:if>
								<c:if test="${weibo.repost.user.userId!=user.userId }">
									<img
										onclick="javascript:clickother(${weibo.repost.user.userId});"
										src="/imgUpload/${weibo.repost.user.face}" width="40px"
										height="40px" class="img-circle">
								</c:if>
							</div>
							<!-- 昵称+日期 -->
							<div
								style="text-align: left; margin: 10px; margin-left: 20px; float: left;">
								<a style="color: #333; font-size: 14px" href="javascrip:;">${weibo.repost.user.nickname }</a><br>
								<span style="color: #333; font-size: 10px">${weibo.repost.date }</span>
							</div>
						</div>
						<div class="container"
							style="width: auto; background-color: #eaeaec;">
							<!-- 文字 -->
							<!-- onclick="javascript:clickWeibo(${weibo.weiboId});" -->
							<div style="text-align: left; margin-left: 160px">
								<p style="color: #333; font-size: 17px">${weibo.repost.content }</p>
							</div>
							<!-- 图片 -->
							<div class="example"
								style="margin-left: 160px; margin-bottom: 20px;">
								<table>
									<tr>
										<c:if test="${weibo.repost.pic1!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic1 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
										<c:if test="${weibo.repost.pic2!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic2 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
										<c:if test="${weibo.repost.pic3!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic3 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
									</tr>
									<tr>
										<c:if test="${weibo.repost.pic4!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic4 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
										<c:if test="${weibo.repost.pic5!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic5 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
										<c:if test="${weibo.repost.pic6!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic6 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
									</tr>
									<tr>
										<c:if test="${weibo.repost.pic7!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic7 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
										<c:if test="${weibo.repost.pic8!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic8 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
										<c:if test="${weibo.repost.pic9!=null }">
											<td><img src="/imgUpload/${weibo.repost.pic9 }"
												style="width: 90px; height: 90px"></td>
										</c:if>
									</tr>
								</table>
							</div>
						</div>
					</c:if>
					<!-- 底部 -->
					<div class="container"
						style="width: auto; background-color: #fff;">
						<br>
						<div class="btn-group" style="width: 100%">
							<!---------------------------------------------------- 收藏 --------------------------------------------------------->
							<c:if test="${weibo.collect==0 }">
								<button id="collect${weibo.weiboId }"
									onclick="javascript:collect(${weibo.weiboId});" type="button"
									style="width: 25%;" class="btn btn-success">收藏</button>
							</c:if>
							<c:if test="${weibo.collect==1 }">
								<button id="collect${weibo.weiboId }"
									onclick="javascript:collect(${weibo.weiboId});" type="button"
									style="width: 25%;" class="btn btn-success">已收藏</button>
							</c:if>
							<!----------------------------------------------------转发---------------------------------------------------------->
							<button type="button" style="width: 25%" class="btn btn-primary"
								onclick="javascript:repost(${weibo.weiboId});">转发</button>
							<!------------------------------------------------------评论------------------------------------------------------->
							<button onclick="javascript:loadComment(${weibo.weiboId});"
								type="button" style="width: 25%" class="btn btn-warning"
								id="bt${status.index }"><span style="color: #fff;" id="likespan${weibo.weiboId }"
										class="glyphicon glyphicon-comment" aria-hidden="true"></span>
									<span style="color: #fff;" id="likeCount${weibo.weiboId}">${weibo.commentCount}</span></button>
							<!---------------------------------------------------- 点赞 --------------------------------------------------------->
							<c:if test="${weibo.likes==0 }">
								<button id="like${weibo.weiboId}" type="button"
									style="width: 25%" class="btn btn-danger"
									onclick="javascript:likes(${weibo.weiboId})">
									<span style="color: #fff;" id="likespan${weibo.weiboId }"
										class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
									<span style="color: #fff;" id="likeCount${weibo.weiboId}">${weibo.likeCount}</span>
								</button>
							</c:if>
							<c:if test="${weibo.likes==1 }">
								<button id="like${weibo.weiboId}" type="button"
									style="width: 25%" class="btn btn-danger"
									onclick="javascript:likes(${weibo.weiboId})">
									<span style="color: #fff;" id="likespan${weibo.weiboId }"
										class="glyphicon glyphicon-heart" aria-hidden="true"></span> <span
										style="color: #fff;" id="likeCount${weibo.weiboId}">${weibo.likeCount}</span>
								</button>
							</c:if>


						</div>
					</div>
				</div>
				<!-- 转发模态框 -->
				<div class="modal fade" id="Modal${weibo.weiboId}" role="dialog"
					aria-labelledby="myModalLabel">
					<form method="POST" action="repost.action">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel" style="color: #987">转发这条微博</h4>
								</div>
								<div class="modal-body">
									<c:if test="${weibo.original == 0 }">
										<input type="hidden" name="repostId"
											value="${weibo.repostId }">
									</c:if>
									<c:if test="${weibo.original == 1 }">
										<input type="hidden" name="repostId" value="${weibo.weiboId }">
									</c:if>
									<textarea autofocus="autofocus" id="repostContent"
										name="repostContent" class="content comment-input "
										placeholder="说点什么吧"></textarea>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">取消</button>
									<button type="submit" class="btn btn-primary">转发</button>
								</div>
							</div>
						</div>
					</form>
				</div>
				<!-- 评论区 -->
				<div class="container "
					style="width: auto; background-color: #fff;">
					<div class="commentAll " id="com${status.index }"
						style="display: none;">
						<!--评论区域 begin-->
						<div class="reviewArea clearfix ">
							<textarea class="content comment-input "
								placeholder="等待输入......." onkeyup="keyUP(this) "></textarea>
							<a href="javascript:; " class="plBtn ">评论</a>
							<!-- 微博id -->
							<input type="hidden" value="${weibo.weiboId}" class="weiboId">
						</div>
						<!--评论区域 end-->
						<!--回复区域 begin-->
						<div class="comment-show " id="${weibo.weiboId }"></div>
						<!--回复区域 end-->
					</div>
					<hr>
				</div>
			</c:forEach>
			<div class="container" style="width: auto; background-color: #fff;">
				<!-- 分页 -->
				<ul class="pagination pagination-lg">
					<!-- 上一页 -->
					<li><a href="queryAllWeiboFollow.action?pageNo=${page.pageNo-1 }">&laquo;</a></li>
					<c:choose>
						<%-- 第一条：如果总页数<=5，那么页码列表为1 ~ tp --%>
						<c:when test="${page.totalPage <= page.pageSize }">
							<c:set var="begin" value="1" />
							<c:set var="end" value="${page.totalPage }" />
						</c:when>
						<c:otherwise>
							<%-- 第二条：按公式计算，让列表的头为当前页+2；列表的尾为当前页+2 --%>
							<c:set var="begin" value="${page.pageNo-2 }" />
							<c:set var="end" value="${page.pageNo+2 }" />

							<%-- 第三条：第二条只适合在中间，而两端会出问题。这里处理begin出界！ --%>
							<%-- 如果begin<1，那么让begin=1，相应end=10 --%>
							<c:if test="${begin<1 }">
								<c:set var="begin" value="1" />
								<c:set var="end" value="5" />
							</c:if>
							<%-- 第四条：处理end出界。如果end>tp，那么让end=tp，相应begin=tp-4 --%>
							<c:if test="${end>page.totalPage }">
								<c:set var="begin" value="${page.totalPage-4 }" />
								<c:set var="end" value="${page.totalPage }" />
							</c:if>
						</c:otherwise>
					</c:choose>
					<c:forEach begin="${begin}" end="${end}" var="i">
						<c:if test="${i==page.pageNo }">
							<li class="active"><a href="#">${i}</a></li>
						</c:if>
						<c:if test="${i!=page.pageNo }">
							<li><a href="queryAllWeiboFollow.action?pageNo=${i }">${i}</a></li>
						</c:if>
					</c:forEach>
					<!-- 下一页 -->
					<li><a href="queryAllWeiboFollow.action?pageNo=${page.pageNo+1 }">&raquo;</a></li>
				</ul>
			</div>

		</div>
	</div>
	<script type="text/javascript">
	//转发微博
	function repost(weiboId) {
		$('#Modal'+weiboId).modal('toggle');
	}
	
	//跳至自己的主页
	function clickme() {
		window.location="queryMinePage.action?pageNo=1";
	}

	//跳至userId的用户主页
	function clickother(userId) {
		var url = "queryUserPage.action?pageNo=1&userId=" + userId;
		window.location=url;
	}
	
	//跳至所选微博页
	function clickWeibo(weiboId) {
		var url = "singleWeibo.action?weiboId=" + weiboId;
		window.open(url);
	}
	
	function likes(weiboId) {
		//未赞——>已赞
		var likeCount = $("#likeCount" + weiboId).text();
		if($("#likespan"+weiboId).hasClass("glyphicon-heart-empty")){
			$.get("${pageContext.request.contextPath }/like.action?weiboId=" + weiboId,null,function(data){
				$("#likespan"+weiboId).attr("class","glyphicon glyphicon-heart");
				likeCount++;
				$("#likeCount" + weiboId).text(likeCount);
			});
		}
		//已赞——>取消赞
		else {
			$.get("${pageContext.request.contextPath }/unlike.action?weiboId=" + weiboId,null,function(data){
				$("#likespan"+weiboId).attr("class","glyphicon glyphicon-heart-empty");
				likeCount--;
				$("#likeCount" + weiboId).text(likeCount);
			});
		}
	}

	function collect(weiboId) {
		var text = $("#collect" + weiboId).text();
		if(text == "收藏") {
			$.get("${pageContext.request.contextPath }/collect.action?weiboId=" + weiboId,null,function(data){
				$("#collect" + weiboId).text("已收藏");
			});
		} 
		if(text == "已收藏"){
			$.get("${pageContext.request.contextPath }/uncollect.action?weiboId=" + weiboId,null,function(data){
				$("#collect" + weiboId).text("收藏");
			});
		}
		
	}

	</script>

	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/jquery-3.3.1.js "></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/bootstrap.js "></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.js "></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.zh-CN.js "></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/date.js "></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/jquery.flexText.js "></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/webuploader.js"></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/comment.js"></script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/js/zoomify.js"></script>
	<script type="text/javascript">
		$('.example img').zoomify();
		
		// 长轮询
		$.ajax(getNotice);
	</script>
</body>

</html>