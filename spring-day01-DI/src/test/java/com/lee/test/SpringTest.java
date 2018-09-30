package com.lee.test;

import com.lee.demo.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService1 = (IUserService) context1.getBean("userService");
        userService1.testDI();
        System.out.println("userService=" + userService1);
        //-----------------------------------------------
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = (IUserService) context.getBean("serviceImpl2");
        userService.toString();
        System.out.println("userService=" + userService);
    }
}
