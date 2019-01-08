package com.zking.ssm.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home/index.shtml")
    public String toIndex(){
        return "index";
    }

}
