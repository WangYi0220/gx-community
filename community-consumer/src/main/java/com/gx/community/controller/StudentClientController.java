package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.*;
import com.gx.community.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/10 15:09
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/student")
public class StudentClientController {

    @Autowired
    private StudentClientService studentClientService;


    //xyy
    @GetMapping("/industry/get")
    public List<Industry> queryIndustry() {
        return studentClientService.queryIndustry();
    }

    //xyy
    @GetMapping("/industry/get/industry/{industry}")
    public List<Industry> queryIndustryLikeIndustry(@PathVariable("industry") String industry) {
        return studentClientService.queryIndustryLikeIndustry(industry);
    }

    //xyy
    @GetMapping("/post/job/get/{nextPage}")
    public PageInfo<Map<String,Object>> queryJobPost(@PathVariable("nextPage") int nextPage) {
        return studentClientService.queryJobPost(nextPage);
    }

    //xyy
    @GetMapping("/post/job/get/job/post/{jobUUID}")
    public JobPost queryJobPostByJobUUID(@PathVariable("jobUUID") String jobUUID) {
        return studentClientService.queryJobPostByJobUUID(jobUUID);
    }

    //xyy/post/job/get/industryID/job/post/{industryID}/{nextPage}
    @GetMapping("/post/job/get/industryID/job/post/{industryID}/{nextPage}")
    public PageInfo<Map<String,Object>> queryJobPostByIndustryID(@PathVariable("industryID") int industryID,@PathVariable("nextPage") int nextPage) {
        return studentClientService.queryJobPostByIndustryID(industryID,nextPage);
    }
    //xyy
    @PostMapping("/post/job/get/like/job/post")
    public PageInfo<Map<String,Object>> queryJobPostLikePostName(String postName, int nextPage) {
        return studentClientService.queryJobPostLikePostName(postName,nextPage);
    }

    @GetMapping("/classInfo/get/{classUUID}")
    ClassInfo queryByClassUUID(@PathVariable("classUUID") String classUUID) {
        return studentClientService.queryByClassUUID(classUUID);
    }

    @GetMapping(value = "/class/schedule/get/{classUUID}")
    ClassSchedule getClassScheduleByClassUUID(@PathVariable("classUUID") String classUUID) {
        return studentClientService.getClassScheduleByClassUUID(classUUID);
    }

    @GetMapping("/post/list/{tabID}/{nextPage}")
    PageInfo<Map<String, Object>> queryPostByTabName(@PathVariable("tabID") int tabID,@PathVariable("nextPage") int nextPage) {
        return studentClientService.queryPostByTabName(tabID,nextPage);
    }

    @GetMapping("/post/all/{nextPage}")
    PageInfo<Map<String, Object>> getPostList(@PathVariable("nextPage") int nextPage) {
        return studentClientService.getPostList(nextPage);
    }

    @PostMapping("/post/add")
    String insertPost(Post post) {
        return studentClientService.insertPost(post);
    }

    @GetMapping("/post/get/{postUUID}")
    Map<String, Object> getPostByPostUUID(@PathVariable("postUUID") String postUUID){
        return studentClientService.getPostByPostUUID(postUUID);
    }

    @GetMapping("/post/getForPar/{postUUID}")
    Map<String, Object> getPostByPostUUIDForPar(@PathVariable("postUUID") String postUUID){
        return studentClientService.getPostByPostUUIDForPar(postUUID);
    }

    @GetMapping("/post/discuss/get/{postUUID}")
    List<Map<String, Object>> postDiscussByPostUUID(@PathVariable("postUUID") String postUUID){
        return studentClientService.postDiscussByPostUUID(postUUID);
    }

    @PostMapping("/post/discuss/add")
    String insertPostDiscuss(PostDiscuss postDiscuss){
        return studentClientService.insertPostDiscuss(postDiscuss);
    }

    @GetMapping("/post/discuss/del/{discussUUID}")
    boolean delPostDiscuss(@PathVariable("discussUUID") String discussUUID){
        studentClientService.delPostDiscuss(discussUUID);
        return true;
    }

    @GetMapping("/post/tab/list")
    List<PostTab> getPostTabList(){
        return studentClientService.getPostTabList();
    }

    @PostMapping("/student/upHeadImg")
    boolean upHeadImg(MultipartFile file, String stuUUID){
        studentClientService.upHeadImg(file, stuUUID);
        return true;
    }

    @GetMapping("/student/list/{classUUID}")
    List<Map<String, Object>> queryStudentListByClassUUID(@PathVariable("classUUID") String classUUID){
        return studentClientService.queryStudentListByClassUUID(classUUID);
    }

    @GetMapping("/student/get/{stuUUID}")
    Map<String, Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID){
        return studentClientService.queryByStuUUID(stuUUID);
    }

    @PostMapping("/student/login")
    Map<String, Object> login(Student student){
        return studentClientService.login(student);
    }

    @GetMapping("/score/list/{semester}/{stuUUID}")
    List<StudentScore> queryScoreListByStuUUID(@PathVariable("semester") String semester, @PathVariable("stuUUID") String stuUUID){
        return studentClientService.queryScoreListByStuUUID(semester, stuUUID);
    }

    @GetMapping("/utils/sendCode/{mobile}")
    boolean registerCode(@PathVariable("mobile") String mobile){
        studentClientService.registerCode(mobile);
        return true;
    }

    @GetMapping("/wx/user//login/{code}")
    String login(@PathVariable("code") String code){
        return studentClientService.login(code);
    }


}
