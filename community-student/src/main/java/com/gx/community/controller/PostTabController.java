package com.gx.community.controller;

import com.gx.community.pojo.PostTab;
import com.gx.community.service.PostTabService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/3 15:14
 * @description：帖子分类
 * @modified By：
 */
@Api(tags = "帖子分类")
@RestController
@RequestMapping("/post/tab")
public class PostTabController {
    @Autowired
    private PostTabService postTabService;

    @ApiOperation("获取所有帖子分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PostTab> getPostTabList() {
       return postTabService.getPostTabList();
    }
}
