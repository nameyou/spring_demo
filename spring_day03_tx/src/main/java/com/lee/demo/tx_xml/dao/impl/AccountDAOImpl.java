package com.lee.demo.tx_xml.dao.impl;

import com.lee.demo.tx_xml.dao.AccountDAO;
import com.lee.demo.tx_xml.domain.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
        List<Account> accountList = jdbcTemplate.query("select * from account", new RowMapper<Account>() {
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setMoney(rs.getInt("money"));
                return account;
            }
        });
        return accountList;
    }

    public Account findOne(Integer id) {
        return jdbcTemplate.queryForObject("select * from account where id=?", new Object[]{id}, new RowMapper<Account>() {

            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setMoney(rs.getInt("money"));
                account.setName(rs.getString("name"));
                return account;
            }
        });
    }

    /**
     * 转出账户
     *
     * @param name
     * @param money
     */
    public void transOut(String name, Integer money) {
        jdbcTemplate.update("UPDATE account SET name=?,money=money-? WHERE name=?", name, money, name);
    }

    /**
     * 转入账户
     *
     * @param name
     * @param money
     */
    public void transIn(String name, Integer money) {
        jdbcTemplate.update("UPDATE account SET name=?,money=money+? WHERE name=?", name, money, name);
    }

}
