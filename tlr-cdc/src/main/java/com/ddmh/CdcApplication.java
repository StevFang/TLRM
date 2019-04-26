package com.ddmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.ddmh.mapper")
@EnableTransactionManagement
@EnableScheduling
public class CdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdcApplication.class, args);
    }

}
