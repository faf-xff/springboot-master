package com.example.demo.activemq.demo1;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 路径：com.activemq.demo1
 * 类名：JMSProducer
 * 功能：消息生产者-消息发布者
 * 备注：发布-订阅消息模式实现
 * 创建人：typ
 * 创建时间：2018/8/14 21:35
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class JMSProducer {

    //默认的连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认的连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认的连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    //发送的消息数量
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        // 连接工厂
        ConnectionFactory connectionFactory = null;
        // 连接
        Connection connection = null;
        // 会话，接受或者发送消息的线程
        Session session = null;
        // 消息的目的地
        Destination destination = null;
        // 消息的生产者
        MessageProducer messageProducer = null;

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

        try{
            // 通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            // 启动连接
            connection.start();
            // 创建Session
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            // 创建消息队列
            destination = session.createTopic("FirstQueue");
            // 创建消息生产者
            messageProducer = session.createProducer(destination);
            // 发送消息
            sendMessage(session,messageProducer);
            // 提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 方法名：
     * 功能：发送消息
     * 描述：
     * 创建人：typ
     * 创建时间：2018/8/14 21:47
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static void sendMessage(Session session,MessageProducer messageProducer)throws Exception{
        for(int i = 0; i< JMSProducer.SENDNUM; i++){
            TextMessage message=session.createTextMessage("ActiveMQ 发送的消息"+i);
            System.out.println("来自 ActiveMQ 发送的消息"+i);
            messageProducer.send(message);
        }
    }
}
