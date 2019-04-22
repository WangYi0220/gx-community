package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@FeignClient(value = "MICROSERVICECLOUD-STUDENT", fallbackFactory = StudentClientFallbackFactory.class)
public interface StudentClientService {

    @GetMapping("/industry/get")
    public List<Industry> queryIndustry();

    @GetMapping("/industry/get/industry/{industry}")
    public List<Industry> queryIndustryLikeIndustry(@PathVariable("industry") String industry);

    @GetMapping("/post/job/get/{nextPage}")
    public PageInfo<Map<String,Object>> queryJobPost(@PathVariable("nextPage") int nextPage);

    @GetMapping("/post/job/get/job/post/{jobUUID}")
    public JobPost queryJobPostByJobUUID(@PathVariable("jobUUID") String jobUUID);

    @GetMapping("/post/job/get/industryID/job/post/{industryID}/{nextPage}")
    public PageInfo<Map<String,Object>> queryJobPostByIndustryID(@PathVariable("industryID") int industryID,@PathVariable("nextPage") int nextPage);

    @PostMapping("/post/job/get/like/job/post")
    public PageInfo<Map<String,Object>> queryJobPostLikePostName(@RequestParam("postName") String postName, @RequestParam("nextPage") int nextPage);


    @GetMapping("/classInfo/get/{classUUID}")
    ClassInfo queryByClassUUID(@PathVariable("classUUID") String classUUID);

    @GetMapping(value = "/class/schedule/get/{classUUID}")
    ClassSchedule getClassScheduleByClassUUID(@PathVariable("classUUID") String classUUID);

    @GetMapping("/post/list/{tabID}/{nextPage}")
    PageInfo<Map<String, Object>> queryPostByTabName(@PathVariable("tabID") int tabID,@PathVariable("nextPage") int nextPage);

    @GetMapping("/post/all/{nextPage}")
    PageInfo<Map<String, Object>> getPostList(@PathVariable("nextPage") int nextPage);

    @PostMapping("/post/add")
    String insertPost(Post post);

    @GetMapping("/post/get/{postUUID}")
    Map<String, Object> getPostByPostUUID(@PathVariable("postUUID") String postUUID);

    @GetMapping("/post/getForPar/{postUUID}")
    Map<String, Object> getPostByPostUUIDForPar(@PathVariable("postUUID") String postUUID);

    @GetMapping("/post/discuss/get/{postUUID}")
    List<Map<String,Object>> postDiscussByPostUUID(@PathVariable("postUUID") String postUUID);

    @PostMapping("/post/discuss/add")
    String insertPostDiscuss(PostDiscuss postDiscuss);

    @GetMapping("/post/discuss/del/{discussUUID}")
    boolean delPostDiscuss(@PathVariable("discussUUID") String discussUUID);

    @GetMapping("/post/tab/list")
    List<PostTab> getPostTabList();

    @PostMapping("/student/upHeadImg")
    boolean upHeadImg(@RequestParam("file") MultipartFile file, @RequestParam("stuUUID") String stuUUID);

    @GetMapping("/student/list/{classUUID}")
    List<Map<String,Object>> queryStudentListByClassUUID(@PathVariable("classUUID") String classUUID);

    @GetMapping("/student/get/{stuUUID}")
    Map<String,Object> queryByStuUUID(@PathVariable("stuUUID") String stuUUID);

    @RequestMapping(value = "/student/login", method = RequestMethod.POST)
    Map<String,Object> login(@RequestBody Student student);

    @GetMapping("/score/list/{semester}/{stuUUID}")
    List<StudentScore> queryScoreListByStuUUID(@PathVariable("semester") String semester, @PathVariable("stuUUID") String stuUUID);

    @GetMapping("/utils/sendCode/{mobile}")
    boolean registerCode(@PathVariable("mobile") String mobile);

    @GetMapping("/wx/user/login/{code}")
    String login(@PathVariable("code") String code);
}
