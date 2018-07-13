package service;

import po.LikesCustom;
import po.Page;

public interface LikesService {

	// 点赞
	void like(int weiboId, Integer userId);

	// 取消赞
	void unlike(int weiboId, Integer userId);

	// 是否已赞 0——否 1——是
	int isLike(Integer userId, Integer weiboId);

	// 查询用户被赞过信息
	Page<LikesCustom> queryLikesByUserId(int userId,int pageNo);

	// 查询我赞过的微博
	Page<LikesCustom> queryLikedWeiboSelf(Integer userId, int pageNo);


}
