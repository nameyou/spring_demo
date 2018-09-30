package com.lee.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ImportConfig {

    @Bean
    public Object test() {
        return "导入其他配置类。。。。";
    }

}
