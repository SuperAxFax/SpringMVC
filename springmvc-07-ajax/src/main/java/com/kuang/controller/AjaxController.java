package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }
    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("前端接收的name为："+name);
        if (name.equals("kuangshen")){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("狂神说java",2,"男"));
        userList.add(new User("狂神说前端",3,"男"));
        userList.add(new User("狂神说运维",3,"男"));
        return userList;
    }

    //使用ajax来验证用户名，密码登录
    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "";
        if (name!=null){
            if (name.equals("admin")){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
        }
        if (pwd!=null){
            if (pwd.equals("123456")){
                msg = "ok";
            }else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
