package com.lee.demo.factory;

import com.lee.demo.service.IUserService;
import com.lee.demo.service.impl.UserServiceImpl;

/**
 * 工厂类中的静态方法创建对象
 */
public class StaticFactory {

    public static IUserService getUserService() {
        System.out.println("工厂中的静态方法创建对象。。。");
        return new UserServiceImpl();
    }
}
