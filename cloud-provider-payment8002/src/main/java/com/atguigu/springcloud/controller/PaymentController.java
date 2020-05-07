package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 添加数据
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***************插入结果"+result);

        if (result>0){
            return new CommonResult(200,"插入数据库成功,server.port是"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    /**
     * 查询数据
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***************插入结果"+payment);

        if (payment != null ){
            return new CommonResult(200,"查询数据库成功,server.port是"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询数据库失败，没有对应数据，ID是"+id,null);
        }
    }
}
