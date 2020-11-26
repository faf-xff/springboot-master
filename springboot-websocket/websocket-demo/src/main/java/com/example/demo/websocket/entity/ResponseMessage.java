package com.example.demo.websocket.entity;

/**
 * 路径：com.example.demo.websocket.entity
 * 类名：
 * 功能：响应消息的实体
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/18 11:03
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class ResponseMessage {
    private String responseMessage;

    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
