package com.example.JobService.Job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//used only when we use rest template for communication. it was made because of load balanced.

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced

    public RestTemplate restTemplate()
    {
        return  new RestTemplate();
    }
}
