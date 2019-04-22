package com.gx.community.controller;

import com.gx.community.pojo.Teacher;
import com.gx.community.service.TeacherAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/8 12:17
 * @description：教师账号接口
 * @modified By：
 */
@RestController
@RequestMapping("/teacherAdmin")
@Api(tags = {"教师账号接口(xyy)"})
public class TeacherAdminController {

    @Autowired
    private TeacherAdminService teacherAdminService;


    @PostMapping("/login")
    @ApiOperation("用户登入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "账号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "Password", value = "密码", dataType = "String", paramType = "query")

    })
    public Teacher login(@ApiIgnore @RequestBody Teacher teacher) {
        return teacherAdminService.login(teacher);
    }


    @PostMapping("/update")
    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "账号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "String", paramType = "query")
    })
    public boolean updateTeacherAdmin(String newPassword, String telephone) {
        return teacherAdminService.updateTeacherAdmin(newPassword, telephone);
    }

}
