package com.bobocode.config;

import com.bobocode.TestDataGenerator;
import com.bobocode.dao.FakeAccountDao;
import com.bobocode.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class specifies application context configuration. It tells Spring to scan "dao" and "service" packages in order
 * to find and create instances for {@link com.bobocode.dao.FakeAccountDao} and
 * {@link com.bobocode.service.AccountService}.
 * <p>
 * It also explicitly configures a bean of {@link TestDataGenerator} called "dataGenerator". This bean will be injected
 * into {@link com.bobocode.dao.FakeAccountDao} in order to generate some fake accounts.
 */
@Configuration
@ComponentScan(basePackages = {"com.bobocode.dao", "com.bobocode.service"})
public class ApplicationConfig {

    /**
     * Configure the TestDataGenerator bean for dependency injection.
     * This bean will be used by FakeAccountDao to generate fake accounts.
     *
     * @return the TestDataGenerator bean
     */
    @Bean
    public TestDataGenerator dataGenerator() {
        return new TestDataGenerator(); // Return an instance of TestDataGenerator
    }
}
