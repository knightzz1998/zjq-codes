package cn.knightzz.test;

import cn.knightzz.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 王天赐
 * @title: SpringTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 11:29
 */
public class SpringTest {

    @Autowired
    Person person;

    public static void main(String[] args) {

        SpringTest springTest = new SpringTest();
        String name = springTest.person.getName();
        System.out.println("name = " + name);

    }


}
