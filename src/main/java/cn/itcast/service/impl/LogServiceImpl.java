package cn.itcast.service.impl;

import cn.itcast.dao.LogDao;
import cn.itcast.domain.Log;
import cn.itcast.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 15:25
 **/
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void insert(Log log) {
        logDao.insert(log);
    }
}
