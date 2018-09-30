package com.lee.demo.dao.impl;

import com.lee.demo.dao.AccountDAO;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    public void transfer() {
        System.out.println("转账成功===================");
//        int i=1/0;
    }
}
