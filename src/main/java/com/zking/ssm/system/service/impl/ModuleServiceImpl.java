package com.zking.ssm.system.service.impl;

import com.zking.ssm.system.mapper.ModuleMapper;
import com.zking.ssm.system.model.Module;
import com.zking.ssm.system.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Transactional
@Service
public class ModuleServiceImpl implements IModuleService {
    @Autowired
    private ModuleMapper moduleMapper;
    @Transactional
    @Override
    public List<Module> queryModule() {
        return moduleMapper.queryModule();
    }

    @Override
    public List<Map<String, Object>> queryModuleLst(Integer pid) {
        return moduleMapper.queryModuleLst(pid);
    }
}
