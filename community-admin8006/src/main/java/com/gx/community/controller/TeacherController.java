package com.gx.community.controller;

import com.gx.community.common.utils.DownloadFileUtil;
import com.gx.community.pojo.Teacher;
import com.gx.community.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 16:23
 * @description：管理-教师
 * @modified By：
 */
@Api(tags = "教师")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    private static final String PATH = "/usr/community/file";
    private static final String FILENAME = "teacher.xlsx";
    private static final String NAME = "教师信息模板";

    @ApiOperation(value = "教师信息模板下载", httpMethod = "GET", produces = "application/json;charset=UTF-8")
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

    @ApiOperation("导入教师信息(监听状态码500，联系电话有重复值或excel格式错误)")
    @RequestMapping(value = "/import", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean importTeacherInfo(@RequestPart("multipartFile") MultipartFile multipartFile) {
        teacherService.importTeacherInfo(multipartFile);
        return true;
    }

    @ApiOperation("修改老师信息（姓名、电话）")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return true;
    }

    @ApiOperation("根据教师姓名模糊查询")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public List<Map<String, Object>> getTeacherByTeaName(String teaName) {
        return teacherService.getTeacherByTeaName(teaName);
    }

    @ApiOperation("根据教师编号查询教师详情")
    @RequestMapping(value = "/get/info/{teaUUID}", method = RequestMethod.GET)
    public Teacher getTeacherByTeaUUID(@PathVariable("teaUUID") String teaUUID) {
        return teacherService.getTeacherByTeaUUID(teaUUID);
    }
}
