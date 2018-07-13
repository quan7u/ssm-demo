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
<title>微博详情</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/login.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/mine.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/comment.css">
<!-- 导航栏 -->
<jsp:include page="../nav.jsp"></jsp:include>
</head>
<body style="padding: 80px;">

	<!-- 头部 -->
	<div id=${weibo.weiboId }>

		<div class="container" style="width: 850px; background-color: white;">
			<!-- 头像 -->
			<div style="height: 50px; width: 50px; margin: 10px; float: left;">
				<img src="/imgUpload/${weibo.user.face}" width="50px" height="50px"
					class="img-circle">
			</div>
			<!-- 昵称+日期 -->
			<div
				style="text-align: left; margin: 10px; margin-left: 20px; float: left;">
				<a style="color: #333; font-size: 20px" href="#">${weibo.user.nickname }</a>
				<br> <a style="color: #333" href="#">${weibo.date }</a>
			</div>
		</div>
		<!-- 内容 -->
		<div class="container" style="width: 850px; background-color: #fff;">
			<!-- 文字 -->
			<div style="text-align: left; margin-left: 85px">
				<p style="color: #333; font-size: 17px">${weibo.content }</p>
			</div>
			<!-- 图片 -->
			<div style="margin-left: 85px;">
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
		</div>
		<!-- 非原创 转发微博 -->
			<c:if test="${weibo.original == 0 }">
				<!-- 头部 -->
				<div class="container"
					style="width: 850px; background-color: #eaeaec;">
					<!-- 头像 -->
					<div
						style="cursor: pointer; height: 30px; width: 30px; margin: 10px; float: left; margin-left: 100px;">
						<img
							onclick="
		<c:if test="${weibo.repost.user.userId==user.userId }">javascript:clickme();</c:if>
		<c:if test="${weibo.repost.user.userId!=user.userId }">javascript:clickother(${weibo.repost.user.userId});</c:if>"
							src="/imgUpload/${weibo.repost.user.face}" width="40px"
							height="40px" class="img-circle">
					</div>
					<!-- 昵称+日期 -->
					<div
						style="text-align: left; margin: 10px; margin-left: 20px; float: left;">
						<a style="color: #333; font-size: 14px" href="javascrip:;">${weibo.repost.user.nickname }</a><br>
						<span style="color: #333; font-size: 10px">${weibo.repost.date }</span>
					</div>
				</div>
				<div class="container"
					style="width: 850px; background-color: #eaeaec;">
					<!-- 文字 -->
					<!-- onclick="javascript:clickWeibo(${weibo.weiboId});" -->
					<div style="text-align: left; margin-left: 160px">
						<p style="color: #333; font-size: 17px">${weibo.repost.content }</p>
					</div>
					<!-- 图片 -->
					<div class="example" style="margin-left: 160px;margin-bottom: 20px;">
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
		</div>
		<!-- 底部 -->
		<div class="container" style="width: 850px; background-color: #fff;">
			<br>
			<div class="btn-group" style="width: 100%">
				<button type="button" style="width: 25%" class="btn btn-success">收藏</button>
				<button type="button" style="width: 25%" class="btn btn-primary">转发</button>
				<button type="button" style="width: 25%" class="btn btn-warning"
					id="btn_1" onclick="show_comment()"">评论</button>
				<button type="button" style="width: 25%" class="btn btn-danger">点赞</button>
			</div>
			<br> <br>
		</div>
		<!--
    此评论textarea文本框部分使用的https://github.com/alexdunphy/flexText此插件
    -->
		<div class="container" style="width: 850px; background-color: #fff;">
			<div class="commentAll" id="comment_1" style="display: block;">
				<!--评论区域 begin-->
				<div class="reviewArea clearfix">
					<textarea class="content comment-input"
						placeholder="评论吧！！！！！！！！！！！！" onkeyup="keyUP(this)"></textarea>
					<a href="javascript:;" class="plBtn">评论</a>
					<!-- 微博id -->
					<input type="hidden" value="${weibo.weiboId}" class="weiboId">
				</div>
				<!--评论区域 end-->
				<!--回复区域 begin-->
				<div class="comment-show">
					<c:forEach items="${commentList }" var="comment">
						<div class="comment-show-con clearfix">
							<div class="comment-show-con-img pull-left">
								<img class="img-circle" style="height: 50px; width: 50px;"
									src="/imgUpload/${comment.user.face }" alt="">
							</div>
							<div class="comment-show-con-list pull-left clearfix">
								<div class="pl-text clearfix">
									<a href="#" class="comment-size-name">${comment.user.nickname}</a>
									<input type="hidden" class="comment-size-userId"
										value="${comment.userId}"> <input type="hidden"
										class="comment-size-commentId" value="${comment.commentId}">
									<span class="my-pl-con">&nbsp;${comment.commentContent }</span>
								</div>
								<div class="date-dz">
									<span class="date-dz-left pull-left comment-time">${comment.time }</span>
									<div class="date-dz-right pull-right comment-pl-block">
										<c:if test="${user.userId == comment.userId}">
											<a href="javascript:deleteComment(${comment.commentId});"
												class="removeBlock" style="color: #333">删除</a>
										</c:if>
										<a href="javascript:;"
											class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span
											class="pull-left date-dz-line">|</span> <a
											href="javascript:;" class="date-dz-z pull-left"> <i
											class="date-dz-z-click-red"></i>赞(<i class="z-num">666</i>)
										</a>
									</div>
								</div>
								<!-- 回复列表 -->
								<div class="hf-list-con">
									<c:forEach items="${comment.replyList}" var="reply">
										<div class="all-pl-con">
											<div class="pl-text hfpl-text clearfix">
												<!-- 来自 -->
												<a href="#" class="comment-size-name">${reply.from }</a> <span
													style="color: #987">回复</span>
												<!-- 回复@ -->
												<a href="#" class="comment-size-name">@${reply.to }:&nbsp</a>
												<input type="hidden" class="comment-size-userId"
													value="${reply.fromId}"> <input type="hidden"
													class="comment-size-commentId" value="${reply.commentId}">
												<!-- 内容 -->
												<span class="my-pl-con">${reply.content }</span>
											</div>
											<div class="date-dz">
												<!-- 时间 -->
												<span class="date-dz-left pull-left comment-time">${reply.rtime}</span>
												<div class="date-dz-right pull-right comment-pl-block">
													<c:if test="${user.userId == reply.fromId}">
														<a href="javascript:deleteReply(${reply.replyId})"
															class="removeBlock">删除</a>
													</c:if>
													<a href="javascript:;"
														class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span
														class="pull-left date-dz-line">|</span> <a
														href="javascript:;" class="date-dz-z pull-left"> <i
														class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)
													</a>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!--回复区域 end-->
			</div>
		</div>
		<hr>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/date.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery.flexText.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/comment.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/longPolling.js "></script>
	<script type="text/javascript">
		//删除评论
		function deleteComment(commentId) {
			if (confirm("您确定要删除这条评论吗？")) {
				$.get(
						"${pageContext.request.contextPath }/deleteComment.action?commentId="
								+ commentId, null, null);
			}
		}

		//删除回复
		function deleteReply(replyId) {
			if (confirm("您确定要删除这条回复吗？")) {
				$.get(
						"${pageContext.request.contextPath }/deleteReply.action?replyId="
								+ replyId, null, null);
			}
		}

		//已关注——关注
		function follow1(userId) {
			var text = $("#follow").text();
			if (text == "关注") { //未关注——— 关注 ————>已关注
				$.get(
						"${pageContext.request.contextPath }/follow.action?flag=1&userId="
								+ userId, null, function(data) {
							$("#follow")
									.attr("class", "btn btn-lg btn-success");
							$("#follow").text("已关注");
						});
			} else if (text == "已关注") { //已关注—— 取关 ——>关注
				$.get(
						"${pageContext.request.contextPath }/unfollow.action?flag=1&userId="
								+ userId, null, function(data) {
							$("#follow")
									.attr("class", "btn btn-lg btn-primary");
							$("#follow").text("关注");
						});
			}
		}
		//相互关注—关注
		function follow2(userId) {
			var text = $("#follow").text();
			if (text == "相互关注") { //相互关注——— 取关 ————>关注
				$.get(
						"${pageContext.request.contextPath }/unfollow.action?flag=2&userId="
								+ userId, null, function(data) {
							$("#follow")
									.attr("class", "btn btn-lg btn-primary");
							$("#follow").text("关注");
						});
			} else if (text == "关注") {
				$.get(
						"${pageContext.request.contextPath }/follow.action?flag=2&userId="
								+ userId, null, function(data) {
							$("#follow")
									.attr("class", "btn btn-lg btn-warning");
							$("#follow").text("相互关注");
						});
			}
		}

		//长轮询
		$.ajax(getNotice);
	</script>

</body>

</html>