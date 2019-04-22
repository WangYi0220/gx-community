package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@FeignClient(value = "MICROSERVICECLOUD-ADMIN")
public interface AdminClientService {

    //xyy
    @RequestMapping(value = "/industry/add", method = RequestMethod.POST)
    public boolean insertIndustry(Industry industry);

    @PostMapping("/admin/login")
    Object login(Admin admin);

    @PostMapping("/admin/add")
    boolean addAdmin(Admin admin);

    @GetMapping("/admin/del/{adminUUID}")
    boolean delAdmin(@PathVariable("adminUUID") int adminUUID);

    @GetMapping("/classInfo/list/{colID}/{pageNum}")
    PageInfo<Map<String, Object>> queryClassInfoByColID(@PathVariable("colID") String colID, @PathVariable("pageNum") Integer pageNum);

    @PostMapping("/classInfo/addTea")
    boolean addClassTeacher(@RequestBody List<ClassInfo> params);

    @GetMapping("/class/schedule/get/{classUUID}")
    ClassSchedule getClassScheduleByClassUUID(@PathVariable("classUUID") String classUUID);

    @PostMapping("/class/schedule/add")
    String addClassSchedule(ClassSchedule classSchedule);

    @PostMapping("/class/schedule/update")
    boolean updateClassSchedule(ClassSchedule classSchedule);

    @GetMapping("/college/list")
    List<College> queryCollegeList();

    @RequestMapping(value = "/parent/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    Object downloadModel();

    @GetMapping("/parent/list/{pageNum}")
    PageInfo<Parent> queryParentList(@PathVariable("pageNum") Integer pageNum);

    @GetMapping("/parent/get/{parUUID}")
    Parent queryByParUUID(@PathVariable("parUUID") String parUUID);

    @RequestMapping(value = "/parent/import", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Boolean addParent(MultipartFile multipartFile);

    @GetMapping("/parent/delete/{parUUID}")
    Boolean delParent(@PathVariable("parUUID") String parUUID);

    @PostMapping("/parent/update")
    Boolean updateParent(Parent parent);

    @RequestMapping(value = "/student/download/{classUUID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    Object downloadStudentBaseInfoByClassUUID(@PathVariable("classUUID") String classUUID);

    @GetMapping("/student/list/{classUUID}/{pageNum}")
    PageInfo<Map<String, Object>> getStudentInfoByClassUUID(@PathVariable("classUUID") String classUUID, @PathVariable("pageNum") Integer pageNum);

    @GetMapping("/student/get/{stuUUID}")
    Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID);

    @PostMapping("/student/add")
    String addStudent(Student student);

    @GetMapping("/student/delete/{stuUUID}")
    Boolean delStudent(@PathVariable("stuUUID") String stuUUID);

    @PostMapping("/student/update")
    Boolean updateStudent(Student student);

    @RequestMapping(value = "/teacher/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    Object downloadTeacherModel();

    @RequestMapping(value = "/teacher/import", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Boolean importTeacherInfo(@RequestPart("multipartFile") MultipartFile multipartFile);

    @PostMapping("/teacher/update")
    boolean updateTeacher(Teacher teacher);

    @PostMapping("/teacher/get")
    List<Map<String, Object>> getTeacherByTeaName(@RequestParam("teaName") String teaName);

    @GetMapping(value = "/teacher/get/info/{teaUUID}")
    public Teacher getTeacherByTeaUUID(@PathVariable("teaUUID") String teaUUID);
}
