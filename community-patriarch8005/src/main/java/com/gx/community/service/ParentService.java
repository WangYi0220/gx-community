package com.gx.community.service;

import com.gx.community.pojo.Parent;

import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/9 8:42
 * @description 家长
 * @modified By:
 */
public interface ParentService {
    /**
      *@Author lxl
      *@Description 家长登录
      *@Date 8:49 2019/4/9
      *@Param [formData]
      *@return java.util.Map<java.lang.String,java.lang.Object>
      **/
    Map<String,Object> login(Parent formData);

    /**
     *@Author lxl
     *@Description 修改默认密码
     *@Date 10:07 2019/4/9
     *@Param [formData]
     *@return void
     **/
    void updateDefaultPassword(Parent formData);
}
