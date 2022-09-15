package cn.knightzz.dao.impl;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 王天赐
 * @title: StudnetDaoImpl
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 10:30
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAllStudent() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }

    @Override
    public void saveContact(Student Student) {
        sessionFactory.getCurrentSession().save(Student);
    }

    @Override
    public Student findById(int id) {
        Student Student = (Student) sessionFactory.getCurrentSession().get(Student.class, id);
        return Student;
    }

    @Override
    public void deleteContact(int id) {
        Student Student = findById(id);
        sessionFactory.getCurrentSession().delete(Student);
    }

    @Override
    public void updateContact(Student Student) {
        sessionFactory.getCurrentSession().update(Student);
    }

    @Override
    public List<Student> findByName(String name) {
        String hql = "from Student c where c.name like '%" + name + "%'";
        return sessionFactory.getCurrentSession().createQuery(hql).list();
    }
}
