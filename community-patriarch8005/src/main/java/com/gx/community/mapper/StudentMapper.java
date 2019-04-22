package com.gx.community.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author shiloh
 * @Date Created in 2019/4/9 14:22
 * @description 学生
 * @modified By:
 */
public interface StudentMapper {
    /**
     *@Author lxl
     *@Description 查看自己小孩的在校信息列表
     *@Date 9:13 2019/4/9
     *@Param [parUUID]
     *@return java.util.List<com.gx.community.patriarch.pojo.Student>
     **/
    List<Map<String,Object>> queryStudentListByParUUID(@Param("parUUID") String parUUID);
}
