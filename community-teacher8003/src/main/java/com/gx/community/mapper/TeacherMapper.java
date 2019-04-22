package com.gx.community.mapper;

import com.gx.community.pojo.ClassInfo;
import com.gx.community.pojo.StudentScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
  *@Author lxl
  *@Description mapper:TeacherMapper
  *@Date 9:37 2019/4/8
  **/
public interface TeacherMapper {
    /**
      *@Author lxl
      *@Description 查看当前教师所带班级列表(分级查询，如：2017级、2018级)
      *@Date 9:44 2019/4/8
      *@Param [teaUUID, grade]
      *@return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
      **/
    List<Map<String,Object>> queryClassInfoListByTeaUUIDAndGrade(@Param("teaUUID") String teaUUID, @Param("grade") String grade);

    /**
     *@Author lxl
     *@Description 导入学生成绩信息
     *@Date 19:41 2019/4/8
     *@Param [studentScores]
     *@return void
     **/
    void importStudentScoreInfo(@Param("studentScores") List<StudentScore> studentScores);

    /**
     *@Author lxl
     *@Description 根据教师编号查询班级信息列表
     *@Date 11:45 2019/4/11
     *@Param [teaUUID]
     *@return java.util.List<com.gx.community.teacher.pojo.ClassInfo>
     **/
    List<ClassInfo> queryClassInfoListByTeaUUID(@Param("teaUUID") String teaUUID);
}
