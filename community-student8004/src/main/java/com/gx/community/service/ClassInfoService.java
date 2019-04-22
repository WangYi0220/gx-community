package com.gx.community.service;

import com.gx.community.pojo.ClassInfo;

/**
  *@Author lxl
  *@Description service:ClassInfoService
  *@Date 15:08 2019/4/1
  **/
public interface ClassInfoService {
    /**
      *@Author lxl
      *@Description 根据classUUID查询对应的学生信息
      *@Date 15:15 2019/4/1
      *@Param [classUUID]
      *@return com.gx.community.pojo.ClassInfo
      **/
    ClassInfo queryByClassUUID(String classUUID);

}
