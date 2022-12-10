package com.laobuzhang.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer_Routing {

    public static void main(String[] args) throws IOException, TimeoutException {

        //1.创建连接工厂
        ConnectionFactory factory=new ConnectionFactory();

        //2.设置参数
        factory.setHost("192.168.234.100");//ip，默认为localhost
        factory.setPort(5672);//端口，默认为5672
        factory.setVirtualHost("/laobuzhang");//虚拟机，默认为/
        factory.setUsername("laobuzhang");//用户名 默认为guest
        factory.setPassword("20030425");//密码，默认为guest

        //3.创建连接connection
        Connection connection = factory.newConnection();

        //4.创建channel
        Channel channel = connection.createChannel();


        //5. 创建交换机
        //交换机类型设置为DIRECT
        String exchangeName = "test_direct";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT,true,false,false,null);

        //6. 创建队列
        String queue1Name = "test_direct_queue1";
        String queue2Name = "test_direct_queue2";
        channel.queueDeclare(queue1Name,true,false,false,null);
        channel.queueDeclare(queue2Name,true,false,false,null);

        //7. 绑定队列和交换机
        /*
        queueBind(String queue, String exchange, String routingKey)
        参数：
            1. queue：队列名称
            2. exchange：交换机名称
            3. routingKey：路由键，绑定规则
         */
        //队列1绑定 error
        channel.queueBind(queue1Name,exchangeName,"error");
        //队列2绑定 info  error  warning
        channel.queueBind(queue2Name,exchangeName,"info");
        channel.queueBind(queue2Name,exchangeName,"error");
        channel.queueBind(queue2Name,exchangeName,"warning");


        //8. 发送消息
        String body = "日志信息：张三调用了delete方法...出错误了。。。日志级别：error...";
        channel.basicPublish(exchangeName,"warning",null,body.getBytes());

        //9. 释放资源
        channel.close();
        connection.close();
    }
}
