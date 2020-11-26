package com.example.demo.rabbitmq.service.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 路径：com.example.demo.rabbitmq.service.callback
 * 类名：CallBackSender
 * 功能：带callback的消息发送-----生产者
 * 创建人：typ
 * 创建时间：2018/9/24 20:09
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Component
public class CallBackSender implements  RabbitTemplate.ConfirmCallback{

    private static final Logger log = LoggerFactory.getLogger(CallBackSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplatenew;

    public void send() {
        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        log.info(msg);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);  
    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("callbakck confirm: " + correlationData.getId());
    }
}