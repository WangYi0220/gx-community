package com.gx.community.controller;

import com.gx.community.pojo.Industry;
import com.gx.community.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 21:54
 * @description：行业操作
 * @modified By：
 */
@RestController
@RequestMapping("/industry")
@Api(tags = "行业操作接口(xyy)")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @ApiOperation("查询所有行业分类")
    @GetMapping("/get")
    public List<Industry> queryIndustry() {
        return industryService.queryIndustry();
    }

    @ApiOperation("根据行业名称 模糊查询行业")
    @GetMapping("/get/industry/{industry}")
    public List<Industry> queryIndustryLikeIndustry(@PathVariable("industry") String industry) {
        return industryService.queryIndustryLikeIndustry(industry);
    }
}
