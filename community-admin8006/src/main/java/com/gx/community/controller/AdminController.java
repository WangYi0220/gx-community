package com.gx.community.controller;

import com.gx.community.pojo.Admin;
import com.gx.community.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/3 9:19
 * @description：管理员
 * @modified By：
 */
@Api(tags = "管理员")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation("管理员登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", paramType = "query"),
            @ApiImplicitParam(name = "passwords", value = "密码", paramType = "query"),
    })
    public Object login(@ApiIgnore @RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @ApiOperation("添加管理员")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addAdmin(Admin admin) {
        adminService.addAdmin(admin);
        return true;
    }

    @ApiOperation("删除管理员")
    @RequestMapping(value = "/del/{adminUUID}", method = RequestMethod.GET)
    public boolean delAdmin(@PathVariable("adminUUID") int adminUUID){
        adminService.delAdmin(adminUUID);
        return true;
    }
}
