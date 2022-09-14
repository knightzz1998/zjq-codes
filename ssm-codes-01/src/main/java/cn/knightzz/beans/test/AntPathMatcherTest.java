package cn.knightzz.beans.test;

import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.w3c.dom.DOMLocator;

/**
 * @author 王天赐
 * @title: AntPathMatcherTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-08-30 10:13
 */
public class AntPathMatcherTest {

    public static void main(String[] args) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        System.out.println(antPathMatcher.match("/hello", "/hello.html"));
        System.out.println(antPathMatcher.match("/hello2", "/hello.html"));
    }
}
