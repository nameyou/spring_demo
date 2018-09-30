package com.lee.test;

import com.lee.demo.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpirngTest {


    /**
     * 测试Spring常州注解
     */
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = context.getBean("userService", IUserService.class);
        userService.testDI();
    }

}
