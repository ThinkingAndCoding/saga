package com.go.saga.coordinator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.go.saga.coordinator.dao")
public class CoordinatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordinatorApplication.class, args);
	}
}
