package com.lee.test;

import com.lee.demo.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
////        1.加载bean.xml 配置文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext context1 = new FileSystemXmlApplicationContext("F:\\Project\\Lee\\spring-day01-ioc-di\\src\\main\\resources\\bean.xml");
////        根据id获取bean对象
//        IUserService userService = (IUserService) context.getBean("userService");
////        3.打印
//        System.out.println("userServie=" + userService);

        //==============华丽分割线    生命周期====================
//        单利
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = (IUserService) context.getBean("userService");
        System.out.println("userServie=" + userService);
        context.close();

//        //多例
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        IUserService userService = (IUserService) context.getBean("userService");
//        System.out.println("userServie=" + userService);
//        context.close();

    }
}
