package com.pratice.example;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy
//@MapperScan(basePackages = "com.pratice.example.nBatis.dao")
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}
