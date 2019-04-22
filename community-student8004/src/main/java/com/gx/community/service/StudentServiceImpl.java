package com.gx.community.service;

import com.gx.community.common.utils.FileUtils;
import com.gx.community.mapper.StudentMapper;
import com.gx.community.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    
    public static final String PATH_PREFIX = "stu/";

    /**
     * 上传用户头像
     * @param file
     * @param stuUUID
     */
    @Override
    public void upHeadImg(MultipartFile file, String stuUUID) {
        String path = FileUtils.fileUP(file, PATH_PREFIX);
        studentMapper.upHeadImg(path, stuUUID);
    }

    /**
     *@Author shiloh
     *@Description 查看与当前学生同班的学生信息列表
     *@Date 17:21 2019/4/1
     *@Param [classUUID]
     *@return java.util.List<com.gx.community.pojo.Student>
     **/
    @Override
    public List<Map<String,Object>> queryStudentListByClassUUID(String classUUID) {
        return studentMapper.queryStudentListByClassUUID(classUUID);
    }

    /**
     *@Author shiloh
     *@Description 根据学生编号查看对应的学生信息
     *@Date 17:22 2019/4/1
     *@Param [stuUUID]
     *@return com.gx.community.pojo.Student
     **/
    @Override
    public Map<String,Object> queryByStuUUID(String stuUUID) {
        return studentMapper.queryByStuUUID(stuUUID);
    }

    @Override
    public Map<String,Object> login(Student student) {
        Map<String,Object> student1 = studentMapper.login(student);
        if(student1 != null){
            return student1;
        } else {
            student1 = new HashMap<>();
            String statusCode = "err";
            student1.put("statusCode",statusCode);
            return student1;
        }
    }

}
