package com.uppi.poc.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import com.uppi.poc.resource.SchoolServiceResource;
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackageClasses=SchoolServiceResource.class)
public class SpringEurekaClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientServiceApplication.class, args);
	}
}
