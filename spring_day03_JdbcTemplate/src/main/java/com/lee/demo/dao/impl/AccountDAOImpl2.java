package com.lee.demo.dao.impl;

import com.lee.demo.dao.AccountDAO;
import com.lee.demo.domain.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

public class AccountDAOImpl2 implements AccountDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void save(Account account) {
        jdbcTemplate.update("INSERT INTO account (name,money) VALUES(?,?)", account.getName(), account.getMoney());
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE account SET name=?,money=? WHERE id=?", account.getName(), account.getMoney(), account.getId());

    }

    public void delete(Integer id) {

    }

    public List<Account> findAll() {
        return null;
    }

    public Account findOne(Integer id) {
        return null;
    }

}
