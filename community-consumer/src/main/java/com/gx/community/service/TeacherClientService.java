package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.ClassInfo;
import com.gx.community.pojo.GraduateJob;
import com.gx.community.pojo.Student;
import com.gx.community.pojo.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@FeignClient(value = "MICROSERVICECLOUD-TEACHER", fallbackFactory = TeacherClientFallbackFactory.class)
public interface TeacherClientService {

    @PostMapping("/student/import")
    public boolean addStudent(@RequestParam("multipartFile") MultipartFile multipartFile, @RequestParam("classUUID") String classUUID);

    @RequestMapping(value = "/student/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<InputStreamResource> downloadTeacherModel();

    @RequestMapping(value = "/score/download/{classUUID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<InputStreamResource> downloadStudentBaseInfoByClassUUID(@PathVariable("classUUID") String classUUID);

    @GetMapping("/classInfo/get/{classUUID}")
    Map<String, Object> queryByClassUUID(@PathVariable("classUUID") String classUUID);

    @GetMapping("/job/getName/{stuName}")
    List<Map<String, Object>> queryGraduateLikeStuName(@PathVariable("stuName") String stuName);

    @GetMapping("/job/get/{stuUUID}")
    List<Map<String, Object>> queryGraduateJobByStuUUID(@PathVariable("stuUUID") String stuUUID);

    @PostMapping("/job/add")
    String insertGraduateJob(GraduateJob graduateJob);

    @GetMapping("/student/list/{classUUID}/{pageNum}")
    PageInfo<Student> queryStudentListByClassUUID(@PathVariable("classUUID") String classUUID, @PathVariable("pageNum") Integer pageNum);

    @GetMapping("/student/get/{stuUUID}")
    Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID);

    @PostMapping("/teacherAdmin/login")
    Teacher login(Teacher teacher);

    @PostMapping("/teacherAdmin/update")
    boolean updateTeacherAdmin(@RequestParam("newPassword") String newPassword, @RequestParam("telephone") String telephone);

    @GetMapping("/teacher/list/{teaUUID}/{grade}")
    List<Map<String, Object>> queryClassInfoListByTeaUUIDAndGrade(@PathVariable("teaUUID") String teaUUID,
                                                                  @PathVariable("grade") String grade);

    @PostMapping("/teacher/import")
    Boolean addParent(MultipartFile multipartFile);

    @GetMapping("/teacher/listByTeaUUID/{teaUUID}")
    List<ClassInfo> queryClassInfoListByTeaUUID(@PathVariable("teaUUID") String teaUUID);
}
