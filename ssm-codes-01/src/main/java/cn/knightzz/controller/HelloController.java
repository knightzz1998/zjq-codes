package cn.knightzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 王天赐
 * @title: HelloController
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-08-28 16:21
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello================");
        return "hello2";
    }

    @GetMapping("/hello.html")
    public String hell2() {
        System.out.println("hello================2");
        return "hello.html222";
    }

}
