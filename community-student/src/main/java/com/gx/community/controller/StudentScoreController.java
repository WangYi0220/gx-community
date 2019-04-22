package com.gx.community.controller;

import com.gx.community.pojo.StudentScore;
import com.gx.community.service.StudentScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName StudentScoreController
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@RestController
@RequestMapping("/score")
@Api(tags = "学生成绩信息操作接口(lxl)")
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;

    @ApiOperation("根据学期和学生编号查询对应的成绩信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "semester",value = "学期",paramType = "path"),
            @ApiImplicitParam(name = "stuUUID",value = "学生编号",paramType = "path"),
    })
    @GetMapping("/list/{semester}/{stuUUID}")
    public List<StudentScore> queryScoreListByStuUUID(@PathVariable("semester") String semester,
                                                      @PathVariable("stuUUID") String stuUUID){
        List<StudentScore> studentScoreList = studentScoreService.queryScoreListByExample(semester,stuUUID);
        return studentScoreList;
    }

}
