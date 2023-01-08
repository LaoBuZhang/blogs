package cn.itcast.mq.sping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //普通队列
    @Test
    public void testSendMessage2SimpleQueue(){
        String queueName="simple.queue";
        String message="hello, spring amqp!";
        rabbitTemplate.convertAndSend(queueName,message);
    }


    @Test
    public void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName="work.queue";
        String message="hello, spring amqp__";
        for(int i=1;i<=50;i++){
            rabbitTemplate.convertAndSend(queueName,message+i);
            Thread.sleep(20);
        }
    }


    @Test
    public void testSendFanoutExahcnge(){
        String exchangeName="itcast.fanout";
        String message="hello,everyone!";
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }


    @Test
    public void testSendDirectExahcnge(){
        String exchangeName="itcast.direct";
        String message="hello,blue!";
        rabbitTemplate.convertAndSend(exchangeName,"blue",message);
    }


    @Test
    public void testSendTopicExahcnge(){
        String exchangeName="itcast.topic";
        String message="放开了，我能够更多得见你了!";
        rabbitTemplate.convertAndSend(exchangeName,"china.news",message);
    }



    @Test
    public void testSendObjectExahcnge(){
        Map<String,Object> msg=new HashMap<>();
        msg.put("name","xhc");
        msg.put("age",19);
        rabbitTemplate.convertAndSend("object.queue",msg);
    }
}
