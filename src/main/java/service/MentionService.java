package service;

import po.MentionCustom;

public interface MentionService {

	//查询
	// 转发量
	int queryRepost(int userId) throws Exception;

	// 评论量
	int queryComment(int userId) throws Exception;

	// 回复量
	int queryReply(int userId) throws Exception;

	// 赞
	int queryLike(int userId) throws Exception;
	
	// 粉丝量
	int queryFans(int userId) throws Exception;
	
	//计算差值
	// 转发量
	int countRepost(int userId, int oldCount) throws Exception;

	// 评论量
	int countComment(int userId, int oldCount) throws Exception;

	// 回复量
	int countReply(int userId, int oldCount) throws Exception;

	// 赞
	int countLike(int userId, int oldCount) throws Exception;
	
	// 粉丝量
	int countFans(int userId, int oldCount) throws Exception;
	
	// 读取数据库上次保存的与我相关数目
	MentionCustom queryLastMention(int userId) throws Exception;

	// 读取实时数目与我相关
	MentionCustom queryNewMention(Integer userId) throws Exception;

	// 更新转发数
	void updateRepost(int userId, int totalRepost);

	// 更新评论数
	void updateComment(Integer userId, int newComment);

	// 更新赞数
	void updateLikes(Integer userId, int newLike);

	// 更新粉丝数
	void updateFans(Integer userId, int newFans);

	// 更新回复数
	void updateReply(Integer userId, int newReply);


}
