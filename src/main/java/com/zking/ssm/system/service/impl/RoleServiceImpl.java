package com.zking.ssm.system.service.impl;

import com.zking.ssm.system.mapper.RoleMapper;
import com.zking.ssm.system.model.Role;
import com.zking.ssm.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public  List<Map<String,Object>> queryRolePager(Role role) {
        return roleMapper.queryRolePager(role);
    }

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
