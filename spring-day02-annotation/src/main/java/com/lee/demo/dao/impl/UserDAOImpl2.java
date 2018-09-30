package com.lee.demo.dao.impl;

import com.lee.demo.dao.IUserDAO;
import org.springframework.stereotype.Repository;

@Repository(value = "userDAO1")
public class UserDAOImpl2 implements IUserDAO {

    public void testDI() {
        System.out.println("调用成功。。。UserDAOImpl------2");

    }
}
