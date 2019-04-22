package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.*;
import com.gx.community.service.AdminClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/11 14:53
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/admin")
public class AdminClientController {
    @Autowired
    private AdminClientService adminClientService;

    //xyy
    @RequestMapping(value = "/industry/add", method = RequestMethod.POST)
    public boolean insertIndustry(Industry industry) {
        return adminClientService.insertIndustry(industry);
    }

    @PostMapping("/admin/login")
    Object login(Admin admin) {
        return adminClientService.login(admin);
    }

    @PostMapping("/admin/add")
    boolean addAdmin(Admin admin) {
        return adminClientService.addAdmin(admin);
    }

    @GetMapping("/admin/del/{adminUUID}")
    boolean delAdmin(@PathVariable("adminUUID") int adminUUID) {
        return adminClientService.delAdmin(adminUUID);
    }

    @GetMapping("/classInfo/list/{colID}/{pageNum}")
    PageInfo<Map<String, Object>> queryClassInfoByColID(@PathVariable("colID") String colID,
                                                        @PathVariable("pageNum") Integer pageNum) {
        return adminClientService.queryClassInfoByColID(colID, pageNum);
    }

    @PostMapping("/classInfo/addTea")
    boolean addClassTeacher(@RequestBody List<ClassInfo> params) {
        return adminClientService.addClassTeacher(params);
    }

    @GetMapping("/class/schedule/get/{classUUID}")
    ClassSchedule getClassScheduleByClassUUID(@PathVariable("classUUID") String classUUID) {
        return adminClientService.getClassScheduleByClassUUID(classUUID);
    }

    @PostMapping("/class/schedule/add")
    String addClassSchedule(ClassSchedule classSchedule) {
        return adminClientService.addClassSchedule(classSchedule);
    }

    @PostMapping("/class/schedule/update")
    boolean updateClassSchedule(ClassSchedule classSchedule) {
        return adminClientService.updateClassSchedule(classSchedule);
    }

    @GetMapping("/college/list")
    List<College> queryCollegeList() {
        return adminClientService.queryCollegeList();
    }

    @RequestMapping(value = "/parent/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    Object downloadModel() {
        return adminClientService.downloadModel();
    }

    @GetMapping("/parent/list/{pageNum}")
    PageInfo<Parent> queryParentList(@PathVariable("pageNum") Integer pageNum) {
        return adminClientService.queryParentList(pageNum);
    }

    @GetMapping("/parent/get/{parUUID}")
    Parent queryByParUUID(@PathVariable("parUUID") String parUUID) {
        return adminClientService.queryByParUUID(parUUID);
    }

    @RequestMapping(value = "/parent/import", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Boolean addParent(MultipartFile multipartFile) {
        return adminClientService.addParent(multipartFile);
    }

    @GetMapping("/parent/delete/{parUUID}")
    Boolean delParent(@PathVariable("parUUID") String parUUID) {
        return adminClientService.delParent(parUUID);
    }

    @PostMapping("/parent/update")
    Boolean updateParent(Parent parent) {
        return adminClientService.updateParent(parent);
    }

    @RequestMapping(value = "/student/download/{classUUID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    Object downloadStudentBaseInfoByClassUUID(@PathVariable("classUUID") String classUUID) {
        return adminClientService.downloadStudentBaseInfoByClassUUID(classUUID);
    }

    @GetMapping("/student/list/{classUUID}/{pageNum}")
    PageInfo<Map<String, Object>> getStudentInfoByClassUUID(@PathVariable("classUUID") String classUUID, @PathVariable("pageNum") Integer pageNum) {
        return adminClientService.getStudentInfoByClassUUID(classUUID, pageNum);
    }

    @GetMapping("/student/get/{stuUUID}")
    Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID) {
        return adminClientService.queryByStuUUID(stuUUID);
    }

    @PostMapping("/student/add")
    String addStudent(Student student) {
        return adminClientService.addStudent(student);
    }

    @GetMapping("/student/delete/{stuUUID}")
    Boolean delStudent(@PathVariable("stuUUID") String stuUUID) {
        return adminClientService.delStudent(stuUUID);
    }

    @PostMapping("/student/update")
    Boolean updateStudent(Student student) {
        return adminClientService.updateStudent(student);
    }

    @RequestMapping(value = "/teacher/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    Object downloadTeacherModel() {
        return adminClientService.downloadTeacherModel();
    }

    @PostMapping("/teacher/import")
    Boolean importTeacherInfo(@RequestPart("multipartFile") MultipartFile multipartFile) {
        return adminClientService.importTeacherInfo(multipartFile);
    }

    @PostMapping("/teacher/update")
    boolean updateTeacher(Teacher teacher) {
        return adminClientService.updateTeacher(teacher);
    }

    @PostMapping("/teacher/get")
    List<Map<String, Object>> getTeacherByTeaName(String teaName) {
        return adminClientService.getTeacherByTeaName(teaName);
    }

    @GetMapping(value = "/teacher/get/info/{teaUUID}")
    public Teacher getTeacherByTeaUUID(@PathVariable("teaUUID") String teaUUID){
        return adminClientService.getTeacherByTeaUUID(teaUUID);
    }
}
