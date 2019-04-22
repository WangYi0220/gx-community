package com.gx.community.service;

import com.gx.community.mapper.StudentScoreMapper;
import com.gx.community.pojo.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName StudentScoreServiceImpl
 * @Author lxl
 * @Date 2019/4/1
 * @Version 1.0
 **/
@Service
@Transactional
public class StudentScoreServiceImpl implements StudentScoreService {
    @Autowired
    private StudentScoreMapper studentScoreMapper;

    @Override
    public List<StudentScore> queryScoreListByExample(String semester,String stuUUID) {
        return studentScoreMapper.queryScoreListByExample(semester,stuUUID);
    }
}
