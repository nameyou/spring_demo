package com.lee.demo.service.impl;

import com.lee.demo.dao.UserDAO;
import com.lee.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserServceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void test() {
        userDAO.test();
        int i = 1 / 0;
    }
}
