package com.blogx.controller;

import com.blogx.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XueYuan.
 * @date 2018/10/15 19:27.
 * Email: eoooxy@gmail.com.
 * PS: good good study day day up!
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("hello")
    public String helloWorld() {
        return "Hello XXX";
    }

    @GetMapping("get")
    public String getHello() {
        return helloService.getHello().toString();
    }
}
