package com.zking.ssm.opinion.service;

import com.zking.ssm.opinion.model.Reply;
import com.zking.ssm.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IReplyService {


    int insert(Reply record);

    List<Reply> queryReplyLstPager(Reply reply, PageBean pageBean);
    List<Reply> queryDirectoryReplyLstPager(Reply reply,PageBean pageBean);
    int updateReply(Reply reply);
    int deleteByPrimaryKey(Integer repid);


}