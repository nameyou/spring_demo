package com.lee.test.demo;


import com.lee.demo.proxy.service.UserService;
import com.lee.demo.proxy.service.impl.UserServceImpl;
import com.lee.demo.proxy.static_proxy.UserServiceImplProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class Test_proxy_static {

    /**
     * 没有增强的时候
     */
    @Test
    public void testSave() {
        UserService userService = new UserServceImpl();
        userService.save();
    }

    /**
     * 测试增强 事务
     */
    @Test
    public void testWrapper() {
        UserService proxy = new UserServiceImplProxy();
        proxy.save();
    }


}
