<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>微博</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
	
  </head>
  <body>
    
    <div class="site-wrapper">

      <div class="site-wrapper-inner">
        <div class="cover-container">
          <div class="inner cover">
            <h1 class="cover-heading">发现新鲜事！</h1>
            <h1 class="cover-heading" style="color: #52c250" name="register_success">${register_success }</h1>
            <h1 class="cover-heading" style="color: #52c250" name="register_success">${updatepassword_success }</h1>
            <form class="form-signin" action="${pageContext.request.contextPath }/loginUser.action" method="post">
              <div class="from-group">
                <input type="text" name="userCustom.username" class="form-control" placeholder="用户名" required="required" autofocus="autofocus">
              </div>
              <div class="from-group">
                <input type="password" name="userCustom.password" class="form-control" placeholder="密码" required="required">
              </div>
              <br>
              <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
              <a href="${pageContext.request.contextPath }/goregister.action" class="btn btn-lg btn-success btn-block">还没有账号，去注册</a> 
            </form> 

          </div>
        </div>
      </div>
    </div>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>