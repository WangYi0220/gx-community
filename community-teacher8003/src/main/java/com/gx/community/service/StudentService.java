package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
/**
 *@Author lxl
 *@Description service:StudentService
 *@Date 9:37 2019/4/8
 **/
public interface StudentService {
    /**
     *@Author lxl
     *@Description 根据班级编号查看对应班级所有学生信息列表(实现分页)
     *@Date 10:59 2019/4/8
     *@Param [classUUID,pageNum]
     *@return com.github.pagehelper.PageInfo<com.gx.community.teacher.pojo.Student>
     **/
    PageInfo<Student> queryStudentListByClassUUID(String classUUID,Integer pageNum);

    /**
      *@Author lxl
      *@Description 根据学生编号查看对应学生的详细信息
      *@Date 10:51 2019/4/8
      *@Param [stuUUID]
      *@return java.util.Map<java.lang.String,java.lang.Object>
      **/
    Map<String,Object> queryByStuUUID(String stuUUID);

    void addStudent(MultipartFile multipartFile, String classUUID);
}
