package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import po.MentionCustom;
import po.Relation;
import po.User;
import po.UserCustom;
import service.MentionService;
import service.RelationService;
import service.UserService;

@Controller
public class RelationController {

	@Autowired
	private RelationService relationService;

	@Autowired
	private MentionService mentionService;

	// 关注
	@RequestMapping(value = "follow")
	public void follow(HttpSession session, 
			HttpServletResponse response,
			@RequestParam("flag") int flag, // 判断两人关系
																				// 1：陌生
																				// 2：有一人已关注
			@RequestParam("userId") int userId) throws Exception {

		User user = (User) session.getAttribute("user");
		int me = user.getUserId();

		Relation relation = new Relation();
		relation.setUserId(me);
		relation.setFollowid(userId);

		relationService.follow(relation, flag);
	}

	// 取关
	@RequestMapping(value = "unfollow")
	public void unfollow(HttpSession session, HttpServletResponse response, @RequestParam("flag") int flag, // 判断两人关系
																				// 1：陌生
																				// 2：有一人已关注
			@RequestParam("userId") int userId) throws Exception {

		User user = (User) session.getAttribute("user");
		int me = user.getUserId();

		Relation relation = new Relation();
		relation.setUserId(me);
		relation.setFollowid(userId);

		relationService.unfollow(relation, flag);
	}

	@Autowired
	private UserService userService;

	// 关注列表
	@RequestMapping("listFollow")
	public String listFollow(@RequestParam("userId") int userId, HttpServletRequest request, HttpSession session)
			throws Exception {

		UserCustom user = (UserCustom) userService.queryInfoByUserId(userId).get(0);
		UserCustom me = (UserCustom) session.getAttribute("user");
		user.setUserId(userId);
		// 微博数
		int weiboCount = userService.queryWeiboCount(user.getUserId());
		// 关注
		int followCount = userService.queryFollowCount(user.getUserId());
		// 粉丝
		int fansCount = userService.queryFansCount(user.getUserId());

		request.setAttribute("weiboCount", weiboCount);
		request.setAttribute("followCount", followCount);
		request.setAttribute("fansCount", fansCount);

		// 用户关系
		int relation = relationService.queryRelation(me.getUserId(), user.getUserId());
		request.setAttribute("relation", relation);

		// 关注列表
		List<UserCustom> followList = userService.queryFollowList(userId);
		for (UserCustom userCustom : followList) {
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

		// 用户年龄 所在地
		user.setAge(userService.calculateAge(user.getBir()));
		user.setP(userService.queryPC(user.getProvince()));
		user.setC(userService.queryPC(user.getCity()));

		request.setAttribute("followList", followList);
		request.setAttribute("user", user);
		request.setAttribute("me", me);
		
		// 读取 数据库中保存的 [上次退出时] 与我相关数
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		me.setMentionCustom(mention);
		session.setAttribute("user", me);
		return "/user/followlist";
	}

	// 粉丝列表
	@RequestMapping("listFans")
	public String listFans(@RequestParam("userId") int userId, HttpServletRequest request, HttpSession session)
			throws Exception {

		UserCustom user = (UserCustom) userService.queryInfoByUserId(userId).get(0);
		UserCustom me = (UserCustom) session.getAttribute("user");

		user.setUserId(userId);

		// 访问自己的粉丝列表 session更新 与我相关db更新
		if (me.getUserId() == userId) {
			int newFans = userService.queryFansCount(userId);
			mentionService.updateFans(userId, newFans);
			me.getMentionCustom().setFanscount(newFans);
			session.setAttribute("user", me);
		}

		// 微博数
		int weiboCount = userService.queryWeiboCount(user.getUserId());
		// 关注
		int followCount = userService.queryFollowCount(user.getUserId());
		// 粉丝
		int fansCount = userService.queryFansCount(user.getUserId());

		request.setAttribute("weiboCount", weiboCount);
		request.setAttribute("followCount", followCount);
		request.setAttribute("fansCount", fansCount);

		// 用户关系
		int relation = relationService.queryRelation(me.getUserId(), user.getUserId());
		request.setAttribute("relation", relation);

		// 粉丝列表
		List<UserCustom> fansList = userService.queryFansList(userId);
		for (UserCustom userCustom : fansList) {
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

		// 用户年龄 所在地
		user.setAge(userService.calculateAge(user.getBir()));
		user.setP(userService.queryPC(user.getProvince()));
		user.setC(userService.queryPC(user.getCity()));

		request.setAttribute("fansList", fansList);
		request.setAttribute("user", user);
		request.setAttribute("me", me);
		// 读取 数据库中保存的 [上次退出时] 与我相关数
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		me.setMentionCustom(mention);
		session.setAttribute("user", me);

		return "/user/fanslist";
	}
}
