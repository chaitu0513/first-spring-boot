package com.wipro.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean
	public String devDatabaseConnection()
	{
		System.out.print("DB Connection for dev -H2");
		System.out.print(driverClassName);
		System.out.print(url);
		return "DB Connection for DEV - H2";
	}
	
	@Profile("test")
	@Bean
	public String testDatabaseConnection()
	{
		System.out.print("DB Connection for test MySQL");
		System.out.print(driverClassName);
		System.out.print(url);
		return "DB Connection for TEST - MySQL";
	}
	
	
	
}
