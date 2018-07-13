package mapper;

import java.util.List;

import po.Page;
import po.ReplyCustom;

public interface ReplyMapperCustom {

	// 添加回复
	void addReply(ReplyCustom replyCustom);

	// 遍历回复
	List<ReplyCustom> queryReply(int commentId);

	// 删除回复
	void deleteReplyById(int replyId);

	// 根据userID查询回复列表
	List<ReplyCustom> queryReplyByUserId(Page<ReplyCustom> page);

}
