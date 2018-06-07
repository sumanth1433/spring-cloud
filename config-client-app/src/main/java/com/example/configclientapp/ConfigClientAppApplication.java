package com.example.configclientapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientAppApplication {
	
	@Autowired
	ConfiguClientAppConfiguration  properties;
	
	@Value("${some.other.property}")
	private String someotherProperty;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAppApplication.class, args);
	}
	
	
	@RequestMapping("/")
	public String getContent() {
		StringBuilder str = new StringBuilder();
		str.append(properties.getProperty());
		str.append("||   ");
		str.append(someotherProperty);
		return str.toString();
	}
}
