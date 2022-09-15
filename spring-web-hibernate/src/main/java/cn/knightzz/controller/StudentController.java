package cn.knightzz.controller;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 王天赐
 * @title: StudentController
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 18:24
 */
@Controller
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @RequestMapping("/student")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Student> students = studentDao.findAll();
        mav.addObject("students", students);
        mav.setViewName("student");
        return mav;
    }

}
