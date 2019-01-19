package com.zking.ssm.system.service;

import com.zking.ssm.system.model.Role;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    int insert(Role record);
    List<Map<String,Object>> queryRolePager(Role role);
    int deleteByPrimaryKey(Integer roleid);
    int updateByPrimaryKey(Role record);
}
