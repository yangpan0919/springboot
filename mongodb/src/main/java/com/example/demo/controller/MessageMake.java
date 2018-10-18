package com.example.demo.controller;

import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EDZ on 2018/10/17.
 */
@RestController
public class MessageMake {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/insertMongo")
    public Person getSomeMessage(){
        Person person = new Person();
        person.setIdNo("340825199309182618");
        person.setUserName("yangpan");
        person.setAge(18);

        mongoTemplate.insert(person);
        return person;
    }

    @GetMapping("/mongo")
    public Person getPerson(String idNo){

        Query query = new Query(Criteria.where("idNo").is(idNo));

        return   mongoTemplate.findOne(query, Person.class);

    }
}
