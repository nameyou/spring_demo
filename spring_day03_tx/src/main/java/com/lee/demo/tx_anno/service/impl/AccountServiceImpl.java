package com.lee.demo.tx_anno.service.impl;

import com.lee.demo.tx_xml.dao.AccountDAO;
import com.lee.demo.tx_xml.domain.Account;
import com.lee.demo.tx_xml.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//配置事务
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public void save(Account account) {
        accountDAO.save(account);
    }

    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    //配置只读事务
    @Transactional(readOnly = true)
    public Account findOne(Integer id) {
        return accountDAO.findOne(id);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    public void delete(Integer id) {

    }

    public void trans(String OutName, String InName, Integer money) {
        accountDAO.transOut(OutName, money);
        //模拟异常
//        int i = 1 / 0;
        accountDAO.transIn(InName, money);
    }
}
