package com.gx.community.service;

import com.gx.community.pojo.College;

import java.util.List;

/**
  *@Author lxl
  *@Description service:CollegeService
  *@Date 19:23 2019/4/3
  **/
public interface CollegeService {
    /**
      *@Author lxl
      *@Description 查看学院信息列表
      *@Date 19:24 2019/4/3
      *@return java.util.List<com.gx.community.admin.pojo.College>
      **/
    List<College> queryCollegeList();
}
