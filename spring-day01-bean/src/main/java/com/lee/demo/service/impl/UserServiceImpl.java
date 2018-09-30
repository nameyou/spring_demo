package com.lee.demo.service.impl;

import com.lee.demo.service.IUserService;

public class UserServiceImpl implements IUserService {


    public UserServiceImpl() {
      //  System.out.println("对象创建了。。。。。。");
    }


    public void init() {
        System.out.println("对象创建了。。。。");
    }

    public void destory() {
        System.out.println("对象销毁了。。。。");
    }
}
