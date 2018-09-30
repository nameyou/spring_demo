package com.lee.demo.dao.impl;

import com.lee.demo.dao.IUserDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userDAO")
public class UserDAOImpl implements IUserDAO {
    public void testDI() {
        System.out.println("调用成功。。。UserDAOImpl-----1");

    }
}
