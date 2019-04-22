package com.gx.community.mapper;

import com.gx.community.pojo.JobPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 就业贴操作
 */
public interface PostJobTabMapper {

    //就业贴列表
    List<Map<String,Object>> queryJobPost();

    //根据帖子编号查询就业贴详情
    JobPost queryJobPostByJobUUID(@Param("jobUUID") String jobUUID);

    //根据行业查询industryID就业贴
    List<Map<String,Object>> queryJobPostByIndustryID(@Param("industryID") int industryID);

    //模糊查询就业贴
    List<Map<String,Object>> queryJobPostLikePostName(@Param("postName") String postName);
}
