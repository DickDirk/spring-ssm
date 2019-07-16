package cn.itcast.aspect;

import cn.itcast.domain.Log;
import cn.itcast.domain.User;
import cn.itcast.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 13:43
 **/
@Controller
@Aspect
@EnableAspectJAutoProxy
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LogService logService;

    @Around("execution(* cn.itcast.controller.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Date star = new Date();
        //调用目标方法
        Object proceed = pjp.proceed();
        //执行方法花费的时间
        long cost = new Date().getTime() - star.getTime();
        //获取执行类名
        String className = pjp.getTarget().getClass().getName();
        //获取执行的方法名
        String methodName = pjp.getSignature().getName();
        User user = (User) request.getSession().getAttribute("login");
        String username = "";
        //判断
        if (user != null) {
            username = user.getName();
        }else {
            username = request.getParameter("name")+"登陆失败";
        }
        //设置参数
        Log log = new Log();
        log.setUrl("类名"+className+"方法名"+methodName);
        log.setName(username);
        log.setCost(cost);
        log.setTime(new Date());
        logService.insert(log);
        return proceed;
    }
}
