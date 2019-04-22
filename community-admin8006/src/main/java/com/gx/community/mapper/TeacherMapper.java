package com.gx.community.mapper;

import com.gx.community.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    void importTeacherInfo(@Param("teachers") List<Teacher> teachers);

    void updateTeacher(Teacher teacher);

    List<Map<String, Object>> getTeacherByTeaName(@Param("teaName") String teaName);

    Teacher getTeacherByTeaUUID(@Param("teaUUID") String teaUUID);
}
