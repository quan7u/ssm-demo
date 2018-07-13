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
<title>用户信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/login.css">
<script src="${pageContext.request.contextPath }/js/city.js"></script>
<script src="${pageContext.request.contextPath }/js/longPolling.js"></script>

<!-- 导航栏 -->
<jsp:include page="../nav.jsp"></jsp:include>
</head>
<body style="padding: 80px">
	<h1 class="cover-heading" style="margin-left: -50px">现在您可以更改信息！</h1>
	<br>
	<div class="cover-container">
		<form class="form-horizontal" method="post"
			enctype="multipart/form-data" action="submitInfo.action" name="form1">
			<div class="form-group">
				<label class="col-sm-4 control-label">昵称</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" style="width: 66%"
						name="userCustom.nickname" value="${user.nickname }">
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-4 control-label" style="margin-top: 15px">头像</label>
				<div class="col-sm-3">
					<!-- 头像框 -->
					<img src="/imgUpload/${user.face}" name="face" class="img-circle"
						height="70" width="70" style="margin-left: 25px"> <br>
					<br>
					<!-- 上传框 -->
					<input type="file" name="user_face" style="margin-left: 50px;"
						value="更换头像">
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-4 control-label">性别</label>
				<div class="col-sm-3" style="margin: 5px">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:choose>
						<c:when test="${user.sex==0}">
							<input type="radio" name="userCustom.sex" value="1">
							<span>男</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                    <input type="radio" checked="checked"
								name="userCustom.sex" value="0">
							<span>女</span>
						</c:when>
						<c:otherwise>
							<input type="radio" checked="checked" name="userCustom.sex"
								value="1">
							<span>男</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                    <input type="radio" name="userCustom.sex"
								value="0">
							<span>女</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-4 control-label">出生日期</label>
				<div class="col-sm-3">
					<input type="text" value="${user.bir_String }"
						name="userCustom.bir_String" id="date" class="form-control"
						style="width: 123%;">
				</div>
			</div>
			<br>

			<!-- ——————————————所在地———————————— -->
			<div class="form-group" style="margin-top: 10px">
				<label class="col-sm-4 control-label">所在地</label> <input
					type="hidden" value="${user.province}" id="selectedP"> <input
					type="hidden" value="${user.city}" id="selectedC">
				<div class="col-sm-3" style="display: inline-flex;">
					<select class="form-control" id="province" style="width: 90px;"
						name="userCustom.province"
						onchange="selectcityarea('province','city','form1');">
						<option value="0">选择省份</option>
						<option value="01">北京</option>
						<option value="02">深圳</option>
						<option value="03">上海</option>
						<option value="04">重庆</option>
						<option value="05">天津</option>
						<option value="06">广东</option>
						<option value="07">河北</option>
						<option value="08">山西</option>
						<option value="09">内蒙古</option>
						<option value="10">辽宁</option>
						<option value="11">吉林</option>
						<option value="12">黑龙江</option>
						<option value="13">江苏</option>
						<option value="14">浙江</option>
						<option value="15">安徽</option>
						<option value="16">福建</option>
						<option value="17">江西</option>
						<option value="18">山东</option>
						<option value="19">河南</option>
						<option value="20">湖北</option>
						<option value="21">湖南</option>
						<option value="22">广西</option>
						<option value="23">海南</option>
						<option value="24">四川</option>
						<option value="25">贵州</option>
						<option value="26">云南</option>
						<option value="27">西藏</option>
						<option value="28">陕西</option>
						<option value="29">甘肃</option>
						<option value="30">青海</option>
						<option value="31">宁夏</option>
						<option value="32">新疆</option>
						<option value="33">香港</option>
						<option value="34">澳门</option>
						<option value="35">台湾</option>
					</select>&nbsp;&nbsp; <select class="form-control" id="city"
						style="width: 90px;" name="userCustom.city">
						<option value="0">选择城市</option>
					</select>
				</div>
			</div>


			<br> <br>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<button type="submit" class="btn btn-lg btn-success"
						style="padding: 10px 55px">提交修改</button>
				</div>
			</div>
		</form>
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
		src="${pageContext.request.contextPath }/js/loadnav.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/date.js"></script>
	<script type="text/javascript">
		$('#date').datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN',
			autoclose : true,
			minView : 'month'
		});
		var p = $("#selectedP").val();
		var c = $("#selectedC").val();
		first("province", "city", "form1", p, c);

		//长轮询
		$.ajax(getNotice);
	</script>
</body>

</html>