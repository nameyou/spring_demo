package com.lee.test;

import com.lee.demo.config.Myconfig;
import com.lee.demo.service.IAnnotation;
import com.lee.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring 5.x 要求junit 4.12以上版本
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "calsspath:bean.xml")
@ContextConfiguration(classes = Myconfig.class)
public class DemoTest {

    @Autowired
    private IAnnotation annotation;

    @Test
    public void demo() {
        annotation.demo();
    }


}
