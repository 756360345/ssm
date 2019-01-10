package com.zking.ssm.opinion.controller;

import com.zking.ssm.opinion.model.Opinion;
import com.zking.ssm.opinion.service.IOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
}
