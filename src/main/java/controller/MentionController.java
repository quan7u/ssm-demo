package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.CollectCustom;
import po.CommentCustom;
import po.LikesCustom;
import po.MentionCustom;
import po.Page;
import po.ReplyCustom;
import po.UserCustom;
import po.WeiboCustom;
import service.CollectService;
import service.CommentService;
import service.LikesService;
import service.MentionService;
import service.ReplyService;
import service.WeiboService;
import utils.DateConvert;

/**
 * 被提及 有新消息提醒
 * 
 * @作者 yrucrew
 * @日期 2018年6月8日 下午2:46:57
 */
@Controller
public class MentionController {

	@Autowired
	private MentionService mentionService;

	@Autowired
	private WeiboService weiboService;

	@Autowired
	private LikesService likesService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private ReplyService replyService;

	@Autowired
	private CollectService collectService;

	@Autowired
	private static ObjectMapper MAPPER = new ObjectMapper();

	// date格式化工具类
	private DateConvert dateConvert;

	/**
	 * ajax长轮询 获得新通知
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "getNotice")
	public String getNotice(HttpSession session) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");

		// 上一次与我相关 db中存的值（session的值）
		MentionCustom mention = user.getMentionCustom();

		// 差值：实时-db中存的值
		MentionCustom notice = new MentionCustom();

		// 超时时间
		int maxTime = 0;

		while (true) {

			maxTime++;
			if (maxTime == 20) {
				break;
			}
			// 计算差值 显示通知数量
			notice.setRepostcount(mentionService.countRepost(user.getUserId(), mention.getRepostcount()));
			notice.setCommentcount(mentionService.countComment(user.getUserId(), mention.getCommentcount()));
			notice.setReplycount(mentionService.countReply(user.getUserId(), mention.getReplycount()));
			notice.setLikecount(mentionService.countLike(user.getUserId(), mention.getLikecount()));
			notice.setFanscount(mentionService.countFans(user.getUserId(), mention.getFanscount()));

			// 数据不变
			if (notice.getRepostcount() == 0 && notice.getCommentcount() == 0 && notice.getReplycount() == 0
					&& notice.getFanscount() == 0 && notice.getLikecount() == 0) {

				Thread.sleep(3000);
			} else {
				break;
			}

		}
		// 数据变化
		notice.setMentionId(mention.getMentionId());
		notice.setUserId(mention.getUserId());
		user.setMentionCustom(mentionService.queryNewMention(user.getUserId()));
		user.setNotice(notice);
		session.setAttribute("user", user);
		String json = MAPPER.writeValueAsString(notice);
		return json;
	}

	/**
	 * 跳转到<转发过我的>
	 * 
	 * @param session
	 * @param model
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "toRepostPage")
	public String toRepostPage(HttpSession session, Model model, @RequestParam("pageNo") int pageNo) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");

		// 实时转发数
		int totalRepost = mentionService.queryRepost(user.getUserId());
		// 触发数据库更新
		mentionService.updateRepost(user.getUserId(), totalRepost);
		// session更新
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);
		session.setAttribute("user", user);

		// 用户被转发的微博列表
		Page<WeiboCustom> page = new Page<WeiboCustom>();
		page.setPageNo(pageNo);
		page.getParams().put("userId", user.getUserId());
		// 转发微博外部
		Page<WeiboCustom> pageList = weiboService.queryRepostByUserId(page);
		// 源微博
		List<WeiboCustom> weiboList = pageList.getResults();
		for (WeiboCustom weibo : weiboList) {
			// 查询微博转发 评论 点赞次数
			weibo.setRepostCount(weiboService.queryRepostCount(weibo.getWeiboId()));
			// weiboCustom.setCommentCount(weiboService.queryCommentCount(weiboCustom.getWeiboId()));
			weibo.setLikeCount(weiboService.queryLikeCount(weibo.getWeiboId()));
			weibo.setDate(dateConvert.convert2s(weibo.getPostTime()));
			WeiboCustom repost = weiboService.queryWeiboByWeiboId(weibo.getRepostId()).get(0);
			repost.setDate(dateConvert.convert2s(repost.getPostTime()));
			weibo.setRepost(repost);
		}

		model.addAttribute("RepostList", pageList.getResults());

		pageList.setResults(null);
		model.addAttribute("page", pageList);

		model.addAttribute("user", user);
		return "/weibo/RepostPage";
	}

	/**
	 * 跳转到<收到的评论>
	 * 
	 * @param session
	 * @param model
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "toCommentPage")
	public String toCommentPage(HttpSession session, Model model, @RequestParam("pageNo") int pageNo) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");
		// 实时评论数
		int newComment = mentionService.queryComment(user.getUserId());
		// db更新评论数
		mentionService.updateComment(user.getUserId(), newComment);
		// session 更新评论数
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);
		session.setAttribute("user", user);

		// page
		Page<CommentCustom> page = commentService.queryCommentByUserId(user.getUserId(), pageNo);
		List<CommentCustom> commentList = page.getResults();
		model.addAttribute("commentList", commentList);
		page.setResults(null);
		model.addAttribute("page", page);
		return "/weibo/CommentPage";
	}

	/**
	 * 跳转到<回复我的>
	 * 
	 * @param session
	 * @param model
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "toReplyPage")
	public String toReplyPage(HttpSession session, Model model, @RequestParam("pageNo") int pageNo) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");

		// 实时回复数
		int newReply = mentionService.queryReply(user.getUserId());
		// db更新 session更新
		mentionService.updateReply(user.getUserId(), newReply);
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);

		// 回复page
		Page<ReplyCustom> page = replyService.queryReplyByUserId(user.getUserId(), pageNo);

		model.addAttribute("replyList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		return "/weibo/ReplyPage";
	}

	/**
	 * 跳转到<赞过我的>
	 * 
	 * @param session
	 * @param model
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "toLikePage")
	public String toLikePage(HttpSession session, Model model, @RequestParam("pageNo") int pageNo) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");

		// 实时赞
		int newLike = mentionService.queryLike(user.getUserId());

		// 触发数据库更新
		mentionService.updateLikes(user.getUserId(), newLike);

		// 更新session
		MentionCustom mention = mentionService.queryLastMention(user.getUserId());
		user.setMentionCustom(mention);
		session.setAttribute("user", user);

		// 点赞page
		Page<LikesCustom> page = likesService.queryLikesByUserId(user.getUserId(), pageNo);
		// 点赞list
		List<LikesCustom> likesList = page.getResults();

		model.addAttribute("likesList", likesList);

		page.setResults(null);
		model.addAttribute("page", page);
		return "/weibo/LikePage";
	}

	/**
	 * 跳转到<我的赞>
	 * 
	 * @param session
	 * @param model
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "toMyLikes")
	public String toMyLikes(HttpSession session, Model model, @RequestParam("pageNo") int pageNo) throws Exception {

		UserCustom user = (UserCustom) session.getAttribute("user");
		Page<LikesCustom> page = likesService.queryLikedWeiboSelf(user.getUserId(), pageNo);
		List<LikesCustom> likesList = page.getResults();
		for (LikesCustom like : likesList) {
			WeiboCustom weibo = like.getWeibo();
			// 微博发送时间
			weibo.setDate(dateConvert.convert2s(weibo.getPostTime()));
			// 用户是否赞过
			weibo.setLikes(likesService.isLike(user.getUserId(), weibo.getWeiboId()));

			// 用户是否收藏
			weibo.setCollect(collectService.isCollect(user.getUserId(), weibo.getWeiboId()));

			// 查询微博 评论 点赞次数
			// weiboCustom.setCommentCount(weiboService.queryCommentCount(weiboCustom.getWeiboId()));
			weibo.setLikeCount(weiboService.queryLikeCount(weibo.getWeiboId()));
			// 非原创 即属于转发微博
			if (weibo.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weibo.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weibo.setRepost(repostWeibo);
			}
		}
		model.addAttribute("likesList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		return "/weibo/myLikes";
	}

	/**
	 * 跳转到<我的收藏>
	 * 
	 * @param session
	 * @param model
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "toMyCollection")
	public String toMyCollection(HttpSession session, Model model, @RequestParam("pageNo") int pageNo)
			throws Exception {
		UserCustom user = (UserCustom) session.getAttribute("user");
		Page<CollectCustom> page = collectService.queryMyCollection(user.getUserId(), pageNo);
		List<CollectCustom> collectionList = page.getResults();
		for (CollectCustom collection : collectionList) {
			WeiboCustom weibo = collection.getWeibo();
			// 微博发送时间
			weibo.setDate(dateConvert.convert2s(weibo.getPostTime()));
			// 用户是否赞过
			weibo.setLikes(likesService.isLike(user.getUserId(), weibo.getWeiboId()));

			// 用户是否收藏
			weibo.setCollect(collectService.isCollect(user.getUserId(), weibo.getWeiboId()));

			// 查询微博 评论 点赞次数
			// weiboCustom.setCommentCount(weiboService.queryCommentCount(weiboCustom.getWeiboId()));
			weibo.setLikeCount(weiboService.queryLikeCount(weibo.getWeiboId()));
			// 非原创 即属于转发微博
			if (weibo.getOriginal() == 0) {
				WeiboCustom repostWeibo = weiboService.queryWeiboByWeiboId(weibo.getRepostId()).get(0);
				repostWeibo.setDate(dateConvert.convert2s(repostWeibo.getPostTime()));
				weibo.setRepost(repostWeibo);
			}
		}
		model.addAttribute("collectionList", page.getResults());
		page.setResults(null);
		model.addAttribute("page", page);
		return "/weibo/myCollection";
	}
}
