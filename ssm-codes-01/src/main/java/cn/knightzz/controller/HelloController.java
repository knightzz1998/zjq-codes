package cn.knightzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "hello222";
    }

}
