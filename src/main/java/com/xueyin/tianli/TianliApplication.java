package com.xueyin.tianli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xueyin.tianli.mapper")
public class TianliApplication {

	public static void main(String[] args) {
		SpringApplication.run(TianliApplication.class, args);
	}

}
