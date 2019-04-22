package com.gx.community.controller;

import com.gx.community.pojo.Parent;
import com.gx.community.service.ParentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/9 9:00
 * @description 家长
 * @modified By:
 */
@RestController
@RequestMapping("/parent")
@Api(tags = "家长操作接口(lxl)")
public class ParentController {
    @Autowired
    private ParentService parentService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone",value = "联系电话",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "密码(与电话一致)",paramType = "query")
    })
    @ApiOperation("家长登录")
    public Map<String,Object> login(@ApiIgnore @RequestBody Parent formData){
        Map<String,Object> parent = parentService.login(formData);
        return parent;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone",value = "账号(联系电话)",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "新密码",paramType = "query")
    })
    @ApiOperation("修改默认密码")
    public Boolean updateDefaultPassword(@ApiIgnore @RequestBody Parent formData){
        parentService.updateDefaultPassword(formData);
        return true;
    }
}
