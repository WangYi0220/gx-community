package com.gx.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.community.mapper.PostJobTabMapper;
import com.gx.community.pojo.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 21:03
 * @description：就业贴操作
 * @modified By：
 */
@Service
public class PostJobTabServiceImpl implements PostJobTabService {

    @Autowired
    private PostJobTabMapper postJobTabMapper;

    //就业贴列表
    @Override
    public PageInfo<Map<String,Object>> queryJobPost(int nextPage) {
        PageHelper.startPage(nextPage,10);//1.设置pageHelper分页所需的参数
        List<Map<String,Object>> listData = postJobTabMapper.queryJobPost();
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(listData);//获取分页对象
        return pageInfo;
    }

    //根据帖子编号查询就业贴详情
    @Override
    public JobPost queryJobPostByJobUUID(String jobUUID) {
        return postJobTabMapper.queryJobPostByJobUUID(jobUUID);
    }


    //根据行业查询industryID就业贴
    @Override
    public PageInfo<Map<String,Object>> queryJobPostByIndustryID(int industryID,int nextPage) {
        PageHelper.startPage(nextPage,10);//1.设置pageHelper分页所需的参数
        List<Map<String, Object>> listData = postJobTabMapper.queryJobPostByIndustryID(industryID);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(listData);//获取分页对象
        return pageInfo;
    }

    //模糊查询就业贴
    @Override
    public PageInfo<Map<String,Object>> queryJobPostLikePostName(String postName,int nextPage) {
        PageHelper.startPage(nextPage,10);//1.设置pageHelper分页所需的参数
        List<Map<String, Object>> listData = postJobTabMapper.queryJobPostLikePostName(postName);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(listData);//获取分页对象
        return pageInfo;
    }
}
