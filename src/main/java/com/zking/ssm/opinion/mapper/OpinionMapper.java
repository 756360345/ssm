package com.zking.ssm.opinion.mapper;

import com.zking.ssm.opinion.model.Opinion;

public interface OpinionMapper {
    int deleteByPrimaryKey(Integer opid);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    Opinion selectByPrimaryKey(Integer opid);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKey(Opinion record);
}