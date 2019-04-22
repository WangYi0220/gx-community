package com.gx.community.service;

import com.gx.community.pojo.PostDiscuss;

import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/2 8:33
 * @description： 帖子聊天操作
 * @modified By：
 */
public interface PostDiscussService {

    //添加 回复消息
    String insertPostDiscuss(PostDiscuss postDiscuss);

    //根据帖子编号查询  全部帖子聊天信息
    List<Map<String,Object>> postDiscussByPostUUID(String postUUID);

    void delPostDiscuss(String discussUUID);
}
