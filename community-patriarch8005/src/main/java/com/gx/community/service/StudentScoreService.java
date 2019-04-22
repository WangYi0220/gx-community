package com.gx.community.service;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author shiloh
 * @Date Created in 2019/4/9 14:26
 * @description 学生成绩
 * @modified By:
 */
public interface StudentScoreService {
    /**
     *@Author lxl
     *@Description 查询自己小孩的成绩信息
     *@Date 10:18 2019/4/9
     *@Param [stuUUID]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> queryStudentScoreByStuUUID(@Param("stuUUID") String stuUUID);
}
