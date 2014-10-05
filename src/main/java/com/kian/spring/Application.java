package com.kian.spring;

import com.kian.sandbox.romanNumerals.RomanNumeralConverter;
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

    @Bean
    public RomanNumeralConverter romanNumeralConverter() {
        return new RomanNumeralConverter();
    }


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println("Bean: " + beanName);
        }
    }

}
