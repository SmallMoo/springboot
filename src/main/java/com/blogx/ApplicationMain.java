package com.blogx;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author XueYuan.
 * @date 2018/10/15 19:25.
 * Email: eoooxy@gmail.com.`
 * PS: good good study day day up!
 */
@SpringBootApplication
@MapperScan(value = "com.blogx.mapper")
public class ApplicationMain extends SpringBootServletInitializer implements CommandLineRunner {


    private static Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

    private final CountDownLatch latch = new CountDownLatch(3);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationMain.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        kafkaTemplate.send("test", "foo1");
        kafkaTemplate.send("test", "foo2");
        kafkaTemplate.send("test", "foo3");
        latch.await(60, TimeUnit.SECONDS);
        logger.info("All received");
    }

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info(cr.toString());
        latch.countDown();
    }


}

