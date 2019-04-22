package com.gx.community.service;

import java.util.Map;

/**
 *@Author lxl
 *@Description service:ClassInfoService
 *@Date 9:37 2019/4/8
 **/
public interface ClassInfoService {
    /**
     *@Author lxl
     *@Description 根据班级编号查看对应班级的详情信息
     *@Date 10:31 2019/4/8
     *@Param [classUUID]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> queryByClassUUID(String classUUID);
}
