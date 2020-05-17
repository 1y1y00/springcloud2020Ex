package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 作为Feign功能使用的接口,新增使用接口，找哪个微服务的东西
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PayMentFeignService {

    //拿到cloud-provider-payment8001的controller的查询方法，@GetMapping是调用地址
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
