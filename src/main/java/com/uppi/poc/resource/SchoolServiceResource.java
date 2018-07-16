package com.uppi.poc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SchoolServiceResource {
	@Value("${rest.discovery.service.id}")
	private String serviceId;
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping(value="/studentDetails",method=RequestMethod.GET)
	public String studentDetails() {
		String body=restTemplate.exchange("http://"+serviceId+"/students", HttpMethod.GET,null,String.class).getBody();
		return body;
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
