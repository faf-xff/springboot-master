package com.example.demo.websocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 路径：com.example.demo.websocket.controller
 * 类名：
 * 功能：webSocket实现聊天室
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/18 11:48
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Controller
public class WsController {
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 方法名：
     * 功能：《用一句话描述一下》
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/18 12:04 
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        log.info("name:{} ,msg:{},",principal.getName(),msg);
        if (principal.getName().equals("admin")) {
            messagingTemplate.convertAndSendToUser("admin", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("root", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }
    }
}
