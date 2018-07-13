<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
    

</head>

<body>
    <div class="site-wrapper">
        <div class="site-wrapper-inner">
            <div class="cover-container">
                <div class="inner cover">
                    <h1 class="cover-heading">发现新鲜事！</h1>
                    <form class="form-signin" method="post" action="${pageContext.request.contextPath }/register.action">
                        <div class="from-group">
                            <span id="error_username" style="color: #ff5b5b; font-size: 17px" name="error_username">${error_username }</span>
                            <input oninput="javascript:check_username();" type="text" id="username" value="${username }" 
                                name="username" class="form-control" placeholder="请输入用户名" required="required" autofocus="autofocus">
                        </div>
                        <div class="from-group">
                            <span style="color: #ff5b5b; font-size: 17px" name="error_pw1">${error_pw1 }</span>
                            <input type="password" name="password1" class="form-control" placeholder="请输入密码" required="required">
                        </div>
                        <div class="from-group">
                            <span style="color: #ff5b5b; font-size: 17px" name="error_pw2">${error_pw2 }</span>
                            <input type="password" name="password2" class="form-control" placeholder="再次输入密码" required="required">
                        </div>
                        <div class="from-group">
                            <span style="color: #ff5b5b; font-size: 17px" name="error_vc">${error_vc }</span>
                            <table>
                                <tr>
                                    <td>
                                        <input name="vCode" type="text" name="verify" class="form-control" placeholder="输入验证码" required="required">
                                    </td>
                                    <td>
                                        <img onclick="changeVerifyCode()" style="height: 41px; margin-left: 10px; border-radius: 5px;" id="vCode" src="${pageContext.request.contextPath }/toRegister.action">
                                    </td>
                                </tr>
                            </table>
                        </div>
                        
                        <!-- <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me"> 记住我
                </label>
              </div> -->
                        <br>
                        <button type="submit" class="btn btn-lg btn-primary btn-block">注册</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    function check_username() {
        var input_username = document.getElementById("username");
        var error_username = document.getElementById("error_username");
        //正则判断数字+字母
        var reg=/^[A-Za-z0-9]+$/;
        if(input_username.value.length<5){
            error_username.innerHTML="用户名长度必须大于4";
        } else if(!reg.test(input_username.value)){
            error_username.innerHTML="用户名必须由数字和字母组成";
        } else {  
        	error_username.innerHTML= "";
        }
    }
    function changeVerifyCode(){
    	var img = document.getElementById("vCode");
    	img.src = "${pageContext.request.contextPath }/toRegister.action?" + new Date().getTime();
    }
    </script>
    
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>