package com.ensias.albcgateway.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean

    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();
    }
    @Bean
    public HttpMessageConverters messageConverters(){
        return new HttpMessageConverters(new MappingJackson2HttpMessageConverter());
    }
}
