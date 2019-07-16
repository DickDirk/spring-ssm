package cn.itcast.test;

import cn.itcast.dao.StudentDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 22:26
 **/
public class UserTest {
    @Test
    public void test(){
        ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = apps.getBean(UserService.class);
        User user = new User();
        user.setName("admin");
        user.setPassword("admin");
        User login = userService.login(user);
       /* User user = new User();
        user.setName("admin");
        user.setPassword("admin");*/
       // User user = userDao.login("admin", "admin");
        System.out.println(login);
    }
}
