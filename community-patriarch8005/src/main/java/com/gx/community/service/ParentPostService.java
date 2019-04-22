package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.JobPost;

import java.util.Map;

/**
 * @author xyy
 * @Date Created in
 * @description 就业贴操作
 * @modified By:
 */
public interface ParentPostService {

    //根据家长编号查看自己发布的就业贴
    PageInfo<Map<String,Object>> queryJobPostByParUUID(String parUUID,int nextPage);

    //家长删除自己发布的就业贴
    boolean deleteJobPostByJobUUID(String jobUUID);

    boolean addPost(JobPost jobPost);
}
