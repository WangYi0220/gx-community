package com.gx.community.controller;

import com.gx.community.pojo.ClassInfo;
import com.gx.community.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description controller:TeacherController
 * @Author lxl
 * @Date 2019/4/8
 * @Version 1.0
 **/
@RestController
@RequestMapping("/teacher")
@Api(tags = "教师操作接口(lxl)")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @RequestMapping(value = "/list/{teaUUID}/{grade}", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teaUUID", value = "教师编号", paramType = "path"),
            @ApiImplicitParam(name = "grade", value = "年级", paramType = "path"),
    })
    @ApiOperation("根据年级查看当前教师所带班级列表")
    public List<Map<String, Object>> queryClassInfoListByTeaUUIDAndGrade(@PathVariable("teaUUID") String teaUUID,
                                                                         @PathVariable("grade") String grade) {
        return teacherService.queryClassInfoListByTeaUUIDAndGrade(teaUUID, grade);
    }

    @ApiOperation("导入学生成绩信息")
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Boolean addParent(MultipartFile multipartFile){
        teacherService.importStudentScoreInfo(multipartFile);
        return true;
    }

    @RequestMapping(value = "/listByTeaUUID/{teaUUID}",method = RequestMethod.GET)
    @ApiOperation("根据教师编号查询班级信息列表")
    public List<ClassInfo> queryClassInfoListByTeaUUID(@PathVariable("teaUUID") String teaUUID){
        List<ClassInfo> classInfoListByTeaUUID = teacherService.queryClassInfoListByTeaUUID(teaUUID);
        return classInfoListByTeaUUID;
    }
}
