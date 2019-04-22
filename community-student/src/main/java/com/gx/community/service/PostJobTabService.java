package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.JobPost;

import java.util.Map;

public interface PostJobTabService {
    //就业贴列表
    PageInfo<Map<String,Object>> queryJobPost(int nextPage);

    //根据帖子编号查询就业贴详情
    JobPost queryJobPostByJobUUID(String jobUUID);

    //根据行业查询industryID就业贴
    PageInfo<Map<String,Object>> queryJobPostByIndustryID(int industryID,int nextPage);

    //模糊查询就业贴
    PageInfo<Map<String,Object>> queryJobPostLikePostName(String postName,int nextPage);
}
