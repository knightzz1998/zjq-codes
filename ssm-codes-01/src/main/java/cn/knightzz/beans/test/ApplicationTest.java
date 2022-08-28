package cn.knightzz.beans.test;

import cn.knightzz.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author 王天赐
 * @title: ApplicationTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-08-26 23:36
 */
public class ApplicationTest {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-beans.xml");
        Person  person = (Person) context.getBean("personBySet");
        System.out.println(person);

    }
}
