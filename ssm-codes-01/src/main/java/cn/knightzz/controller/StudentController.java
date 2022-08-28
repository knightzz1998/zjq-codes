package cn.knightzz.controller;

import cn.knightzz.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王天赐
 * @title: StudentController
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-08-28 19:50
 */
@Controller
@RestController
public class StudentController {

    @GetMapping("/student2")
    public String list(Model model) {

        model.addAttribute("title", "湖北工业大学教务系统");

        List<Student> students = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            students.add(new Student("张三", i + 10, i));
        }
        model.addAttribute("students", students);
        // /static/templates/ + "student + .html
        return "student";
    }
}
