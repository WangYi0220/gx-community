package com.gx.community.mapper;

import org.apache.ibatis.annotations.Param;

import com.gx.community.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author lxl
 * @Description mapper:StudentMapper
 * @Date 15:08 2019/4/1
 **/
public interface StudentMapper {
    /**
     * @return java.util.List<com.gx.community.pojo.Student>
     * @Author shiloh
     * @Description 查看与当前学生同班的学生信息列表
     * @Date 17:21 2019/4/1
     * @Param [classUUID]
     **/
    List<Map<String, Object>> queryStudentListByClassUUID(@Param("classUUID") String classUUID);

    /**
     * @return com.gx.community.pojo.Student
     * @Author shiloh
     * @Description 根据学生编号查看对应的学生信息
     * @Date 17:22 2019/4/1
     * @Param [stuUUID]
     **/
    Map<String, Object> queryByStuUUID(@Param("stuUUID") String stuUUID);

    /**
     * @return com.gx.community.pojo.Student
     * @Author lxl
     * @Description 用户登录
     * @Date 21:20 2019/4/1
     * @Param [student]
     **/
    Map<String, Object> login(Student student);

    void upHeadImg(@Param("path") String path, @Param("stuUUID") String stuUUID);
}
