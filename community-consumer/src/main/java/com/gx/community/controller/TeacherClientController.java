package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.ClassInfo;
import com.gx.community.pojo.GraduateJob;
import com.gx.community.pojo.Student;
import com.gx.community.pojo.Teacher;
import com.gx.community.service.TeacherClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/11 10:24
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/teacher")
public class TeacherClientController {
    @Autowired
    private TeacherClientService teacherClientService;

    @PostMapping("/student/import")
    public boolean addStudent(MultipartFile multipartFile, String classUUID) {
        return teacherClientService.addStudent(multipartFile, classUUID);
    }

    @RequestMapping(value = "/student/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<InputStreamResource> downloadTeacherModel() {
        return teacherClientService.downloadTeacherModel();
    }

    @RequestMapping(value = "/score/download/{classUUID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<InputStreamResource> downloadStudentBaseInfoByClassUUID(@PathVariable("classUUID") String classUUID) {
        return teacherClientService.downloadStudentBaseInfoByClassUUID(classUUID);
    }

    @GetMapping("/classInfo/get/{classUUID}")
    Map<String, Object> queryByClassUUID(@PathVariable("classUUID") String classUUID) {
        return teacherClientService.queryByClassUUID(classUUID);
    }

    @GetMapping("/job/getName/{stuName}")
    List<Map<String, Object>> queryGraduateLikeStuName(@PathVariable String stuName) {
        return teacherClientService.queryGraduateLikeStuName(stuName);
    }

    @GetMapping("/job/get/{stuUUID}")
    List<Map<String, Object>> queryGraduateJobByStuUUID(@PathVariable String stuUUID) {
        return teacherClientService.queryGraduateJobByStuUUID(stuUUID);
    }

    @PostMapping("/job/add")
    String insertGraduateJob(GraduateJob graduateJob) {
        return teacherClientService.insertGraduateJob(graduateJob);
    }

    @GetMapping("/student/list/{classUUID}/{pageNum}")
    PageInfo<Student> queryStudentListByClassUUID(@PathVariable("classUUID") String classUUID, @PathVariable("pageNum") Integer pageNum) {
        return teacherClientService.queryStudentListByClassUUID(classUUID, pageNum);
    }

    @GetMapping("/student/get/{stuUUID}")
    Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID) {
        return teacherClientService.queryByStuUUID(stuUUID);
    }

    @PostMapping("/teacherAdmin/login")
    Teacher login(Teacher teacher) {
        return teacherClientService.login(teacher);
    }

    @PostMapping("/teacherAdmin/update")
    boolean updateTeacherAdmin(@RequestParam String newPassword, @RequestParam String telephone) {
        return teacherClientService.updateTeacherAdmin(newPassword, telephone);
    }

    @GetMapping("/teacher/list/{teaUUID}/{grade}")
    List<Map<String, Object>> queryClassInfoListByTeaUUIDAndGrade(@PathVariable("teaUUID") String teaUUID,
                                                                  @PathVariable("grade") String grade) {
        return teacherClientService.queryClassInfoListByTeaUUIDAndGrade(teaUUID, grade);
    }

    @PostMapping("/teacher/import")
    Boolean addParent(MultipartFile multipartFile) {
        teacherClientService.addParent(multipartFile);
        return true;
    }

    @GetMapping("/teacher/listByTeaUUID/{teaUUID}")
    List<ClassInfo> queryClassInfoListByTeaUUID(@PathVariable("teaUUID") String teaUUID) {
        return teacherClientService.queryClassInfoListByTeaUUID(teaUUID);
    }
}
