package com.zking.ssm.opinion.service.impl;

import com.zking.ssm.opinion.mapper.ReplyMapper;
import com.zking.ssm.opinion.model.Reply;
import com.zking.ssm.opinion.service.IReplyService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class ReplyServiceImpl implements IReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public int insert(Reply record) {
        return replyMapper.insert(record);
    }

    @Override
    public List<Reply> queryReplyLstPager(Reply reply, PageBean pageBean) {
        return replyMapper.queryReplyLst(reply);
    }

    @Override
    public List<Reply> queryDirectoryReplyLstPager(Reply reply,PageBean pageBean) {
        return replyMapper.queryDirectoryReplyLstPager(reply);
    }

    @Override
    public int updateReply(Reply reply) {
        return replyMapper.updateReply(reply);
    }

    @Override
    public int deleteByPrimaryKey(Integer repid) {
        return replyMapper.deleteByPrimaryKey(repid);
    }
}
