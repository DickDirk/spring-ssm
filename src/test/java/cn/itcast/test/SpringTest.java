package cn.itcast.test;


import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 09:20
 **/
public class SpringTest {
    /**
     * dao测试查询所有
     */
    @Test
    public void test(){
        ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = apps.getBean(StudentDao.class);
        List<Student> studentList = studentDao.findAll();
        for (Student student : studentList) {

            System.out.println(student);
        }
    }

    /**
     * dao测试添加
     */
    @Test
    public void test2(){
        ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = apps.getBean(StudentDao.class);
        Student ss = new Student();
        ss.setName("小花");
        ss.setAge(5);
        ss.setSex(0);
        ss.setAddress("河南");
        studentDao.add(ss);
    }
    /**
     * dao测试删除
     */
    @Test
    public void test3(){
        ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = apps.getBean(StudentDao.class);
        studentDao.delOne(11);
    }

    /**
     * 查找一个
     */
    @Test
    public void test4(){
        ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = apps.getBean(StudentDao.class);
        Student student = studentDao.findOne(1);
        System.out.println(student);
    }

    /**
     * 测试修改
     */
    @Test
    public void test5(){
        ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = apps.getBean(StudentDao.class);
        Student one = studentDao.findOne(1);
        one.setName("刘梦柯");
        one.setSex(0);
        one.setAge(24);
        one.setAddress("禹州");
        studentDao.update(one);
    }

}
