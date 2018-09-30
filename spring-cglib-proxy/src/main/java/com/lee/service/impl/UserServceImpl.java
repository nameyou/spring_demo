package com.lee.service.impl;

import com.lee.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.lee.service.UserService;


public class UserServceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void test() {
        userDAO.test();
//        int i = 1 / 0;
    }
}
