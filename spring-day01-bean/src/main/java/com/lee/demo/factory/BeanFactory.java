package com.lee.demo.factory;

import com.lee.demo.service.IUserService;
import com.lee.demo.service.impl.UserServiceImpl;

/**
 * 模拟工厂类
 */
public class BeanFactory {

    public IUserService getUserService() {
        System.out.println("工厂类方法创建对象。。。。。");
        return new UserServiceImpl();
    }
}
