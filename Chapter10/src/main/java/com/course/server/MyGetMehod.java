package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
* 这是返回结果携带cookies信息的类
* */
@RestController
@Api(value = "/",description = "这是我全部的get方法")
//@RestController 该标签表示，该class是需要被扫描的类
public class MyGetMehod {
    @RequestMapping(value = "/getMyCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个get方法可以获取cookie信息",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类
        Cookie cookie=new Cookie("login","hi");
        Cookie cookie1=new Cookie("age","30");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        return "恭喜您获取cookies信息成功~~~~~";
    }

    /*
    * 要求客户端携带cookies信息访问
    * 这是一个必须携带正确cookies信息才能访问的
    * */
    @RequestMapping(value = "/get/with/mycookies",method = RequestMethod.GET)
    @ApiOperation(value = "客户端需要携带cookie信息才能访问的get方法",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
       Cookie[] cookies = request.getCookies();
       if(Objects.isNull(cookies)){
            return "你必须携带cookies信息";
       }
       for (Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("chenggong")){
                return "这是一个带cooikes(login=chenggong)的get请求";
            }
       }
        return "你必须携带cookies信息来~~~";
    }
    /*
    * 开发一个需要携带参数才能访问的get请求,获取商品列表
    * 第一种实现方式：url:key=value&key=value
    * */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get方法一",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList= new HashMap<>();
        myList.put("衬衣",500);
        myList.put("牙刷",10);
        myList.put("毛巾",20);
        return myList;
    }
    /*
    * 开发一个需要携带参数才能访问的get请求,获取商品列表
    * 第二种实现仿古式：url:ip:port/get/with/param/10/20
    * */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的get方法二",httpMethod = "GET")
    public Map<String,Integer> getMyList(@PathVariable Integer start,
                                         @PathVariable Integer end){
        Map<String,Integer> myList= new HashMap<>();
        myList.put("A4纸",50);
        myList.put("签字笔",3);
        myList.put("胶水",2);
        return myList;
    }
}
