package com.zking.ssm.opinion.controller;

import com.zking.ssm.opinion.model.Reply;
import com.zking.ssm.opinion.service.IReplyService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/opinion")
public class ReplyController {
    @Autowired
    private IReplyService replyService;

    @RequestMapping("/toReply")
    public String toReply(){
        return "/opinion/reply";
    }
    @RequestMapping("/toReplys")
    public String toReplys(){
        return "/opinion/replys";
    }
    @RequestMapping("/toDirectoryReply")
    public  String toDirectoryReply(){
        return "/opinion/directoryReply";
    }
    @ResponseBody
    @RequestMapping("/queryReplyPager")
    public Map<String,Object> queryReplyLstPager(Reply reply, HttpServletRequest req){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Reply> lst = replyService.queryReplyLstPager(reply, pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("data",lst);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;
    }
    @ResponseBody
    @RequestMapping("/updateReply")
    public Map<String,Object> updateReply(Reply reply){
        Map<String,Object> map = new HashMap<>();
        int i = replyService.updateReply(reply);
            if(i>0) {
                map.put("success", true);
                map.put("message", "回复成功");
            }else {
                map.put("success", false);
                map.put("message", "回复失败");
            }
            return  map;
    }
    @ResponseBody
    @RequestMapping("/queryDirectoryReplyLstPager")
    public Map<String,Object> queryDirectoryReplyLstPager(Reply reply, HttpServletRequest req){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Reply> lst = replyService.queryDirectoryReplyLstPager(reply, pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("data",lst);
        map.put("count",pageBean.getTotal());
        map.put("code",0);
        return map;
    }
    @ResponseBody
    @RequestMapping("/deleteReply")
    public Map<String,Object> deleteReply(Reply reply){
        Map<String,Object> map = new HashMap<>();
        int del = replyService.deleteByPrimaryKey(reply.getRepid());
        if(del>0) {
            map.put("success", true);
            map.put("message", "删除成功");
        }else {
            map.put("success", false);
            map.put("message", "删除失败");
        }
        return  map;
    }
}
