package com.laobuzhang;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.flushDB();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","laobuzhang");

        //开启事务
        Transaction multi=jedis.multi();
        String result=jsonObject.toJSONString();

        //jedis.watch(result);//乐观锁


        try {
            multi.set("user1",result);
            multi.set("user2",result);
            //int i=1/0;   //模拟异常
            multi.exec();
        } catch (Exception e) {
            multi.discard();//放弃事务
            throw new RuntimeException(e);
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();//关闭连接
        }


    }
}
