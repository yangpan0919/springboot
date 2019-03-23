package com.example.demo.test;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2019/3/23.
 */
public class ReadWriteTest {
    public static void main(String[] args) throws InterruptedException 
              {
             Jedis jedis_M = new Jedis("39.104.206.97",6379);
             Jedis jedis_S = new Jedis("39.104.206.97",6380);
             
             jedis_S.slaveof("39.104.206.97",6379);
             
             jedis_M.set("k6","v6");
             Thread.sleep(500);
             System.out.println(jedis_S.get("k6"));
          }
}
