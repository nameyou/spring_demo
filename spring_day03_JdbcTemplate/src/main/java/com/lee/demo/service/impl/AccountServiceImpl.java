package com.lee.demo.service.impl;

import com.lee.demo.dao.AccountDAO;
import com.lee.demo.domain.Account;
import com.lee.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    public Account findOne(Integer id) {
        return accountDAO.findOne(id);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    public void delete(Integer id) {

    }
}
