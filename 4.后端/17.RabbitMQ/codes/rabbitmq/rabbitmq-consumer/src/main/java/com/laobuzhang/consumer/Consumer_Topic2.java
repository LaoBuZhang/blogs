package com.laobuzhang.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer_Topic2 {

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


        String queue1Name = "test_topic_queue1";
        String queue2Name = "test_topic_queue2";


        //5.接收消息
        Consumer consumer = new DefaultConsumer(channel){
            /*
                回调方法，当收到消息后，会自动执行该方法

                1. consumerTag：标识
                2. envelope：获取一些信息，交换机，路由key...
                3. properties:配置信息
                4. body：数据

             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
              /*
                System.out.println("consumerTag："+consumerTag);
                System.out.println("Exchange："+envelope.getExchange());
                System.out.println("RoutingKey："+envelope.getRoutingKey());
                System.out.println("properties："+properties);
              */
                System.out.println("body："+new String(body));
                System.out.println("将日志信息存储到数据库.....");
            }
        };
        channel.basicConsume(queue2Name,true,consumer);


        //消费者不要关闭资源
    }
}
