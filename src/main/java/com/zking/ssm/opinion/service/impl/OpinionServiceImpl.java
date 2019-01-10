package com.zking.ssm.opinion.service.impl;

import com.zking.ssm.opinion.mapper.OpinionMapper;
import com.zking.ssm.opinion.model.Opinion;
import com.zking.ssm.opinion.service.IOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
