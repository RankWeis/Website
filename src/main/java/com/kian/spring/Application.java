package com.kian.spring;

import com.kian.sandbox.romanNumerals.RomanNumeralConverter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ConfigurationProperties
@EnableAutoConfiguration
@ComponentScan({"com.kian.spring"})
public class Application {
	private static final Logger log = LogManager.getLogger(Application.class);

    @Bean
    public RomanNumeralConverter romanNumeralConverter() {
        return new RomanNumeralConverter();
    }


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        log.info("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            log.info(beanName);
        }
		log.info("End initialization beans.");
	}

}
