package com.gx.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.UUIDUtils;
import com.gx.community.mapper.PostMapper;
import com.gx.community.pojo.Post;
import com.gx.community.pojo.PostDiscuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/1 17:00
 * @description：帖子操作
 * @modified By：
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据帖子类型  查询全部帖子
     * @param tabID
     * @return
     */
    @Override
    public PageInfo<Map<String,Object>> queryPostByTabName(int tabID,int nextPage){
        PageHelper.startPage(nextPage,10);//1.设置pageHelper分页所需的参数
        List<Map<String,Object>> map = postMapper.queryPostByTabName(tabID);//获取每页数据
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(map);//获取分页对象
        return pageInfo;
    }

    /**
     * 添加帖子
     * @param post
     * @return
     */
    @Override
    public String insertPost(Post post) {
        String uuid = UUIDUtils.getUUID();
        post.setPostUUID(uuid);
        postMapper.insertPost(post);
        return uuid;
    }

    /**
     * 根据帖子编号查询帖子详情
     * @param postUUID
     * @return
     */
    @Override
    public Map<String, Object> getPostByPostUUID(String postUUID) {
        return postMapper.getPostByPostUUID(postUUID);
    }

    /**
     * 获取所有帖子
     * @return
     */
    @Override
    public PageInfo<Map<String,Object>> getPostList(int nextPage) {
        PageHelper.startPage(nextPage,10);//1.设置pageHelper分页所需的参数
        List<Map<String,Object>> map = postMapper.getPostList();//获取每页数据
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(map);//获取分页对象
        return pageInfo;
    }
}
