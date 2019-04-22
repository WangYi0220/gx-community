package com.gx.community.common.config;

import org.springframework.stereotype.Component;

/**
 * MQ消息处理器
 * @author zhh
 */
@Component
public class MessageReceiver {

    /**
     * 接收消息的方法1
     **/
    public void receiveMessage(String message){
        /*System.out.println("receiveMessage接收到的消息："+message);
        String getSignInfo = message.substring(message.indexOf(":") + 1);
        System.out.println(getSignInfo);*/



    }

    /**
     * 接收消息的方法2
     **/
    public void receiveMessage2(String message){
       /* System.out.println("receiveMessage2接收到的消息："+message);*/
    }

}