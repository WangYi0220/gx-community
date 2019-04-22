package com.gx.community.mapper;

import com.gx.community.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shiloh
 * @Date Created in 2019/4/8 19:07
 * @description 学生成绩
 * @modified By:
 */
public interface StudentScoreMapper {
    /**
      *@Author lxl
      *@Description 根据班级编号查询学生成绩基本信息
      *@Date 19:09 2019/4/8
      *@Param [classUUID]
      *@return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
      **/
    List<Student> getStudentScoreBaseInfoByClassUUID(@Param("classUUID") String classUUID);
}
