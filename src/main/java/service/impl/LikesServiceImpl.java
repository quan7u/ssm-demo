package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mapper.LikesMapperCustom;
import po.LikesCustom;
import po.Page;
import po.WeiboCustom;
import service.LikesService;
import utils.DateConvert;

@Transactional
public class LikesServiceImpl implements LikesService {

	@Autowired
	private LikesMapperCustom likesMapperCustom;

	// date格式化工具类
	private DateConvert dateConvert;

	// 点赞
	@Override
	public void like(int weiboId, Integer userId) {
		LikesCustom likes = new LikesCustom();
		likes.setUserId(userId);
		likes.setWeiboId(weiboId);
		Date likeTime = new java.sql.Date(new java.util.Date().getTime());
		likes.setLikeTime(likeTime);
		likesMapperCustom.like(likes);
	}

	// 取消赞
	@Override
	public void unlike(int weiboId, Integer userId) {
		LikesCustom likes = new LikesCustom();
		likes.setUserId(userId);
		likes.setWeiboId(weiboId);
		likesMapperCustom.unlike(likes);
	}

	// 查询是否赞
	@Override
	public int isLike(Integer userId, Integer weiboId) {
		LikesCustom likes = new LikesCustom();
		likes.setUserId(userId);
		likes.setWeiboId(weiboId);
		List<LikesCustom> likesList = likesMapperCustom.queryIsLike(likes);
		if (likesList.size() != 0) {
			// 存在记录 已赞
			return 1;
		} else {
			// 无记录
			return 0;
		}
	}

	// 查询用户被赞过信息
	@SuppressWarnings("static-access")
	@Override
	public Page<LikesCustom> queryLikesByUserId(int userId, int pageNo) {
		Page<LikesCustom> page = new Page<LikesCustom>();
		page.setPageSize(10);
		page.setPageNo(pageNo);
		page.getParams().put("userId", userId);
		List<LikesCustom> likesList = likesMapperCustom.queryLikesByUserId(page);
		for (LikesCustom like : likesList) {
			like.setDate(dateConvert.convert2s(like.getLikeTime()));
		}
		page.setResults(likesList);
		return page;

	}

	// 查询我赞过的微博
	@SuppressWarnings("static-access")
	@Override
	public Page<LikesCustom> queryLikedWeiboSelf(Integer userId, int pageNo) {
		Page<LikesCustom> page = new Page<LikesCustom>();
		page.setPageNo(pageNo);
		page.setPageSize(8);
		page.getParams().put("userId", userId);
		List<LikesCustom> likesList = likesMapperCustom.queryLikedWeiboSelf(page);
		for (LikesCustom like : likesList) {
			like.setDate(dateConvert.convert2s(like.getLikeTime()));
		}
		page.setResults(likesList);

		return page;
	}

}
