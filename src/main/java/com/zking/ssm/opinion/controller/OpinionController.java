package com.zking.ssm.opinion.controller;

import com.zking.ssm.opinion.model.Opinion;
import com.zking.ssm.opinion.model.Reply;
import com.zking.ssm.opinion.service.IOpinionService;
import com.zking.ssm.opinion.service.IReplyService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Controller
@RequestMapping("/opinion")
public class OpinionController {
    @Autowired
    private IOpinionService opinionService;
    @Autowired
    private IReplyService replyService;

    //去社情民意填写页面
    @RequestMapping("/opinionAdd")
    public String toOpinionAdd(){
        return "/opinion/opinionAdd";
    }
//    去社情民意查询页面
    @RequestMapping("/toOpinion")
    public String toOpinion(){
        return "/opinion/opinion";
    }
//    去采用稿目录页面
    @RequestMapping("/toDirectory")
    public String toDirectory(){
        return "/opinion/directory";
    }

    //highchar1
    @RequestMapping("toChar1")
    public String toChar1(){
        return "/opinion/char1";
    }

    //民意添加
    @ResponseBody
    @RequestMapping("/Addopinion")
    public Map<String,Object> opinionAdd(Opinion opinion){
        int insert = opinionService.insert(opinion);
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

    /**
     * opinion分页及条件查询
     * @param opinion
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryOpinionPager")
    public Map<String,Object> queryOpinionPager(Opinion opinion, HttpServletRequest req){
        PageBean pageBean = new PageBean();


        pageBean.setRequest(req);
        List<Map<String, Object>> lst = opinionService.queryOpinionPager(opinion , pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("data",lst);
        map.put("count",pageBean.getTotal());

        map.put("code","0");
        return map;
    }
//    修改民意状态同时添加采用稿目录
        @Transactional
        @ResponseBody
        @RequestMapping("/updateType")
        public Map<String,Object> updateType(Opinion opinion){
            int update = opinionService.UpdateType(opinion);
            Reply reply = new Reply();
            reply.setRepname(opinion.getOplgbt());
            reply.setRepdw(opinion.getOpdwtype());
            Map<String,Object> map = new HashMap<>();
            if(update>0){
                int insert = replyService.insert(reply);
                map.put("success",true);
                map.put("message","报送成功");
            }else{
                map.put("success",false);
                map.put("message","报送失败");
            }
            return map;
        }
    @Transactional
    @ResponseBody
    @RequestMapping("/deleteOpinion")
    public Map<String,Object> deleteOpinion(Opinion opinion){
        int update = opinionService.deleteByPrimaryKey(opinion.getOpid());
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
    //highChar 查询
    @ResponseBody
    @RequestMapping("/queryCount")
    public Map<String,Object> queryCount(Opinion opinion){
        List<Map<String, Object>> lst = opinionService.queryCount(opinion);
        Map<String,Object> map = new HashMap<>();
        map.put("data",lst);
        return map;
    }

}
