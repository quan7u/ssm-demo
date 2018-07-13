package mapper;

import po.MentionCustom;

public interface MentionMapperCustom {

	// 读取与我相关数目
	MentionCustom queryLastMention(int userId);

	// 查询转发量
	int queryRepostCount(int userId);

	// 查询评论量
	int queryCommentCount(int userId);

	// 查询回复量
	int queryReplyCount(int userId);

	// 查询赞量
	int queryLikeCount(int userId);

	// 更新与我相关-微博转发数
	void updateRepost(MentionCustom mentionCustom);

	// 更新与我相关-评论数
	void updateComment(MentionCustom mention);

	// 更新与我相关-赞数
	void updateLikes(MentionCustom mention);

	// 更新与我相关-粉丝数
	void updateFans(MentionCustom mention);

	// 更新与我相关-回复数
	void updateReply(MentionCustom mention);

	// 注册生成mention对象 记录与我相关记录
	void insertMention(Integer userId);

}
