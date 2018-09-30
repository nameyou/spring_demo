package com.lee.test;


import com.lee.demo.dao.UserDAO;
import com.lee.demo.jdk.JDKProxy;
import com.lee.demo.service.UserService;
import com.lee.demo.tx.TranscationManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContent.xml")
public class JDKProxyTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;


    @Autowired
    private TranscationManager tx;

    @Autowired
    private JDKProxy proxy;


    @Test
    public void test() {
        Object object = new Object();
        System.out.println(object.getClass());
        System.out.println(userDAO.getClass().getSuperclass());
        System.out.println(userService.getClass().getClass().getClass());
    }

    @Test
    public void testJDK() {
        UserService userServce = proxy.getProxyObject();
        System.out.println("jdjjd=" + userService.getClass());
        userService.test();
    }

}
