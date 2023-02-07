package com.itheima.controller;

import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    //@Autowired//本地注入

    /*
    @Reference的作用
        1.从zookeeper注册中心获取userService的访问url
        2.进行远程调用RPC
        3.将结构封装成一个代理对象，给变量赋值
     */
    @Reference//远程注入，要用dubbo的
    private UserService userService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println(userService.getClass().getName());
        return userService.sayHello();
    }
}
