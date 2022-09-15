package cn.knightzz.test;

import cn.knightzz.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 王天赐
 * @title: HibernateConfigrationTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 12:27
 */
public class HibernateConfigrationTest {

    public static void main(String[] args) {

        Configuration configure = new Configuration().configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Student.class);

        Student student = new Student();
        student.setId(1);
        student.setName("hanxin");
        student.setAge(12);

        session.save(student);
        // 开启事务提交
        session.beginTransaction().commit();
        session.close();

    }
}
