package com.lee.demo.tx_anno.dao;


import com.lee.demo.tx_xml.domain.Account;

import java.util.List;

public interface AccountDAO {

    public void save(Account account);

    public List<Account> findAll();

    public Account findOne(Integer id);

    public void updateAccount(Account account);

    public void delete(Integer id);

    /**
     * 转出资金
     *
     * @param name
     * @param money
     */
    public void transOut(String name, Integer money);

    /**
     * 转入金额
     *
     * @param name
     * @param money
     */
    public void transIn(String name, Integer money);

}
