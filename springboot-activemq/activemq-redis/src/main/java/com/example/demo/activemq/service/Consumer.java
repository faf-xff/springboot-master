package com.example.demo.activemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 路径：com.activemq.demo.service
 * 类名：消费者
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/8/24 18:18
 * 修改人：
 * 修改备注：
 * 修改时间：
 */

@Component
public class Consumer {

     @JmsListener(destination = "promoteAct")
     public void receiveQueue(String consumer) {
         System.out.println(consumer+"消息已经消费了");
     }
}
