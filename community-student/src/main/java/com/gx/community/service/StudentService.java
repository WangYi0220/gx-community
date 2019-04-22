package com.gx.community.service;

import com.gx.community.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 *@Author lxl
 *@Description service:StudentService
 *@Date 15:08 2019/4/1
 **/
public interface StudentService {

    void upHeadImg(MultipartFile file, String stuUUID);

    /**
      *@Author shiloh
      *@Description 查看与当前学生同班的学生信息列表
      *@Date 17:21 2019/4/1
      *@Param [classUUID]
      *@return java.util.List<com.gx.community.pojo.Student>
      **/
    List<Map<String,Object>> queryStudentListByClassUUID(@Param("classUUID") String classUUID);

    /**
      *@Author shiloh
      *@Description 根据学生编号查看对应的学生信息
      *@Date 17:22 2019/4/1
      *@Param [stuUUID]
      *@return com.gx.community.pojo.Student
      **/
    Map<String,Object> queryByStuUUID(@Param("stuUUID") String stuUUID);

    /**
     *@Author shiloh
     *@Description 学生登陆
     *@Date 17:22 2019/4/1
     *@Param [stuUUID]
     *@return com.gx.community.pojo.Student
     **/
    Map<String,Object> login(Student student);
}
