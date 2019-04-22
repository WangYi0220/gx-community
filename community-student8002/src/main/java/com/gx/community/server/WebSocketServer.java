package com.gx.community.server;

import com.gx.community.common.utils.RedisUtils;
import com.gx.community.common.utils.SpringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/1 15:27
 * @description：会话服务
 * @modified By：
 */
@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocketServer {

    public static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    private RedisUtils redisUtil = SpringUtils.getBean(RedisUtils.class);

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        if (sessionMap == null) {
            sessionMap = new ConcurrentHashMap<String, Session>();
        }
        sessionMap.put(userId, session);
        System.out.println("新用户连接：" + userId);
        List<Object> messageList = redisUtil.lGet(userId, 0, -1);
        if (messageList != null) {
            messageList.forEach(item -> {
                System.out.println(item.toString());
                try {
                    session.getBasicRemote().sendText(item.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        redisUtil.del(userId);
    }

    @OnClose
    public void onClose(@PathParam("userId") String userId) {
        System.out.println("我是关闭方法");
        sessionMap.remove(userId);

    }

    @OnMessage
    public void onMessage(@PathParam("userId") String userId, String message) {
        System.out.println(userId + ":" + message);
        int i = message.lastIndexOf("?");
        String onUserId = message.substring(i + 1);
        System.out.println("onUserId: " + onUserId);
        message = message.substring(0, i);
        sendMessage(userId, onUserId, message);
    }

    public void sendMessage(String sendUserId, String onUserId, String message) {
        System.out.println("sendUserId：" + sendUserId);
        System.out.println("onUserId:" + onUserId);
        System.out.println(message);
        try {
            Session session = sessionMap.get(onUserId);
            session.getAsyncRemote().sendText(message + "?" + sendUserId);
        } catch (Exception e) {
            System.out.println("我异常了");
            redisUtil.lSet(onUserId, message + "?" + sendUserId, 3000);
        }
    }
}
