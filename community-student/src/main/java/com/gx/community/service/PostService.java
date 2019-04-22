package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.Post;

import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/1 16:59
 * @description：贴子操作
 * @modified By：
 */
public interface PostService {
    //根据帖子类型  查询全部帖子
    PageInfo<Map<String,Object>> queryPostByTabName(int tabID,int nextPage);

    //添加帖子
    String insertPost(Post post);

    Map<String,Object> getPostByPostUUID(String postUUID);

    PageInfo<Map<String,Object>> getPostList(int nextPage);
}
