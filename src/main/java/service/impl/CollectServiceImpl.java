package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mapper.CollectMapperCustom;
import po.CollectCustom;
import po.Page;
import service.CollectService;
import utils.DateConvert;

@Transactional
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectMapperCustom collectMapperCustom;
	
	private DateConvert dateConvert;
	
	// 收藏
	@Override
	public void collect(CollectCustom collection) {
		collectMapperCustom.collect(collection);
	}

	// 取消收藏
	@Override
	public void uncollect(CollectCustom collection) {
		collectMapperCustom.uncollect(collection);
	}

	// 是否收藏 1——是 0——否
	@Override
	public int isCollect(Integer userId, Integer weiboId) {
		CollectCustom collect = new CollectCustom();
		collect.setUserId(userId);
		collect.setWeiboId(weiboId);
		List<CollectCustom> collectList = collectMapperCustom.isCollect(collect);
		if(collectList.size() != 0) {
			return 1;
		} else {
			return 0;
		}
		
	}

	// 查询我的收藏列表
	@Override
	public Page<CollectCustom> queryMyCollection(Integer userId, int pageNo) {
		Page<CollectCustom> page = new Page<CollectCustom>();
		page.setPageNo(pageNo);
		page.setPageSize(8);
		page.getParams().put("userId", userId);
		List<CollectCustom> collectionList = collectMapperCustom.queryMyCollection(page);
		for (CollectCustom collection : collectionList) {
			collection.setDate(dateConvert.convert2s(collection.getCollectTime()));
		}
		page.setResults(collectionList);
		
		
		return page;
	}
	
}
