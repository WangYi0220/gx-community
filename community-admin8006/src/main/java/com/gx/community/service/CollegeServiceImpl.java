package com.gx.community.service;

import com.gx.community.mapper.CollegeMapper;
import com.gx.community.pojo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CollegeServiceImpl
 * @Description impl:CollegeServiceImpl
 * @Author lxl
 * @Date 2019/4/3
 * @Version 1.0
 **/
@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    /**
     *@Author lxl
     *@Description 查看学院信息列表
     *@Date 19:24 2019/4/3
     *@return java.util.List<com.gx.community.admin.pojo.College>
     **/
    @Override
    public List<College> queryCollegeList() {
        List<College> colleges = collegeMapper.queryCollegeList();
        return colleges;
    }
}
