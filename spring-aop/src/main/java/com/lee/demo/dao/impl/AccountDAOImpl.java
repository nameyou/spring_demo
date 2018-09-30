package com.lee.demo.dao.impl;

import com.lee.demo.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class AccountDAOImpl implements AccountDAO {

    public void transfer() {
        System.out.println("转账成功===================");
        int i=1/0;
    }
}
