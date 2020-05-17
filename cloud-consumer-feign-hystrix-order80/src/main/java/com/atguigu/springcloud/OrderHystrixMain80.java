package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//在主启动类上激活Hystrix功能
@EnableHystrix
public class OrderHystrixMain80 {
     public static void main(String[] args) {
           SpringApplication.run(OrderHystrixMain80.class, args);
      }
}
