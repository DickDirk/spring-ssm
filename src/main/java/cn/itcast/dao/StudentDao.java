package cn.itcast.dao;

import cn.itcast.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 09:50
 **/
public interface StudentDao {
    @Select("select * from t_student")
    List<Student> findAll();

    @Insert("insert into t_student values(#{id},#{name},#{sex},#{age},#{address})")
    void add(Student student);
    @Select("select * from t_student where id=#{id}")
    Student findOne(Integer id);
    @Update("update t_student set name=#{name},sex=#{sex},age=#{age},address=#{address} where id = #{id}")
    void update(Student student);
    @Delete("delete from t_student where id=#{id}")
    void delOne(Integer id);
    void del(Integer[] ids);
    @Select("select * from t_student where id=#{id}")
    Student updateBefore(Integer id);
}
