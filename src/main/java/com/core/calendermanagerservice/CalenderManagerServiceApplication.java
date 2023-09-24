package com.core.calendermanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.core.calendermanagerservice.configs.PropertiesConfig;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
@EnableConfigurationProperties(PropertiesConfig.class)
public class CalenderManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalenderManagerServiceApplication.class, args);
	}
}
