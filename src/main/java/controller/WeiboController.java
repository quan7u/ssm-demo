package controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;
import po.CommentCustom;
import po.MentionCustom;
import po.Page;
import po.ReplyCustom;
import po.User;
import po.UserCustom;
import po.WeiboCustom;
import po.WeiboVo;
import service.CollectService;
import service.CommentService;
import service.LikesService;
import service.MentionService;
import service.ReplyService;
import service.UserService;
import service.WeiboService;
import utils.DateConvert;

@Controller
public class WeiboController {

	// Weibo
	@Autowired
	private WeiboService weiboService;

	// User
	@Autowired
	private UserService userService;

	// Comment
	@Autowired
	private CommentService commentService;

	// Reply
	@Autowired
	private ReplyService replyService;

	// Mention
	@Autowired
	private MentionService mentionService;

	// Likes
	@Autowired
	private LikesService likesService;

	// Collect
	@Autowired
	private CollectService collectService;

	// date格式化工具类
	private DateConvert dateConvert;

	// 独立微博页面 详细评论页
	@SuppressWarnings("all")
	@RequestMapping(value = "/singleWeibo")
	public void singleWeibo(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("weiboId") Integer weiboId) throws Exception {
		//
		User user = (User) session.getAttribute("user");
		// 微博数
		int weiboCount = userService.queryWeiboCount(user.getUserId());
		// 关注
		int followCount = userService.queryFollowCount(user.getUserId());
		// 粉丝
		int fansCount = userService.queryFansCount(user.getUserId());

		// 微博主体
		List<WeiboCustom> weiboList = weiboService.queryWeiboByWeiboId(weiboId);
		WeiboCustom weibo = weiboList.get(0);
		weibo.setDate(dateConvert.convert2s(weibo.getPostTime()));

		// 非原创 即属于转发微博
		if (weibo.getOriginal() == 0) {
			WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weibo.getRepostId()).get(0);
			repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
			weibo.setRepost(repostWeibo);
		}
		// 评论主体
		List<CommentCustom> commentList = commentService.queryComment(weiboId);
		for (CommentCustom commentCustom : commentList) {
			// 遍历回复
			List<ReplyCustom> replyList = (replyService.queryReply(commentCustom.getCommentId()));
			for (ReplyCustom replyCustom : replyList) {
				replyCustom.setRtime(DateConvert.convert2s(replyCustom.getTime()));
			}
			commentCustom.setTime(DateConvert.convert2s(commentCustom.getCommentTime()));
			commentCustom.setReplyList(replyList);
		}

		request.setAttribute("user", user);
		request.setAttribute("weibo", weibo);
		request.setAttribute("weiboCount", weiboCount);
		request.setAttribute("followCount", followCount);
		request.setAttribute("fansCount", fansCount);
		request.setAttribute("commentList", commentList);

		request.getRequestDispatcher("/WEB-INF/jsp/weibo/single.jsp").forward(request, response);

	}

	// 删除微博
	@RequestMapping(value = "deleteWeibo", method = RequestMethod.GET)
	public void deleteWeibo(@RequestParam("weiboId") Integer weiboId, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		weiboService.deleteByWeiboId(weiboId);
	}

	// 转发微博
	@RequestMapping(value = "repost")
	public String repost(HttpSession session, @RequestParam("repostId") int repostId,
			@RequestParam("repostContent") String repostContent) throws Exception {

		// 微博扩展类
		WeiboCustom weibo = new WeiboCustom();

		// userId
		User user = (User) session.getAttribute("user");
		weibo.setUserId(user.getUserId());

		// 发送时间
		Date postTime = new java.sql.Date(new java.util.Date().getTime());
		weibo.setPostTime(postTime);

		// 内容
		weibo.setContent(repostContent);

		// 转发Id
		weibo.setRepostId(repostId);

		weiboService.repost(weibo);
		return "redirect:queryAllWeiboNow.action?pageNo=1";
	}

	// 发送微博
	@RequestMapping(value = "post")
	public String post(HttpServletRequest request, HttpSession session, Model model, WeiboVo weiboVo) throws Exception {
		int count = 0;
		for (int i = 1; i < 30; i++) {
			String pic = request.getParameter("pic_pic_" + i);
			if (pic != null) {
				count++;
				switch (count) {
				case 1:
					weiboVo.getWeiboCustom().setPic1(pic);
					break;
				case 2:
					weiboVo.getWeiboCustom().setPic2(pic);
					break;
				case 3:
					weiboVo.getWeiboCustom().setPic3(pic);
					break;
				case 4:
					weiboVo.getWeiboCustom().setPic4(pic);
					break;
				case 5:
					weiboVo.getWeiboCustom().setPic5(pic);
					break;
				case 6:
					weiboVo.getWeiboCustom().setPic6(pic);
					break;
				case 7:
					weiboVo.getWeiboCustom().setPic7(pic);
					break;
				case 8:
					weiboVo.getWeiboCustom().setPic8(pic);
					break;
				case 9:
					weiboVo.getWeiboCustom().setPic9(pic);
					break;
				}
			}
		}

		// 用户id
		User user = (User) session.getAttribute("user");
		weiboVo.getWeiboCustom().setUserId(user.getUserId());

		// 发送时间
		Date postTime = new java.sql.Date(new java.util.Date().getTime());
		weiboVo.getWeiboCustom().setPostTime(postTime);

		weiboService.post(weiboVo);
		return "redirect:queryAllWeiboNow.action?pageNo=1";
	}

	// 图片上传
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file, Model model, HttpSession session) throws Exception {
		JSONObject json = new JSONObject();
		// 原始名称
		String originalFilename = file.getOriginalFilename();
		// 上传图片
		if (file != null && originalFilename != null && originalFilename.length() > 0) {

			// 存储图片的物理路径
			String pic_path = "F:\\upload\\userface\\";

			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			String pic_1, pic_2, pic_3, pic_4, pic_5, pic_6, pic_7, pic_8, pic_9;
			pic_1 = (String) session.getAttribute("pic_1");
			pic_2 = (String) session.getAttribute("pic_2");
			pic_3 = (String) session.getAttribute("pic_3");
			pic_3 = (String) session.getAttribute("pic_3");
			pic_4 = (String) session.getAttribute("pic_4");
			pic_5 = (String) session.getAttribute("pic_5");
			pic_6 = (String) session.getAttribute("pic_6");
			pic_7 = (String) session.getAttribute("pic_7");
			pic_8 = (String) session.getAttribute("pic_8");
			pic_9 = (String) session.getAttribute("pic_9");
			if (pic_1 == null) {
				pic_1 = newFileName;
				session.setAttribute("pic_1", newFileName);
			} else if (pic_2 == null) {
				pic_2 = newFileName;
				session.setAttribute("pic_2", newFileName);
			} else if (pic_3 == null) {
				pic_3 = newFileName;
				session.setAttribute("pic_3", newFileName);
			} else if (pic_4 == null) {
				pic_3 = newFileName;
				session.setAttribute("pic_4", newFileName);
			} else if (pic_5 == null) {
				pic_3 = newFileName;
				session.setAttribute("pic_5", newFileName);
			} else if (pic_6 == null) {
				pic_3 = newFileName;
				session.setAttribute("pic_6", newFileName);
			} else if (pic_7 == null) {
				pic_3 = newFileName;
				session.setAttribute("pic_7", newFileName);
			} else if (pic_8 == null) {
				pic_3 = newFileName;
				session.setAttribute("pic_8", newFileName);
			} else if (pic_9 == null) {
				pic_3 = newFileName;
				session.setAttribute("pic_9", newFileName);
			}
			// 新图片
			File newFile = new File(pic_path + newFileName);

			// 将内存中的数据写入磁盘
			file.transferTo(newFile);

			// 将新图片名称写到user中

			json.put("status", "OK");
			json.put("picName", newFileName);
			System.out.println(json.toString());
			return json.toString();
		}
		json.put("status", "NO");
		System.out.println(json.toString());
		return json.toString();
	}

	// 遍历所有微博 实时
	@SuppressWarnings("static-access")
	@RequestMapping(value = "queryAllWeiboNow")
	public String queryAllWeiboNow(HttpSession session, Model model, @RequestParam("pageNo") int pageNo)
			throws Exception {

		// 当前用户信息
		UserCustom user = (UserCustom) session.getAttribute("user");

		// 页码
		if (pageNo == 0) {
			pageNo = 1;
		}
		//
		// 遍历出微博列表
		Page<WeiboCustom> page = weiboService.queryAllWeiboNow(pageNo);
		for (WeiboCustom weiboCustom : page.getResults()) {
			// 将date格式化 精确到s
			weiboCustom.setDate(dateConvert.convert2s(weiboCustom.getPostTime()));

			// 用户是否赞过
			weiboCustom.setLikes(likesService.isLike(user.getUserId(), weiboCustom.getWeiboId()));

			// 用户是否收藏
			weiboCustom.setCollect(collectService.isCollect(user.getUserId(), weiboCustom.getWeiboId()));

			// 查询微博转发 评论 点赞次数
			weiboCustom.setRepostCount(weiboService.queryRepostCount(weiboCustom.getWeiboId()));
			weiboCustom.setCommentCount(weiboService.queryCommentCount(weiboCustom.getWeiboId()));
			weiboCustom.setLikeCount(weiboService.queryLikeCount(weiboCustom.getWeiboId()));
			// 非原创 即属于转发微博
			if (weiboCustom.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weiboCustom.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weiboCustom.setRepost(repostWeibo);
			}
		}
		// 与我相关数据库存储值
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);

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

		model.addAttribute("weiboList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		model.addAttribute("user", user);

		session.setAttribute("user", user);
		return "/weibo/home";

	}

	// 遍历所有微博 好友圈
	@SuppressWarnings("static-access")
	@RequestMapping(value = "queryAllWeiboFriends")
	public String queryAllWeiboFriends(HttpSession session, Model model, @RequestParam("pageNo") int pageNo)
			throws Exception {

		// 当前用户信息
		UserCustom user = (UserCustom) session.getAttribute("user");

		// 页码
		if (pageNo == 0) {
			pageNo = 1;
		}
		//
		// 遍历出微博列表
		Page<WeiboCustom> page = weiboService.queryAllWeiboFriends(user.getUserId(), pageNo);
		for (WeiboCustom weiboCustom : page.getResults()) {
			// 将date格式化 精确到s
			weiboCustom.setDate(dateConvert.convert2s(weiboCustom.getPostTime()));

			// 用户是否赞过
			weiboCustom.setLikes(likesService.isLike(user.getUserId(), weiboCustom.getWeiboId()));

			// 用户是否收藏
			weiboCustom.setCollect(collectService.isCollect(user.getUserId(), weiboCustom.getWeiboId()));

			// 查询微博转发 评论 点赞次数
			weiboCustom.setRepostCount(weiboService.queryRepostCount(weiboCustom.getWeiboId()));
			weiboCustom.setCommentCount(weiboService.queryCommentCount(weiboCustom.getWeiboId()));
			weiboCustom.setLikeCount(weiboService.queryLikeCount(weiboCustom.getWeiboId()));
			// 非原创 即属于转发微博
			if (weiboCustom.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weiboCustom.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weiboCustom.setRepost(repostWeibo);
			}
		}
		// 与我相关数据库存储值
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);

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

		model.addAttribute("weiboList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		model.addAttribute("user", user);

		session.setAttribute("user", user);
		return "/weibo/home_friends";

	}

	// 遍历所有微博 首页
	@SuppressWarnings("static-access")
	@RequestMapping(value = "queryAllWeiboFollow")
	public String queryAllWeiboFollow(HttpSession session, Model model, @RequestParam("pageNo") int pageNo)
			throws Exception {

		// 当前用户信息
		UserCustom user = (UserCustom) session.getAttribute("user");

		// 页码
		if (pageNo == 0) {
			pageNo = 1;
		}
		//
		// 遍历出微博列表 首页
		Page<WeiboCustom> page = weiboService.queryAllWeiboFollow(user.getUserId(), pageNo);
		for (WeiboCustom weiboCustom : page.getResults()) {
			// 将date格式化 精确到s
			weiboCustom.setDate(dateConvert.convert2s(weiboCustom.getPostTime()));

			// 用户是否赞过
			weiboCustom.setLikes(likesService.isLike(user.getUserId(), weiboCustom.getWeiboId()));

			// 用户是否收藏
			weiboCustom.setCollect(collectService.isCollect(user.getUserId(), weiboCustom.getWeiboId()));

			// 查询微博转发 评论 点赞次数
			weiboCustom.setRepostCount(weiboService.queryRepostCount(weiboCustom.getWeiboId()));
			weiboCustom.setCommentCount(weiboService.queryCommentCount(weiboCustom.getWeiboId()));
			weiboCustom.setLikeCount(weiboService.queryLikeCount(weiboCustom.getWeiboId()));
			// 非原创 即属于转发微博
			if (weiboCustom.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weiboCustom.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weiboCustom.setRepost(repostWeibo);
			}
		}
		// 与我相关数据库存储值
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);

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

		model.addAttribute("weiboList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		model.addAttribute("user", user);

		session.setAttribute("user", user);
		return "/weibo/home_follow";

	}

	// 根据关键字搜索相关微博
	@RequestMapping(value = "queryWeiboByWord")
	public String queryWeiboByWord(
			Model model,
			HttpSession session, 
			@RequestParam("keyWord") String keyWord,
			@RequestParam("pageNo") int pageNo) throws Exception {
		// 当前用户信息
		UserCustom user = (UserCustom) session.getAttribute("user");
		// 遍历出微博列表 首页
		Page<WeiboCustom> page = weiboService.queryWeiboByWord(keyWord, pageNo);
		for (WeiboCustom weiboCustom : page.getResults()) {
			// 将date格式化 精确到s
			weiboCustom.setDate(dateConvert.convert2s(weiboCustom.getPostTime()));

			// 用户是否赞过
			weiboCustom.setLikes(likesService.isLike(user.getUserId(), weiboCustom.getWeiboId()));

			// 用户是否收藏
			weiboCustom.setCollect(collectService.isCollect(user.getUserId(), weiboCustom.getWeiboId()));

			// 查询微博转发 评论 点赞次数
			weiboCustom.setRepostCount(weiboService.queryRepostCount(weiboCustom.getWeiboId()));
			// weiboCustom.setCommentCount(weiboService.queryCommentCount(weiboCustom.getWeiboId()));
			weiboCustom.setLikeCount(weiboService.queryLikeCount(weiboCustom.getWeiboId()));
			// 非原创 即属于转发微博
			if (weiboCustom.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weiboCustom.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weiboCustom.setRepost(repostWeibo);
			}
		}
		// 与我相关数据库存储值
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);

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

		model.addAttribute("weiboList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		model.addAttribute("user", user);

		session.setAttribute("user", user);

		return "/search/search_weibo";
	}
}
