package com.lee.demo.config;

import com.lee.demo.service.IAnnotation;
import org.springframework.context.annotation.*;

@Configuration
//@Import(ImportConfig.class)//导入其他配置类
//@ComponentScan(value = "com.lee.demo")
//@PropertySource("calsspath:/properties/db.properties")//
public class Myconfig {

    @Bean
    public IAnnotation iannotation() {
        return new AnnotationServiceImple();
    }


}
