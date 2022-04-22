package com.doromv.ch02inmeory.controller;

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
}
