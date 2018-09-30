package com.lee.cglib;

import com.lee.service.UserService;
import com.lee.tx.TranscationManager;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIB_Proxy {

    private UserService target;
    private TranscationManager tx;

    public void setTarget(UserService target) {
        this.target = target;
    }

    public void setTx(TranscationManager tx) {
        this.tx = tx;
    }

    public <T> T getProxy(){

      return (T) Enhancer.create(UserService.class, new MethodInterceptor() {

          /**
           *
           * @param proxy  代理对象
           * @param method 被代理对象的方法
           * @param args   被代理对象的方法参数
           * @param methodProxy   当前执行方法的代理对象
           * @return
           * @throws Throwable
           */
          public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        });
    }



}
