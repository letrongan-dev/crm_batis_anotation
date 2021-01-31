package com.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.crm")
public class CrmMyBatisAnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmMyBatisAnotationApplication.class, args);
	}

}
