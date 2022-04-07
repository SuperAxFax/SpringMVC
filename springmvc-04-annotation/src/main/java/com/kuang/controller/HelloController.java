package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//解决implements Controller问题
public class HelloController {

    @RequestMapping("/hello")//解决配置<bean  id="/hello" class="com.kuang.controller.HelloController"/>的问题
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello,SpringMVCAnnotation");
        return  "hello";//会被视图解析器处理
    }
}
