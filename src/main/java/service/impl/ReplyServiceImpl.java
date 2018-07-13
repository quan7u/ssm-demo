package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mapper.ReplyMapperCustom;
import po.Page;
import po.ReplyCustom;
import service.ReplyService;
import utils.DateConvert;

@Transactional
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapperCustom replyMapperCustom;
	
	

	// 添加回复
	@Override
	public void addReply(ReplyCustom replyCustom) {
		replyMapperCustom.addReply(replyCustom);
	}

	// 遍历评论id为commentId的回复
	@Override
	public List<ReplyCustom> queryReply(int commentId) {
		return replyMapperCustom.queryReply(commentId);
	}

	// 删除回复
	@Override
	public void deleteReplyById(int replyId) {
		replyMapperCustom.deleteReplyById(replyId);
	}

	// 根据userID查询回复列表
	@Override
	public Page<ReplyCustom> queryReplyByUserId(Integer userId, int pageNo) {
		Page<ReplyCustom> page = new Page<ReplyCustom>();
		page.setPageSize(10);
		page.setPageNo(pageNo);
		page.getParams().put("userId", userId);
		List<ReplyCustom> replyList = replyMapperCustom.queryReplyByUserId(page);
		for (ReplyCustom reply : replyList) {
			reply.setRtime(DateConvert.convert2s(reply.getTime()));
		}
		page.setResults(replyList);
		return page;
	}

}
