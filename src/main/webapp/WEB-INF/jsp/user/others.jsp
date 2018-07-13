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
<title>${others.nickname}的主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mine.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/zoomify.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/comment.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.0.min.js "></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/longPolling.js "></script>
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
	<div class="container">
		<div class="leftbox">
			<!-- 头像 -->
			<img src="/imgUpload/${others.face }" height="150px" width="150px"
				class="img-circle" align="center">
		</div>
		<div class="rightbox">
			<table width="100%">
				<tr style="height: 60px; margin-left: 100px">
					<td style="font-size: 40px"><span>${others.nickname }&nbsp;&nbsp;</span></td>
					<td>
					<!-- 相互关注 4； 我关注他 3； 他关注我 2； 陌生 1 -->
					<c:if test="${user.userId!=others.userId }">
						<!-- 相互关注 -->
						<c:if test="${relation==4}">
							<button id="follow" class="btn btn-lg btn-warning"
								onclick="javascript:follow2(${others.userId});">相互关注</button>
						</c:if>
						<!-- 我关注他 -->
						<c:if test="${relation==3}">
							<button id="follow" class="btn btn-lg btn-success"
								onclick="javascript:follow1(${others.userId});">已关注</button>
						</c:if>
						<!-- 他关注我 -->
						<c:if test="${relation==2}">
							<button id="follow" class="btn btn-lg btn-primary"
								onclick="javascript:follow2(${others.userId})">关注</button>
						</c:if>
						<!-- 陌生 -->
						<c:if test="${relation==1}">
							<button id="follow" class="btn btn-lg btn-primary"
								onclick="javascript:follow1(${others.userId})">关注</button>
						</c:if>
					</c:if>
					</td>
				</tr>
			</table>
			<br>
			<table width="100%" style="table-layout: fixed; font-size: 20px">
				<tr>
					<td><a href="queryUserPage.action?pageNo=1&userId=${others.userId}">${others.weiboCount }微博</a></td>
					<td><a href="listFollow.action?userId=${others.userId}">${others.followCount }关注</a></td>
					<td><a href="listFans.action?userId=${others.userId}">${others.fansCount }粉丝</a></td>
				</tr>
			</table>
			<br>
			<table style="font-size: 15px" align="center">
				<tr>
					<td> 
					<c:if test="${others.sex==1 }">
						<span>♂</span>
					</c:if>
					<c:if test="${others.sex==0 }">
						<span>♀</span>
					</c:if>
					<span>${others.age}岁  ${others.p } ${others.c }</span>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<c:forEach items="${weiboList }" var="weibo" varStatus="status">
		<div id="${weibo.weiboId }">
		<!-- 头部 -->
		<div id="weiboItem">
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
				<!-- 删除操作按钮 -->
				<c:if test="${me_userId==user.userId}">
				<div class="btn-group" style="float: right; margin: 10px">
					<button type="button" class="btn btn-xs btn-Info data-toggle"
						data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<!-- ${pageContext.request.contextPath }/deleteWeibo.action?weiboId=${weibo.weiboId} -->
						<li><a style="font-size: 10px"
							href="javascript:delWeibo(${weibo.weiboId })">删除</a></li>
					</ul>
				</div>
				</c:if>
			</div>
			<!-- 内容 -->
			<div class="container" style="width: 850px; background-color: #fff;">
				<!-- 文字 -->
				<div style="text-align: left; margin-left: 85px">
					<p style="color: #333; font-size: 17px">${weibo.content }</p>
				</div>
				<!-- 原创微博 -->
				<c:if test="${weibo.original == 1 }">
					<!-- 图片 -->
					<div class="example" style="margin-left: 85px; margin-bottom: 20px;">
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
				<button onclick="javascript:loadComment(${weibo.weiboId});" type="button" style="width: 25%" 
					class="btn btn-warning" id="bt${status.index }">评论</button>
				<button type="button" style="width: 25%" class="btn btn-danger">点赞</button>
			</div>
			<br> <br>
		</div>
		<!-- 评论区 -->
		<div class="container "	style="width: 850px; background-color: #fff;">
			<div class="commentAll " id="com${status.index }" style="display: none;">
				<!--评论区域 begin-->
				<div class="reviewArea clearfix ">
					<textarea class="content comment-input "
						placeholder="等待输入......." onkeyup="keyUP(this) "></textarea>
					<a href="javascript:; " class="plBtn " >评论</a>
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
	</div>
	</c:forEach>
	<!-- 分页 -->
				<ul class="pagination pagination-lg">
					<!-- 上一页 -->
					<li><a href="queryAllWeiboFriends.action?pageNo=${page.pageNo-1 }">&laquo;</a></li>
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
							<li><a href="queryAllWeiboFriends.action?pageNo=${i }">${i}</a></li>
						</c:if>
					</c:forEach>
					<!-- 下一页 -->
					<li><a href="queryAllWeiboFriends.action?pageNo=${page.pageNo+1 }">&raquo;</a></li>
				</ul>

	<script type="text/javascript">
	
	//删除微博
	function delWeibo(weiboId) {
		if(confirm("您确定要删除这条微博吗？")){
			$.get("${pageContext.request.contextPath }/deleteWeibo.action?weiboId=" + weiboId,null,function(data){
				$("#" + weiboId).remove();
			});
		}
	}
	
	//已关注——关注
	function follow1(userId) {
		var text = $("#follow").text();
		if(text=="关注") { //未关注——— 关注 ————>已关注
		$.get("${pageContext.request.contextPath }/follow.action?flag=1&userId=" + userId,null,function(data){
			$("#follow").attr("class","btn btn-lg btn-success");
			$("#follow").text("已关注");
		});
		} else if(text=="已关注"){ //已关注—— 取关 ——>关注
		$.get("${pageContext.request.contextPath }/unfollow.action?flag=1&userId=" + userId,null,function(data){
			$("#follow").attr("class","btn btn-lg btn-primary");
			$("#follow").text("关注");
		});
		}
	}
	

	//相互关注—关注
	function follow2(userId) {
		var text = $("#follow").text();
		if(text=="相互关注"){ //相互关注——— 取关 ————>关注
		$.get("${pageContext.request.contextPath }/unfollow.action?flag=2&userId=" + userId,null,function(data){
			$("#follow").attr("class","btn btn-lg btn-primary");
			$("#follow").text("关注");
		});
		} else if(text=="关注") {
		$.get("${pageContext.request.contextPath }/follow.action?flag=2&userId=" + userId,null,function(data){
			$("#follow").attr("class","btn btn-lg btn-warning");
			$("#follow").text("相互关注");
		});
		}
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
	</script>


	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/jquery-3.3.1.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/bootstrap.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.zh-CN.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/date.js "></script>
	<script type="text/javascript " src="${pageContext.request.contextPath }/js/jquery.flexText.js "></script>
	<script type="text/javascript " src="${pageContext.request.contextPath }/js/comment.js"></script>
	<script type="text/javascript " src="${pageContext.request.contextPath }/js/zoomify.js"></script>
	<script type="text/javascript">
		$('.example img').zoomify();
		
		//长轮询
	    $.ajax(getNotice);
	  //加载评论
	    function loadComment(weiboId){
	        if($('#'+weiboId).children().length<=0){
	        var commentAction = "queryComment.action?weiboId=" + weiboId;
	        $.ajax({
	            type: 'GET',
	            url: commentAction,
	            contentType: 'application/json;charset=utf-8',
	            dataType: 'json',
	            success:function(data) {
	                for(var i in data){
	                    var com = '<div class="comment-show-con clearfix ">' +
	                    '<div class="comment-show-con-img pull-left ">' +
	                    //头像
	                    '<img class="img-circle " style="height: 50px; width: 50px;"' +
	                    'src="/imgUpload/'+ data[i].user.face + '"></div>' +
	                    '<div class="comment-show-con-list pull-left clearfix ">' +
	                    '<div class="pl-text clearfix ">' +
	                    //昵称
	                    '<a href="# " class="comment-size-name ">'+ data[i].user.nickname +'</a>' +
	                    '<input type="hidden" class="comment-size-userId" value="'+ data[i].userId +'">'+
	                    '<input type="hidden" class="comment-size-commentId" value="'+ data[i].commentId +'">'+
	                    //内容
	                    '<span class="my-pl-con ">:&nbsp; '+ data[i].commentContent +'</span></div>' +
	                    '<div class="date-dz ">'+
	                    //时间
	                    '<span class="date-dz-left pull-left comment-time ">'+ data[i].time +'</span>' +
	                    '<div class="date-dz-right pull-right comment-pl-block ">' +
	                    //回复
	                    '<a href="javascript:; " class="date-dz-pl pl-hf hf-con-block pull-left ">回复</a>' +
	                    '<span class="pull-left date-dz-line ">|</span>' +
	                    '<a href="javascript:; " class="date-dz-z pull-left ">' +
	                    //赞
	                    '<i class="date-dz-z-click-red "></i>赞 (<i class="z-num ">666</i>)</a>' +
	                    '</div></div><div class="hf-list-con " style="text-align: left;" id="'+ data[i].commentId +'">';
	                    if(data[i].countReply == 0) {
	                    	com = com + '</div></div></div>';
	                    } else {
	                    	com = com + '<a href="singleWeibo.action?weiboId='+ weiboId +'" style="color: #987">共'+ data[i].countReply +'条回复</a>'+
	                        			'</div></div></div>';
	                    }
	                $('#'+weiboId).prepend(com);
	                    }
	                }
	            });
	        }
	    }
	</script>

</body>

</html>