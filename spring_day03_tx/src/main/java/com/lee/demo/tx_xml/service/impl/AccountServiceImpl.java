package com.lee.demo.tx_xml.service.impl;


import com.lee.demo.tx_xml.dao.AccountDAO;
import com.lee.demo.tx_xml.domain.Account;
import com.lee.demo.tx_xml.service.AccountService;

import java.util.ArrayList;
import java.util.List;


public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void save(Account account) {
        accountDAO.save(account);
    }

    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    public Account findOne(Integer id) {
        return accountDAO.findOne(id);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    public  void delete(Integer id) {

    }

    public void trans(String OutName, String InName, Integer money) {
        accountDAO.transOut(OutName, money);
        //模拟异常
//        int i = 1 / 0;
        accountDAO.transIn(InName, money);
    }

    public static void demo(){
        ArrayList list =new ArrayList();

    }

}
