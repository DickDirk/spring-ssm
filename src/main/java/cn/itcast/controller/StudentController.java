package cn.itcast.controller;

import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: spring_shizhan
 * @description
 * @author: liumengke
 * @create: 2019-07-14 10:52
 **/
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(Integer currentPage, Integer pageSize) {
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 3;
        }
        ModelAndView modelAndView = new ModelAndView();
        PageInfo pageInfo = studentService.findAll(currentPage, pageSize);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("list");

        return modelAndView;

    }

    @RequestMapping("/add")
    public String add(Student student) {
        studentService.add(student);
       // System.out.println("sdfsd");
        return "redirect:/student/findAll.do";
    }

    @RequestMapping("/findOne")
    public String findOne(Integer id, Model model) {
        Student student = studentService.findOne(id);
        model.addAttribute("stu",student);

        return "update";
    }

    @RequestMapping("/update")
    public String update(Student student) {
        studentService.update(student);
        System.out.println(student);
        return "redirect:/student/findAll.do";
    }
    @RequestMapping("/updateBefore")
    public String updateBefore(Integer id,Model model) {
        Student student = studentService.updateBefore(id);
        model.addAttribute("student",student);
        System.out.println(student);
        return "update";
    }
    @RequestMapping("/delOne")
    public String delOne(Integer id) {
        studentService.delOne(id);
        return "redirect:/student/findAll.do";
    }

    @RequestMapping("/del")
    public String del(Integer[] ids) {
        studentService.del(ids);
        return "redirect:/student/findAll.do";
    }

}
