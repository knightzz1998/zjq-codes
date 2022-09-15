package cn.knightzz.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王天赐
 * @title: PersonTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 11:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonTest {

    @Autowired
    Person person;

    @Test
    public void test01() {

        System.out.println("name = " + person.getName());

    }
}