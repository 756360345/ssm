package com.zking.ssm.opinion.mapper;

import com.zking.ssm.opinion.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReplyMapper {
    int deleteByPrimaryKey(Integer repid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer repid);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> queryReplyLst(Reply reply);
    List<Reply> queryDirectoryReplyLstPager(Reply reply);

    int updateReply(Reply reply);
}