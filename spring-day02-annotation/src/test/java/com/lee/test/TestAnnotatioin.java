package com.lee.test;

import com.lee.demo.config.ImportConfig;
import com.lee.demo.config.Myconfig;
import com.lee.demo.service.IAnnotation;
import com.lee.demo.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotatioin {

    /*
     * spinrg 5 的新注解
     *
     *    @Configuration : 声明一个配置类，替换xml配置文件。
     *
     *    @ComponentScan ： 会自动扫描包路径下面的所有@Controller、@Service、@Repository、@Component等的类
     *                      相当于<context:component-scan base-package="" />
     *
     *    @bean ：用来初始化一个bean对象，详单与<bean/>标签，并且放到sprig容器中。
     *
     *    @Import :导入其他配置类
     *
          @PropertySource :
      *
      *
      *    这些方法将会被AnnotationConfigApplicationContext
      *      或AnnotationConfigWebApplicationContext类进行扫描，
      *       并用于构建bean定义，初始化Spring容器。
     *
     */
    @Test
    public void demo() {
        //可不加@Configuration
//        ApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class, ImportConfig.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
        IAnnotation annotation = (IAnnotation) context.getBean("iannotation");
//        Object test = context.getBean("test");
//        System.out.println(test + "=test......");
        System.out.println(annotation + "++---------------------");

        //------------------------------------------
        IUserService service = (IUserService) context.getBean("userService");
        System.out.println(service + "fasdf adsf afd");
    }

}
