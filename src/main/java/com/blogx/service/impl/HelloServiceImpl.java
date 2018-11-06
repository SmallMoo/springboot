package com.blogx.service.impl;

import com.blogx.entity.Hello;
import com.blogx.mapper.HelloMapper;
import com.blogx.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author XueYuan.
 * @date 2018/10/16 21:52.
 * Email: eoooxy@gmail.com.
 * PS: good good study day day up!
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloMapper helloMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public Hello getHello() {
        Hello hello = helloMapper.getOne();
        if (hello != null) {
            stringRedisTemplate.opsForValue().set("obj", hello.toString());
        }
        return helloMapper.getOne();
    }

}
