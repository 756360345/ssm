package com.zking.ssm.opinion.controller;

import com.zking.ssm.opinion.model.Opinion;
import com.zking.ssm.opinion.service.IOpinionService;
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
public class OpinionController {
    @Autowired
    private IOpinionService opinionService;

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

        System.out.println(pageBean.getTotal());
        pageBean.setRequest(req);
        List<Map<String, Object>> lst = opinionService.queryOpinionPager(opinion , pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("data",lst);
        map.put("count",pageBean.getTotal());

        map.put("code","0");
        return map;
    }
//    修改民意状态
        @ResponseBody
        @RequestMapping("/updateType")
        public Map<String,Object> updateType(Opinion opinion){
            System.out.println("来了老弟");
            int update = opinionService.UpdateType(opinion);
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
