package com.wfaxxdyy.mall.mallcontroller;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubbo
@SpringBootApplication
public class MallControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallControllerApplication.class, args);
    }

}
