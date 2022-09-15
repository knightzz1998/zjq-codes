package cn.knightzz.dao;

import cn.knightzz.entity.Student;

import java.util.List;

/**
 * @author 王天赐
 * @title: StudentDao
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 09:41
 */
public interface StudentDao {

    /**
     * 获取所有的Student对象
     * @return List集合
     */
    public List<Student> findAllStudent();

    public void saveContact(Student Student);

    public Student findById(int id);

    public void deleteContact(int id);

    public void updateContact(Student Student);

    public List<Student> findByContactName(String name);
}
