package com.gx.community.controller;

import com.gx.community.pojo.ClassInfo;
import com.gx.community.service.ClassInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName ClassInfoController
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@RestController
@RequestMapping("/classInfo")
@Api(tags = "班级信息操作接口(lxl)")
public class ClassInfoController {
    @Autowired
    private ClassInfoService classInfoService;

    @ApiOperation("根据班级编号查询对应的班级信息")
    @GetMapping("/get/{classUUID}")
    public ClassInfo queryByClassUUID(@PathVariable("classUUID") String classUUID) {
        return classInfoService.queryByClassUUID(classUUID);
    }


}
