package com.harshit.customerservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate()
	{
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
