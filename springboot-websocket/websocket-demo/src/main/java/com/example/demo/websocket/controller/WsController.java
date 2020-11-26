package com.example.demo.websocket.controller;

import com.example.demo.websocket.entity.RequestMessage;
import com.example.demo.websocket.entity.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 路径：com.example.demo.websocket.controller
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/18 10:26
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Controller
public class WsController {

    /**
     * 方法名：
     * 功能：《用一句话描述一下》
     * 描述：@MessageMapping注解和我们之前使用的@RequestMapping类似;
     *      @SendTo注解表示当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息。
     * 创建人：typ
     * 创建时间：2018/10/18 10:28
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(@RequestBody RequestMessage message){
        log.info("消息：{}",message.getName());
        String mag = "welcom," + message.getName() + "!";
        return new ResponseMessage(mag);
    }
}
