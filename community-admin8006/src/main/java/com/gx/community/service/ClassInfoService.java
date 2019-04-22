package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *@Author lxl
 *@Description service:ClassInfoService
 *@Date 19:23 2019/4/3
 **/
public interface ClassInfoService {
    /**
      *@Author lxl
      *@Description 根据学院编号查询对应学院的班级信息列表,实现分页功能
      *@Date 19:32 2019/4/3
      *@Param [colID,pageNum]
      *@return java.util.List<com.gx.community.admin.pojo.ClassInfo>
      **/
    PageInfo<Map<String,Object>> queryClassInfoByColID(@Param("colID") String colID,Integer pageNum);

    void addClassTeacher(List<ClassInfo> params);
}
