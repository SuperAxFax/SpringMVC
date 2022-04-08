package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//代表这个类会被Spring接管
//被这个注解的类中的所有方法，如果返回值是String,并且有具体页面可以跳转，那么就会被视图解析器解析；
public class ControllerTest2 {

    @RequestMapping("/h1")
    public  String test1(Model model){
        //封装视图
        model.addAttribute("msg","ControllerTest2");
        // 返回要跳转的页面
        return "hello";//WEB-INF/jsp/hello.jsp
    }
}
