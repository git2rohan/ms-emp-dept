package com.ms.departmentservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.ms.departmentservice.client.EmployeeClient;

@Configuration
public class WebClientConfig {
	
	//As Eureka has this employee service load balancer.
	//So we need to add a filter for LoadBalancer
	@Autowired
	private LoadBalancedExchangeFilterFunction functionFilter;
	
	//This is for fetching employee web client
	@Bean
	public WebClient employeeWebClient() {
		return WebClient
				.builder()
				.baseUrl("http://employee-service")
				.filter(functionFilter)
				.build();
	}
	
	//now create bean for employee webclient and use above settings
	@Bean
	public EmployeeClient employeeClient() {
		HttpServiceProxyFactory httpServiceProxyFactory 
			= HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(employeeWebClient()))
				.build();
		return httpServiceProxyFactory.createClient(EmployeeClient.class);
	}

}
