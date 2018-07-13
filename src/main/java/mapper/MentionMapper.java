package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Mention;
import po.MentionExample;

public interface MentionMapper {
    int countByExample(MentionExample example);

    int deleteByExample(MentionExample example);

    int deleteByPrimaryKey(Integer mentionId);

    int insert(Mention record);

    int insertSelective(Mention record);

    List<Mention> selectByExample(MentionExample example);

    Mention selectByPrimaryKey(Integer mentionId);

    int updateByExampleSelective(@Param("record") Mention record, @Param("example") MentionExample example);

    int updateByExample(@Param("record") Mention record, @Param("example") MentionExample example);

    int updateByPrimaryKeySelective(Mention record);

    int updateByPrimaryKey(Mention record);
}