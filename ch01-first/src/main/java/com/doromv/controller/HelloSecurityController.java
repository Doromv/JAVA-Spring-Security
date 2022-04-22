package com.doromv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doromv
 * @create 2022-04-22-15:49
 */
@RestController
@RequestMapping("/hello")
public class HelloSecurityController {
    @RequestMapping("/world")
    public String sayHello(){
        return "Hello Spring Security 安全管理框架";
    }
}
