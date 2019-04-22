package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.JobPost;
import com.gx.community.pojo.Parent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@FeignClient(value = "MICROSERVICECLOUD-PATRIARCH")
public interface PatriarchClientService {

    @PostMapping("/post/add")
    public boolean addPost(JobPost jobPost);

    @GetMapping("/post/delete/{jobUUID}")
    public boolean deleteJobPostByJobUUID(@PathVariable("jobUUID") String jobUUID);

    @GetMapping("/post/get/{parUUID}/{nextPage}")
    public PageInfo<Map<String, Object>> queryJobPostByParUUID(@PathVariable("parUUID") String parUUID, @PathVariable("nextPage") int nextPage);

    @PostMapping("/parent/login")
    Map<String, Object> login(Parent formData);

    @PostMapping("/parent/update")
    Boolean updateDefaultPassword(Parent formData);

    @GetMapping("/student/getStudent/{parUUID}")
    List<Map<String,Object>> queryStudentListByParUUID(@PathVariable("parUUID") String parUUID);

    @GetMapping("/score/getScore/{stuUUID}")
    Map<String,Object> queryStudentScoreByStuUUID(@PathVariable("stuUUID") String stuUUID);
}
