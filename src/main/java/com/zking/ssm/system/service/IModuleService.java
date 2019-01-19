package com.zking.ssm.system.service;

import com.zking.ssm.system.model.Module;

import java.util.List;
import java.util.Map;


public interface IModuleService {


    List<Module> queryModule();
    List<Map<String,Object>> queryModuleLst(Integer pid);
}