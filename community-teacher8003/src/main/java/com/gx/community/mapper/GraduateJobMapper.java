package com.gx.community.mapper;

import com.gx.community.pojo.GraduateJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/8 10:32
 * @description：毕业生就业
 * @modified By：
 */
public interface GraduateJobMapper {

    //模糊查询姓名
    List<Map<String,Object>> queryGraduateLikeStuName(@Param("stuName") String stuName);

    //查看毕业生就业信息详情
    List<Map<String,Object>> queryGraduateJobByStuUUID(String stuUUID);

    //添加毕业生就业信息详情
    void insertGraduateJob(GraduateJob graduateJob);
}
