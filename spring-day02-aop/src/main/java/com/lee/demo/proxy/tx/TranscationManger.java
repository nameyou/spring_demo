package com.lee.demo.proxy.tx;

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

    public void callback() {
        System.out.println("回滚事务。。。。");
    }

}
