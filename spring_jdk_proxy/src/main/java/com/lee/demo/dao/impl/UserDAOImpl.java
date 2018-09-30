package com.lee.demo.dao.impl;

import com.lee.demo.dao.UserDAO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository
public class UserDAOImpl implements UserDAO {
    public void test() {
        System.out.println("测试jdk——proxy");
    }
}
