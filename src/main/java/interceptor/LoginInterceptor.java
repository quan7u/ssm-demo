package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import po.UserCustom;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的url 
		String url = request.getRequestURI();
		if(url.indexOf("loginUser")>=0){
			return true;
		}
		if(url.indexOf("goregister")>=0){
			return true;
		}
		if(url.indexOf("toRegister")>=0){
			return true;
		}
		if(url.indexOf("register")>=0){
			return true;
		}
		if(url.indexOf("signin")>=0){
			return true;
		}
		if(url.indexOf("loginAdmin")>=0){
			return true;
		}
		
		HttpSession session = request.getSession();
		UserCustom user = (UserCustom) session.getAttribute("user");
		
		if(user != null){
			return true;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
