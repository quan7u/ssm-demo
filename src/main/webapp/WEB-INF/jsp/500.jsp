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
<title>${user.nickname}的主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mine.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/zoomify.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/comment.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.0.min.js "></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/longPolling.js "></script>

<!-- 导航栏 -->
<jsp:include page="nav.jsp"></jsp:include>
</head>
<body style="padding: 80px">
	<h1 style="font-size: 100px; color: #f44336;">服务器出错！</h1>

	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/jquery-3.3.1.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/bootstrap.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.zh-CN.js "></script>
	<script type="text/javascript "	src="${pageContext.request.contextPath }/js/date.js "></script>

</body>

</html>