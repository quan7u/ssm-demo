package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import po.Admin;
import service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	/**
	 * 管理员登录页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="signin")
	public String signin() throws Exception {
		return "/admin/sign-in";
	}
	
	/**
	 * 管理员登录校验
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="loginAdmin", method=RequestMethod.POST)
	public String loginAdmin(
			@RequestParam("username") String username,
			@RequestParam("password") String password
			) throws Exception {
		Admin admin = new Admin();
		admin.setUsername(username);
		List<Admin> adminList = adminService.queryAdminByUsername(admin);
		if(adminList.size()==0){
			return "/admin/sign-in";
		}
		admin = adminList.get(0);
		if(password.equals(admin.getPassword())){
			return "/admin/index";
		} else {
			return "/admin/sign-in";
		}
		
		
	}
}
