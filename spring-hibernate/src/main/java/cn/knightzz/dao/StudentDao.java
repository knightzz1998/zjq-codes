package cn.knightzz.dao;

import cn.knightzz.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王天赐
 * @title: StudentDao
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 10:21
 */
@Repository
public interface StudentDao {

    public List<Student> findAllStudent();

    public void saveContact(Student Student);

    public Student findById(int id);

    public void deleteContact(int id);

    public void updateContact(Student Student);

    public List<Student> findByName(String name);

}
