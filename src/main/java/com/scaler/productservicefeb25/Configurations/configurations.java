package com.scaler.productservicefeb25.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//This marks the class as a Spring configuration class, meaning it contains bean definitions.
@Configuration
public class configurations {

    //In Spring, a bean is an instance of a class that is managed by the Spring IoC (Inversion of Control) container.
    //It is created, initialized, and managed by Spring.
    //It can be injected into other parts of the application.
    //Unlike regular objects (which you create using new), beans are automatically instantiated by Spring.
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
    //from my understanding we are explicitly creating a config file for RestTemplate class
    // because we need object of this class in our various codebase so seperately creating it
    // again n again in different classes we have created it here in config file so everytime
    // we want to use RestTemplate will just pass reference of RestTemplate in
    // constructor and will write this.restTemplate = restTemplate and we are good to go
}
