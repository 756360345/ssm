package com.zking.ssm.opinion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/opinion")
public class OpinionController {
    @RequestMapping("/opinionAdd")
    public String toOpinionAdd(){
        return "/opinion/opinionAdd";
    }
}
