import dao.UserDao;
import dao.impl.UserDaoImpl;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by user on 2016/8/24.
 */
public class test {
    @Resource
    private UserDao userDao;
    private UserDaoImpl userDaoImpl;
    @Test
    public void base(){
//        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//        UserDao userDao= (UserDao) context.getBean("userDaoImpl");
        userDaoImpl.save();
    }

}
