package com.zking.ssm.opinion.service.impl;

import com.zking.ssm.opinion.mapper.OpinionMapper;
import com.zking.ssm.opinion.model.Opinion;
import com.zking.ssm.opinion.service.IOpinionService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class OpinionServiceImpl implements IOpinionService {
    @Autowired
    private OpinionMapper opinionMapper;
    @Transactional
    @Override
    public int insert(Opinion record) {
        return opinionMapper.insert(record);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Map<String, Object>> queryOpinionPager(Opinion opinion, PageBean pageBean) {
        return opinionMapper.queryOpinionPager(opinion);
    }

    @Override
    public int UpdateType(Opinion opinion) {
        return opinionMapper.UpdateType(opinion);
    }

    @Override
    public int deleteByPrimaryKey(Integer opid) {
        return opinionMapper.deleteByPrimaryKey(opid);
    }

    @Override
    public List<Map<String,Object>> queryCount(Opinion opinion) {
        return opinionMapper.queryCount(opinion);
    }
}
