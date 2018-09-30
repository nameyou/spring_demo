package com.lee.test;


import com.lee.demo.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AOP_Test {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAOP(){
        //class com.sun.proxy.$Proxy21
        System.out.println(accountService.getClass());
        accountService.transfer();
    }
}
