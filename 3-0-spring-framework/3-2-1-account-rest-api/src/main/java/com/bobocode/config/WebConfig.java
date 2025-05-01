package com.bobocode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web-related configuration for Spring MVC.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bobocode.web") // Enable component scanning for the "web" package
public class WebConfig {
}
