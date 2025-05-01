package com.bobocode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This class provides web (servlet) related configuration. In the Web MVC framework,
 * each DispatcherServlet has its own WebApplicationContext, which inherits all the beans already defined
 * in the root ApplicationContext.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bobocode.web") // Enable component scanning for the "web" package
public class WebConfig {
    // Web configuration enabling Spring Web MVC and component scanning for web-related beans
}
