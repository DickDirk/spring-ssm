package cn.itcast.service;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 10:12
 **/

public interface StudentService {
   PageInfo findAll(int currentPage,int pageSize);
   void add(Student student);
   Student findOne(Integer id);
   void update(Student student);
   void delOne(Integer id);
   void del(Integer[] ids);
   Student updateBefore(Integer id);
}
