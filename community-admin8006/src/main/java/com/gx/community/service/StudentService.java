package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.Map;
/**
  *@Author lxl
  *@Description service:StudentService
  *@Date 9:20 2019/4/3
  **/
public interface StudentService {
    /**
     * @Auther WangYi
     * @param classUUID
     * @return
     */
    ResponseEntity<InputStreamResource> downloadStudentBaseInfoByClassUUID(String classUUID);

    /**
     *@Author lxl
     *@Description 根据班级编号查看对应的学生信息列表，实现分页功能
     *@Date 19:48 2019/4/3
     *@Param [classUUID,pageNum]
     *@return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    PageInfo<Map<String, Object>> getStudentInfoByClassUUID(@Param("classUUID") String classUUID,Integer pageNum);

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
     *@Description 导入家长信息,并导入家长与学生关联表的信息
     *@Date 8:39 2019/4/3
     *@Param [student]
     *@return java.lang.String
     **/
    String addStudent(Student student);

    /**
     *@Author lxl
     *@Description 删除学生信息
     *@Date 8:40 2019/4/3
     *@Param [stuUUID]
     *@return java.lang.Boolean
     **/
    Boolean delStudent(@Param("stuUUID") String stuUUID);

    /**
     *@Author lxl
     *@Description 修改学生信息
     *@Date 8:40 2019/4/3
     *@Param [student]
     *@return java.lang.Boolean
     **/
    Boolean updateStudent(Student student);
}
