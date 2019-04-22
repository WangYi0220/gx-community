package com.gx.community.service;

import com.gx.community.pojo.StudentScore;

import java.util.List;

/**
 *@Author lxl
 *@Description service:StudentScoreService
 *@Date 15:08 2019/4/1
 **/
public interface StudentScoreService {
    /**
      *@Author lxl
      *@Description 根据学生编号查看对应的成绩信息列表
      *@Date 19:46 2019/4/1
      *@Param [stuUUID]
      *@return java.util.List<com.gx.community.pojo.StudentScore>
      **/
    List<StudentScore> queryScoreListByExample(String semester, String stuUUID);
}
