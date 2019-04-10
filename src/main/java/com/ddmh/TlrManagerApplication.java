package com.ddmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author FBin
 * @date 2019/04/09
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ddmh.mapper")
public class TlrManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TlrManagerApplication.class, args);
	}

}
