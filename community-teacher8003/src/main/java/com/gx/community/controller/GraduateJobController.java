package com.gx.community.controller;

import com.gx.community.pojo.GraduateJob;
import com.gx.community.service.GraduateJobService;
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
 * @date ：Created in 2019/4/8 11:07
 * @description：毕业生就业接口
 * @modified By：
 */
@RestController
@Api(tags = {"毕业生就业接口(xyy)"})
@RequestMapping("/job")
public class GraduateJobController {

    @Autowired
    private GraduateJobService graduateJobService;

    @GetMapping("/getName/{stuName}")
    @ApiOperation("搜索名字")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuName",value = "学生姓名",dataType = "String",paramType = "path")
    })
    public List<Map<String,Object>> queryGraduateLikeStuName(@PathVariable("stuName") String stuName){
        return graduateJobService.queryGraduateLikeStuName(stuName);
    }


    @GetMapping("/get/{stuUUID}")
    @ApiOperation("查看毕业生就业信息详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuUUID",value = "学生编号",dataType = "String",paramType = "path")
    })
    public List<Map<String,Object>> queryGraduateJobByStuUUID(@PathVariable("stuUUID") String stuUUID){
        return graduateJobService.queryGraduateJobByStuUUID(stuUUID);
    }



    @PostMapping("/add")
    @ApiOperation("添加毕业生就业信息详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuUUID",value = "学生编号",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "graStartTime",value = "开始工作时间",dataType = "date",paramType = "query"),
            @ApiImplicitParam(name = "graEndTime",value = "结束工作时间",dataType = "date",paramType = "query"),
            @ApiImplicitParam(name = "graCompany",value = "公司名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "graPost",value = "公司职位",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pay",value = "薪资",dataType = "float",paramType = "query"),
            @ApiImplicitParam(name = "graAddress",value = "公司详细地址",dataType = "String",paramType = "query")
    })
    public String insertGraduateJob(@ApiIgnore @RequestBody GraduateJob graduateJob){
        System.out.println(graduateJob.toString());
        return graduateJobService.insertGraduateJob(graduateJob);
    }
}
