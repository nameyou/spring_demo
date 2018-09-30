package com.lee.demo.tx_anno.service;


import com.lee.demo.tx_xml.domain.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();

    public Account findOne(Integer id);

    public void updateAccount(Account account);

    public void delete(Integer id);

    public void trans(String OutName, String InName, Integer money);
}
