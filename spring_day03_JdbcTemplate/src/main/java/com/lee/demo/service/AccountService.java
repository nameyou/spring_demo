package com.lee.demo.service;

import com.lee.demo.domain.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();

    public Account findOne(Integer id);

    public void updateAccount(Account account);

    public void delete(Integer id);
}
