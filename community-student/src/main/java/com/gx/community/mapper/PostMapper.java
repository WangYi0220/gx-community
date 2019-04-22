package com.gx.community.mapper;

import com.gx.community.pojo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 帖子操作
 */
public interface PostMapper {
    List<Map<String,Object>> queryPostByTabName(@Param("tabID") int tabID);

    void insertPost(Post post);

    Map<String,Object> getPostByPostUUID(@Param("postUUID") String postUUID);

    List<Map<String,Object>> getPostList();
}
