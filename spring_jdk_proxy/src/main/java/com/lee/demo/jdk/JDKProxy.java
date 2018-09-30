package com.lee.demo.jdk;

import com.lee.demo.tx.TranscationManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//@Component
public class JDKProxy implements InvocationHandler {


    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }


    //
    //    private Object target;
    //
    //    public void setTarget(Object target) {
    //        this.target = target;
    //    }

    private TranscationManager tx;

    public void setTx(TranscationManager tx) {
        this.tx = tx;
    }

    /**
     * 创建代理对象
     *
     * @return
     */
    public <T> T getProxyObject() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), //类加载器

                target.getClass().getInterfaces(), //被代理对象的接口，代理对象会实现这个接口

                this);//如何做增强
    }


    /**
     * 执行增强的方法
     *
     * @param proxy  jvm创建的代理对象
     * @param method 对哪一个方法做增强，也就是真实对象中的方法
     * @param args   真实对象的方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        Object obj = null;
        try {
            tx.begin();
            obj = method.invoke(target, args);
            tx.commot();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return obj;
    }
}
