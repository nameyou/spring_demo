import com.lee.cglib.CGLIB_Proxy;
import com.lee.cglib.DD;
import com.lee.dao.UserDAO;
import com.lee.service.UserService;
import com.lee.tx.TranscationManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContent.xml")
public class CGLIBProxyTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;


    @Autowired
    private TranscationManager tx;

    @Autowired
    private CGLIB_Proxy cglibProxy;

    @Autowired
    private DD dd;
    @Test
    public void test() {
        Object object = new Object();
        System.out.println(object.getClass());
        System.out.println(userDAO.getClass().getSuperclass());
        System.out.println(userService.getClass().getClass().getClass());
    }

    @Test
    public void testCGLIB() {
        UserService proxy = cglibProxy.getProxy();
        System.out.println(proxy.getClass());
        proxy.test();
    }
    @Test
    public void testCGLIB2() {
        UserService proxy = (UserService) dd.getProxy();
        System.out.println(proxy.getClass());
        proxy.test();
    }

}
