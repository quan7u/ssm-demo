package service;

import java.util.List;

import po.Page;
import po.ReplyCustom;

public interface ReplyService {

	//添加回复
	void addReply(ReplyCustom replyCustom);

	//遍历commentId下的回复
	List<ReplyCustom> queryReply(int commentId);

	//删除回复
	void deleteReplyById(int replyId);

	// 根据useId查询回复列表
	Page<ReplyCustom> queryReplyByUserId(Integer userId, int pageNo);

}
