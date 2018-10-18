package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by EDZ on 2018/10/18.
 */
@Service
public class TicketService {


    public String getTicket(){
        System.out.println("8001");
        return  "《厉害了，我的小姐姐》";
    }

}
