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
<title>${user.nickname}的关注列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/follow.css">

<!-- 导航栏 -->
<jsp:include page="../nav.jsp"></jsp:include>
</head>
<body style="padding: 80px">
	<div class="container" style="width: 500px">
		<div class="row">
			<div class="leftbox" style="margin: 40px">
				<!-- 头像 -->
				<img src="/imgUpload/${user.face}" height="150px" width="150px"
					class="img-circle" align="center">
			</div>
			<div class="rightbox">
				<table width="100%">
					<tr style="height: 60px; margin-left: 100px">
						<td style="font-size: 40px"><span>${user.nickname}&nbsp;&nbsp;</span></td>
						<td>
						<!-- 相互关注 4； 我关注他 3； 他关注我 2； 陌生 1 -->
						<c:if test="${user.userId!=me.userId }">
							<!-- 相互关注 -->
							<c:if test="${relation==4}">
								<button id="follow" class="btn btn-lg btn-warning"
									onclick="javascript:follow2(${user.userId});">相互关注</button>
							</c:if>
							<!-- 我关注他 -->
							<c:if test="${relation==3}">
								<button id="follow" class="btn btn-lg btn-success"
									onclick="javascript:follow1(${user.userId});">已关注</button>
							</c:if>
							<!-- 他关注我 -->
							<c:if test="${relation==2}">
								<button id="follow" class="btn btn-lg btn-primary"
									onclick="javascript:follow2(${user.userId})">关注</button>
							</c:if>
							<!-- 陌生 -->
							<c:if test="${relation==1}">
								<button id="follow" class="btn btn-lg btn-primary"
									onclick="javascript:follow1(${user.userId})">关注</button>
							</c:if>
						</c:if>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" style="table-layout: fixed; font-size: 20px">
					<tr>
						<td><a href="queryUserPage.action?pageNo=1&userId=${user.userId}">${weiboCount }微博</a></td>
                        <td><a href="listFollow.action?userId=${user.userId}">${followCount }关注</a></td>
                        <td><a href="listFans.action?userId=${user.userId}">${fansCount }粉丝</a></td>
					</tr>
				</table>
				<br>
				<table style="font-size: 15px" align="center">
					<tr>
						<td>
						<c:if test="${user.sex==1 }">
						<span>♂</span>
						</c:if>
						<c:if test="${user.sex==0 }">
						<span>♀</span>
						</c:if>
						<span>${user.age}岁  ${user.p } ${user.c }</span>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<!-- --------------------------------------------------------------------------------------------- -->

	<div class="container">
		<div class="row" align="center" style="background-color: #fff;">
			<c:forEach items="${followList }" var="follower">
				<div class="col-md-4" style="height: 150px; background-color: #fff;">
					<div class="leftbox">
						<!-- 头像 -->
						<div
							style="cursor: pointer; height: 50px; width: 50px; float: left;">
							<img onclick="javascript:ClickUser(${follower.userId});"
								src="/imgUpload/${follower.face }" height="100px" width="100px"
								class="img-circle" align="center">
						</div>
					</div>
					<div class="rightbox" style="" align="center">
						<table>
							<tr>
								<td>
                                <!-- 非本人 -->
								<c:if test="${follower.userId!=me.userId}">
									<!-- 相互关注 --> 
                                    <c:if test="${follower.relation.state==4}">
										<button id="${follower.userId }" class="btn btn-warning"
											onclick="javascript:ex_follow2(${follower.userId });">相互关注</button>
									</c:if> 
                                    <!-- 我关注他 --> 
                                    <c:if test="${follower.relation.state==3}">
										<button id="${follower.userId }" class="btn btn-success"
											onclick="javascript:ex_follow1(${follower.userId });">已关注</button>
									</c:if> 
                                    <!-- 他关注我 --> 
                                    <c:if test="${follower.relation.state==2}">
										<button id="${follower.userId }" class="btn btn-primary"
											onclick="javascript:ex_follow2(${follower.userId })">关注</button>
									</c:if>
                                    <!-- 陌生 -->
                                    <c:if test="${follower.relation.state==1}">
                                        <button id="${follower.userId }" class="btn btn-primary"
                                            onclick="javascript:ex_follow1(${follower.userId})">关注</button>
                                    </c:if>
                                </c:if>
                                <!-- 本人 -->
                                <c:if test="${follower.userId==me.userId}">
                                        <div class="btn btn-danger">我</div>
                                </c:if>
								</td>
							</tr>
							<tr>
								<td><span style="font-size: 17px">${follower.nickname }</span></td>
							</tr>
							<tr>
								<td><span style="font-size: 15px"> <!-- 性别 --> <c:if
											test="${follower.sex==0 }">♀</c:if> <c:if
											test="${follower.sex==1 }">♂</c:if> <!-- 年龄 -->
										${follower.age }岁 <!-- 所在省 --> ${follower.p } <!-- 所在市 -->
										${follower.c }
								</span></td>
							</tr>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/longPolling.js "></script>
	<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
	<script type="text/javascript" src="./js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="./js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="./js/date.js"></script>
	<script type="text/javascript">
    $.ajax(getNotice);
    
    //新开用户主页
    function ClickUser(userId) {
    	var url = "queryUserPage.action?pageNo=1&userId=" + userId;
		window.open(url);
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

	//已关注——关注
	function ex_follow1(userId) {
		var text = $("#"+userId).text();
		if(text=="关注") { //未关注——— 关注 ————>已关注
		$.get("${pageContext.request.contextPath }/follow.action?flag=1&userId=" + userId,null,function(data){
			$("#"+userId).attr("class","btn btn-success");
			$("#"+userId).text("已关注");
		});
		} else if(text=="已关注"){ //已关注—— 取关 ——>关注
		$.get("${pageContext.request.contextPath }/unfollow.action?flag=1&userId=" + userId,null,function(data){
			$("#"+userId).attr("class","btn btn-primary");
			$("#"+userId).text("关注");
		});
		}
	}
	

	//相互关注—关注
	function ex_follow2(userId) {
		var text = $("#"+userId).text();
		if(text=="相互关注"){ //相互关注——— 取关 ————>关注
		$.get("${pageContext.request.contextPath }/unfollow.action?flag=2&userId=" + userId,null,function(data){
			$("#"+userId).attr("class","btn btn-primary");
			$("#"+userId).text("关注");
		});
		} else if(text=="关注") {
		$.get("${pageContext.request.contextPath }/follow.action?flag=2&userId=" + userId,null,function(data){
			$("#"+userId).attr("class","btn btn-warning");
			$("#"+userId).text("相互关注");
		});
		}
	}
    </script>


</body>

</html>