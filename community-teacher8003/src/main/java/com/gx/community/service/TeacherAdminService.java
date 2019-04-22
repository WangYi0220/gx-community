package com.gx.community.service;

import com.gx.community.pojo.Teacher;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/8 11:57
 * @description：教师账号
 * @modified By：
 */
public interface TeacherAdminService {

    //修改密码
    boolean updateTeacherAdmin(String newPassword,String telephone);

    //教师登入
    Teacher login(Teacher teacher);
}
