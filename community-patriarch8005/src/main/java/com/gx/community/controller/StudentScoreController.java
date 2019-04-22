package com.gx.community.controller;

import com.gx.community.service.StudentScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author shiloh
 * @Date Created in 2019/4/9 14:30
 * @description 学生成绩
 * @modified By:
 */
@RestController
@RequestMapping("/score")
@Api(tags = "学生成绩操作接口(lxl)")
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;

    @RequestMapping(value = "/getScore/{stuUUID}", method = RequestMethod.GET)
    @ApiOperation("根据学生编号查询自己小孩的成绩信息")
    public Map<String, Object> queryStudentScoreByStuUUID(@PathVariable("stuUUID") String stuUUID) {
        return studentScoreService.queryStudentScoreByStuUUID(stuUUID);
    }
}
