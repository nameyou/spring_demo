package com.lee.demo.proxy.static_proxy;

import com.lee.demo.proxy.service.UserService;
import com.lee.demo.proxy.service.impl.UserServceImpl;
import com.lee.demo.proxy.tx.TranscationManger;

/**
 * 静态代理
 * 程序运行前就已经存在 代理类的字节码文件，代理对象和真实对象的关系一开始就确定了
 */
public class UserServiceImplProxy implements UserService {
    //要增强处理事务
    private TranscationManger tx = new TranscationManger();
    //真实对象
    private UserService target = new UserServceImpl();


    public void save() {
        try {
            //开启事务
            tx.begin();
            //保存
            target.save();
            //提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            tx.callback();
        }
    }
}
