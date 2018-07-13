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
    <title>修改密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.zh-CN.js"></script>

<!-- 导航栏 -->
<jsp:include page="../nav.jsp"></jsp:include>
</head>
<body style="padding: 80px">
    <br>
    <h1 class="cover-heading" style="margin-left: -80px">——修改密码——</h1>
    <br>
    <br>
    <br>
    <div class="cover-container" style="margin-left: 160x;">
        <form class="form-horizontal" action="${pageContext.request.contextPath }/undatePassword.action" method="post">
            <span id="error_username" style="color: #ff5b5b; font-size: 17px">${error_old }</span>
            <div class="form-group">
                <label class="col-sm-4 control-label">原密码</label>
                <div class="col-sm-5">
                    <input name="oldpw" type="password" class="form-control" style="width: 68%">
                </div>
            </div>
            <br>
            <div class="form-group">
                <label class="col-sm-4 control-label">新密码</label>
                <div class="col-sm-5">
                    <input id="newpw1" name="newpw1" type="password" class="form-control" style="width: 68%">
                </div>
            </div>
            <br>
            <span id="error_new" style="color: #ff5b5b; font-size: 17px">${error_new }</span>
            <div class="form-group">
                <label class="col-sm-4 control-label">再次输入新密码</label>
                <div class="col-sm-5">
                    <input oninput="javascript:check_password();" name="newpw2" id="newpw2" type="password" class="form-control" style="width: 68%">
                </div>
            </div>
            <br>
            <br>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-2">
                    <button type="submit" class="btn btn-lg btn-success" style="padding: 10px 55px;">确认更改</button>
                </div>
            </div>
        </form>
    </div>
    <script type="text/javascript">
    function check_password(){
    	var pw1 = $("#newpw1").val();
    	var pw2 = $("#newpw2").val();
    	if(pw1 != pw2){
    		$("#error_new").text("两次输入的新密码不一致");
    	}else{
    		$("#error_new").text("");
    	}
    }
    </script>
</body>

</html>