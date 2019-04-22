package com.gx.community.controller;

import com.gx.community.service.ClassInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description controller:ClassInfoController
 * @Author lxl
 * @Date 2019/4/8
 * @Version 1.0
 **/
@RestController
@RequestMapping("/classInfo")
@Api(tags = "班级操作接口(lxl)")
public class ClassInfoController {
    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping(value = "/get/{classUUID}",method = RequestMethod.GET)
    @ApiOperation("根据班级编号查看对应班级的详情信息")
    public Map<String,Object> queryByClassUUID(@PathVariable("classUUID") String classUUID){
        Map<String,Object> classInfo = classInfoService.queryByClassUUID(classUUID);
        return classInfo;
    }
}
