package com.atguigu.springcloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 由于springboot是个容器类，而且我们需要RestTemplate类，所以我们要写一个配置类将RestTemplate注入到springboot容器中
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
