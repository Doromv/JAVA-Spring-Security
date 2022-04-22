package com.example.ch03inmemoryrole.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doromv
 * @create 2022-04-22-16:43
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "QAQ";
    }
    //normal和admin角色都可以访问的方法
    @RequestMapping("/user")
    @PreAuthorize(value = "hasAnyRole('normal','admin')")
    public String helloCommonUser(){
        return "hello!normal,admin";
    }
    //只有admin角色可以访问的方法
    @RequestMapping("/admin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String helloAdmin(){
        return "hello!admin";
    }
}
