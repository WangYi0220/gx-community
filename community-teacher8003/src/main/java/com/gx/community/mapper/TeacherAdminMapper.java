package com.gx.community.mapper;

import com.gx.community.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/8 11:52
 * @description：账号
 * @modified By：
 */
public interface TeacherAdminMapper {

    //修改密码
   int updateTeacherAdmin(@Param("newPassword") String newPassword,@Param("telephone") String telephone);

   //教师登入
   Teacher login(Teacher teacher);


}
