package com.zking.ssm.system.controller;

import com.zking.ssm.system.model.User;
import com.zking.ssm.system.service.IUserService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class UserContorller {
    @Autowired
    private IUserService userService;
    //用户主页面
    @RequestMapping("/toUserManager")
    public String toUser(){
        return "system/userManager";
    }
    //用户添加页面
    @RequestMapping("/toUserAdd")
    public String toUserAdd(){
        return "system/userAdd";
    }
//    用户添加
    @ResponseBody
    @RequestMapping("/userAdd")
    public Map<String,Object> userAdd(User user){
        int insert = userService.insert(user);
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

    //user页面的分页查询
    @ResponseBody
    @RequestMapping("/queryUserPager")
    public Map<String,Object> queryUserPager(User user, HttpServletRequest req){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        Map<String,Object> map = new HashMap<>();
        List<User> lst = userService.queryUserPager(user, pageBean);
        map.put("count",pageBean.getTotal());
        map.put("code","0");
        map.put("data",lst);
        return map;
    }
    //删除用户
    @ResponseBody
    @RequestMapping("/userDel")
    public Map<String,Object> userDel(User user){
        int del = userService.deleteByPrimaryKey(user);
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
    //修改用户
    @ResponseBody
    @RequestMapping("/userUpdate")
    public Map<String,Object> userUpdate(User user){
        System.out.println("123:"+user.getRealname());
        int update = userService.updateByPrimaryKey(user);
        Map<String,Object> map = new HashMap<>();
        if(update>0){
            map.put("success",true);
            map.put("message","修改成功");
        }else{
            map.put("success",false);
            map.put("message","修改失败");
        }
        return map;
    }
}
