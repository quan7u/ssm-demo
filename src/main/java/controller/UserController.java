package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import po.MentionCustom;
import po.Page;
import po.Relation;
import po.User;
import po.UserCustom;
import po.UserVo;
import po.WeiboCustom;
import service.MentionService;
import service.RelationService;
import service.UserService;
import service.WeiboService;
import utils.DateConvert;
import utils.VerifyCode;

@Controller
public class UserController {

	// UserService
	@Autowired
	private UserService userService;

	// WeiboService
	@Autowired
	private WeiboService weiboService;

	// date格式化工具类
	DateConvert dateConvert;

	// RelationService
	@Autowired
	private RelationService relationService;

	@Autowired
	private MentionService mentionService;

	// 登录页面
	@RequestMapping(value = "login")
	public String login() throws Exception {
		return "login";
	}

	@RequestMapping(value = "goregister")
	public String goregister() throws Exception {
		return "register";
	}

	// 用户退出
	@RequestMapping(value = "exit")
	public String exit(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "login";
	}

	// 用户注册
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@RequestParam("vCode") String vCode, @RequestParam("username") String username,
			@RequestParam("password1") String password1, @RequestParam("password2") String password2,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int flag = 0;
		List<UserCustom> userList = userService.queryByUsername(username);
		// 用户名长度 合法性 （只能由数字和字母组成）校验
		if (username.length() < 5) {
			request.setAttribute("error_username", "我已经跟你说了用户名长度必须大于4位");
			flag = 1;
		}
		// 数据库username校验
		if (userList.size() > 0) {
			request.setAttribute("error_username", "用户名已存在");
			flag = 1;
		}
		// 用户名合法性（数字字母）校验
		String reg = "^[A-Za-z0-9]+$";
		if (!username.matches(reg)) {
			request.setAttribute("error_username", "用户名必须由数字和字母组成");
			flag = 1;
		}
		// 密码长度校验
		if (password1.length() > 8) {
			request.setAttribute("error_pw1", "密码长度不能超过8位");
			flag = 1;
		}
		// 密码一致校验
		if (!password2.equals(password1)) {
			request.setAttribute("error_pw2", "两次密码输入不一致");
			flag = 1;
		}
		// 验证码校验
		if (!(request.getSession().getAttribute("verifyCode").toString().toLowerCase()).equals(vCode.toLowerCase())) {
			request.setAttribute("error_vc", "验证码错误");
			request.getSession().removeAttribute("vCode");
			flag = 1;
		}
		if (flag == 0) {
			// 校验成功
			response.setCharacterEncoding("utf-8");
			request.setAttribute("register_success", "注册成功 即刻登录");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password1);
			userService.addUser(user);
			return "login";
		} else {
			// 校验失败
			request.setAttribute("username", username);
			return "register";
		}

	}

	// 注册页面（生成验证码）
	@RequestMapping(value = "toRegister")
	public void toRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		VerifyCode vc = new VerifyCode();// 创建验证码类
		BufferedImage image = vc.getImage();// 创建验证码图片
		System.out.println("生成验证码：" + vc.getText());
		request.getSession().setAttribute("verifyCode", vc.getText());
		VerifyCode.output(image, response.getOutputStream());// 输出图片到页面
	}
 
	// 用户登录
	@RequestMapping(value = "loginUser", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest request, HttpSession session, UserVo userVo) throws Exception {

		List<UserCustom> userList = userService.loginUser(userVo);

		// 验证账号密码
		if (userList.size() != 0 
				&& userList.get(0).getUsername().equals(userVo.getUserCustom().getUsername())
				&& userList.get(0).getPassword().equals(userVo.getUserCustom().getPassword())) {
			System.out.println(
					"——————————————————————————————————————————————登录成功——————————————————————————————————————————————");
			// 用户基础信息
			UserCustom user = userList.get(0);

			// 用户年龄
			user.setAge(userService.calculateAge(user.getBir()));

			// 省市
			user.setP(userService.queryPC(user.getProvince()));
			user.setC(userService.queryPC(user.getCity()));

			// 微博数wi
			int weiboCount = userService.queryWeiboCount(user.getUserId());
			// 关注
			int followCount = userService.queryFollowCount(user.getUserId());
			// 粉丝
			int fansCount = userService.queryFansCount(user.getUserId());
			user.setWeiboCount(weiboCount);
			user.setFollowCount(followCount);
			user.setFansCount(fansCount);

			// 读取 数据库中保存的 [上次退出时] 与我相关数
			MentionCustom mention = mentionService.queryLastMention(user.getUserId());

			user.setMentionCustom(mention);
			user.setPassword(null);
			session.setAttribute("user", user);
			request.setAttribute("pageNo", 1);
			return "forward:/queryAllWeiboNow.action?pageNo=1";
		} else {
			return "login";
		}
	}

	// 跳至修改用户信息视图
	@SuppressWarnings("static-access")
	@RequestMapping(value = "updateInfo")
	public String updateInfo(HttpSession session, Model model) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");
		// 读取 数据库中保存的 [上次退出时] 与我相关数
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());

		user.setMentionCustom(mention);
		// bir格式转化 返回String
		user.setBir_String(dateConvert.convert2d(user.getBir()));

		model.addAttribute("user", user);
		session.setAttribute("user", user);
		return "/user/userinfo";
	}

	// 提交修改用户信息
	@RequestMapping(value = "submitInfo", method = RequestMethod.POST)
	public String submitInfo(HttpSession session, Model model, MultipartFile user_face, UserVo userVo)
			throws Exception {

		// 得到自身用户id
		UserCustom user = (UserCustom) session.getAttribute("user");
		int userId = user.getUserId();
		String face = user.getFace();

		userVo.getUserCustom().setUserId(userId);
		userVo.getUserCustom().setFace(face);

		// ————————————————————头像上传————————————————
		// 原始名称
		String originalFilename = user_face.getOriginalFilename();
		// 上传图片
		if (user_face != null && originalFilename != null && originalFilename.length() > 0) {

			// 存储图片的物理路径
			String pic_path = "F:\\imgUpload\\";

			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);

			// 将内存中的数据写入磁盘
			user_face.transferTo(newFile);

			// 将新图片名称写到user中
			userVo.getUserCustom().setFace(newFileName);
		}

		userVo.getUserCustom().setBir(dateConvert.convert2Date(userVo.getUserCustom().getBir_String()));

		// 参数绑定model
		userService.updateUserInfo(userVo);
		user = userVo.getUserCustom();
		model.addAttribute("user", user);
		// 读取 数据库中保存的 [上次退出时] 与我相关数
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);
		// 用户年龄
		user.setAge(userService.calculateAge(user.getBir()));
		// 微博数wi
		int weiboCount = userService.queryWeiboCount(user.getUserId());
		// 关注
		int followCount = userService.queryFollowCount(user.getUserId());
		// 粉丝
		int fansCount = userService.queryFansCount(user.getUserId());
		user.setWeiboCount(weiboCount);
		user.setFollowCount(followCount);
		user.setFansCount(fansCount);
		// 所在地
		String province = userService.queryPC(user.getProvince());
		String city = userService.queryPC(user.getCity());
		user.setP(province);
		user.setC(city);
		session.setAttribute("user", user);
		return "/user/userinfo";
	}

	// 跳至修改密码页面
	@RequestMapping(value = "toUpdatePassword")
	public String toUpdatePassword(HttpSession session) throws Exception {

		if (session.getAttribute("user") != null) {
			return "/user/password";
		} else {
			return "login";
		}
	}

	// 修改密码
	@RequestMapping(value = "undatePassword")
	public String undatePassword(HttpSession session, HttpServletRequest request, @RequestParam("oldpw") String oldpw,
			@RequestParam("newpw1") String newpw1, @RequestParam("newpw2") String newpw2) throws Exception {
		int flag = 1;

		// 原密码
		User user = (User) session.getAttribute("user");
		String oldpassword = userService.queryByUsername(user.getUsername()).get(0).getPassword();

		// 判断原密码是否一致
		if (!oldpw.equals(oldpassword)) {
			flag = 0;
			request.setAttribute("error_old", "原密码不正确！");
		}
		// 新密码是否一致
		if (!newpw1.equals(newpw2)) {
			flag = 0;
			request.setAttribute("error_new", "两次输入的新密码不一致");
		}
		if (flag == 0) {
			return "password";
		} else {
			User u = new User();
			u.setUserId(user.getUserId());
			u.setPassword(newpw1);
			userService.updatePassword(u);
			request.setAttribute("updatepassword_success", "密码修改成功 请重新登录！");
			return "login";
		}

	}

	// 去往我的主页
	@SuppressWarnings("static-access")
	@RequestMapping(value = "queryMinePage")
	public String queryMinePage(HttpSession session, Model model, @RequestParam("pageNo") int pageNo) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");

		Page<WeiboCustom> page = weiboService.qeuryByUserId(user.getUserId(), pageNo);
		// sql.Date 转换
		for (WeiboCustom weiboCustom : page.getResults()) {
			// 将date格式化 精确到s
			weiboCustom.setDate(dateConvert.convert2s(weiboCustom.getPostTime()));
			// 非原创 即属于转发微博
			if (weiboCustom.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weiboCustom.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weiboCustom.setRepost(repostWeibo);
			}
		}
		model.addAttribute("weiboList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		// 读取 数据库中保存的 [上次退出时] 与我相关数
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);
		session.setAttribute("user", user);
		model.addAttribute("user", user);

		return "/user/mine";
	}

	// 访问用户主页
	@RequestMapping(value = "queryUserPage")
	public String queryUserPage(HttpServletRequest request, HttpSession session, 
			@RequestParam("userId") int userId,
			@RequestParam("pageNo") int pageNo,
			Model model) throws Exception {
		// 本用户信息
		UserCustom user = (UserCustom) session.getAttribute("user");

		if (user.getUserId() == userId) {
			return "forward:queryMinePage.action";
		}

		List<UserCustom> othersList = userService.queryInfoByUserId(userId);
		UserCustom others = othersList.get(0);
		// 被访问用户
		// queryInfoByUserId 仅仅查出信息 没有userId ????
		others.setUserId(userId);
		model.addAttribute("others", others);

		int relation = relationService.queryRelation(user.getUserId(), others.getUserId());
		model.addAttribute("relation", relation);

		// 遍历微博
		Page<WeiboCustom> page = weiboService.qeuryByUserId(userId,pageNo);
		for (WeiboCustom weiboCustom : page.getResults()) {
			weiboCustom.setDate(dateConvert.convert2s(weiboCustom.getPostTime()));
			// 非原创 即属于转发微博
			if (weiboCustom.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weiboCustom.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weiboCustom.setRepost(repostWeibo);
			}
		}
		model.addAttribute("weiboList", page.getResults());
		// 微博数
		int weiboCount = userService.queryWeiboCount(userId);
		// 关注
		int followCount = userService.queryFollowCount(userId);
		// 粉丝
		int fansCount = userService.queryFansCount(userId);
		others.setWeiboCount(weiboCount);
		others.setFollowCount(followCount);
		others.setFansCount(fansCount);
		// 所在地
		others.setP(userService.queryPC(user.getProvince()));
		others.setC(userService.queryPC(user.getCity()));
		// 年龄
		others.setAge(userService.calculateAge(user.getBir()));

		model.addAttribute("others", others);
		page.setResults(null);
		model.addAttribute("page", page);
		// 读取 数据库中保存的 [上次退出时] 与我相关数
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);
		session.setAttribute("user", user);
		return "/user/others";
	}

	// 模糊查询用户列表
	@RequestMapping("queryUserByWord")
	public String queryUserByWord(
			Model model,
			HttpSession session, 
			@RequestParam("keyWord") String keyWord) throws Exception {

		UserCustom me = (UserCustom) session.getAttribute("user");
		// 查询结果列表
		List<UserCustom> userList = userService.queryUserByWord(keyWord);
		for (UserCustom userCustom : userList) {
			// 年龄
			userCustom.setAge(userService.calculateAge(userCustom.getBir()));
			// 省
			userCustom.setP(userService.queryPC(userCustom.getProvince()));
			// 市
			userCustom.setC(userService.queryPC(userCustom.getCity()));

			// 与我关系
			int state = relationService.queryRelation(me.getUserId(), userCustom.getUserId());
			userCustom.getRelation().setState(state);
		}
		model.addAttribute("fansList", userList);
		return "/search/search_people";
	}

}
