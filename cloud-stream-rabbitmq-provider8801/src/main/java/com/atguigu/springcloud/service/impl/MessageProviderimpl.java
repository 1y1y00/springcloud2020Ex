package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 这个消息驱动操纵的是rabbitmq，不是正常的controller-service-dao，所以不能用@Service注解，要用Stream的注解
 */
@EnableBinding(Source.class)  //定义消息的推送管道
@Slf4j
public class MessageProviderimpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //相当于消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("!!!!!!!!!serial是----->"+serial);
        System.out.println("*********serial:"+serial);
        return null;
    }
}
