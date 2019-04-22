package com.gx.community.service;

import com.gx.community.mapper.StudentScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author shiloh
 * @Date Created in 2019/4/9 14:29
 * @description 学生成绩
 * @modified By:
 */
@Service
@Transactional
public class StudentScoreServiceImpl implements StudentScoreService {
    @Autowired
    private StudentScoreMapper studentScoreMapper;

    /**
     *@Author lxl
     *@Description 查询自己小孩的成绩信息
     *@Date 10:18 2019/4/9
     *@Param [stuUUID]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     **/
    public Map<String,Object> queryStudentScoreByStuUUID(String stuUUID){
        return studentScoreMapper.queryStudentScoreByStuUUID(stuUUID);
    }
}
