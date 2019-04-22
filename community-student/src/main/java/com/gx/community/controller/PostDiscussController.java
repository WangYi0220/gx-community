package com.gx.community.controller;

import com.gx.community.pojo.PostDiscuss;
import com.gx.community.service.PostDiscussService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/2 8:45
 * @description：帖子回复操作
 * @modified By：
 */
@RestController
@RequestMapping("/post/discuss")
@Api(tags = "帖子回复接口（xyy）")
public class PostDiscussController {

    @Autowired
    private PostDiscussService postDiscussService;

    @GetMapping("/get/{postUUID}")
    @ApiOperation("查看回复  {根据帖子编号查询回复消息内容}")
    public List<Map<String,Object>> postDiscussByPostUUID(@PathVariable("postUUID") String postUUID){
        return postDiscussService.postDiscussByPostUUID(postUUID);
    }

    @PostMapping("/add")
    @ApiOperation("回复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postUUID",value ="帖子编号",paramType = "query"),
            @ApiImplicitParam(name = "stuA",value ="学生编号A",paramType = "query"),
            @ApiImplicitParam(name = "stuB",value ="学生编号B",paramType = "query"),
            @ApiImplicitParam(name = "discussContent",value ="回复内容",paramType = "query")
    })
    public String insertPostDiscuss(@ApiIgnore @RequestBody PostDiscuss postDiscuss){
        String s = postDiscussService.insertPostDiscuss(postDiscuss);
        return "{'discussUUID':'"+s+"'}";
    }

    @ApiOperation("删除评论")
    @RequestMapping(value = "/del/{discussUUID}", method = RequestMethod.GET)
    public boolean delPostDiscuss(@PathVariable("discussUUID") String discussUUID) {
        postDiscussService.delPostDiscuss(discussUUID);
        return true;
    }
}

