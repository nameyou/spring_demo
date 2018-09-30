package com.lee.demo.service.impl;

import com.lee.demo.dao.IUserDAO;
import com.lee.demo.dao.impl.UserDAOImpl;
import com.lee.demo.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements IUserService {

    UserDAOImpl userDAO = new UserDAOImpl();

    public UserServiceImpl() {
        System.out.println("对象创建了。。。。。。");
    }


    /**
     * 保存用户
     */
    public void save() {
        userDAO.save();
    }
}
