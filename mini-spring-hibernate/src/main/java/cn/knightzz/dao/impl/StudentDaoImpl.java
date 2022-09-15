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
 * @title: StudentDaoImpl
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 12:05
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria("Student");
        return criteria.list();
    }
}
