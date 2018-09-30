package com.lee.demo.service.impl;

import com.lee.demo.dao.AccountDAO;
import com.lee.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public void transfer() {
        accountDAO.transfer();
    }

}
