package com.gx.community.service;

import com.gx.community.mapper.TeacherAdminMapper;
import com.gx.community.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/8 11:59
 * @description：教师账号
 * @modified By：
 */
@Service
public class TeacherAdminServiceImpl implements TeacherAdminService {

    @Autowired
    private TeacherAdminMapper adminMapper;

    @Override
    public boolean updateTeacherAdmin(String newPassword, String telephone) {
        int i = adminMapper.updateTeacherAdmin(newPassword,telephone);
        return true;
    }

    @Override
    public Teacher login(Teacher teacher) {
        return adminMapper.login(teacher);
    }


}
