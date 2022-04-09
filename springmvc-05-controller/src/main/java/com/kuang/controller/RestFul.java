package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFul {
    //原来的：http://localhost:8080/add?a=1&b=2
    //RestFul：http://localhost:8080/add/a/b
   /* @RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    public String test(@PathVariable int a, @PathVariable int b, Model model){
        int res = a +b ;
        model.addAttribute("msg","结果为：" + res);
        return "test";
    }*/
    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        int res = a +b ;
        model.addAttribute("msg","结果1为：" + res);
        return "test";
    }
    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int res = a +b ;
        model.addAttribute("msg","结果2为：" + res);
        return "test";
    }
}

package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    //localhost:8080/user/t1 ? name = xxx
    @GetMapping("/t1")
    public String test(/*@RequestParam("username") */String name, Model model){
        //1：接收前端参数
        System.out.println("接收到的前端参数为："+name);
        //2：将返回的结果传递给前端，使用Model
        model.addAttribute("msg","UserController");
        //3:视图跳转
        return "hello";
    }

    //前端接收的是一个对象：id，name，age
    /*
    * 1：接收前端用户传递的参数，判断参数的名字，假设名字直接在方法的参数上，则可以直接使用，否则用@RequestParam即可
    * 2：假设传递的是一个对象User,匹配User对象中的字段名；如果名字一致则OK，否则匹配不到！
    *
    * */
    @GetMapping("/t2")
    public String test2(User user, Model model){
        //1:接收前端参数
        System.out.println("从前端接收的参数为"+user);
        //2：将返回结果传递给前端，使用Model
        model.addAttribute("msg","UserTest");
        //3：视图跳转
        return "hello";
    }

    //ModelMap
    @GetMapping("/t3")
    public String test3(ModelMap modelMap){
        //1:将返回结果传递给前端，使用ModelMap
        modelMap.addAttribute("msg","UserTest");
        //2：视图跳转
        return "hello";
    }
}

