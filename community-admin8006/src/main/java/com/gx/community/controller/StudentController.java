package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.Student;
import com.gx.community.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 22:12
 * @description：学生
 * @modified By：
 */
@Api(tags = "学生信息操作接口(lxl)")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "学生基础信息下载(班级为单位)", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/download/{classUUID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object downloadStudentBaseInfoByClassUUID(@PathVariable("classUUID") String classUUID) {
        return studentService.downloadStudentBaseInfoByClassUUID(classUUID);
    }

    @ApiOperation("根据班级编号查看对应的学生信息列表")
    @RequestMapping(value = "/list/{classUUID}/{pageNum}", method = RequestMethod.GET)
    public PageInfo<Map<String, Object>> getStudentInfoByClassUUID(@PathVariable("classUUID") String classUUID,
                                                                   @PathVariable("pageNum") Integer pageNum) {
        return studentService.getStudentInfoByClassUUID(classUUID,pageNum);
    }

    @ApiOperation("根据学生编号查看对应的学生信息")
    @RequestMapping(value = "/get/{stuUUID}", method = RequestMethod.GET)
    public Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID) {
        return studentService.queryByStuUUID(stuUUID);
    }

    @ApiOperation("添加学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNO", value = "学号", paramType = "query"),
            @ApiImplicitParam(name = "classUUID", value = "班级编号", paramType = "query"),
            @ApiImplicitParam(name = "stuName", value = "姓名", paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "性别", paramType = "query"),
            @ApiImplicitParam(name = "nationID", value = "民族", paramType = "query"),
            @ApiImplicitParam(name = "accountLoc", value = "户口所在地", paramType = "query"),
            @ApiImplicitParam(name = "telephone", value = "联系电话", paramType = "query"),
            @ApiImplicitParam(name = "idCard", value = "身份证号", paramType = "query"),
            @ApiImplicitParam(name = "polStatus", value = "政治面貌", paramType = "query"),
            @ApiImplicitParam(name = "accountType", value = "户口类型", paramType = "query"),
            @ApiImplicitParam(name = "familyAdd", value = "家庭住址", paramType = "query"),
            @ApiImplicitParam(name = "graSchool", value = "毕业中学", paramType = "query"),
            @ApiImplicitParam(name = "eduLevel", value = "文化程度", paramType = "query"),
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ApiIgnore @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @ApiOperation("删除学生信息")
    @RequestMapping(value = "/delete/{stuUUID}", method = RequestMethod.GET)
    public Boolean delStudent(@PathVariable("stuUUID") String stuUUID) {
        studentService.delStudent(stuUUID);
        return true;
    }

    @ApiOperation("修改学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classUUID", value = "班级编号", paramType = "query"),
            @ApiImplicitParam(name = "stuName", value = "姓名", paramType = "query"),
            @ApiImplicitParam(name = "telephone", value = "联系电话", paramType = "query"),
            @ApiImplicitParam(name = "idCard", value = "身份证号", paramType = "query"),
            @ApiImplicitParam(name = "polStatus", value = "政治面貌", paramType = "query"),
            @ApiImplicitParam(name = "familyAdd", value = "家庭住址", paramType = "query"),
            @ApiImplicitParam(name = "stuUUID", value = "学生编号", paramType = "query"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean updateStudent(@ApiIgnore @RequestBody Student student) {
        studentService.updateStudent(student);
        return true;
    }
}
