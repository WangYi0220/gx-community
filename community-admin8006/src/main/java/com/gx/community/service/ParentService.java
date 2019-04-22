package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.Parent;
import org.springframework.web.multipart.MultipartFile;

/**
  *@Author lxl
  *@Description service:ParentService
  *@Date 16:52 2019/4/2
  **/
public interface ParentService {
    /**
      *@Author lxl
      *@Description 查看家长信息列表,实现分页功能
      *@Date 18:56 2019/4/2
     * @Param [pageNum]
      *@return com.gx.community.admin.pojo.Parent
      **/
    PageInfo<Parent> queryParentList(Integer pageNum);

    /**
      *@Author shiloh
      *@Description
      *@Date 18:56 2019/4/2
      *@Param [parUUID]
      *@return com.gx.community.admin.pojo.Parent
      **/
    Parent queryByParUUID(String parUUID);

    /**
      *@Author lxl
      *@Description 添加家长信息
      *@Date 19:02 2019/4/2
      *@Param [parent]
      *@return void
      **/
    void importParentInfo(MultipartFile multipartFile);

    /**
      *@Author lxl
      *@Description 删除家长信息
      *@Date 19:02 2019/4/2
      *@Param [parUUID]
      *@return java.lang.Boolean
      **/
    Boolean delParent(String parUUID);

    /**
      *@Author lxl
      *@Description 修改家长信息
      *@Date 19:03 2019/4/2
      *@Param [parent]
      *@return java.lang.Boolean
      **/
    Boolean updateParent(Parent parent);
}
