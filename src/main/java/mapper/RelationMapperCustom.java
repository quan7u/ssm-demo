package mapper;

import java.util.List;

import po.Relation;

public interface RelationMapperCustom {


	// 查询相互关注
	public List<Relation> queryMutual(Relation relation);

	//查询单方关注
	public List<Relation> queryUnilateral(Relation relation);

	// 关注
	public void Follow(Relation relation);

	// 改变关注状态
	public void Status(Relation r);

	// 取关
	public void UnFollow(Relation relation);

}
