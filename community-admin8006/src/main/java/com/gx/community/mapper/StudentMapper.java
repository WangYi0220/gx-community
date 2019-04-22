package com.gx.community.mapper;

import com.gx.community.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 *@Author lxl
 *@Description mapper:StudentMapper
 *@Date 9:20 2019/4/3
 **/
public interface StudentMapper {
    /**
     * @Auther WangYi
     * @param classUUID
     * @return
     */
    List<Map<String, Object>> getStudentBaseInfoByClassUUID(@Param("classUUID") String classUUID);

    /**
      *@Author lxl
      *@Description 根据班级编号查看对应的学生信息列表，实现分页功能
      *@Date 19:48 2019/4/3
      *@Param [classUUID]
      *@return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
      **/
    List<Map<String, Object>> getStudentInfoByClassUUID(@Param("classUUID") String classUUID);

    /**
      *@Author lxl
      *@Description 根据学生编号查询对应的学生信息
      *@Date 8:39 2019/4/3
      *@Param [stuUUID]
      *@return java.util.Map<java.lang.String,java.lang.Object>
      **/
    Map<String,Object> queryByStuUUID(@Param("stuUUID") String stuUUID);

    /**
      *@Author lxl
      *@Description 添加学生信息
      *@Date 8:39 2019/4/3
      *@Param [student]
      *@return void
      **/
    void addStudent(Student student);

    /**
      *@Author lxl
      *@Description 删除学生信息
      *@Date 8:40 2019/4/3
      *@Param [stuUUID]
      *@return void
      **/
    void delStudent(@Param("stuUUID") String stuUUID);

    /**
      *@Author lxl
      *@Description 修改学生信息
      *@Date 8:40 2019/4/3
      *@Param [student]
      *@return void
      **/
    void updateStudent(Student student);
}
