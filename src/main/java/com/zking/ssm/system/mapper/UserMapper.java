package com.zking.ssm.system.mapper;

import com.zking.ssm.system.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(User key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(User key);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> queryUserPager(User user);
}