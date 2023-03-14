package com.welitoncardozo.bicycleallocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BicycleAllocationApplication {
	public static void main(String[] args) {
		SpringApplication.run(BicycleAllocationApplication.class, args);
	}
}
