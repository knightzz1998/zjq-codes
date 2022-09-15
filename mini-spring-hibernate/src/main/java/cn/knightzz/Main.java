package cn.knightzz;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.entity.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 王天赐
 * @title: ${NAME}
 * @projectName ${PROJECT_NAME}
 * @description: ${description}
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = context.getBean(StudentDao.class);
        List<Student> students = studentDao.findAll();
        System.out.println(students);
    }
}