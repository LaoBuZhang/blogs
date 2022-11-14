package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Service;


//@Service 不在需要将该类加入到Spring的IOC容器之中
@Service  //使用dubbo提供的service注解，将这个类提供的服务对外发布，注册到注册中心去
public class UserServiceImpl implements UserService {


    public String sayHello() {
        return "Hello dubbo laobuzhang!";
    }
}
