package cn.itcast.service;

import cn.itcast.domain.User;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 09:29
 **/
public interface UserService {
    User login(User user);
}
