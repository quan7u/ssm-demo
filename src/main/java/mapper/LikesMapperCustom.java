package mapper;

import java.util.List;

import po.LikesCustom;
import po.Page;
import po.WeiboCustom;

public interface LikesMapperCustom {

	// 点赞
	void like(LikesCustom likes);

	// 取消赞
	void unlike(LikesCustom likes);

	// 检验是否赞
	List<LikesCustom> queryIsLike(LikesCustom likes);

	// 查询被赞记录
	List<LikesCustom> queryLikesByUserId(Page<LikesCustom> page);

	// 查询我的赞
	List<LikesCustom> queryLikedWeiboSelf(Page<LikesCustom> page);

}