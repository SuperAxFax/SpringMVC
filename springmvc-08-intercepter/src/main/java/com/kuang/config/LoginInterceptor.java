package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行：判断什么情况下登录
        //登录页面也会放行
        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("login")){
            return true;
        }
        if (session.getAttribute("userLoginInfo")!=null){
            return true;
        }
        //由于第一次登录的时候没有Session，如果不给第一次登录放行，就会产生登录不进去的情况
        if (request.getRequestURI().contains("goLogin")){
            return true;
        }
        //判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
