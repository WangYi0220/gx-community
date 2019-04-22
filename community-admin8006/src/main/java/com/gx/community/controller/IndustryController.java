package com.gx.community.controller;

import com.gx.community.pojo.Industry;
import com.gx.community.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 23:21
 * @description：行业操作
 * @modified By：
 */
@Api(tags = "行业操作接口(lxl)")
@RestController
@RequestMapping("/industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @ApiOperation("添加行业")
    @ApiImplicitParam(name = "industry", value = "行业名称", paramType = "query")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean insertIndustry(@RequestBody @ApiIgnore Industry industry) {
        return industryService.insertIndustry(industry);
    }
}
