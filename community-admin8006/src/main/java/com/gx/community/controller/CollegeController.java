package com.gx.community.controller;

import com.gx.community.pojo.College;
import com.gx.community.service.CollegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：lxl
 * @date ：Created in 2019/4/2 16:23
 * @description：管理-学院
 * @modified By：
 */
@Api(tags = "学院信息操作接口(lxl)")
@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @ApiOperation("查看学院信息列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<College> queryCollegeList(){
        List<College> colleges = collegeService.queryCollegeList();
        return colleges;
    }

}
