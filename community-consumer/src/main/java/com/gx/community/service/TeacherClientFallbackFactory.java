package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.ClassInfo;
import com.gx.community.pojo.GraduateJob;
import com.gx.community.pojo.Student;
import com.gx.community.pojo.Teacher;
import feign.hystrix.FallbackFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 13:56
 * @description：
 * @modified By：
 */
@Component
public class TeacherClientFallbackFactory implements FallbackFactory<TeacherClientService> {
    @Override
    public TeacherClientService create(Throwable throwable) {
        return new TeacherClientService() {
            @Override
            public boolean addStudent(MultipartFile multipartFile, String classUUID) {
                return false;
            }

            @Override
            public ResponseEntity<InputStreamResource> downloadTeacherModel() {
                return null;
            }

            @Override
            public ResponseEntity<InputStreamResource> downloadStudentBaseInfoByClassUUID(String classUUID) {
                return null;
            }

            @Override
            public Map<String, Object> queryByClassUUID(String classUUID) {
                return null;
            }

            @Override
            public List<Map<String, Object>> queryGraduateLikeStuName(String stuName) {
                return null;
            }

            @Override
            public List<Map<String, Object>> queryGraduateJobByStuUUID(String stuUUID) {
                return null;
            }

            @Override
            public String insertGraduateJob(GraduateJob graduateJob) {
                return null;
            }

            @Override
            public PageInfo<Student> queryStudentListByClassUUID(String classUUID,Integer pageNum) {
                return null;
            }

            @Override
            public Map<String, Object> queryByStuUUID(String stuUUID) {
                return null;
            }

            @Override
            public Teacher login(Teacher teacher) {
                return null;
            }

            @Override
            public boolean updateTeacherAdmin(String newPassword, String telephone) {
                return false;
            }

            @Override
            public List<Map<String, Object>> queryClassInfoListByTeaUUIDAndGrade(String teaUUID, String grade) {
                return null;
            }

            @Override
            public Boolean addParent(MultipartFile multipartFile) {
                return null;
            }

            @Override
            public List<ClassInfo> queryClassInfoListByTeaUUID(String teaUUID) {
                return null;
            }
        };
    }
}
