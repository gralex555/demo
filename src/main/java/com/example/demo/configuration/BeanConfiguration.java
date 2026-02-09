package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {
    @Bean("order1")
    @Scope(scopeName = "proxy")
    public String getOrderName() {
        return "заказ № 1";
    }

    @Bean("order2")
    public String getOrderName2() {
        return "Заказ № 2";
    }
}
