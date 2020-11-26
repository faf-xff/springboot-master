package com.example.demo.activemq.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 路径：com.activemq.demo
 * 类名：Listener
 * 功能：消息监听
 * 备注：
 * 创建人：typ
 * 创建时间：2018/8/14 22:07
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class Listener implements MessageListener{

	public void onMessage(Message message) {
		try {
			System.out.println("接收到的消息："+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
