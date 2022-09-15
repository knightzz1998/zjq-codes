package cn.knightzz.controller;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.dao.impl.StudentDaoImpl;
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
 * @create: 2022-09-15 09:51
 */
@Controller
@RequestMapping("/")
public class StudentController {
    //@Autowired
    //private StudentDaoImpl studentDao;
    //
    //@RequestMapping("index")
    //public ModelAndView indexPage() {
    //    ModelAndView mav = new ModelAndView("index");
    //    List<Student> students = studentDao.findAllStudent();
    //    System.out.println(students.size());
    //    mav.addObject("students", students);
    //    return mav;
    //}
}
