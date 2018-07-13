package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Reply;
import po.ReplyExample;

public interface ReplyMapper {
    int countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Integer replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Integer replyId);

    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}