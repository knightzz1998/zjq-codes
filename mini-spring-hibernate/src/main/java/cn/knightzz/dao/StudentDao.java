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
 * @create: 2022-09-15 12:04
 */
public interface StudentDao {

    public List<Student> findAll();

}
