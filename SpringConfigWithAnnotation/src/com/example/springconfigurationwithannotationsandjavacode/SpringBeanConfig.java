package com.example.springconfigurationwithannotationsandjavacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sports.properties")
public class SpringBeanConfig {

	/**
	 * Define a bean for SadFortune Service
	 */
	
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	/**
	 * Define a bean for Swim Coach	
	 */
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
