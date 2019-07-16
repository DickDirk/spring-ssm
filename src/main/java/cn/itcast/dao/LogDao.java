package cn.itcast.dao;

import cn.itcast.domain.Log;
import org.apache.ibatis.annotations.Insert;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 13:01
 **/
public interface LogDao {
    @Insert("insert into t_log values(#{id},#{name},#{time},#{url},#{cost})")
    void insert(Log log);
}
