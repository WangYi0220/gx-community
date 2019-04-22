package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.JobPost;
import com.gx.community.pojo.Parent;
import com.gx.community.service.PatriarchClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/11 9:55
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/patriarch")
public class PatriarchClientController {
    @Autowired
    private PatriarchClientService patriarchClientService;

    @PostMapping("/post/add")
    public boolean addPost(JobPost jobPost){
        patriarchClientService.addPost(jobPost);
        return true;
    }

    //xyy
    @GetMapping("/post/get/{parUUID}/{nextPage}")
    public PageInfo<Map<String, Object>> queryJobPostByParUUID(@PathVariable("parUUID") String parUUID, @PathVariable("nextPage") int nextPage){
        return patriarchClientService.queryJobPostByParUUID(parUUID,nextPage);
    }

    //xyy
    @GetMapping("/post/delete/{jobUUID}")
    public boolean deleteJobPostByJobUUID(@PathVariable("jobUUID") String jobUUID){
        return patriarchClientService.deleteJobPostByJobUUID(jobUUID);
    }

    @PostMapping("/parent/login")
    Map<String, Object> login(Parent formData) {
        return patriarchClientService.login(formData);
    }

    @PostMapping("/parent/update")
    Boolean updateDefaultPassword(Parent formData) {
        return patriarchClientService.updateDefaultPassword(formData);
    }

    @GetMapping("/student/getStudent/{parUUID}")
    List<Map<String, Object>> queryStudentListByParUUID(@PathVariable("parUUID") String parUUID) {
        return patriarchClientService.queryStudentListByParUUID(parUUID);
    }

    @GetMapping("/score/getScore/{stuUUID}")
    Map<String, Object> queryStudentScoreByStuUUID(@PathVariable("stuUUID") String stuUUID) {
        return patriarchClientService.queryStudentScoreByStuUUID(stuUUID);
    }
}
