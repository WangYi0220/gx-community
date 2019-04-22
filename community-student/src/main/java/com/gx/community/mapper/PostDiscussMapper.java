package com.gx.community.mapper;

import com.gx.community.pojo.PostDiscuss;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PostDiscussMapper {
    //根据帖子编号查询  全部帖子聊天信息
    List<Map<String,Object>> postDiscussByPostUUID(@Param("postUUID") String postUUID);

    //添加 回复消息
    void insertPostDiscuss(PostDiscuss postDiscuss);

    void delPostDiscuss(@Param("discussUUID") String discussUUID);
}
