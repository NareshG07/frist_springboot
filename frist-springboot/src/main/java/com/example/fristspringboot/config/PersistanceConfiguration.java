package com.example.fristspringboot.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class PersistanceConfiguration {
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/demo");
        builder.username("postgres");
        builder.password("1@34");
        System.out.println("Custom datasource has been initialized and set");
        return builder.build();
    }
}
