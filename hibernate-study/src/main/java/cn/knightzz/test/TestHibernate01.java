package cn.knightzz.test;

import cn.knightzz.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 王天赐
 * @title: TestHibernate01
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 14:13
 */
public class TestHibernate01 {

    public static void main(String[] args) {

        //创建Configuration
        // 默认文件名是 hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        //获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取Session
        Session session = sessionFactory.openSession();

        Student student = new Student();
        student.setId(1);
        student.setAge(12);
        student.setName("张飞");

        session.save(student);
        // 手动提交事务, 这里和mybatis不一样
        session.beginTransaction().commit();
        session.close();
    }
}
