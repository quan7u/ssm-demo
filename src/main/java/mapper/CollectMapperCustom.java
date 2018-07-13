package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Collect;
import po.CollectCustom;
import po.CollectExample;
import po.Page;

public interface CollectMapperCustom {

	// 收藏
	void collect(CollectCustom collection);

	// 取消收藏
	void uncollect(CollectCustom collection);

	// 该用户是否收藏
	List<CollectCustom> isCollect(CollectCustom collect);

	// 查询我的收藏列表
	List<CollectCustom> queryMyCollection(Page<CollectCustom> page);
}