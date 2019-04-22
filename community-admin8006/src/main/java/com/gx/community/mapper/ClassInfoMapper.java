package com.gx.community.mapper;

import com.gx.community.pojo.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *@Author lxl
 *@Description mapper:ClassInfoMapper
 *@Date 19:23 2019/4/3
 **/
public interface ClassInfoMapper {
    /**
      *@Author lxl
      *@Description 根据学院编号查询对应学院的班级信息列表
      *@Date 19:32 2019/4/3
      *@Param [colID]
      *@return java.util.List<com.gx.community.admin.pojo.ClassInfo>
      **/
    List<Map<String,Object>> queryClassInfoByColID(@Param("colID") String colID);

    void addClassTeacher(ClassInfo classInfo);
}
