package com.blogx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author XueYuan.
 * @date 2018/10/15 19:25.
 * Email: eoooxy@gmail.com.`
 * PS: good good study day day up!
 */
@SpringBootApplication
@MapperScan(value = "com.blogx.mapper")
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}

