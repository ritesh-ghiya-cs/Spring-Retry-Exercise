package org.spring.retry.exercise.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@ComponentScan(basePackages="org.spring.retry.exercise")
@EnableRetry
public class AppConfig {

}
