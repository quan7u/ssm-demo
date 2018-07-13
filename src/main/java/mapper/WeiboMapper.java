package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Weibo;
import po.WeiboExample;

public interface WeiboMapper {
    int countByExample(WeiboExample example);

    int deleteByExample(WeiboExample example);

    int deleteByPrimaryKey(Integer weiboId);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    List<Weibo> selectByExample(WeiboExample example);

    Weibo selectByPrimaryKey(Integer weiboId);

    int updateByExampleSelective(@Param("record") Weibo record, @Param("example") WeiboExample example);

    int updateByExample(@Param("record") Weibo record, @Param("example") WeiboExample example);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKey(Weibo record);
}