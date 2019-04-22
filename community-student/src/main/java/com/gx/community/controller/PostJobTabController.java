package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.JobPost;
import com.gx.community.service.PostJobTabService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 21:05
 * @description：就业贴操作
 * @modified By：
 */
@RestController
@RequestMapping("/post/job")
@Api(tags = "就业贴操作接口(xyy)")
public class PostJobTabController {

    @Autowired
    private PostJobTabService postJobTabService;

    @ApiOperation("查询全部就业列表")
    @GetMapping("/get/{nextPage}")
    public PageInfo<Map<String,Object>> queryJobPost(@PathVariable("nextPage") int nextPage) {
        return postJobTabService.queryJobPost(nextPage);
    }

    @ApiOperation("帖子详情")
    @GetMapping("/get/job/post/{jobUUID}")
    public JobPost queryJobPostByJobUUID(@PathVariable("jobUUID") String jobUUID) {
        return postJobTabService.queryJobPostByJobUUID(jobUUID);
    }

    @ApiOperation("根据行业查询就业贴")
    @GetMapping("/get/industryID/job/post/{industryID}/{nextPage}")
    public PageInfo<Map<String,Object>> queryJobPostByIndustryID(@PathVariable("industryID") int industryID,@PathVariable("nextPage") int nextPage) {
        return postJobTabService.queryJobPostByIndustryID(industryID,nextPage);
    }

    @ApiOperation("模糊查询就业贴")
    @PostMapping("/get/like/job/post")
    public PageInfo<Map<String,Object>> queryJobPostLikePostName(String postName, int nextPage) {
        return postJobTabService.queryJobPostLikePostName(postName,nextPage);
    }


}
