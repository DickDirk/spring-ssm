package cn.itcast.interceptor;

import cn.itcast.domain.User;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 10:33
 **/
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        User user = (User) request.getSession().getAttribute("login");
        //System.out.println("进入了拦截器"+user);
        if(user == null){
            response.sendRedirect(request.getContextPath() + "/denied.jsp");
            return false;
        }else{
            return true;
        }

    }
}
