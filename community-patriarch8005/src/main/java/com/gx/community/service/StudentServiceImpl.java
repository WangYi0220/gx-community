package com.gx.community.service;

import com.gx.community.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author shiloh
 * @Date Created in 2019/4/9 14:23
 * @description 学生
 * @modified By:
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    /**
     *@Author lxl
     *@Description 查看自己小孩的在校信息列表
     *@Date 9:13 2019/4/9
     *@Param [parUUID]
     *@return java.util.List<com.gx.community.patriarch.pojo.Student>
     **/
    @Override
    public List<Map<String, Object>> queryStudentListByParUUID(String parUUID) {
        return studentMapper.queryStudentListByParUUID(parUUID);
    }
}
