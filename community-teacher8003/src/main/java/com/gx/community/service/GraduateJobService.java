package com.gx.community.service;

import com.gx.community.pojo.GraduateJob;

import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/8 11:04
 * @description：毕业生就业
 * @modified By：
 */
public interface GraduateJobService {

    //根据班级 与 姓名模糊查询 就业详细信息
    List<Map<String,Object>> queryGraduateLikeStuName(String stuName);

    //查看毕业生就业信息详情
    List<Map<String,Object>> queryGraduateJobByStuUUID(String stuUUID);

    //添加毕业生就业信息详情
    String insertGraduateJob(GraduateJob graduateJob);
}
