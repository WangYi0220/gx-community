package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.Post;
import com.gx.community.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/1 17:01
 * @description：帖子操作
 * @modified By：
 */
@RestController
@Api(tags = {"帖子操作（xyy）"})
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation("根据帖子分类编号查询")
    @GetMapping("/list/{tabID}/{nextPage}")
    public PageInfo<Map<String, Object>> queryPostByTabName(@PathVariable("tabID") int tabID,@PathVariable("nextPage") int nextPage) {
        return postService.queryPostByTabName(tabID,nextPage);
    }

    @ApiOperation("获取所有帖子")
    @GetMapping("/all/{nextPage}")
    public PageInfo<Map<String, Object>> getPostList(@PathVariable("nextPage")int nextPage) {
        return postService.getPostList(nextPage);
    }

    @PostMapping("/add")
    @ApiOperation("发布帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postTitle", value = "帖子标题", paramType = "query"),
            @ApiImplicitParam(name = "postTab", value = "帖子分类", paramType = "query"),
            @ApiImplicitParam(name = "stuUUID", value = "发帖者编号", paramType = "query"),
            @ApiImplicitParam(name = "postContent", value = "内容", paramType = "query")
    })
    public String insertPost(@ApiIgnore @RequestBody Post post) {
        return postService.insertPost(post);
    }

    @ApiOperation("根据帖子编号查询帖子详情")
    @RequestMapping(value = "/get/{postUUID}", method = RequestMethod.GET)
    public Map<String, Object> getPostByPostUUID(@PathVariable("postUUID") String postUUID) {
        return postService.getPostByPostUUID(postUUID);
    }
}

