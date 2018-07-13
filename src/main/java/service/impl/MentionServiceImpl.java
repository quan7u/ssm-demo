package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mapper.MentionMapperCustom;
import mapper.UserMapperCustom;
import po.MentionCustom;
import service.MentionService;

@Transactional
public class MentionServiceImpl implements MentionService {

	@Autowired
	private MentionMapperCustom mentionMapperCustom;

	@Autowired
	private UserMapperCustom userMapperCustom;

	// 读取与我相关数目
	@Override
	public MentionCustom queryLastMention(int userId) throws Exception {
		return mentionMapperCustom.queryLastMention(userId);
	}

	/**
	 * 计算转发差值 
	 * session中保存值 与 实时值相比较
	 */
	@Override
	public int countRepost(int userId, int oldCount) throws Exception {
		
		// 实时转发量
		int newCount = mentionMapperCustom.queryRepostCount(userId);
		
		int res = newCount - oldCount;
		if (res == 0) {
			res = 0;
		}
		return res;
	}

	// 计算评论差值
	@Override
	public int countComment(int userId, int oldCount) throws Exception {
		
		int newCount = mentionMapperCustom.queryCommentCount(userId);
		int res = newCount - oldCount;
		if (res < 0) {
			res = 0;
		}
		return res;
	}

	// 计算回复差值
	@Override
	public int countReply(int userId, int oldCount) throws Exception {
		int newCount = mentionMapperCustom.queryReplyCount(userId);
		int res = newCount - oldCount;
		if (res < 0) {
			res = 0;
		}
		return res;
	}

	// 计算赞差值
	@Override
	public int countLike(int userId, int oldCount) throws Exception {
		int newCount = mentionMapperCustom.queryLikeCount(userId);
		int res = newCount - oldCount;
		if (res < 0) {
			res = 0;
		}
		return res;
	}

	// 计算粉丝差值
	@Override
	public int countFans(int userId, int oldCount) throws Exception {
		int newCount = userMapperCustom.queryFansCount(userId);
		int res = newCount - oldCount;
		if (res < 0) {
			res = 0;
		}
		return res;
	}

	// 读取实时mention
	@Override
	public MentionCustom queryNewMention(Integer userId) throws Exception {
		MentionCustom mention = new MentionCustom();
		mention.setRepostcount(mentionMapperCustom.queryRepostCount(userId));
		mention.setCommentcount(mentionMapperCustom.queryCommentCount(userId));
		mention.setReplycount(mentionMapperCustom.queryReplyCount(userId));
		mention.setFanscount(userMapperCustom.queryFansCount(userId));
		mention.setLikecount(mentionMapperCustom.queryLikeCount(userId));
		return mention;
	}

	// 查询
	@Override
	public int queryRepost(int userId) throws Exception {
		return mentionMapperCustom.queryRepostCount(userId);
	}

	@Override
	public int queryComment(int userId) throws Exception {
		return mentionMapperCustom.queryCommentCount(userId);
	}

	@Override
	public int queryReply(int userId) throws Exception {
		return mentionMapperCustom.queryReplyCount(userId);
	}

	@Override
	public int queryLike(int userId) throws Exception {
		return mentionMapperCustom.queryLikeCount(userId);
	}

	@Override
	public int queryFans(int userId) throws Exception {
		return userMapperCustom.queryFansCount(userId);
	}

	
	// 更新转发记录
	@Override
	public void updateRepost(int userId, int countRepost) {
		MentionCustom mentionCustom = new MentionCustom();
		mentionCustom.setUserId(userId);
		mentionCustom.setRepostcount(countRepost);
		mentionMapperCustom.updateRepost(mentionCustom);
	}

	// 更新评论数
	@Override
	public void updateComment(Integer userId, int newComment) {
		MentionCustom mention = new MentionCustom();
		mention.setUserId(userId);
		mention.setCommentcount(newComment);
		mentionMapperCustom.updateComment(mention);
	}

	// 更新赞数
	@Override
	public void updateLikes(Integer userId, int newLike) {
		MentionCustom mention = new MentionCustom();
		mention.setUserId(userId);
		mention.setLikecount(newLike);
		mentionMapperCustom.updateLikes(mention);
	}

	// 更新粉丝数
	@Override
	public void updateFans(Integer userId, int newFans) {
		MentionCustom mention = new MentionCustom();
		mention.setUserId(userId);
		mention.setFanscount(newFans);
		mentionMapperCustom.updateFans(mention);
	}

	// 更新回复数
	@Override
	public void updateReply(Integer userId, int newReply) {
		MentionCustom mention = new MentionCustom();
		mention.setUserId(userId);
		mention.setReplycount(newReply);
		mentionMapperCustom.updateReply(mention);
	}

}
