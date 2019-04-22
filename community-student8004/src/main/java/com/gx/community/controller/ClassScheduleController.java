package com.gx.community.controller;

import com.gx.community.pojo.ClassSchedule;
import com.gx.community.service.ClassScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/2 8:46
 * @description：课表
 * @modified By：
 */
@Api(tags = "课表(wy)")
@RestController
@RequestMapping("/class/schedule")
public class ClassScheduleController {
    @Autowired
    private ClassScheduleService classScheduleService;

    @ApiOperation("根据班级编号获取课程表")
    @RequestMapping(value = "/get/{classUUID}", method = RequestMethod.GET)
    public ClassSchedule getClassScheduleByClassUUID(@PathVariable("classUUID") String classUUID) {
        return classScheduleService.getClassScheduleByClassUUID(classUUID);
    }
}
