package com.example.demo.test;

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by Administrator on 2019/3/23.
 */
public class Test {
    public static void main(String[] args){
        Jedis jedis = new Jedis("39.104.206.97",6379);
        Set<String> keys = jedis.keys("*");
        for(Iterator iterator = keys.iterator();iterator.hasNext();){
            String key = (String) iterator.next();
            System.out.println(key);
        }
        System.out.println("jedis.exists====>"+jedis.exists("k2")); //key  为k2 的值是否存在

        System.out.println(jedis.ttl("k1"));   //key 为 k1  的有效时间
//String
        //jedis.append("k1","myreids");
        System.out.println(jedis.get("k1"));
        jedis.set("k4","k4_redis");
        System.out.println("----------------------------------------");
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1","str2","str3"));
        //list
        System.out.println("----------------------------------------");
        jedis.lpush("mylist","v1","v2","v3","v4","v5");
        List<String> list = jedis.lrange("mylist",0,-1);  //范围查询，-1查询所有
        for(String element : list) {
           System.out.println(element);
          }

        //set
        jedis.sadd("redis_set","set001");
        jedis.sadd("redis_set","set002");
        jedis.sadd("redis_set","set003");
        jedis.sadd("orders","jd001");
        jedis.sadd("orders","jd002");
        jedis.sadd("orders","jd003");
        Set<String> set1 = jedis.smembers("redis_set");
        for(Iterator iterator = set1.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
            }
        jedis.srem("orders","jd002");
        System.out.println(jedis.smembers("orders").size());
       //hash
        jedis.hset("hash1","userName","lisi");
        System.out.println(jedis.hget("hash1","userName"));
        Map<String,String> map = new HashMap<String,String> ();
        map.put("telphone","13811814763");
        map.put("address","atguigu");
        map.put("email","abc@163.com");
        jedis.hmset("hash2",map);
        List<String> result = jedis.hmget("hash2","telphone","email");
        for(String element : result) {
            System.out.println(element);
            }
        //zset
        jedis.zadd("zset01",60d,"v1");
        jedis.zadd("zset01",70d,"v2");
        jedis.zadd("zset01",80d,"v3");
        jedis.zadd("zset01",90d,"v4");

        Set<String> s1 = jedis.zrange("zset01",0,-1);
        for(Iterator iterator = s1.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
            }
        /*   //key
             Set<String> keys = jedis.keys("*");
             for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
                   String key = (String) iterator.next();
                   System.out.println(key);
                 }
             System.out.println("jedis.exists====>"+jedis.exists("k2"));
             System.out.println(jedis.ttl("k1"));
             //String
             //jedis.append("k1","myreids");
             System.out.println(jedis.get("k1"));
             jedis.set("k4","k4_redis");
             System.out.println("----------------------------------------");
             jedis.mset("str1","v1","str2","v2","str3","v3");
             System.out.println(jedis.mget("str1","str2","str3"));
             //list
             System.out.println("----------------------------------------");
             //jedis.lpush("mylist","v1","v2","v3","v4","v5");
             List<String> list = jedis.lrange("mylist",0,-1);
             for (String element : list) {
                   System.out.println(element);
                 }
             //set
             jedis.sadd("orders","jd001");
             jedis.sadd("orders","jd002");
             jedis.sadd("orders","jd003");
             Set<String> set1 = jedis.smembers("orders");
             for (Iterator iterator = set1.iterator(); iterator.hasNext();) {
                   String string = (String) iterator.next();
                   System.out.println(string);
                 }
             jedis.srem("orders","jd002");
             System.out.println(jedis.smembers("orders").size());
             //hash
             jedis.hset("hash1","userName","lisi");
             System.out.println(jedis.hget("hash1","userName"));
             Map<String,String> map = new HashMap<String,String>();
             map.put("telphone","13811814763");
             map.put("address","atguigu");
             map.put("email","abc@163.com");
             jedis.hmset("hash2",map);
             List<String> result = jedis.hmget("hash2", "telphone","email");
             for (String element : result) {
                   System.out.println(element);
                 }
             //zset
             jedis.zadd("zset01",60d,"v1");
             jedis.zadd("zset01",70d,"v2");
             jedis.zadd("zset01",80d,"v3");
             jedis.zadd("zset01",90d,"v4");
             
             Set<String> s1 = jedis.zrange("zset01",0,-1);
             for (Iterator iterator = s1.iterator(); iterator.hasNext();) {
                   String string = (String) iterator.next();
                   System.out.println(string);
                 }
*/


    }

}
