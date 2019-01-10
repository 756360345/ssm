package com.zking.ssm.opinion.service;

import com.zking.ssm.opinion.mapper.OpinionMapper;
import com.zking.ssm.opinion.model.Opinion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface IOpinionService {


    int insert(Opinion record);


}