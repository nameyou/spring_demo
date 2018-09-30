package com.lee.demo.jdk;

import com.lee.demo.service.UserService;
import com.lee.demo.service.impl.UserServceImpl;
import com.lee.demo.tx.TranscationManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ddf {


    private Object target;

    private TranscationManager tx;

    public <T> T get() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),//类加载器

                target.getClass().getInterfaces(), //被代理对象的接口，代理对象会实现这个接口

                new InvocationHandler() {//才是如何做增强
                    /**
                     * @param proxy  代理对象
                     * @param method  真实对象的方法，要执行的方法
                     * @param args  真实方法的参数
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = null;
                        try {
                            String test = method.getName();
                            if (test.equals("test")) {
                                tx.begin();
                                obj = method.invoke(target, args);
                                tx.commot();
                            }
                        } catch (Exception e) {
                            tx.rollback();
                            e.printStackTrace();
                        }
                        return obj;
                    }
                });
    }
}
