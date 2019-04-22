package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.DownloadFileUtil;
import com.gx.community.pojo.Student;
import com.gx.community.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description controller:StudentController
 * @Author lxl
 * @Date 2019/4/8
 * @Version 1.0
 **/
@RestController
@RequestMapping("/student")
@Api(tags = "学生操作接口(lxl)")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private static final String PATH = "/usr/community/file";
    private static final String FILENAME = "student.xlsx";
    private static final String NAME = "学生信息模板";

    @ApiOperation(value = "学生信息模板下载", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object downloadTeacherModel() {
        ResponseEntity<InputStreamResource> response = null;
        try {
            response = DownloadFileUtil.download(PATH, FILENAME, NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    @RequestMapping(value = "/list/{classUUID}/{pageNum}", method = RequestMethod.GET)
    @ApiOperation("根据班级编号查看对应班级所有学生信息列表")
    public PageInfo<Student> queryStudentListByClassUUID(@PathVariable("classUUID") String classUUID,
                                                         @PathVariable("pageNum") Integer pageNum) {
        return studentService.queryStudentListByClassUUID(classUUID, pageNum);
    }


    @RequestMapping(value = "/get/{stuUUID}", method = RequestMethod.GET)
    @ApiOperation("根据学生编号查看对应学生的详细信息")
    public Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID) {
        return studentService.queryByStuUUID(stuUUID);
    }

    @ApiOperation("导入学生信息")
    @PostMapping("/import")
    public boolean addStudent(MultipartFile multipartFile, String classUUID){
        studentService.addStudent(multipartFile, classUUID);
        return true;
    }
}
