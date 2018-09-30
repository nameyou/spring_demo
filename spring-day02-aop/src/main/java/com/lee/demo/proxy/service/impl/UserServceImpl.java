package com.lee.demo.proxy.service.impl;

import com.lee.demo.proxy.dao.UserDAO;
import com.lee.demo.proxy.dao.impl.UserDAOImpl;
import com.lee.demo.proxy.service.UserService;

public class UserServceImpl implements UserService {

    //    @Autowired
    private UserDAO userDAO = new UserDAOImpl();

    public void save() {
        userDAO.save();
        int i = 1 / 0;
    }
}
