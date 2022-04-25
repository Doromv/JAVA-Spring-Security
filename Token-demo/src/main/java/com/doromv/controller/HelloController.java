package com.doromv.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doromv
 * @create 2022-04-22-21:58
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
//    @PreAuthorize("hasAnyAuthority('system:dept:list','system:test:list')")
//    @PreAuthorize("hasRole('system:dept:list')")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
