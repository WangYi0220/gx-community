package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.ClassInfo;
import com.gx.community.service.ClassInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：lxl
 * @date ：Created in 2019/4/2 16:23
 * @description：管理-班级
 * @modified By：
 */
@Api(tags = "班级信息操作接口(lxl)")
@RestController
@RequestMapping("/classInfo")
public class ClassInfoController {

    @Autowired
    private ClassInfoService classInfoService;

    @ApiOperation("根据学院编号查询对应学院的班级信息列表")
    @RequestMapping(value = "/list/{colID}/{pageNum}", method = RequestMethod.GET)
    public PageInfo<Map<String, Object>> queryClassInfoByColID(@PathVariable("colID") String colID,
                                                               @PathVariable("pageNum") Integer pageNum) {
        return classInfoService.queryClassInfoByColID(colID,pageNum);
    }

    @ApiOperation("添加班级辅导员")
    @RequestMapping(value = "/addTea", method = RequestMethod.POST)
    public boolean addClassTeacher(@RequestBody List<ClassInfo> params) {
        classInfoService.addClassTeacher(params);
        return true;
    }
}
