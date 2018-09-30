package com.test;

import com.lee.demo.tx_xml.domain.Account;
import com.lee.demo.tx_xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class JdbcTemplateTest {


    @Autowired
    private AccountService accountService;

    @Test
    public void testList() {
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testfindOne() {
        Account account = accountService.findOne(2);
        System.out.println(account);

    }

    @Test
    public void testTrans() {
        accountService.trans("张三", "李四", 100);
    }

}
