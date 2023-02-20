package com.max;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.max.maxmall.dao")
public class IapApplication {

    public static void main(String[] args) {
        SpringApplication.run(IapApplication.class, args);
    }

}
