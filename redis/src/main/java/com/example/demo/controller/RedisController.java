package com.example.demo.controller;

import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by EDZ on 2018/10/17.
 */
@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;



    /**
     stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
     stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
     stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
     stringRedisTemplate.boundValueOps("test").increment(1);//val +1
     stringRedisTemplate.getExpire("test")//根据key获取过期时间
     stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
     stringRedisTemplate.delete("test");//根据key删除缓存
     stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
     stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
     stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
     stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
     stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合


     stringRedisTemplate.opsForValue();//操作字符串
     stringRedisTemplate.opsForHash();//操作hash
     stringRedisTemplate.opsForList();//操作list
     stringRedisTemplate.opsForSet();//操作set
     stringRedisTemplate.opsForZSet();//操作有序set

     当你的redis数据库里面本来存的是字符串数据或者你要存取的数据就是字符串类型数据的时候，那么你就使用StringRedisTemplate即可，
     但是如果你的数据是复杂的对象类型，而取出的时候又不想做任何的数据转换，直接从Redis里面取出一个对象，那么使用RedisTemplate是
     更好的选择。
     原文：https://blog.csdn.net/notsaltedfish/article/details/75948281?utm_source=copy

     */
    @GetMapping("/insertRedis")
    public String insertRedis(){

        stringRedisTemplate.opsForValue().set("test","100");
        stringRedisTemplate.opsForValue().set("test1","101");
        stringRedisTemplate.opsForValue().set("test2","102");
        stringRedisTemplate.opsForValue().set("test3","103");
        stringRedisTemplate.opsForValue().set("test4","104");
        return  null;
    }
    @GetMapping("/getRedis")
    public String getRedis(String str){

        return stringRedisTemplate.opsForValue().get(str);
    }

    @GetMapping("/insertRedisSet")
    public String insertRedisSet(){
        stringRedisTemplate.opsForSet().add("r_123","1","2","3");
        return null;
    }
    @GetMapping("/getRedisSet")
    public String getRedisSet(String str){

             Set<String> set = stringRedisTemplate.opsForSet().members(str);
        return  set.toString();

    }

    @GetMapping("/insertRedisPerson")
    public String insertRedisPerson(){
        Person person = new Person();
        person.setIdNo("就是这么拽");
        person.setUserName("小邋遢");
        person.setAge(18);

        redisTemplate.opsForValue().set(person.getIdNo(),person);

        return null;

    }
    @GetMapping("/getRedisPerson")
    public String getRedisPerson(String idNo){

       Person person = (Person) redisTemplate.opsForValue().get(idNo);

        return person.toString();

    }







}
