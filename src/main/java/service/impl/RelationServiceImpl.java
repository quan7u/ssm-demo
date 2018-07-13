package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mapper.RelationMapperCustom;
import po.Relation;
import service.RelationService;

@Transactional
public class RelationServiceImpl implements RelationService {

	@Autowired
	private RelationMapperCustom relationMapperCustom;

	// 查询是否相互关注
	@Override
	public List<Relation> queryMutual(Relation relation) throws Exception {
		return relationMapperCustom.queryMutual(relation);
	}

	// 查询是否单方关注
	@Override
	public List<Relation> queryUnilateral(Relation relation) throws Exception {
		return relationMapperCustom.queryUnilateral(relation);
	}

	// 关注
	@Override
	public void follow(Relation relation, int flag) throws Exception {

		Relation r = new Relation();
		r.setUserId(relation.getFollowid());
		r.setFollowid(relation.getUserId());

		if (flag == 2) { // 被访问用户已关注我 升级为相互关注 status=2
			// 插入新纪录 设置为相互关注
			relation.setState(2);
			relationMapperCustom.Follow(relation);
			// 更新被访问用户关注记录
			r.setState(2);
			relationMapperCustom.Status(r);
		} else { // 完全陌生 创建关系 status=1
			relation.setState(1);
			relationMapperCustom.Follow(relation);
		}
	}

	// 取关
	@Override
	public void unfollow(Relation relation, int flag) throws Exception {
		Relation r = new Relation();
		r.setUserId(relation.getFollowid());
		r.setFollowid(relation.getUserId());

		if (flag == 2) { // 被访问用户已关注我 status=2
			// 解除关注
			relationMapperCustom.UnFollow(relation);
			// 更新被访问用户关注记录 更新状态为1 单方关注
			r.setState(1);
			relationMapperCustom.Status(r);
		} else { // 完全陌生 解除关系 status=1
			relationMapperCustom.UnFollow(relation);
		}
	}

	// 查询两人关系
	@Override
	public int queryRelation(Integer userId, Integer followId) throws Exception {
		// 我——>他
		Relation relation1 = new Relation();
		relation1.setUserId(userId);
		relation1.setFollowid(followId);

		// 他——>我
		Relation relation2 = new Relation();
		relation2.setUserId(followId);
		relation2.setFollowid(userId);

		// 相互关注
		List<Relation> mutualList = relationMapperCustom.queryMutual(relation1);
		// 我关注他
		List<Relation> unilateralList1 = relationMapperCustom.queryUnilateral(relation1);
		// 他关注我
		List<Relation> unilateralList2 = relationMapperCustom.queryUnilateral(relation2);
		if (mutualList.size() != 0) {
			// 相互关注 （相互关注——关注）
			return 4;
		} else if (unilateralList1.size() != 0) {
			// 我关注他 他未关注我 （已关注——关注）
			return 3;
		} else if (unilateralList2.size() != 0) {
			// 他关注我 我未关注他 （关注——相互关注）
			return 2;
		} else {
			// 相互未关注 我发起关注（关注——已关注）
			return 1;
		}
	}

}
