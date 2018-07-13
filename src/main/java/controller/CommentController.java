package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.Comment;
import po.CommentCustom;
import service.CommentService;
import utils.DateConvert;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private static ObjectMapper MAPPER = new ObjectMapper();
	
	//添加评论
	@RequestMapping(value="comment",method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public CommentCustom comment(
			@RequestBody CommentCustom commentCustom) throws Exception {
		commentService.addComment(commentCustom);
		
		return commentCustom;
	}
	
	//遍历评论
	@RequestMapping(value="queryComment", method = RequestMethod.GET)
	@ResponseBody
	public String queryComment(
			HttpServletRequest request,
			@RequestParam("weiboId") int weiboId) throws Exception {
		
		List<CommentCustom> commentList = commentService.queryComment(weiboId);
		for (CommentCustom commentCustom : commentList) {
			commentCustom.setCountReply(commentService.qeuryCountReply(commentCustom.getCommentId()));
			commentCustom.setTime(DateConvert.convert2json(commentCustom.getCommentTime().getTime()));
		}
		String json = MAPPER.writeValueAsString(commentList);
		return json;
	}
	
	//删除评论
	@RequestMapping(value="deleteComment")
	public void deleteComment(@RequestParam("commentId") int commentId) throws Exception {
		commentService.deleteCommentById(commentId);
	}
}
