package controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import po.CollectCustom;
import po.UserCustom;
import service.CollectService;

@Controller
public class CollectController {

	@Autowired
	private CollectService collectService;
	
	// 收藏
	@RequestMapping(value = "collect")
	public void collect(
			@RequestParam("weiboId") int weiboId,
			HttpServletResponse response,
			HttpSession session) throws Exception {
		UserCustom user = (UserCustom) session.getAttribute("user");
		CollectCustom collection = new CollectCustom();
		collection.setUserId(user.getUserId());
		collection.setWeiboId(weiboId);
		// 收藏时间
		Date time = new java.sql.Date(new java.util.Date().getTime());
		collection.setCollectTime(time);
		collectService.collect(collection);
	}

	// 取消收藏
	@RequestMapping(value = "uncollect")
	public void uncollect(
			@RequestParam("weiboId") int weiboId, 
			HttpServletResponse response,
			HttpSession session) throws Exception {
		UserCustom user = (UserCustom) session.getAttribute("user");
		CollectCustom collection = new CollectCustom();
		collection.setUserId(user.getUserId());
		collection.setWeiboId(weiboId);
		collectService.uncollect(collection);
	}

}
