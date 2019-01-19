package com.zking.ssm.system.service.impl;

import com.zking.ssm.system.mapper.UserMapper;
import com.zking.ssm.system.model.User;
import com.zking.ssm.system.service.IUserService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override

    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public List<User> queryUserPager(User user, PageBean pageBean) {
        return userMapper.queryUserPager(user);
    }

    @Override
    public int deleteByPrimaryKey(User key) {
        return userMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);

    }
}
