package com.example.demo.bean;


import java.io.Serializable;

/**
 * Created by EDZ on 2018/10/17.
 */

public class Person  implements Serializable{
    private String  idNo;
    private String  userName;
    private int  age;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNo='" + idNo + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
