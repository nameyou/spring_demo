package com.lee.demo.proxy.dao.impl;

import com.lee.demo.proxy.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
    public void save() {
        System.out.println("保存用户。。。。");
    }
}
