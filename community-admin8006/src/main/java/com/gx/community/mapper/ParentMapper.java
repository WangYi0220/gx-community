package com.gx.community.mapper;

import com.gx.community.pojo.Parent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
  *@Author lxl
  *@Description mapper:ParentMapper
  *@Date 16:52 2019/4/2
  **/
public interface ParentMapper {
    /**
      *@Author lxl
      *@Description 查看家长信息列表
      *@Date 18:56 2019/4/2
      *@return com.gx.community.admin.pojo.Parent
      **/
    List<Parent> queryParentList();

    /**
      *@Author shiloh
      *@Description
      *@Date 18:56 2019/4/2
      *@Param [parUUID]
      *@return com.gx.community.admin.pojo.Parent
      **/
    Parent queryByParUUID(@Param("parUUID") String parUUID);

    /**
      *@Author lxl
      *@Description 导入家长信息,并导入家长与学生关联表的信息
      *@Date 19:02 2019/4/2
      *@Param [parents]
      *@return void
      **/
    void importParentInfo(@Param("parents") List<Parent> parents,@Param("params") List<Map<String,Object>> params);

    /**
      *@Author lxl
      *@Description 删除家长信息
      *@Date 19:02 2019/4/2
      *@Param [parUUID]
      *@return void
      **/
    void delParent(@Param("parUUID") String parUUID);

    /**
      *@Author lxl
      *@Description 修改家长信息
      *@Date 19:03 2019/4/2
      *@Param [parent]
      *@return void
      **/
    void updateParent(Parent parent);
}
