package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Likes;
import po.LikesExample;

public interface LikesMapper {
    int countByExample(LikesExample example);

    int deleteByExample(LikesExample example);

    int deleteByPrimaryKey(Integer likesId);

    int insert(Likes record);

    int insertSelective(Likes record);

    List<Likes> selectByExample(LikesExample example);

    Likes selectByPrimaryKey(Integer likesId);

    int updateByExampleSelective(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByExample(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByPrimaryKeySelective(Likes record);

    int updateByPrimaryKey(Likes record);
}