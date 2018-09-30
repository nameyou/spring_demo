package com.lee.test;

import com.lee.demo.domain.Account;
import com.lee.demo.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class JdbcTemplateTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("张三");
        account.setMoney(100);
        accountService.save(account);
        System.out.println("保存成功。。。。");
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setName("王五");
        account.setMoney(200);
        account.setId(2);
        accountService.updateAccount(account);
        System.out.println("更新成功。。。。");
    }

    @Test
    public void testFindOne() {
        Account account = accountService.findOne(2);
        System.out.println(account);
    }


}
