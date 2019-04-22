package com.gx.community.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

/**
 * @author shiloh
 * @Date Created in 2019/4/8 19:07
 * @description 学生成绩
 * @modified By:
 */
public interface StudentScoreService {
    /**
      *@Author lxl
      *@Description 根据班级编号查询学生成绩基本信息
      *@Date 19:17 2019/4/8
      *@Param [classUUID]
      *@return org.springframework.http.ResponseEntity<org.springframework.core.io.InputStreamResource>
      **/
    ResponseEntity<InputStreamResource> downloadStudentScoreBaseInfoByClassUUID(String classUUID);
}
