package com.gx.community.controller;

import com.gx.community.service.StudentScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiloh
 * @Date Created in 2019/4/8 19:28
 * @description 学生成绩
 * @modified By:
 */
@RestController
@RequestMapping("/score")
@Api(tags = "学生成绩操作接口(lxl)")
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;


    @ApiOperation(value = "学生成绩基础信息下载(班级为单位)", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/download/{classUUID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<InputStreamResource> downloadStudentBaseInfoByClassUUID(@PathVariable("classUUID") String classUUID){
        return studentScoreService.downloadStudentScoreBaseInfoByClassUUID(classUUID);
    }
}
