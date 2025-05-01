package com.bobocode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Root application configuration, excluding web-related beans.
 */
@Configuration
@ComponentScan(basePackages = "com.bobocode", excludeFilters = @Filter(Controller.class)) // Exclude web-related beans
public class RootConfig {
}
