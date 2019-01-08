package com.zking.ssm.system.controller;

import com.zking.ssm.system.model.Module;
import com.zking.ssm.system.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Module")
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    @RequestMapping("/getModule")
    @ResponseBody
    public List<Map<String,Object>> getModule(Module module){
        List<Module> modules = moduleService.queryModule();
        System.out.println(modules);
        List<Map<String,Object>> list=children(modules,module.getPid());
        return list;
    }


    public List<Map<String, Object>> children(List<Module> assetType,String st){
        if(st.equals(null)||0==assetType.size()||null==assetType)
            return null;
        List<Map<String, Object>> list=new ArrayList<>();
        Map<String, Object> map;
        for (Module maps : assetType) {
            map=new HashMap<>();
            if(maps.getId().length()<=4) {
                if(maps.getPid().equals(st)) {
                    map.put("name", maps.getmText());
                    map.put("id", maps.getId());
                    if(null!=maps.getUrl()&&!"".equals(maps.getUrl())) {
                        map.put("url", maps.getUrl());
                    }
                    List<Map<String, Object>> list2 = children(assetType, maps.getId());
                    if(0!=list2.size()&&null!=list2) {
                        map.put("children", list2);
                    }
                    list.add(map);
                }
            }
        }
        return list;
    }
}
