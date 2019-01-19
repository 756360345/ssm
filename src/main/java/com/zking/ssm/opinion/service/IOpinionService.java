package com.zking.ssm.opinion.service;


import com.zking.ssm.opinion.model.Opinion;
import com.zking.ssm.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IOpinionService {


    int insert(Opinion record);
    List<Map<String,Object>> queryOpinionPager(Opinion opinion, PageBean pageBean);

    int UpdateType(Opinion opinion);
    int deleteByPrimaryKey(Integer opid);
    List<Map<String,Object>> queryCount(Opinion opinion);


}