package com.gx.community.controller;

import com.gx.community.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author shiloh
 * @Date Created in 2019/4/9 14:25
 * @description 学生
 * @modified By:
 */
@RestController
@RequestMapping("/student")
@Api(tags = "学生操作接口(lxl)")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudent/{parUUID}",method = RequestMethod.GET)
    @ApiOperation("根据家长编号查询自己小孩在校的基本信息")
    public List<Map<String,Object>> queryStudentListByParUUID(@PathVariable("parUUID") String parUUID){
        return studentService.queryStudentListByParUUID(parUUID);
    }
}
