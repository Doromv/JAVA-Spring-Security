package com.doromv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doromv
 * @create 2022-04-22-20:20
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String HelloController(){
        return "hello";
    }
}
