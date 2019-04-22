package com.gx.community.mapper;

import com.gx.community.pojo.StudentScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author lxl
 *@Description mapper:StudentScoreMapper
 *@Date 15:08 2019/4/1
 **/
public interface StudentScoreMapper {
    /**
      *@Author lxl
      *@Description 根据学生编号查看对应的成绩信息列表
      *@Date 19:46 2019/4/1
      *@Param [stuUUID]
      *@return java.util.List<com.gx.community.pojo.StudentScore>
      **/
    List<StudentScore> queryScoreListByExample(@Param("semester") String semester,@Param("stuUUID") String stuUUID);
}
