package com.lee.demo.tx;

import org.springframework.stereotype.Component;

//@Component
public class TranscationManager {

    public void begin() {
        System.out.println("开启事务....");
    }

    public void commot() {
        System.out.println("提交事务....");
    }

    public void rollback() {
        System.out.println("回滚事务....");
    }

}
