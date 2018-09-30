package com.lee.cglib;

import com.lee.service.UserService;
import com.lee.tx.TranscationManager;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import javax.swing.*;
import java.lang.reflect.Method;

public class DD {

    UserService target;
    TranscationManager tx;

    public void setTx(TranscationManager tx) {
        this.tx = tx;
    }

    public void setTarget(UserService target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());//设置代理对象的父类为被代理对象，也就是真实对象
        enhancer.setCallback(new InvocationHandler() { //设置增强

            /**
             *
             * @param proxy 代理对象
             * @param method 被代理对象的方法 ，真实对象的方法
             * @param args  真实对象的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o = null;
                try {
                    tx.begin();
                    o = method.invoke(target, args);
                    tx.commot();
                } catch (Exception e) {
                    tx.rollback();
                    e.printStackTrace();
                }
                return o;
            }
        });
        return enhancer.create();
    }

}
