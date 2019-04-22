package com.gx.community.controller;

import com.github.pagehelper.PageInfo;
import com.gx.community.common.utils.DownloadFileUtil;
import com.gx.community.pojo.Parent;
import com.gx.community.service.ParentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ：lxl
 * @date ：Created in 2019/4/2 16:23
 * @description：管理-家长
 * @modified By：
 */
@Api(tags = "家长信息操作接口(lxl)")
@RestController
@RequestMapping("/parent")
public class ParentController {
    @Autowired
    private ParentService parentService;
    private static final String PATH = "/usr/community/file";
    private static final String FILENAME ="parent.xlsx";
    private static final String NAME="家长信息模板";

    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "模板下载", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    public Object downloadModel() {
        ResponseEntity<InputStreamResource> response = null;
        try {
            response = DownloadFileUtil.download(PATH, FILENAME, NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @ApiOperation("查看家长信息列表")
    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    public PageInfo<Parent> queryParentList(@PathVariable("pageNum") Integer pageNum){
        PageInfo<Parent> pageInfo = parentService.queryParentList(pageNum);
        return pageInfo;
    }

    @ApiOperation("根据家长编号查看对应的家长信息")
    @RequestMapping(value = "/get/{parUUID}", method = RequestMethod.GET)
    public Parent queryByParUUID(@PathVariable("parUUID") String parUUID){
        Parent parent = parentService.queryByParUUID(parUUID);
        System.out.println("parent = " + parent);
        return parent;
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean addParent(@RequestBody MultipartFile multipartFile){
        parentService.importParentInfo(multipartFile);
        return true;
    }

    @ApiOperation("删除家长信息")
    @RequestMapping(value = "/delete/{parUUID}", method = RequestMethod.GET)
    public Boolean delParent(@PathVariable("parUUID") String parUUID){
        parentService.delParent(parUUID);
        return true;
    }

    @ApiOperation("修改家长信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parName",value = "姓名",paramType = "query"),
            @ApiImplicitParam(name = "telephone",value = "联系电话",paramType = "query"),
            @ApiImplicitParam(name = "employer",value = "工作单位",paramType = "query"),
            @ApiImplicitParam(name = "parUUID",value = "家长编号",paramType = "query"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean updateParent(@ApiIgnore @RequestBody Parent parent){
        System.out.println("parent = " + parent);
        parentService.updateParent(parent);
        return true;
    }

}
