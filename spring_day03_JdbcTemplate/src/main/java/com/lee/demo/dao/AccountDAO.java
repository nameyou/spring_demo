package com.lee.demo.dao;

import com.lee.demo.domain.Account;

import java.util.List;

public interface AccountDAO {

    public void save(Account account);

    public List<Account> findAll();

    public Account findOne(Integer id);

    public void updateAccount(Account account);

    public void delete(Integer id);
}
