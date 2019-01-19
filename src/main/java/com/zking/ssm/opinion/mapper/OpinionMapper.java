package com.zking.ssm.opinion.mapper;

import com.zking.ssm.opinion.model.Opinion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OpinionMapper {
    int deleteByPrimaryKey(Integer opid);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    Opinion selectByPrimaryKey(Integer opid);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKey(Opinion record);
    List<Map<String,Object>> queryOpinionPager(Opinion opinion);
    int UpdateType(Opinion opinion);

    List<Map<String,Object>> queryCount(Opinion opinion);

}