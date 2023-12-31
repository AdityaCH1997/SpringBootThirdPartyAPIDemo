package com.example.demo.thirdPartyAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SpringThirdPartyApiIntegrationDemoApplication {

	@GetMapping("/apis")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringThirdPartyApiIntegrationDemoApplication.class, args);
	}

}
