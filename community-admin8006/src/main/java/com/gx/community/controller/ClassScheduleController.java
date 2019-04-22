package com.gx.community.controller;

import com.gx.community.pojo.ClassSchedule;
import com.gx.community.service.ClassScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/3 19:43
 * @description：课表
 * @modified By：
 */
@Api(tags = "课表")
@RestController
@RequestMapping("/class/schedule")
public class ClassScheduleController {
    @Autowired
    private ClassScheduleService classScheduleService;

    @ApiOperation("根据班级获取课表")
    @RequestMapping(value = "/get/{classUUID}", method = RequestMethod.GET)
    public ClassSchedule getClassScheduleByClassUUID(@PathVariable("classUUID") String classUUID) {
        return classScheduleService.getClassScheduleByClassUUID(classUUID);
    }

    @ApiOperation("添加课表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classUUID", value = "班级编号", paramType = "query"),
            @ApiImplicitParam(name = "classSchedule", value = "课程表", paramType = "query"),
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClassSchedule(@RequestBody ClassSchedule classSchedule) {
        return classScheduleService.addClassSchedule(classSchedule);
    }

    @ApiOperation("修改课表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "scheduleUUID", value = "课程表编号", paramType = "query"),
            @ApiImplicitParam(name = "classSchedule", value = "课程表", paramType = "query"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateClassSchedule(@ApiIgnore @RequestBody ClassSchedule classSchedule) {
        classScheduleService.updateClassSchedule(classSchedule);
        return true;
    }
}
