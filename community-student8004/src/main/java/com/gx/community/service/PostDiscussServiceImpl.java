package com.gx.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.SpringUtils;
import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.PostDiscussMapper;
import com.gx.community.mapper.PostMapper;
import com.gx.community.pojo.Post;
import com.gx.community.pojo.PostDiscuss;
import com.gx.community.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/2 8:35
 * @description：帖子聊天操作
 * @modified By：
 */
@Service
public class PostDiscussServiceImpl implements PostDiscussService {

    @Autowired
    private PostDiscussMapper postDiscussMapper;

    /**
     * 添加评论
     * @param postDiscuss
     * @return
     */
    @Override
    public String insertPostDiscuss(PostDiscuss postDiscuss) {
        String uuid = UUIDUtils.getUUID();
        postDiscuss.setDiscussUUID(uuid);//设置uuid
        postDiscussMapper.insertPostDiscuss(postDiscuss);
        //消息提醒
        WebSocketServer webSocketServer = SpringUtils.getBean(WebSocketServer.class);
        webSocketServer.sendMessage(postDiscuss.getStuA(),postDiscuss.getStuB(), "");
        return uuid;
    }

    /**
     * 获取帖子所有评论
     * @param postUUID
     * @return
     */
    @Override
    public List<Map<String, Object>> postDiscussByPostUUID(String postUUID) {
        return postDiscussMapper.postDiscussByPostUUID(postUUID);
    }

    /**
     * 删除回复
     * @param discussUUID
     */
    @Override
    public void delPostDiscuss(String discussUUID) {
        postDiscussMapper.delPostDiscuss(discussUUID);
    }
}
