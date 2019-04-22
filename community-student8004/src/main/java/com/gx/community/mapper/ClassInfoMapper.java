package com.gx.community.mapper;

import com.gx.community.pojo.ClassInfo;
import org.apache.ibatis.annotations.Param;

/**
  *@Author lxl
  *@Description mapper:ClassInfoMapper
  *@Date 15:08 2019/4/1
  **/
public interface ClassInfoMapper {
    /**
      *@Author lxl
      *@Description 根据classUUID查询对应的学生信息
      *@Date 15:15 2019/4/1
      *@Param [classUUID]
      *@return com.gx.community.pojo.ClassInfo
      **/
    ClassInfo queryByClassUUID(@Param("classUUID") String classUUID);

}
