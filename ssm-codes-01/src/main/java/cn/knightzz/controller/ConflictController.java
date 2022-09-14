package cn.knightzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 王天赐
 * @title: ConflictController
 * @projectName zjq-codes
 * @description: 测试请求url和路径冲突
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-08-30 09:29
 */
@Controller
public class ConflictController {

    @RequestMapping("/conflict")
    public String test(){
        return "a";
    }

}
