package cn.itcast.service.impl;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 10:12
 **/
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentdao;


    @Override
    public PageInfo findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Student> studentList = studentdao.findAll();
        PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
        return pageInfo;
    }

    @Override
    public void add(Student student) {
        studentdao.add(student);

    }

   @Override
    public Student findOne(Integer id) {

        return studentdao.findOne(id);

    }

    @Override
    public void update(Student student) {

        studentdao.update(student);

    }

    @Override
    public void delOne(Integer id) {
        studentdao.delOne(id);
    }

    /**
     * 删除多条
     * @param ids
     */
    @Override
    public void del(Integer[] ids) {
        for (Integer id : ids) {

           studentdao.delOne(id);

        }
    }

    @Override
    public Student updateBefore(Integer id) {
        return studentdao.updateBefore(id);
    }


}
