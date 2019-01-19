package com.zking.ssm.system.service;

import com.zking.ssm.system.model.User;
import com.zking.ssm.util.PageBean;

import java.util.List;

public interface IUserService {


    int insert(User record);
    List<User> queryUserPager(User user, PageBean pageBean);
    int deleteByPrimaryKey(User key);
    int updateByPrimaryKey(User record);


}