package cn.knightzz.dao.impl;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 王天赐
 * @title: StudentDaoImplTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 10:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoImplTest {

    //@Autowired
    //StudentDao studentDao;

    @Test
    public void findAllStudent() {

        //List<Student> students = studentDao.findAllStudent();
        //for (Student student : students) {
        //    System.out.println(student);
        //}

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Application");

    }

    @Test
    public void saveContact() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteContact() {
    }

    @Test
    public void updateContact() {
    }

    @Test
    public void findByName() {
    }
}