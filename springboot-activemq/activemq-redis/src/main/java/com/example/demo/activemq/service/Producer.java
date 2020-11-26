package com.example.demo.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 路径：com.activemq.demo.service
 * 类名：
 * 功能：生产者
 * 备注：
 * 创建人：typ
 * 创建时间：2018/8/24 18:14
 * 修改人：
 * 修改备注：
 * 修改时间：
 */

@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    /**
     * 方法名：
     * 功能：发送消息，destination是发送到的队列，message是待发送的消息
     * 描述：每隔2s执行一次
     * 创建人：typ
     * 创建时间：2018/8/24 18:17
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Scheduled(fixedDelay = 2000)
    public void send(){
        jmsMessagingTemplate.convertAndSend(this.queue,"hello activemq");
    }

}
