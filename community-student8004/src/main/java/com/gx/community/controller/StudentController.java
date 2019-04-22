package com.gx.community.controller;

import com.gx.community.pojo.Student;
import com.gx.community.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassInfoController
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@RestController
@RequestMapping("/student")
@Api(tags = "学生信息操作接口(lxl)")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation("上传用户头像")
    @RequestMapping(value = "/upHeadImg", method = RequestMethod.POST)
    public boolean upHeadImg(MultipartFile file, String stuUUID) {
        studentService.upHeadImg(file, stuUUID);
        return true;
    }

    @ApiOperation("根据班级编号查询与当前学生同班的学生信息")
    @GetMapping("/list/{classUUID}")
    public List<Map<String, Object>> queryStudentListByClassUUID(@PathVariable("classUUID") String classUUID) {
        return studentService.queryStudentListByClassUUID(classUUID);
    }

    @ApiOperation("根据学生编号查询对应的学生信息")
    @GetMapping("/get/{stuUUID}")
    public Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID) {
        return studentService.queryByStuUUID(stuUUID);
    }

    @ApiOperation("学生登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNO", value = "学号", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query")
    })
    @PostMapping("/login")
    public Map<String, Object> login(@ApiIgnore @RequestBody Student student) {
        return studentService.login(student);
    }

}
