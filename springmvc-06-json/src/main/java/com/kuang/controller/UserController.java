package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*@Controller*/
@RestController
public class UserController {

    @RequestMapping(value = "/j1"/*,produces = "application/json;charset=utf-8"*/)
    /*@ResponseBody*/ //这里使用@ResponseBody它就不会走视图解析器，会直接返回一个字符串
    public String json() throws JsonProcessingException {
       /* //垃圾lombok，害劳资在这里翻跟头
        User fax = new User(1, "fax",2 );
        return fax.toString();*/

       //使用Jackson
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User(1, "superax", 2);
        String str = mapper.writeValueAsString(user);
        return str;
    }

    //输出List集合
    @RequestMapping("/j2")
    public  String json2() throws JsonProcessingException {
        //使用Jackson
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "fax", 1);
        User user2 = new User(2, "fax", 2);
        User user3 = new User(3, "fax", 3);
        User user4 = new User(4, "fax", 4);

        List<User> userList = new ArrayList<>();

        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        /*String str = mapper.writeValueAsString(userList);
        return str;*/
        return JsonUtils.getJson(userList);
    }

    //输出时间
    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        /*//使用Jackson
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        //ObjectMapper，时间解析之后的默认格式为：Timestamp，时间戳
        String str = mapper.writeValueAsString(date);
        return str;*/

        //让日期输出为有格式的样子
        //方法一：自定义日期的格式
        /*ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = mapper.writeValueAsString(simpleDateFormat.format(date));
        return str;*/


        //方法二：使用时间戳的方式
       /* ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //自定义日期的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);
        Date date = new Date();
        return mapper.writeValueAsString(date);*/

        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");

    }
    //FAstJson
    @RequestMapping("/j4")
    public  String json4() throws JsonProcessingException {

        User user = new User(1, "fax", 1);
        User user2 = new  User(2, "fax", 2);
        User user3 = new User(3, "fax", 3);
        User user4 = new User(4, "fax", 4);

        List<User> userList = new ArrayList<>();

        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        System.out.println("******Java对象转JSON字符串 *****");
        String str = JSON.toJSONString(userList);
        System.out.println(str);
        String str1 = JSON.toJSONString(user);
        System.out.println(str1);
        System.out.println("******JSON字符串转java对象*****");
        User str2 = JSON.parseObject(str1, User.class);
        System.out.println(str2);
        System.out.println("******Java对象转JSON对象*****");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(user2);
        System.out.println(jsonObject);
        System.out.println("******JSON对象转Java对象*****");
        User toJavaObject = JSON.toJavaObject(jsonObject, User.class);
        System.out.println(toJavaObject);
        return str;
    }
}
