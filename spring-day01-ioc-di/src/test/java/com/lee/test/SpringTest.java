package com.lee.test;

import com.lee.demo.dao.IUserDAO;
import com.lee.demo.service.IUserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class SpringTest {

    /**
     * Spring的IOC
     *
     * @param args
     */
//       ApplicaitonContext:
//             ClasspathXmlApplicationContext : 从类的根路径加载配置文件
//             FileSystemXmlApplicationContext: 从磁盘路径加载配置文件
//             AnnotationApplicationContext:


//================Spring容器创建对象的时机================================

//    ApplicationContext:
//             立即加载的策略，当Spring容器开始构建的时候，就开始创建对象，
//    BeanFactory:
//             采用延迟加载的策略，当使用到对象的时候才开始创建对象。
    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
        //1.加载bean.xml 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext context1 = new FileSystemXmlApplicationContext("F:\\Project\\Lee\\spring-day01-ioc-di\\src\\main\\resources\\bean.xml");
        //根据id获取bean对象
        IUserService userService = (IUserService) context.getBean("userService");
        IUserDAO userDAO = (IUserDAO) context.getBean("userDAO");
        //3.打印
        System.out.println("userDAO=" + userDAO);
        System.out.println("userServie=" + userService);
        userService.save();

        //-------------华丽分割线--------------------

        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        for (int i = 0; i <= 5; i++) {
            IUserService service = (IUserService) beanFactory.getBean("userService");
            System.out.println("service=" + service);
        }
    }
}
