package com.kuang.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndController  模型和视图
        ModelAndView modelAndView = new ModelAndView();
        //封装对象，放在ModelAndView中
        modelAndView.addObject("msg","HelloSpringMVC!");
        //封装要跳转的视图，，放在ModelAndView中
        modelAndView.setViewName("hello");//WEB-INF/jsp/hello.jsp
        return  modelAndView;
    }
}
