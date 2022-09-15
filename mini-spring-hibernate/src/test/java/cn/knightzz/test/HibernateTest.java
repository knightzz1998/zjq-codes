package cn.knightzz.test;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王天赐
 * @title: HibernateTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 14:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HibernateTest {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    StudentDao studentDao;

    @Test
    public void test01() {
        System.out.println(sessionFactory);
        Session session = sessionFactory.openSession();
        System.out.println(session);
        Student student = new Student();
        student.setAge(13);
        student.setId(12);
        student.setName("tom");
        session.save(student);
        // 手动提交事务, 这里和mybatis不一样
        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test02() {
        System.out.println(studentDao.findAll());
    }
}
