package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControllerTest3 {
    @RequestMapping("/h1")
    public String test3(Model model){
        //封装对象
        model.addAttribute("msg","ControllerTest3");
        //返回要跳转的视图
        return "test";
    }
}
