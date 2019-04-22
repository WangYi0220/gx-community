package com.gx.community.mapper;

import com.gx.community.pojo.JobPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xyy
 * @Date Created in
 * @description 就业贴操作
 * @modified By:
 */
public interface ParentPostMapper {

    //根据家长编号查看自己发布的就业贴
    List<Map<String,Object>> queryJobPostByParUUID(@Param("parUUID")String parUUID);

    //家长删除自己发布的就业贴
    void deleteJobPostByJobUUID(@Param("jobUUID") String jobUUID);

    void addPost(JobPost jobPost);
}
