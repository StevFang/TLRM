package com.ddmh;

import com.ddmh.analyzer.RequestSingleParamHandlerMethodArgumentResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 启动类
 *
 * @author FBin
 * @date 2019/04/09
 */
@SpringBootApplication
@EnableWebMvc
@MapperScan(basePackages = "com.ddmh.mapper")
public class TlrManagerApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(TlrManagerApplication.class, args);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
		argumentResolvers.add(new RequestSingleParamHandlerMethodArgumentResolver());
		super.addArgumentResolvers(argumentResolvers);
	}
}
