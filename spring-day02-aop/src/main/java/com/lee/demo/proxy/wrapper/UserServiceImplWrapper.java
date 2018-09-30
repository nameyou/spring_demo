package com.lee.demo.proxy.wrapper;

import com.lee.demo.proxy.service.UserService;
import com.lee.demo.proxy.service.impl.UserServceImpl;
import com.lee.demo.proxy.tx.TranscationManger;

/**
 * UserServiceImpl的包装类
 * <p>
 * 1.要和被包装类 （UserServiceImpl)有相同的接口      装饰对象和真实对象有相同的接口
 * <p>
 * 2.要有一个真实对象的引用
 */
public class UserServiceImplWrapper implements UserService {

    //要增强处理事务
    private TranscationManger tx;

    //真实对象的引用    被包装的真实对象对象
    private UserServceImpl target;


    //创建包装对象的时候把 被包装的对象传递过来，以及要增强的对象
    public UserServiceImplWrapper(TranscationManger tx, UserServceImpl target) {
        this.tx = tx;
        this.target = target;
    }

    public void save() {
        try {
            //开启事务
            tx.begin();
            //执行保存
            target.save();

            //提交事务
            tx.commit();
        } catch (Exception e) {
            //回滚事务
            tx.callback();
            e.printStackTrace();
        }
    }
}
