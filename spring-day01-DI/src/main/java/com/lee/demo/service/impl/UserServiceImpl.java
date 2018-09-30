package com.lee.demo.service.impl;

import com.lee.demo.service.IUserService;

import java.util.Date;

public class UserServiceImpl implements IUserService {


    private String name;
    private Integer age;
    private Date time;

    public UserServiceImpl() {
    }

    public UserServiceImpl(String name, Integer age, Date time) {
        this.name = name;
        this.age = age;
        this.time = time;
    }

    public void init() {
        System.out.println("对象创建了。。。。");
    }

    public void destory() {
        System.out.println("对象销毁了。。。。");
    }

    public void testDI() {
        System.out.println("name=" + name + ",age=" + age + ",time=" + time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
