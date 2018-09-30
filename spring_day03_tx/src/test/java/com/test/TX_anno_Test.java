package com.test;

import com.lee.demo.tx_xml.domain.Account;
import com.lee.demo.tx_xml.service.AccountService;
import com.lee.demo.tx_xml.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean_anno_trans.xml")
public class TX_anno_Test {


    @Autowired
    private AccountService accountService;

    @Test
    public void testTrans() {
        accountService.trans("张三", "李四", 100);
    }

    @Test
    public void testList() {
        ArrayList<String> list = new ArrayList<String>();
//        list.add(new Account());
    }


}
