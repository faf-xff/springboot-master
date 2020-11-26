package com.example.demo.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 路径：com.example.demo.websocket.config
 * 类名：
 * 功能：webSocket配置
 * 备注：@EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思；
 * 创建人：typ
 * 创建时间：2018/10/18 10:15
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 方法名：
     * 功能：《用一句话描述一下》
     * 描述：注册STOMP协议的节点，并指定映射的URL
     * 创建人：typ
     * 创建时间：2018/10/18 10:21
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册STOMP协议节点，同时指定使用SockJS协议
        registry.addEndpoint("/endpointSang").withSockJS();
    }

    /**
     * 方法名：
     * 功能：《用一句话描述一下》
     * 描述：配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
     * 创建人：typ
     * 创建时间：2018/10/18 10:22
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
