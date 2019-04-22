package com.gx.community.service;

import com.gx.community.pojo.Teacher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    void importTeacherInfo(MultipartFile multipartFile);

    void updateTeacher(Teacher teacher);

    List<Map<String, Object>> getTeacherByTeaName(String teaName);

    Teacher getTeacherByTeaUUID(String teaUUID);
}
