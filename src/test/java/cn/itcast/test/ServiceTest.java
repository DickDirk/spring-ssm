package cn.itcast.test;

import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 13:50
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceTest {
    @Autowired
    private StudentService studentService;

    /**
     * 测试查找
     */
    @Test
    public void test(){
        PageInfo<Student> all = studentService.findAll(1, 3);
        for (Student student : all.getList()) {
            System.out.println(student);
            
        }

    }

    /**
     * 测试添加
     */
    @Test
    public void test1(){
  /*      Student ss = new Student();
        ss.setName("zsf");
        ss.setAge(19);
        ss.setSex(0);
        ss.setAddress("河南");
      studentService.add(ss);*/
        Student one = studentService.findOne(1);
        one.setName("林青霞");
        one.setSex(1);
        one.setAge(24);
        one.setAddress("香港");
        studentService.update(one);

    }

}
