package cn.itcast.controller;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-15 09:37
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User login = userService.login(user);
       // System.out.println("aaa");
        if (login != null){
            session.setAttribute("login",login);
           // System.out.println(session.getAttribute("login"));
            return "redirect:/student/findAll.do";
        }else {
            session.setAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
}
