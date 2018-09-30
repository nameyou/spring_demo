package com.lee.test.demo;


import com.lee.demo.proxy.service.UserService;
import com.lee.demo.proxy.service.impl.UserServceImpl;
import com.lee.demo.proxy.tx.TranscationManger;
import com.lee.demo.proxy.wrapper.UserServiceImplWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class Test_wrapper {

    @Autowired
    private UserService userService;

    /**
     * 没有增强的时候
     */
    @Test
    public void testSave() {
        userService = new UserServceImpl();
        userService.save();
    }

    /**
     * 测试增强 事务
     */
    @Test
    public void testWrapper() {
        UserServiceImplWrapper wrapper = new UserServiceImplWrapper(new TranscationManger(),new UserServceImpl());
        wrapper.save();
    }


}
