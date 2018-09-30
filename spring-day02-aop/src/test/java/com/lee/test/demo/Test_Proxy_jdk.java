package com.lee.test.demo;


import com.lee.demo.proxy.jdk_proxy.JDK_Proxy;
import com.lee.demo.proxy.service.UserService;
import com.lee.demo.proxy.service.impl.UserServceImpl;
import com.lee.demo.proxy.static_proxy.UserServiceImplProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class Test_Proxy_jdk {

    @Autowired
    private JDK_Proxy jdk_proxy;

    /**
     * 没有增强的时候
     */
    @Test
    public void testSave() {
        //获取代理对象
        UserService proxy = jdk_proxy.getProxy();
        System.out.println("proxy=" + proxy.getClass());
        proxy.save();

    }
}
