package com.zking.ssm.system.controller;

import com.zking.ssm.system.model.Role;
import com.zking.ssm.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    //去权限管理页面
    @RequestMapping("toRolePage")
    public String toRolePage(){
        return "system/authority";
    }
//    去添加角色页面
    @RequestMapping("toRoleAdd")
    public String toRoleAdd(){
        return "system/addRole";
    }

    //角色添加
    @ResponseBody
    @RequestMapping("/addRole")
    public Map<String,Object> addRole(Role role){
        int insert = roleService.insert(role);
        Map<String,Object> map = new HashMap<>();
        if(insert>0){
            map.put("success",true);
            map.put("message","添加成功");
        }else{
            map.put("success",false);
            map.put("message","添加失败");
        }
        return map;
    }

    //角色查询
    @ResponseBody
    @RequestMapping("/queryRolePager")
    public Map<String,Object> queryRolePager(Role role){
        List<Map<String, Object>> lst = roleService.queryRolePager(role);
        Map<String,Object> map = new HashMap<>();
        map.put("data",lst);
        map.put("code","0");
        return map;
    }
    //角色删除
    @ResponseBody
    @RequestMapping("/delRole")
    public Map<String,Object> delRole(Role role){
        int del = roleService.deleteByPrimaryKey(role.getRoleid());
        Map<String,Object> map = new HashMap<>();
        if(del>0){
            map.put("success",true);
            map.put("message","删除成功");
        }else{
            map.put("success",false);
            map.put("message","删除失败");
        }
        return map;
    }
    //角色修改
    @ResponseBody
    @RequestMapping("/updateRole")
    public Map<String,Object> updateRole(Role role){
        int update = roleService.updateByPrimaryKey(role);
        Map<String,Object> map = new HashMap<>();
        if(update>0){
            map.put("success",true);
            map.put("message","删除成功");
        }else{
            map.put("success",false);
            map.put("message","删除失败");
        }
        return map;
    }
}
