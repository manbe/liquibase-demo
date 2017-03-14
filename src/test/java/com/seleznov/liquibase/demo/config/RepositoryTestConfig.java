package com.seleznov.liquibase.demo.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

/**
 * @author Illia Seleznov
 */


@Configuration
@EnableAutoConfiguration
public class RepositoryTestConfig {



    @Value("${liquibase.change-log}")
    private String changeLog;

    @Autowired
    private DataSource dataSource;

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
            protected boolean hasError(HttpStatus statusCode) {
                return false;
            }});
        return restTemplate;
    }


    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDropFirst(true);
        liquibase.setChangeLog(changeLog);
        liquibase.setDataSource(dataSource);
        liquibase.setContexts("test");
        return liquibase;
    }

}
