package com.lee.demo.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.ThrowsAdvice;

/**
 * 事务管理器
 */
public class TranscationManger {

    public void begin() {
        System.out.println("开启事务。。。");
    }

    public void commit() {
        System.out.println("提交事务。。。");
    }

    public void rollback(Throwable ex) {
        System.out.println("回滚事务。。。。"+ex.getMessage());
    }

    public void close() {
        System.out.println("释放资源。。。。");
    }


    /**
     * @param pjp 可以继续向下传递的切入点
     * @return 必须要有一个返回值 object
     */
    public Object round(ProceedingJoinPoint pjp) {
        Object obj = null;
        try {
            System.out.println("开启事务。。。");
            //目标方法
            obj = pjp.proceed(); //执行目标方法  目标方法有返回  返回值 object

            System.out.println(pjp.getKind()); //method-execution
            System.out.println(pjp.getArgs());//[Ljava.lang.Object;@7e928e2f
            System.out.println(pjp.getSignature().getName());//transfer
            System.out.println(pjp.getSignature().getDeclaringTypeName());
            //void com.lee.demo.service.AccountService.transfer()
            //interface com.lee.demo.service.AccountService
            System.out.println(pjp.getTarget());//com.lee.demo.service.impl.AccountServiceImpl@45efc20d

            System.out.println("提交事务。。。");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
//            System.out.println(throwable);
            System.out.println("回滚事务。。。。");
        } finally {
            System.out.println("释放资源。。。。");
        }
        return obj;
    }
}
