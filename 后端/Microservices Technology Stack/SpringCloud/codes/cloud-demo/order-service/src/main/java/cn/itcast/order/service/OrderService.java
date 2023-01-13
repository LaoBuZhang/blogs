package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        //2。利用fegin远程调用
        User user = userClient.findById(order.getUserId());

        //3.将查询到的user对象封装进order对象
        order.setUser(user);
        // 4.返回
        return order;
    }

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//
//        //2。利用restTemplate发送http请求
//        //String url="http://localhost:8081/user/"+order.getUserId();
//        String url="http://userservice:8081/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//
//        //3.将查询到的user对象封装进order对象
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
