package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.JobPost;
import com.gx.community.service.ParentPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 22:35
 * @description：就业贴操作
 * @modified By：
 */
@RestController
@RequestMapping("/post")
@Api(tags = "就业贴操作接口(lxl)")
public class ParentPostController {

    @Autowired
    private ParentPostService parentPostService;

    @ApiOperation("家长查看自己发布的就业贴")
    @GetMapping("/get/{parUUID}/{nextPage}")
    public PageInfo<Map<String, Object>> queryJobPostByParUUID(@PathVariable("parUUID") String parUUID, @PathVariable("nextPage") int nextPage) {
        return parentPostService.queryJobPostByParUUID(parUUID, nextPage);
    }

    @ApiOperation("家长删除自己发布的就业贴")
    @GetMapping("/delete/{jobUUID}")
    public boolean deleteJobPostByJobUUID(@PathVariable("jobUUID") String jobUUID) {
        return parentPostService.deleteJobPostByJobUUID(jobUUID);
    }

    @PostMapping("/add")
    public boolean addPost(@ApiIgnore @RequestBody JobPost jobPost) {
        return parentPostService.addPost(jobPost);
    }
}
