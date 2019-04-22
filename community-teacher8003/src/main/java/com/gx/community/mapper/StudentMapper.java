package com.gx.community.mapper;

import com.gx.community.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 *@Author lxl
 *@Description mapper:StudentMapper
 *@Date 9:37 2019/4/8
 **/
public interface StudentMapper {
    /**
      *@Author lxl
      *@Description 根据班级编号查看对应班级所有学生信息列表
      *@Date 10:46 2019/4/8
      *@Param [classUUID]
      *@return java.util.List<com.gx.community.teacher.pojo.Student>
      **/
    List<Student> queryStudentListByClassUUID(@Param("classUUID") String classUUID);

    /**
      *@Author lxl
      *@Description 根据学生编号查看对应学生的详细信息
      *@Date 10:51 2019/4/8
      *@Param [stuUUID]
      *@return java.util.Map<java.lang.String,java.lang.Object>
      **/
    Map<String,Object> queryByStuUUID(@Param("stuUUID") String stuUUID);

    void addStudent(Student student);
}
