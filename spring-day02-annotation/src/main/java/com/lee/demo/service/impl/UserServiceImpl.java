package com.lee.demo.service.impl;

import com.lee.demo.dao.IUserDAO;
import com.lee.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/*

    要使用注解创建创建对象：
              1. 在要创建对象的类上加上标签  @Component  @Controller  @Service @Repository 等
              2. 告诉Spring我们添加注解的类在哪里

 * 创建贴有标签的类，并放到spring容器中默认类名首字母小写
 *  那怎么去容器中找到这个bean呢，
 *  之前我们都是配置 <bean id="" class=""></bean> 我们可以通过id找到
 *  现在我们没有配置<bean/>怎么找到呢
 *  这里 我点进去看下这个注解  有一个默认属性 value  String value() default "";
 *  我没什么都不写的时候，找到这个bean的id 就是默认的类名首字母小写
 *   我们也指定名称
 *
 *      value :
 *          就是默认的类名首字母小写  (默认情况)
 *          如：@Component(value = "userService")
 *
 */
@Component(value = "userService")
//@Scope("singleton")
public class UserServiceImpl implements IUserService {

    /*
           @Autowired：
                  1.  使用@Autowired时，就不可不需要set方法了
                  2.  自动按类型注入，从spring容器中，容器中又唯一的对象类型和要注入的变量类型匹配时，就可以注入成功。
                  3.  如果没有任何bean的类型和要注入的类型匹配时，则注入失败
                  4.  如果有多个匹配的类型时，
                        1. 用在变量上，先根据类型去容器中查找，找到多个，再根据定义的id查找，id就是变量名称
              属性：
                required ：true 表示必须要有一个bean用于注入，没就报错   （默认）
                           false 如果有bean，就注入，没有的话就赋一个null值。

          @Qualifiler :
                    作用：就可以指定根据id来注入
                    但是不可以单独使用，要配合@Autowired一起使用

            @Resource
                ①如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常。

                ②如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常。

                ③如果指定了type，则从上下文中找到类似匹配的唯一bean进行装配，找不到或是找到多个，都会抛出异常。

                ④如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配。

                @Resource的作用相当于@Autowired，只不过@Autowired按照byType自动注入。

            @Value
                注入基本类型，和String类型，通过使用 SpEL表达式 ${值}


     */
    @Autowired
//    @Qualifier("userDAO")
//    @Resource
    private IUserDAO userDAO1;

    @Value("${aa}")
    private String aass;

    public void testDI() {
        userDAO1.testDI();
        this.init();
        this.destroy();
//        System.out.println(aass);
        // userDAO1.testDI();
    }


    //指定初始化方法
    @PostConstruct
    public void init() {
        System.out.println("初始化");
    }

    //指定销毁方法
    @PreDestroy
    public void destroy() {
        System.out.println("初始化");
    }
}
