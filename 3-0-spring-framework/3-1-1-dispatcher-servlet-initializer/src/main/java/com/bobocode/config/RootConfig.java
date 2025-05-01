package com.bobocode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 * This class provides application root (non-web) configuration for a basic spring application context
 * (containing middle-tier services, datasource, etc.).
 * The configuration must exclude the web layer of the application.
 */
@Configuration
@ComponentScan(basePackages = "com.bobocode", excludeFilters = @Filter(Controller.class)) // Excluding web-related beans (Controllers)
public class RootConfig {
    // Root configuration for application, excluding controllers and web config
}
