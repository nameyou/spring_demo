package com.lee.demo.proxy.jdk_proxy;

import com.lee.demo.proxy.dao.UserDAO;
import com.lee.demo.proxy.tx.TranscationManger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDK_Proxy implements InvocationHandler {

    //真实对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    private TranscationManger tx; //事务管理器

    public void setTx(TranscationManger tx) {
        this.tx = tx;
    }

    /**
     * 创建代理对象
     *
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),// 类加载器
                target.getClass().getInterfaces(),// 被代理类的接口，代理类会实现这个接口
                this); //如果做增强
    }

    /**
     * 如何做增强
     *
     * @param proxy  jvm创建的代理对象
     * @param method 对哪一个方法做增强，也就是真是对象中的方法
     * @param args   被增强方法的实际参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        try {
            //开启事务
            tx.begin();
            //调用真实对象的方法
            obj = method.invoke(target, args);
            //提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            tx.callback();
        }
        return obj;
    }
}
