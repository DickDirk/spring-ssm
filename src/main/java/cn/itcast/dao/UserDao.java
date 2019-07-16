package cn.itcast.dao;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 22:20
 **/
public interface UserDao {

    @Select("select * from t_user where name=#{name} and password=#{password}")
    User login(@Param("name") String name, @Param("password") String password);
}
